<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${lastLief == 'true'}">
        <li class="Node ExpandLeaf islast">

    </c:when>
    <c:otherwise>
        <li class="Node ExpandLeaf">
    </c:otherwise>
</c:choose>
<div class="Expand"></div>
<div class="treeContent">
    <a href="/file?filename=${fullName}" name="filename">${liefName} ${countChildren}</a>
</div>
</li>



