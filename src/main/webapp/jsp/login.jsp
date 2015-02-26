
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<div>
    <h2>Please Log In</h2>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
    <c:url value="/j_spring_security_check" var="authUrl"/>
    <%--<spring:url var="authUrl" value="<c:url value='j_spring_security_check' />"/>--%>
    <form method="post" class="signin" action="${authUrl}">
        <fieldset>
            <div><p>Login</p></div>
            <div><input id="username_or_email"
                        name="username"
                        type="text"/></div>
            <br><br>

            <div><p>Password</p></div>
            <div><input type='password' name='password' id="password"/></div>
            <br><br>

            <div><input id="remember_me"
                        name="_spring_security_remember_me"
                        type="checkbox"/> <!-- Флажок "запомнить меня" -->
                <label for="remember_me"
                       class="inline">Remember me</label></div>
            <br><br>
            <input name="commit" type="submit" value="Sign In"/></td>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </fieldset>
    </form>

</div>