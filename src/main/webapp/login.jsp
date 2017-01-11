<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>光华印刷库存管理系统</title>
    <link type="text/css" rel="stylesheet" media="all"
          href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all"
          href="styles/global_color.css" />
</head>
<body class="index">
<div class="login_box">
    <form action="/login.do"  method="post">
        <table>
            <tr>
                <td class="login_info">账号：</td>
                <td colspan="2">
                    <input type="text" name="userAccount" class="width200"/>
                </td>
            </tr>
            <tr>
                <td class="login_info">密码：</td>
                <td colspan="2">
                    <input type="password" name="userPassword"	class="width200" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">
                    <div class="login_error"></div>
                </td>
            </tr>
            <tr>
                <td></td>
                <td class="login_button" colspan="2">
                    <input type="submit" value="登录" class="btn_save"/>
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
