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

<h1>Success</h1>

<c:out value="${userName}"/>
<br>
<c:out value="${password}"/>
<br>
<c:out value="${usertype}"/>
<br>
<c:out value="${street}"/>
<br>
<c:out value="${postal}"/>
<br>
<c:out value="${city}"/>
<br>

<sql:setDataSource var="ds" url="jdbc:h2:~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE" driver="org.h2.Driver" user="sa" password="sa"/>

<sql:transaction dataSource="${ds}">
<sql:update>
insert into user
(username, password, usertype, street, postal, city)
values (?, ?, ?, ?, ?, ?)
<sql:param value="${userName}"/>
<sql:param value="${password}"/>
<sql:param value="${usertype}"/>
<sql:param value="${street}"/>
<sql:param value="${postal}"/>
<sql:param value="${city}"/>
</sql:update>

</sql:transaction>



</body>
</html>
