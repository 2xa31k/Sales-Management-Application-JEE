<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Sign IN</title>
	<link rel="stylesheet" type="text/css" href="CSS/SignIn.css">
	<link rel="icon" href="Img/dior1.jpg">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
	<body>
	<s:if test='%{#session.user != null}' >
	        <c:redirect url="articles"/>
	</s:if>
	<div class="nav2">
        <ul>
            <li><a href="index.jsp"><img src="Img/logo.jpg"></a></li>
            <li style="float:right"><a href="SignUp.jsp">Inscription</a></li>
            <li style="float:right"><a href="SignIn.jsp">Connexion</a></li>
          </ul>
        </div>
<div class="container">

	
		<div class="img">
			<img src="Img/dior.svg">
		</div>
<div class="login-content">
	
	
			<form method="post" action="login">
			<div class="errorDiv" >
      	<h3 style="color:white">
          <s:fielderror fieldName="Error" />
      	</h3>
      </div>
      <div class="successDiv" >
      	<h3 style="color:white">
          <s:actionmessage/>
      	</h3>
      </div>
			
				<h2 class="title">Connexion</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Email</h5>
           		   		<input type="email" class="input" name="email" value="" required>
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Mot de passe</h5>
           		    	<input type="password" class="input" name="password" required>
            	   </div>
            	</div>
                <a href="SignUp.jsp">Cree un compte?</a>
            	<input type="submit" class="btn" name="login" value="Authentification">
            </form>
        </div>
        </div>
          <script type="text/javascript" src="JS/sign-in.js"></script>
</body>
</html>