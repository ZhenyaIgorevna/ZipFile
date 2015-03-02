<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true" %>
<html>
<body>
<h1>Title : ${title}</h1>

<h1>Message : ${message}</h1>

<c:url value="/j_spring_security_logout" var="logoutUrl"/>

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} | <a
            href="javascript:formSubmit()"> Logout</a>
    </h2>

    <sec:authorize access="hasRole('admin')">
        <c:url value="/jsp/admin/add_university.jsp" var="addUrl"/>
        <spring:url value="${addUrl}" var="springAddUrl"/>
        <a href="${springAddUrl}"><spring:message code="link.add.university"/></a>
    </sec:authorize>
</c:if>

</body>
</html>