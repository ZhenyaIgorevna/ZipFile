<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<header>
    <div class="brand"><h2>Code </h2></div>
    <div id='cssmenu'>
        <ul>
            <li class='active'><a href='#'><span>Home</span></a></li>
            <li><a href='#'><span>Products</span></a></li>
            <li><a href='#'><span>Company</span></a></li>
            <li class='last'><a href='#'><span>Contact</span></a></li>
            <sec:authorize access="hasRole('admin')">
                <c:url value="/jsp/admin/add_university.jsp" var="addUrl"/>
                <spring:url value="${addUrl}" var="springAddUrl"/>
                <li><a href="${springAddUrl}"><spring:message code="link.add.university"/></a></li>
            </sec:authorize>
        </ul>
    </div>
</header>