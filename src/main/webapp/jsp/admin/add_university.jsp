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
        <tiles:putAttribute name="title" value="Add page"/>
        <tiles:putAttribute name="bodyContent">
            <h1>Add university page</h1>
            <form action="/addUniver" method="post">
                <p>University name: </p>
                <input type="text" name="univerName"> <br>

                <p>Faculty name: </p>
                <input type="text" name="facultyName"> <br>

                <input type="submit" value="<spring:message code="button.add.university"/>">
            </form>
        </tiles:putAttribute>
    </tiles:insertDefinition>


</body>
</html>
