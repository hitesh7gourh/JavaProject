<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>	Insurance Claims page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"rel="stylesheet">


<style>
body,h1,h5 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url('https://www.kindpng.com/picc/m/169-1695691_teardrop-drawing-draw-baby-easy-to-draw-hd.pn');
  min-height: 100%;
  background-position: center;
  background-size: ;
}
</style>






</head>


<body>

<div class="bgimg w3-display-container w3-text-teal">
<h1 align="center" style="margin-bottom:50px">	Insurance Claims page</h1>

<form:form method="POST" action="/claim" class="form-horizontal" modelAttribute="nanny">
<fieldset>
<!-- Form Name -->
<legend align="center"></legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" path="policy" for="textinput">	Policy Number</label>  
  <div class="col-md-4">
  <input id="policy" name="policy" path="policy" type="text" placeholder="Policy Number" class="form-control input-md" required="">
    
  </div>
</div>





<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" path="amount" for="Contact no.">amount of claim</label>  
  <div class="col-md-4">
  <input id="amount" name="amount" path="amount" type="text" placeholder="amount" class="form-control input-md" required="">
    
  </div>
</div>



<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Claim description (freeform description)</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="description" name="description">default text</textarea>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">type of claim </label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">o	Accidental</option>
      <option value="2">o	illness</option>
      <option value="3">o	ENT</option>
      <option value="4">o	others</option>
    </select>
  </div>
</div>


<!-- Button -->
<div  align="center" class="form-group">
  <label    class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
   <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-success">Submit</button></a>
  </div>
</div>

</fieldset>
</form:form>

<!-- Button -->
<div align="center" class=form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <li class="active"> <a href="/userpage">User Page?</button></a></li>
  </div>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>