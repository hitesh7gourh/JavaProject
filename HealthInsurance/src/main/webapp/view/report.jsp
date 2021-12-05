<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Nanny Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
    .bs-example{
    	margin: 20px;
    }
</style>
 <h1>Claim Report</h1>
   </head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" >Health Insurance</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/Admin">Admin Page</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/"><input type="button" value="Logout"
						id="userbutton" class="btn btn-danger navbar-btn""></a></li>
			</ul>
		</div>
	</nav>
<br>
<form class="form-horizontal" method="get" modelAttribute="claim" >
		<fieldset>
<div class="bs-example">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Policy no.</th>
                <th>Amount</th>
                <th>Description</th>
                 <th>Status</th>
                
            </tr>
        </thead>
        <tbody>
        <c:forEach items= "${claim}" var="claim">
            <tr>
                <td>${claim.id}</td>
                <td>${claim.policy}</td>
                <td>${claim.amount}</td>
                <td>${claim.description}</td>
              
					<td>
				<form action="setStatus" >
				<input type="submit" name="status" value="Approve">
				<input type="submit" name="status"  value="Reject">
				<input type="text" name="policy" value="${claim.policy}" hidden> 
				</form>
				</td>			
            </tr>
             	</c:forEach>
              
        </tbody>
    </table>
</div>
</body>
</html>