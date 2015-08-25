<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page import="com.flavio.zonepress.model.Match" %> 

<html>
  <body>
Lista partite:<br/>

<c:forEach items="${seasons}" var="season">
	<c:out value="${season.key}"/>***<c:out value="${season.label}"/>-<c:out value="${season.current}"/><br/>
</c:forEach>

  </body>
</html>