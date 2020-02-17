<%--
  Created by IntelliJ IDEA.
  User: hukun
  Date: 2020/2/14
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="insert" id="from">
    <table border="1" align="center">
        <tr align="center">
            <td width="500" colspan="2">会议室</td>
        </tr>
        <tr>
            <td width="200" align="right">会议室：</td>
            <td>
                <select id="se" name="se">
                    <option value="一号会议室">一号会议室</option>
                    <option value="二号会议室">二号会议室</option>
                    <option value="三号会议室">三号会议室</option>
                    <option value="四号会议室">四号会议室</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="200" align="right">申请人：</td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td width="200" align="right">预定时间：</td>
            <td><input type="text" id="time" name="time"></td>
        </tr>
        <tr>
            <td width="250" align="right"><input type="submit" value="提交"></td>
            <td><input type="reset" value="清空"></td>
        </tr>
    </table>
</form>
<script src="js/jquery-3.4.1.js"></script>

<script>

    $(function () {
        $("#from").submit(function () {
            if (sqr() == false) {
                return false;
            } else if (date() == false) {
                return false;
            }

        })

        function sqr() {
            var $name = $("#name").val();
            if ($name == null || $name == "") {
                alert("申请人不能为空");
                return false;
            } else {
                return true;
            }
        }

        function date() {
            var $date=$("#time").val();
            var $leg = /\d{4}-\d{2}-\d{2}/;
            if ($date==null||$date==""){
                alert("不能为空")
                return false;
            }else if ($leg.test($date)==false){
                alert("时间格式不正确")
                return false;
            }else {
                return true;
            }
        }
    })


</script>
</body>
</html>
