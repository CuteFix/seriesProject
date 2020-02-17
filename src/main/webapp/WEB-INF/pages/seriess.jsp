<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Seriess Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Series List</h1>

<c:if test="${!empty listSeries}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">SeriesName</th>
            <th width="120">SeriesOS</th>
            <th width="120">Rate</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listSeries}" var="series">
            <tr>
                <td>${series.id}</td>
                <td><a href=<c:url value='/seriesdata/${series.id}'/>>${series.seriesName}</a></td>
                <td>${series.seriesOS}</td>
                <td>${series.rate}</td>
                <td><a href="<c:url value='/edit/${series.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${series.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Series</h1>
<c:url var="addAction" value="/seriess/add"/>
<form:form action="${addAction}" commandName="series">
    <table>
        <c:if test="${!empty series.seriesName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="seriesName">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="seriesName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="seriesOS">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="seriesOS"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="rate">
                    <spring:message text="rate"/>
                </form:label>
            </td>
            <td>
                <form:input path="rate"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty series.seriesName}">
                    <input type="submit"
                           value="<spring:message text="Edit series"/>"/>
                </c:if>
                <c:if test="${empty series.seriesName}">
                    <input type="submit"
                           value="<spring:message text="Add series"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
