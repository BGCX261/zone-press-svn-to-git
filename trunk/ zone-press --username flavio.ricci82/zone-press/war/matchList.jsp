<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page import="com.flavio.zonepress.model.Match" %> 

<html>
  <body>
Lista partite:<br/>

<c:forEach items="${matches}" var="match">
	<c:out value="${match.key}"/>***<c:out value="${match.homeTeam}"/>-<c:out value="${match.awayTeam}"/> <c:out value="${match.date}"/><br/>
</c:forEach>

  </body>
</html>