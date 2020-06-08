<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Лаба 1</title>
    </head>
    <body>
        <table class="matrix">
            <caption>Таблица читателей</caption>
            <tbody id="tableBody">
                <tr>
                    <td>Id читателя</td>
                    <td>Имя читателя</td>
                    <td>Фамилия читателя</td>
                    <td>Отчество читателя</td>
                    <td>Возраст читателя</td>
                    <td>Обновление данных</td>
                    <td>Удаление данных</td>
                </tr>
                <c:forEach var="reader" items="${readers}">
                    <tr>
                        <td>${reader.id}</td>
                        <td>${reader.name}</td>
                        <td>${reader.surname}</td>
                        <td>${reader.lastName}</td>
                        <td>${reader.age}</td>
                        <td><button onclick=>Обновить</button></td>
                        <td><button onclick=>Удалить</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
    <link rel="stylesheet" href="public/css/main.css">
    <script src="public/js/operationWithReaders.js"></script>
</html>
