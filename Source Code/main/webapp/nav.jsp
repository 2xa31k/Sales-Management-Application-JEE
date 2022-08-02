<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="CSS/nav.css">
	<link rel="icon" href="Img/dior1.jpg">
</head>
<body>
<s:url var= "articles" action="articles" escapeAmp="false"/>
<s:url var= "logout" action="logout" escapeAmp="false"/>
<s:url var= "viewCommands" action="viewCommands" escapeAmp="false"/>
<div class="nav2">
        <ul>
            <li><s:a href="%{articles}"><img src="Img/logo.jpg" class="img" ></s:a></li>
            <li style="float:right"><s:a href="%{logout}"><img src="Img/logout.png" class="img" ></s:a></li>
             <li style="float:right"><a href="profile.jsp">Profile</a></li>
            <li style="float:right"><s:a href="%{viewCommands}">Commandes</s:a></li>
            <li style="float:right"><s:a href="%{articles}">Articles</s:a></li>
           
          </ul>
        </div>
</body>
</html>