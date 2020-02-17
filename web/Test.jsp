<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>会议室使用情况</title>
    <style>
        p{
            margin-right: 400px;
        }
    </style>
</head>
<body>
<table id="tt" border="1" width="600" align="center">
    <tr align="center">
        <td width="200" align="center">预订编号</td>
        <td width="200" align="center">会议室</td>
        <td width="200" align="center">预订人</td>
        <td width="200" align="center">日期</td>
    </tr>
    <c:forEach var="meeting" items="${mettingList}">
        <tr>
            <td>${meeting.id}</td>
            <td>${meeting.meeting_name}</td>
            <td>${meeting.advance_name}</td>
            <td>${meeting.meeting_order}</td>
        </tr>
    </c:forEach>
</table>
<p align="right"><a href="insert.jsp">预订会议室</a></p>

<script src="js/jquery-3.4.1.js"></script>
<script>
    $(function () {
        $("tr:even").css("background", "yellow");
        $("tr:nth-of-type(1)").css("background", "#c1c2d6");
    })
</script>
</body>
</html>