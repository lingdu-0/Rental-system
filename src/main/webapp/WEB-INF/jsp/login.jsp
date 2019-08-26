﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://localhost:8080/HouseRent/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>布谷租房 - 用户登录</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK
            rel=stylesheet type=text/css href="../../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><a href="/house/search"><IMG src="../../images/logo.gif"></a></DIV>
</DIV>

<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DIV class=box>
            <H4>用户登录</H4>
            <form method="post" id="form">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD colSpan=2><span id="error"></span></TD>
                        </TR>
                        <TR>
                            <TD class=field>用 户 名：</TD>
                            <TD><!-- <input type="text" class="text" name="name" /> -->
                                <INPUT id=user_name class=text type=text name=name>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>密　　码：</TD>
                            <TD><!-- <input type="password" class="text" name="password" /> -->
                                <INPUT id=user_password class=text type=password name=password>
                            </TD>
                        </TR><!--
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						--></TBODY>
                    </TABLE>
                    <DIV class=buttons>
                        <INPUT value=登陆 type="submit">
                        <INPUT onclick='document.location="/user/reg"' value=注册 type=button>
                    </DIV>
                </DIV>
            </form>
        </DIV>
    </DIV>
</DIV>
<script>
    var options = {
        type: 'post',
        url: '/user/doLogin',
        dataType: 'json',
        success: function (data) {
            switch (data.result) {
                case 1:
                    $('#error').html('<font color="red">输入有误!</font>');
                    break;
                case 2:
                    location.href='/house/guanli'
                    break;
                case 3:
                    $('#error').html('<font color="red">用户名或密码错误!</font>');
                    break;
            }
        }
    };
    $('#form').submit(
        function () {
            $('#form').ajaxSubmit(options);
            return false;
        }
    );
</script>
<DIV id=footer class=wrap>
    <DL>
        <DT>布谷租房 © 2010 布谷租房 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
