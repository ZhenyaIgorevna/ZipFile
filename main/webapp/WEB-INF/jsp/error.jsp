
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Error Page</title>
    <link href="/style/style.css" rel="stylesheet">
</head>
<body>
    <div>
        <img src="<c:url value='/image/fail.jpg'/>">
        <h1>${errorMessage}</h1>
    </div>
</body>
</html>
