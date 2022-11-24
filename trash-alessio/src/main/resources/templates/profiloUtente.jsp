<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="matchday\src\main\resources\static\css\style.css" rel="stylesheet" type="text/css">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

<title>Area Personale Utente</title>
</head>
<body>

	 <!-- A grey horizontal navbar that becomes vertical on small screens -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	
	

	 
	 

	  <div class="container-fluid">
      	<a class="navbar-brand" href="home" style="position:fixed; right:0;">MatchDay</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
  
  
  
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
    
      <ul class="navbar-nav">
      
      <li class=navbar-nav>
      <a class=nav-link onclick="myFunction()" href="#">Area Personale</a>
      </li>
      
      
      
        <li class="nav-item dropdowns">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button">Deposita</a>
          <form class="navbar-form navbar-left" action="/deposita" method="post">
          <ul class="dropdown-menu">
          <li> <a class="dropdown-item" href="#"><input type="number" name="numDep" min="0" placeholder= "Inserire cifra Deposito"></a></li>
          <li><a class="dropdown-item" href="profiloUtente"><input type="submit" value="Submit"></a></li> 
             
      	</ul>
	</form> 
        
        </li> 
    
        <li class="nav-item dropdowns">
        
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button">Preleva</a>
          <form class="navbar-form navbar-left" action="/preleva" method="post">
          <ul class="dropdown-menu">
          
          <li><a class="dropdown-item" href="#"><input type="number" name="numPre" min="0" placeholder = "Inserire cifra Prelievo"></a></li>
          <li><a class="dropdown-item" href="profiloUtente"><input type="submit" value="Submit"> </a>
          </li>
         
      	</ul>
      
      	</form> 	
          </li>
          
          <li class="nav-item">
          <a class="nav-link"  href="profiloUtente/visualizzaSchedine" onclick="visualizza()" >Storico Schedine</a>
          </li>
          </ul>
  	  </div>
 	  
  	   </div>
  
  	   	</nav> 

<div id="myDIV">  	   
<table class="table">
	<thead class="thead-dark" >
    <tr>
      <th scope="col">Nome</th>
      <td th:text=${utente.nome}></td>
    </tr>
    <tr>
      <th scope="col">Cognome</th>
      <td th:text=${utente.cognome}></td>
    </tr>
    <tr>
      <th scope="col">Email</th>
      <td th:text=${utente.email}></td>
    </tr>
    <tr>
      <th scope="col">Saldo</th>
      <td th:text=${utente.saldo}></td>
      <td th:text=${risultato}></td>
	</tr>
	</thead>
</table>
</div>
<hr>

<div id="listaSchedine">
<table>
			<tr>
				<th  width=20%>SCHEDINE GIOCATE</th>
			</tr>
				<tr> 
		            <td width=7%>NOME</td>
		            <td width=7%>COGNOME</td>
		            <td width=20%>EMAIL</td>
		            <td width=7%>SALDO</td>  
	            </tr>
			<th:block th:each="schedina : ${schedinaList}">
		            <td th:text=${schedina.importo}>   </td>

	                  
	         </th:block>
		</table> 
 </div>


	 
<script>
function visualizza() {
	
	document.getElementById("listaSchedine").hidden = false;
}

function myFunction() {
	  var x = document.getElementById("myDIV");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}</script>
</body>
</html>
