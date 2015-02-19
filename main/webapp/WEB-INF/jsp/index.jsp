<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Index</title>
    <link href="/style/style.css" rel="stylesheet">
    <script src="/js/jquery-1.11.1.min.js"></script>
    <script src="/js/include.js"></script>
</head>
<body>
<div>
    <div class="site_content">
        <a href="/generateDB">
            <button class="button">Generate DB</button>
        </a>
        <a href="/cleanDB">
            <button class="button">Clean DB</button>
        </a>

        <form action="/list" METHOD="post">

            <h1>Get list of employees</h1>

            <div class="line">
                <p class="label">From: </p><input type="text" name="from" id="from" class="input">
            </div>
            <br>

            <div class="line">
                <p class="label">Size: </p><input type="text" name="size" id="size" class="input">
            </div>
            <input class="button" type="submit" onclick="return validate()" value="Get">
        </form>
        <c:if test="${not empty message}">
            <h1>${message}</h1>
        </c:if>
        <c:if test="${not empty listEmployees}">
            <table>
                <thead>
                <tr>
                    <td></td>
                    <td>First name</td>
                    <td>Last name</td>
                    <td>Position</td>
                    <td>Address</td>
                    <td>Offices</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${listEmployees}" varStatus="status">

                    <tr>
                        <td>${status.count}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.position}</td>
                        <td>${employee.address}</td>
                        <td class="offices">
                            <ul>
                                <c:forEach var="office" items="${employee.companies}">
                                    <li>
                                            ${office.name}
                                        <ul>
                                            <c:forEach var="officeAddress" items="${office.addresses}">
                                                <li>${officeAddress}
                                                    (Work ${countMap[office.id]}
                                                    employees)
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</div>
<a href="#" class="scrollup">^</a>
</body>
</html>
