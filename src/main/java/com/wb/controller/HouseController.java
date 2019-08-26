package com.wb.controller;

import com.github.pagehelper.PageInfo;
import com.wb.converter.HouseConverter;
import com.wb.pojo.House;
import com.wb.pojo.HouseSearch;
import com.wb.pojo.User;
import com.wb.service.HouseService;
import com.wb.service.UserService;
import com.wb.vo.HouseSearchVo;
import com.wb.vo.HouseVO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {

    public static final String UPLOAD_DIR = "D:\\images\\";
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;

    @RequestMapping("/images")
    public String images(String imgName, HttpServletResponse response) throws IOException {
        //将图片的输入流,复制到response的输出流中,
        IOUtils.copy(new FileInputStream(UPLOAD_DIR + imgName), response.getOutputStream());
        return null;
    }

    @RequestMapping("dofabu")
    public String dofabu(HouseVO houseVO, HttpServletRequest request) throws IOException {
        House house = getHouse(houseVO, request.getSession());
        houseService.fabu(house);
        return "redirect:guanli";
    }

    @RequestMapping("fabu")
    public String fabu() {
        return "fabu";
    }

    @RequestMapping("search")
    public String search(@ModelAttribute("houseSearchVo") HouseSearchVo houseSearchVo, Model model) {
        if (!StringUtils.isEmpty(houseSearchVo.getFloorage())) {
            String[] strings = houseSearchVo.getFloorage().split("-");
            houseSearchVo.setMinRect(Double.valueOf(strings[0]));
            houseSearchVo.setMaxRect(Double.valueOf(strings[1]));
        }
        HouseSearch houseSearch = HouseConverter.conver(houseSearchVo);
        List<House> list = houseService.search(houseSearch);
        PageInfo houseList = new PageInfo(list);
        model.addAttribute("houseList", houseList);
        return "list";
    }

    @RequestMapping("detail/{houseId}")//路径参数
    public String detail(@PathVariable int houseId, Model model) {
        System.out.println(houseId);
        House house = houseService.findById(houseId);
        model.addAttribute("house", house);
        return "details";
    }

    @RequestMapping("guanli")
    public String guanli(Model model, HttpSession session, Integer pageNum) {
        if (pageNum == null)
            pageNum = 1;
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "redirect:/user/login";
        List<House> list = houseService.findByUserId(user.getUserId(), pageNum);
        PageInfo houseList = new PageInfo(list);
        model.addAttribute("houseList", houseList);
        return "guanli";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer houseId) {
        if (houseService.delete(houseId) != 0) {
            return "{\"result\":" + true + "}";
        } else
            return "{\"result\":" + false + "}";
    }

    @RequestMapping("update/{houseId}")
    public String update(@PathVariable Integer houseId, Model model) {
        House house = houseService.findById(houseId);
        model.addAttribute("house", house);
        return "edit";
    }

    @RequestMapping("doUpdate")
    public String doUpdate(HouseVO houseVO, HttpServletRequest request) throws IOException {
        House house = getHouse(houseVO, request.getSession());
        houseService.update(house);
        return "redirect:/house/guanli";
    }

    private House getHouse(HouseVO houseVO, HttpSession session) throws IOException {
        File file = new File(UPLOAD_DIR + "/" + houseVO.getHouseImg().getOriginalFilename());
        houseVO.getHouseImg().transferTo(file);
        User user = (User) session.getAttribute("user");//从ssesion中获取
        return HouseConverter.conver(houseVO, houseVO.getHouseImg().getOriginalFilename(), user);
    }
}
