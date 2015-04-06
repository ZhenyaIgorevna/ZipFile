<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/js/tree.js"></script>
</head>
<body>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title" value="Success"/>
    <tiles:putAttribute name="bodyContent">
        <h1>You something add! </h1>

    </tiles:putAttribute>
</tiles:insertDefinition>
</body>
</html>
