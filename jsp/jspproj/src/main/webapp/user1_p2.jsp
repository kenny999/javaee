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

	<c:if test="${error != null}">
		<div style="color:red"><c:out value="${error}"/></div>
		<c:remove var="error"/>		
	</c:if>

	<form method="post" action="user1_p2_validation.jsp">
	<label for="street">enter street</label>
	<input type="text" id="street" name="street"/>
	<br>
	<label for="postal">enter postal code</label>
	<input type="text" id="postal" name="postal"/>
	<br>
	<label for="city">Enter city</label>
	<input type="text" id="city" name="city"/>
	<br>
	<label for="btn">Press btn</label>
	<input type="submit" id="btn" value="Press"/>
	<br>
	</form>

</body>
</html>
