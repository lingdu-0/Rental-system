<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>布谷租房 - 用户管理</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="../../css/style.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
    <META name=GENERATOR>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><a href="/house/search"><IMG src="../../images/logo.gif"></a></DIV>
    <DIV class=search><LABEL class="ui-green searchs"><a href="/house/fabu" title="">发布房屋信息</a></LABEL>
        <LABEL class=ui-green><INPUT onclick='document.location="/user/login"' value="退       出" type=button
                                     name=search></LABEL>
    </DIV>
</DIV>
<DIV class="main wrap">
    <DIV id=houseArea>
        <TABLE class=house-list>
            <TBODY>
            <c:forEach items="${houseList.list}" var="house">
                <TR>
                    <TD class=house-thumb>
                    <span>
                        <a href="/house/detail/${house.houseId}" target="_blank">
                    <img src="/house/images?imgName=${house.houseImg}" width="100" height="75" alt="${house.houseImg}">
                        </a>
                    </span>
                    </TD>
                    <TD>
                        <DL>
                            <DT><A href="/house/detail/${house.houseId}" target="_blank">${house.houseName}</A></DT>
                            <DD>海淀区中关村大街,${house.houseRect}平米<BR>联系方式：3456</DD>
                        </DL>
                    </TD>
                    <TD class=house-type>
                        <LABEL class=ui-green>
                            <INPUT value="修改" type=button onclick="updateHouse(${house.houseId})" name=search>
                        </LABEL>
                    </TD>
                    <TD class=house-price>
                        <LABEL class=ui-green>
                            <INPUT onclick='deleteHouse(${house.houseId},this)'value="删除" type=button name=search>
                        </LABEL>
                    </TD>
                </TR>
            </c:forEach>
            </TBODY>
        </TABLE>
    </DIV>
    <DIV class=pager>
        <UL>
            <c:forEach begin="1" end="${houseList.pages}" var="i">
                <LI class=current>

                    <A id=widget_338868862
                       href="?pageNum=${i}"
                       parseContent="true" showError="true" targets="houseArea"
                       ajaxAfterValidation="false" validate="false"
                       dojoType="struts:BindAnchor">${i}</A>

                </LI>
            </c:forEach>
        </UL>
        <SPAN class=total>${houseList.pageNum}/${houseList.pages}页</SPAN></DIV>
</DIV>
<script>
    function deleteHouse(houseId,th) {
        $.post(
            '/house/delete',
            {
                houseId: houseId
            },
            function (msg) {
                if (msg.result) {
                    $(th).parent().parent().parent().remove();
                } else {
                    alert("操作失败!");
                }
            },
            'json'
        );
    }
    function updateHouse(houseId) {
        location.href="/house/update/"+houseId;
    }
</script>
<DIV id=footer class=wrap>
    <DL>
        <DT>布谷租房 © 2010 布谷租房 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
