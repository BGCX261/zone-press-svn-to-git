<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.flavio.zonepress.model.Test" %>
<%@ page import="com.flavio.zonepress.utils.PMF" %>

<html>
  <body>

<%
    PersistenceManager pm = PMF.get().getPersistenceManager();
    String query = "select from " + Test.class.getName();
    List<Test> tests = (List<Test>) pm.newQuery(query).execute();
    if (tests.isEmpty()) {
%>
<p>The guestbook has no messages.</p>
<%
    } else {
        for (Test t : tests) {
            if (t.getValue() == null) {
%>
<p>An anonymous person wrote:</p>
<%
            } else {
%>
<p><b><%= t.getValue() %>
<%
            }
        }
    }
    pm.close();
%>


  </body>
</html>