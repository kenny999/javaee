<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.jspproj.text.textresources" />
<html>
<body>

	<c:if test="${error != null}">
		<div style="color:red"><c:out value="${error}"/></div>
		<c:remove var="error"/>		
	</c:if>
	
	<c:remove var="userName"/>
	<c:remove var="password"/>
	<c:remove var="usertype"/>

	<form method="post" action="user1_p1_validation.jsp">
	<label for="userName"><fmt:message key="label.username"/></label>
	<input type="text" id="userName" name="userName" autofocus/>
	<br>
	<label for="password"><fmt:message key="label.password"/></label>
	<input type="password" id="password" name="password"/>
	<br>
	<label for="usertype"><fmt:message key="label.usertype"/></label>
	<select id="usertype" name="usertype">
		<option value="normal"><fmt:message key="label.usertype.normal"/></option>
		<option value="admin"><fmt:message key="label.usertype.admin"/></option>
	</select>
	<br>
	<label for="btn"><fmt:message key="button.next"/></label>
	<input type="submit" id="btn" value="Press"/>
	<br>
	</form>
</body>
</html>
