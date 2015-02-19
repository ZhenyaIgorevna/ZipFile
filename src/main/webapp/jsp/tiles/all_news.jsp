<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="<c:url value='/js/destroy.js'/>"></script>
<script type="text/javascript">
    var confirmMessage = "<spring:message code="message.delete"/>";
    var checkboxMessage = "<spring:message code="error.delete"/>";
</script>
<tiles:insertDefinition name="defaultTemplate">
    <spring:message code="title.view.page" var="title"/>
    <tiles:putAttribute name="title" value="${title}"/>
    <tiles:putAttribute name="bodyContent">
        <p><a href="/list?method=list"> <spring:message code="link.allNews"/> </a> >>
            <spring:message code="title.newsList"/></p>
        <form:form method="POST" action="/remove" commandName="newsModel">
            <c:forEach var="news" items="${newsModel.newsList}">
                <div class="list">
                    <div class="title"><h3>${news.title}</h3></div>
                    <div class="date">
                        <spring:message code="form.date.format" var="pattern"/>
                        <fmt:formatDate value="${news.newsDate}" pattern="${pattern}"/>
                    </div>
                    <div class="brief"><p>${news.brief}</p></div>
                    <div class="link">
                        <a href="/news/${news.id}">
                            <spring:message code="link.view"/>
                        </a>
                        <a href="/edit/${news.id}">
                            <spring:message code="btn.name.edit"/>
                        </a>

                        <input type="hidden" value="${news.id}" name="newsId">

                        <form:checkbox path="selectedId" value="${news.id}"/>
                    </div>
                </div>
                <br>
            </c:forEach>
            <br><br>

            <div class="link">
                <spring:message code="btn.name.delete" var="deleteBtn"/>
                <input type="submit" value="${deleteBtn}" onclick="return deleteAll();"/>
            </div>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>