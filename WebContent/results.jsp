<%@page import="com.to.Player"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="ad" uri="WEB-INF/playertags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> Your Search Results will be here</h1>
<br>
<br>
<%if(session != null && session.getAttribute("playerList")!=null){ 
	String headers[]=(String[])session.getAttribute("headers");
List<Player>playerList= (List<Player>)session.getAttribute("playerList");%>

<ad:playerResults playerList="<%=playerList %>" headers="<%=headers%>"/>

<%} %>
</body>
</html>