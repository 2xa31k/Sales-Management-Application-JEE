<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/struts-tags" prefix="s"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article Page</title>
	<link rel="icon" href="Img/dior1.jpg">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="CSS/ArticlePage.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
<style>

</style>
</head>
<body>	
<s:if test='%{#session.user == null}' >
        <c:redirect url="403.jsp"/>
</s:if>
<jsp:include page="nav.jsp" />
<div class="container">
  <div class="row justify-content-center p-3">
   <s:iterator value="ArticleList">
   
    <div class="col-auto" id="div1">
      <img src="Img/<s:property value="image"/>.jpg" width="300px" height="300px"/>
    </div>
    <div class="col-auto" id="div2">
    
                               
      		<p><h2>Nom Article:</h2><s:property value="nom"/></p>
      		<p><h2>Description</h2> <s:property value="desc"/></p>
            <p><h2>Prix:</h2> <s:property value="prix"/></p>
            <p><h2>qte:</h2> <s:property value="qte"/></p>                               
            <input type="hidden"  id ="qte" value="<s:property value="qte" />">        
            <s:if test='%{qte==0}' >
        		<img src="Img/out-of-stock.png" class="out-stock">
			</s:if>
			<s:else>
                <button class="btn btn-primary bg-secondary"  data-toggle="modal" data-target="#myModal" onclick="getvalueEdit(this.id);" type="submit" id="<s:property value="code" />">Commander</button>                                                                                     
            </s:else>         
    </div>
      </s:iterator>
  </div>
</div>
<div class="modal fade" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Commander Article</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="addCommande" method="post">
        <div class="form-group">
            <h4>Client:</h4>
           	<input type="text" class="input" name="client" value="" required>
            </div>
             <div class="form-group">
              <h4>Quantite:</h4>
            <input type="number" id="qteCmd" name="qteCmd"
       min="1" max="" value="1">
       </div>
        <input type="hidden"  id ="codeArt" name="codeArt">
                <br>
                <input type="submit" id="Command" class="btn-secondary" name="addCommande" value="Commander">
                <button type="button" class="btn-secondary" data-dismiss="modal">Close</button>
            </form>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
          
        </div>
        </div>
        </div>
        </div>

        
        <script src="JS/JQuery.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
</body>
</html>