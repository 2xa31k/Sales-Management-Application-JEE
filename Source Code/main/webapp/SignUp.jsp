<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign UP</title>
	<link rel="stylesheet" type="text/css" href="CSS/Sign-up.css">
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
            <li><a href="#"><img src="Img/logo.jpg"></a></li>
            <li style="float:right"><a href="SignUp.jsp">Inscription</a></li>
            <li style="float:right"><a href="SignIn.jsp">Connexion</a></li>
          </ul>
        </div>
<div class="container">
		<div class="img">
			<img src="Img/SignUP.svg">
		</div>
		<div class="login-content">
			<form method="post" action="signup"	>
			<div class="errorDiv">
      	<h3 style="color:white">
          <s:fielderror fieldName="Vide" />
          <s:fielderror fieldName="Existe" />
          <s:fielderror fieldName="password" />
      	</h3>
      </div>
				<h2 class="title">S'inscrire</h2>   
           		    
                   <div class="input-div one ">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Username</h5>
           		   		<input type="text" name="username" id="Username" class="input" value=""required>
           		   </div>
                   </div>  
                   <div class="input-div two ">
                        <div class="i">
                                <i class="fas fa-at"></i>
                        </div>
                        <div class="div">
                                <h5>Email</h5>
                                <input type="email" name="email" id="email" class="input" value="" required>
                    </div>
           		</div>
                   
           		<div class="input-div pass ">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
                    <div class="div">
                        <h5>Mot de passe</h5>
                        <input type="password" name="password" id="password" class="input" required>
                    </div>
            	</div>
                <div class="input-div pass ">
                    <div class="i"> 
                         <i class="fas fa-lock"></i>
                    </div>
                  <div class="div">
                      <h5>Mot de passe</h5>
                      <input type="password" name="passwordConfirm" id="confirm_password" class="input" required>
                  </div>
              </div>
              <br>
                <a href="SignIn.jsp">Se connecter</a>
            	<input type="submit" class="btn" name="signup" value="s'inscrire">
            </form>
        </div>
    </div>
    <script type="text/javascript" src="JS/sign-up.js"></script>
</body>
</html>