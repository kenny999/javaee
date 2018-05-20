<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<c:remove var="error"/>
<c:set var="street" value="${param.street}" scope="page"/>
<c:set var="postal" value="${param.postal}" scope="page"/>
<c:set var="city" value="${param.city}" scope="page"/>

<c:if test="${fn:length(street) == 0}">
  <c:set var="error" value="Please enter street" scope="session"/>
  <jsp:forward page="user1_p2.jsp"/>
</c:if>

<c:if test="${fn:length(postal) == 0}">
  <c:set var="error" value="Please enter postal" scope="session"/>
  <jsp:forward page="user1_p2.jsp"/>
</c:if>

<c:if test="${fn:length(city) == 0}">
  <c:set var="error" value="Please enter city" scope="session"/>
  <jsp:forward page="user1_p2.jsp"/>
</c:if>

<c:if test="${fn:length(street) < 3 || fn:length(street) > 8}">
  <c:set var="error" value="Street must be between 3 and 8 chars" scope="session"/>
  <jsp:forward page="user1_p2.jsp"/>
</c:if>

<c:if test="${fn:length(postal) != 5}">
  <c:set var="error" value="Postal must be 5 chars" scope="session"/>
  <jsp:forward page="user1_p2.jsp"/>
</c:if>

<c:if test="${! postal.matches('[0-9]+')}">
  <c:set var="error" value="Postal must numeric" scope="session"/>
  <jsp:forward page="user1_p2.jsp"/>
</c:if>

<!-- Validation passed, set these variables into session -->

<c:set var="street" value="${param.street}" scope="session"/>
<c:set var="postal" value="${param.postal}" scope="session"/>
<c:set var="city" value="${param.city}" scope="session"/>

<c:redirect url="user1_p3.jsp"/>

<h1>Success</h1>

</body>
</html>
