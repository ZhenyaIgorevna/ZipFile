<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<ul class="treeContainer">
    <c:choose>
        <c:when test="${fn:contains(nodeEntity.filename, nodeEntity.parent.filename)}">
            <c:set var="nodeName" value="${nodeEntity.filename}"/>
            <c:set var="parentName" value="${nodeEntity.parent.filename}"/>
            <c:set var="name" value="${fn:replace(nodeName,
                                parentName, '')}"/>
        </c:when>
        <c:otherwise>
            <c:set value="${nodeEntity.filename}" var="name" scope="request"/>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${empty nodeEntity.children}">
            <c:set value="${name}" var="liefName" scope="request"/>
            <c:set var="fullName" value="${nodeEntity.filename}" scope="request"/>
            <jsp:include page="lief.jsp"/>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${lastLief == 'true'|| empty nodeEntity.parent}">
                    <li class="Node ExpandOpen isLast">
                </c:when>
                <c:otherwise>
                    <li class="Node ExpandOpen ">
                </c:otherwise>
            </c:choose>

            <div class="Expand"></div>
            <div class="treeContent">${name} </div>
            <c:forEach var="nodeEntity" items="${nodeEntity.children}" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.index == nodeEntity.parent.children.size()-1}">
                        <c:set value="true" var="lastLief" scope="request"/>
                    </c:when>
                    <c:otherwise>
                        <c:set value="false" var="lastLief" scope="request"/>
                        <c:set value="false" var="firstLief" scope="request"/>
                    </c:otherwise>
                </c:choose>
                <c:set var="nodeEntity" value="${nodeEntity}" scope="request"/>
                <jsp:include page="node.jsp"/>
            </c:forEach>
            </li>
        </c:otherwise>
    </c:choose>
</ul>