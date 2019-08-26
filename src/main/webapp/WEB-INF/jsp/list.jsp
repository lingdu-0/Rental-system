<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>布谷租房 - 首页</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="../../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../../images/logo.gif"></DIV>
</DIV>
<DIV id=navbar class=wrap>
    <DL class="search clearfix">
        <FORM id=sform method=post action=/house/search>
            <input name="pageNum" type="hidden"/>
            <DT>
                <UL>
                    <LI class=bold>房屋信息</LI>
                    <LI>标题：
                        <INPUT class=text type=text name=houseName value="${houseSearchVo.houseName}">
                        <LABEL class=ui-blue>
                            <INPUT value=搜索房屋 type=submit name=search>
                        </LABEL>
                    </LI>
                </UL>
            </DT>
            <DD>
                <UL>
                    <LI class=first>价格</LI>
                    <LI><SELECT name=price>
                        <OPTION selected value="">不限</OPTION>
                        <OPTION
                                value=0-100>100元以下
                        </OPTION>
                        <OPTION value=100-200>100元—200元</OPTION>
                        <OPTION value=200-1000000>200元以上</OPTION>
                    </SELECT></LI>
                </UL>
            </DD>
            <DD>
                <UL>
                    <LI class=first>房屋位置</LI>
                    <LI><SELECT id=street name=street_id>
                        <OPTION selected
                                value="">不限
                        </OPTION>
                        <OPTION value=1000>知春路</OPTION>
                        <OPTION
                                value=1001>中关村大街
                        </OPTION>
                        <OPTION value=1002>学院路</OPTION>
                        <OPTION
                                value=1003>朝阳路
                        </OPTION>
                    </SELECT></LI>
                </UL>
            </DD>
            <DD>
                <UL>
                    <LI class=first>房型</LI>
                    <LI><SELECT name=type_id>
                        <OPTION selected value="">不限</OPTION>
                        <OPTION
                                value=1000>一室一厅
                        </OPTION>
                        <OPTION value=1001>一室两厅</OPTION>
                        <OPTION
                                value=1002>两室一厅
                        </OPTION>
                        <OPTION value=1003>两室两厅</OPTION>
                    </SELECT>
                    </LI>
                </UL>
            </DD>
            <DD>
                <UL>
                    <LI class=first>面积</LI>
                    <LI>
                        <SELECT name=floorage>
                            <OPTION ${houseSearchVo.floorage eq ''?'selected':''} value="">不限</OPTION>
                            <OPTION ${houseSearchVo.floorage eq '0-40'?'selected':''} value=0-40>40以下</OPTION>
                            <OPTION ${houseSearchVo.floorage eq '40-500'?'selected':''} value=40-500>40-500</OPTION>
                            <OPTION ${houseSearchVo.floorage eq '500-1000000'?'selected':''} value=500-1000000>500以上
                            </OPTION>
                        </SELECT>
                    </LI>
                </UL>
            </DD>
        </FORM>
    </DL>
</DIV>
<DIV class="main wrap">
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
                <TD class=house-type>一室一厅</TD>
                <TD class=house-price><SPAN>346.0</SPAN>元/月</TD>
            </TR>
        </c:forEach>
        <TR>无租房信息</TR>
        </TBODY>
    </TABLE>
    <DIV class=pager>
        <UL>
            <LI class=current><A href="javascript:submit2(${houseList.firstPage})">首页</A></LI>
            <LI><A href="javascript:submit2(${houseList.hasPreviousPage?houseList.prePage:houseList.pageNum});">上一页</A>
            </LI>
            <LI><A href="javascript:submit2(${houseList.hasNextPage?houseList.nextPage:houseList.pageNum})">下一页</A></LI>
            <LI><A href="javascript:submit2(${houseList.lastPage})">末页</A></LI>
        </UL>
        <SPAN class=total>${houseList.pageNum}/${houseList.pages}页</SPAN></DIV>
</DIV>
<script>
    function submit2(pageNum) {
        $('input[name="pageNum"]').val(pageNum);
        $('#sform').submit();
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
