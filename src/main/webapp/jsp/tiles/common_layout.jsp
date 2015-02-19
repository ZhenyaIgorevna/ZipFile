<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="bean" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<div class="container">
    <div class="menu">
        <tiles:insertAttribute name="menu"/>
    </div>
    <div class="content">
        <tiles:insertAttribute name="bodyContent"/>
    </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>