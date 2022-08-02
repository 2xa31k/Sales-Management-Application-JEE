<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/struts-tags" prefix="s"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="Img/dior1.jpg">
<title>Profile</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Profile</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="CSS/profile.css" rel="stylesheet">
</head>
<body>
<s:if test='%{#session.user == null}' >
        <c:redirect url="403.jsp"/>
</s:if>
<jsp:include page="nav.jsp" />
<div class="container" style="background-color:white;">
<h3 class="titre"></h3>
<div class="container-overlap  ng-scope" style="background-color:White;">

    </div>
  <div class="row">
    <!-- Left column-->
    <div class="col-md-7 col-lg-8" >
        <div class="card-body">
        <div class="media-body media-middle">
      <h4 class="media-heading">User Profile:</h4>
    </div>
          <table class="table table-striped">
            <tbody>
            <tr>
                <td><em class="ion-document-text icon-fw mr"></em>User ID</td>
                <td class="ng-binding"><s:property value="#session.user.getId()" /></td>
              </tr>
              <tr>
                <td><em class="ion-document-text icon-fw mr"></em>User Name</td>
                <td class="ng-binding"><s:property value="#session.user.getUsername()" /></td>
              </tr>
              <tr>
                <td><em class="ion-document-text icon-fw mr"></em>User Email</td>
                <td class="ng-binding"><s:property value="#session.user.getEmail()" /></td>
              </tr>
              </tbody>
              </table>
              <div class="card-offset-item text-right">
            <button type="button"  class="btn-raised btn btn-circle btn-lg bg-secondary" data-toggle="modal" data-target="#myModal"><em class="fa fa-edit"></em>Modifier</button>
          </div>
              </div>
              </div>
              </div>
              </div>
              
      <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modifier le profile</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="profile" method="post">
        <div class="form-group">
            <label>Username:</label>
            <input type="text" class="input" name="username" value="<s:property value="#session.user.getUsername()" />" required>
            </div>

        <div class="form-group">
            <label >Email:</label>
            <input type="email" class="input" name="email" value="<s:property value="#session.user.getEmail()" />" required>
            </div>
        <div class="form-group">
            <label >password:</label>
            <input type="password" class="input" name="password" value="<s:property value="#session.user.getPassword()" />" required>
            </div>
             <input type="hidden"  id ="id" name="id" value=#session.user.getId()>
                <br>
                <input type="submit" id="profile" class="btn" name="profile" value="Modifier">
        </form>
        </div>
        </div>
        </div>
        </div>
              <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
              
</body>
</html>