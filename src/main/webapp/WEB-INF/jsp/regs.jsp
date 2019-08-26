<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>布谷租房 - 用户注册</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK
            rel=stylesheet type=text/css href="../../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
    <style type="text/css">
        .passInput {
            border: red 1px solid;
        }
    </style>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><a href="/house/search"><IMG src="../../images/logo.gif"></a></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新用户注册</DT>
            <DD class=past>填写个人信息</DD>
        </DL>
        <DIV class=box>
            <%--接收后台返回错误结果--%>
            <form:form action="/user/doReg" method="post" id="form" modelAttribute="userVo">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD class=field>用 户 名：</TD>
                            <TD><INPUT class=text type=text name=name onchange="yanzheng(this)">
                                <span></span>
                                <form:errors path="name" cssStyle="color: red"/>
                            </TD>
                        </TR>

                        <TR>
                            <TD class=field>密　　码：</TD>
                            <TD><INPUT class=text type=password name=password>
                                <form:errors path="password" cssStyle="color: red"/></TD>
                        </TR>
                        <TR>
                            <TD class=field>确认密码：</TD>
                            <TD><INPUT class=text type=password name=repassword>
                                <span id="spanPass" style="color: red; display: none">两次密码不一样!</span>
                                <form:errors path="rgpassword" cssStyle="color: red"/>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>电　　话：</TD>
                            <TD><INPUT class=text type=text name=telephone><form:errors path="telephone"
                                                                                        cssStyle="color: red"/></TD>
                        </TR>
                        <TR>
                            <TD class=field>用户姓名：</TD>
                            <TD><INPUT class=text type=text name=username><form:errors path="username"
                                                                                       cssStyle="color: red"/></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons>
                        <INPUT value=立即注册 type="submit">
                    </DIV>
                </DIV>
            </form:form></DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>布谷租房 © 2010 布谷租房 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
<script>
    function yanzheng(th) {
        var name = $(th).val();
        $.post(
            "/user/doReg2",
            {name: name},
            function (msg) {
                if (msg.result) {
                    $(th).next().html('<font style="color: green">用户名可用</font>');
                } else {
                    $(th).next().html('<font style="color: red">该用户名不可用</font>');
                }
            },
            'json'
        );
    }

    $('#form').submit(function () {
        var p1 = $('input[name="password"]');
        var p2 = $('input[name="repassword"]');
        var password = p1.val();
        var repassword = p2.val();
        if (repassword === password) {
            $('#spanPass').css('display', 'none');
            return true;
        } else {
            $('#spanPass').css('display', 'block');
            return false;//阻止表单自动提交
        }
    });
</script>
</BODY>
</HTML>
