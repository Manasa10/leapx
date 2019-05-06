<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer registration</title>

<style>
body, html {
    height: 100%;
    margin: 0;
}

.center {
  text-align: center;
  }

.bg {
    /* The image used */
    background-image: url("projplainbg.jpg");

    /* Full height */
    height: 120%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
     border: 2px solid black;
}
table.center {
    margin-left:auto; 
    margin-right:auto;
  }
table {
  font-family: arial, sans-serif;
  size:12px;
  border-collapse: collapse;
  width: 60%;
  align:center;
}

td, th {
  border: 3px solid #ffffff;
  text-align: left;
  padding: 8px;
}

tr: {
  background-color: #dddddd;
  opacity: 0.7;
}
</style>
</head>

<body>

<div class="bg">
<div class="center"><h1>Enter details</h1></div>
<form action="addrec1.jsp">
<table class="center">
  <tr>
    <th>Category</th>
    <th><input type="text" placeholder="Enter category" name="cname" size="35" style="height:30px" required></th>
    
  </tr>
  <tr>
    <th>Sub category</th>
    <td><input type="text" placeholder="Enter sub category" name="sname" size="35" style="height:30px" required></td>
 
  </tr>
  <tr>
    <th>Product</th>
    <td><input type="text" placeholder="Enter product" name="pname" size="35"  style="height:30px" required></td>
  </tr>
  <tr>
    <th>Quantity</th>
    <td><input type="text" placeholder="Enter quantity" name="stock" size="35" style="height:30px" required></td>

  </tr>
  <tr>
    <th>Price</th>
    <td><input type="text" placeholder="Enter price" name="price" size="35" style="height:30px" required></td>

  </tr>
  <tr>
    <th>Description</th>
    <td><input type="text" placeholder="Enter description" name="desc" size="35" style="height:30px" required></td>

  </tr>
  
</table>
<br><br>
    <div class="center"> <input type="submit" value="Submit" style="height:30px; width:150px"></div>

</form><br>
<form action="view.jsp">
    <div class="center"> <input type="submit" value="Back" style="height:30px; width:150px"></div>

</form>
</div>

</body>

</html>
