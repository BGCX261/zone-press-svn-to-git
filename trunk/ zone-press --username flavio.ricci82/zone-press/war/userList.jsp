<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<html>
  <body>
Lista utenti:<br/>

<c:forEach items="${users}" var="user">
	<c:out value="${user.name}"/>***<c:out value="${user.userName}"/>-<c:out value="${user.password}"/><br/>
</c:forEach>

  </body>
</html>