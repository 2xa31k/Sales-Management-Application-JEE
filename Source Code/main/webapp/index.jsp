<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
	<link rel="icon" href="Img/dior1.jpg">
	<link rel="stylesheet" type="text/css" href="CSS/index.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<s:if test='%{#session.user != null}' >
	        <c:redirect url="articles"/>
	</s:if>
<div class="container"></div>
    <div class="nav">
        <ul>
            <li><a href="#"><img src="Img/logo.jpg"></a></li>
            <li style="float:right"><a href="SignUp.jsp">Inscription</a></li>
            <li style="float:right"><a href="SignIn.jsp">Connexion</a></li>
          </ul>
        </div>
        <br><br><br>
        <h1 style="text-align:center"><strong>DIOR Gestion de Vente</strong></h1>
        <div class="img" style="width:100%;height:400px;">
            <img src="Img/dior.svg" alt="Image" style="float:left;width:100%;height:100%;">
           </div>
            <div class="text"><p></p></div>
    <div class="Forms">
    <ul>
        <li><a href="SignIn.jsp"><i class="fas fa-sign-in-alt"></i>Connexion</a></li>
        <li><a href="SignUp.jsp"><i class="fas fa-user-plus"></i>Inscription</a></li>
    </ul>
    </div>
</body>
</html>