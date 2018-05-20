<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.jspproj.text.textresources" />
<%@ page errorPage="errorpage.jsp"%>
<html>
<body>

	<c:if test="${error != null}">
		<div style="color:red"><c:out value="${error}"/></div>
		<c:remove var="error"/>		
	</c:if>

<c:set var="userName" value="${param.userName}" scope="page"/>
<c:set var="password" value="${param.password}" scope="page"/>
<c:set var="usertype" value="${param.usertype}" scope="page"/>

<c:if test="${fn:length(userName) == 0}">
  <c:set var="error" value="Please enter username" scope="session"/>
  <jsp:forward page="user1_p1.jsp"/>
</c:if>

<c:if test="${fn:length(password) == 0}">
  <c:set var="error" value="Please enter password" scope="session"/>
  <jsp:forward page="user1_p1.jsp"/>
</c:if>

<c:if test="${fn:length(userName) < 3 || fn:length(userName) > 8}">
  <c:set var="error" value="Username must be between 3 and 8 chars" scope="session"/>
  <jsp:forward page="user1_p1.jsp"/>
</c:if>

<c:if test="${fn:length(password) < 3 || fn:length(password) > 8}">
  <c:set var="error" value="Password must be between 3 and 8 chars" scope="session"/>
  <jsp:forward page="user1_p1.jsp"/>
</c:if>

<c:choose>
	<c:when test="${usertype == 'normal'}">
	</c:when>
	<c:when test="${usertype == 'admin'}">
	</c:when>
	<c:otherwise>
	  <c:set var="error" value="Unexpected value for usertype" scope="session"/>
	  <jsp:forward page="user1_p1.jsp"/>
	</c:otherwise>
</c:choose>

<sql:setDataSource var="ds" url="jdbc:h2:~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE" driver="org.h2.Driver" user="sa" password="sa"/>

<sql:query var="foundUser" dataSource="${ds}">
    select * from user where username = ?
    <sql:param value="${userName}" />
</sql:query>

<c:set var="found" value="0" scope="page"/>

<c:forEach var="row" items="${foundUser.rows}">
<c:set var="found" value="1" scope="page"/>
</c:forEach>

<c:if test="${found eq 1}">
	<c:set var="error" value="User already exists" scope="session"/>
    <jsp:forward page="user1_p1.jsp"/>
</c:if>


<!-- Validation passed, set these variables into session -->

<c:set var="userName" value="${param.userName}" scope="session"/>
<c:set var="password" value="${param.password}" scope="session"/>
<c:set var="usertype" value="${param.usertype}" scope="session"/>

<c:redirect url="user1_p2.jsp"/>

</body>
</html>
