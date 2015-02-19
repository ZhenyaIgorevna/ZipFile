<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <form>
        <c:forEach var="node" items="${projectTree.nodes}" end="0">
            <c:set value="${node.value}" var="nodeEntity" scope="request"/>
            <jsp:include page="/jsp/tiles/part/tree/node.jsp"/>
        </c:forEach>
    </form>
</ul>