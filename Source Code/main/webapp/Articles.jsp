<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Articles</title>
	<link rel="icon" href="Img/dior1.jpg">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <link href="CSS/Articles.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
</head>
<body>
<s:if test='%{#session.user == null}' >
        <c:redirect url="403.jsp"/>
</s:if>
<jsp:include page="nav.jsp" />

		<h3 class="titre">Liste des articles disponibles</h3>
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
                            <div id="bootstrap-data-table_filter" class="dataTables_filter dataFilter">
                            <label><input class="form-control" id="myInput" type="text" placeholder="Rechercher.."></label>
                            </div>
                                <table id="bootstrap-data-table" class="sortable table table-striped table-bordered" id="myTable">
                                    <thead>
                                        <tr>
                                        	<th>Logo</th>
                                        	<th>Code</th>
                                            <th>Nom Article</th>
                                            <th >Prix</th>
                                            <th>Description</th>
                                            <th>Quantite</th>
                                            <th>Option</th>
                                            
                                            
                                        </tr>
                                    </thead>
                                    <tbody id="myList">
                                    
                        <s:iterator value="ArticleList">
                                     <tr>     
                                <td><img src="Img/<s:property value="image" />.jpg" class="out-stock"></td>
                                <td><s:property value="code" /></td>                    
                                <td><s:property value="nom" /></td>
                                <td><s:property value="prix" /></td>
                                <td><s:property value="desc" /></td>
                                <s:if test='%{qte==0}' >
        							<td><img src="Img/out-of-stock.png" class="out-stock"></td>
								</s:if>
								<s:else>
										<td><s:property value="qte" /></td>
								</s:else>
                                
                          
                               <td>
                             <form method="post" action="view">
                              <input type="hidden"  name="codeArt" value="<s:property value="code" />">
                              <input type="image" src="Img/plus.png" alt="Submit" class="btn out-stock" name="view" value="View Article">
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