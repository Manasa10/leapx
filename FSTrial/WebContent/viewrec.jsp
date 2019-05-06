<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
     <%@ page import="java.text.SimpleDateFormat" %>
     <%@ page import="java.util.Date" %>
     <%@ page import="java.util.Scanner" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body, html {
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
    background-image: url("projplainbg.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
     border: 2px solid black;
}

table, th, td {
    border: 2px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
table {
    border-spacing: 50px;
}
form {
    width: 200px;
    margin: 0 auto;
}
</style>
</head>
<body>
<div class="bg"><div class="bg">
<div id="yourTableIdName">

<h1 style="font-size:4vw" align="center">Summary of products in stock</h1>
<table align="center">
 
<thead>
<tr>
<th>Category</th>
<th>Sub Category</th>
<th>Product</th>
<th>Quantity</th>
<th>Price</th>
<th>Description </th>
</tr>
</thead>
<% 
String fp="C:\\Users\\manas\\eclipse-workspace\\FSTrial\\prodfile.txt";
String cname,sname,stock,price,desc,pname;

BufferedReader br = new BufferedReader(new FileReader(fp));
String str;
int t=0;
while ((str = br.readLine())!=null)
{
	   String rep="*"+t+"\t";
	   if(!str.contains(rep)){
	 	   System.out.println(str);
	   String arr[]=str.split("\\|");
	   cname=arr[1];
	   sname=arr[2];
	   pname=arr[3];
	   stock=arr[4];
	   price=arr[5];
	   desc=arr[6];
 %>
      <tbody>
      <tr>
      <td align="center"><%= cname%></td>
      <td align="center"><%= sname %></td>
      <td align="center"><%= pname %></td>
      <td align="center"><%= stock%></td>
      <td align="center"><%= price %></td>
      <td align="center"><%= desc %></td>
      </tr>
      
      <%          
      
	   }
	   t++;
	   if(t>50)
		   break;
}

%>
</tbody>
 </table>
 <br><br>
<%
br.close();


%>
<br><br>
<br><br>
<form action="view.jsp">
<input type="submit" value="Back" style="height:35px; width:150px">
</form>
<br><br>

</div>
</div>
</body>
</html>
