<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Liste de Commandes</title>
	<link rel="icon" href="Img/dior1.jpg">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
      <link href="CSS/Command.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<s:if test='%{#session.user == null}' >
        <c:redirect url="403.jsp"/>
</s:if>
<jsp:include page="nav.jsp" />

		<h3 class="titre">Liste des commandes</h3>
				<div class="row">
							<div class="col-md-12">

                        <div class="card">
                            <div class="card-header">
                            </div>
                            <div class="row">
                            <div class="col-sm-12 col-md-6">
                            </div>
                            </div>

                            <div class="card-body">
                            <div id="bootstrap-data-table_filter" class="dataTables_filter">
                            <label><input class="form-control search" id="myInput" type="text" placeholder="Rechercher.."></label>
                              <form method="post" action="Allfacture" class="fact2">
                              <input type="image" src="Img/pdf.png" alt="Submit" class="btn iconUp" name="Allfacture" value="Facture">
                              </form>
                              <form method="post" action="deleteAllCmd" class="supp2">
                              <input type="hidden"  name="codeCmd" value="<s:property value="codeCmd" />">
                              <input type="image" src="Img/clearAll.jpg" alt="Submit" class="btn iconUp" name="deleteAllCmd" value="supprimer">
                              </form>
                            </div>
                                <table id="bootstrap-data-table" class="sortable table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                        	<th>code</th>
                                            <th>nom client</th>
                                            <th>code article</th>
                                            <th>quantite</th>
                                            <th>Prix Total</th>
                                            <th>Date commande</th>
                                            <th>Options</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody id="myList">
                                    
                        <s:iterator value="commandes">
                                     <tr>     
                                <td><s:property value="codeCmd" /></td>                    
                                <td><s:property value="client" /></td>
                                <td><s:property value="codeArt" /></td>
                                <td><s:property value="qteCmd" /></td>
                                <td><s:property value="PrixTotal" /></td>
                                <td><s:property value="dateCmd" /></td>
                                <td>
                                <form method="post" action="facture" class="fact">
                              <input type="hidden"  name="codeCmd" value="<s:property value="codeCmd" />">
                              <input type="image" src="Img/pdf.png" alt="Submit" class="btn iconT" name="facture" value="Facture">
                              </form>
                              <form method="post" action="deleteCmd" class="supp">
                              <input type="hidden"  name="codeCmd" value="<s:property value="codeCmd" />">
                              <input type="image" src="Img/delete1.png" alt="Submit" class="btn iconT" name="deleteCmd" value="supprimer">
                              </form>
                                </td>
                                                                                                                    
                                     </tr>
                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                            </div>
                            </div>
                            </div>
                            	
                            
                            
                        

           
                            

<script src="JS/sort.js"></script>
<script src="JS/JQuery.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
</body>
</html>