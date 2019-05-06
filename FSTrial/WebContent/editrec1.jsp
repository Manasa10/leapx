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
<title></title>
</head>
<body>
<%
String cname,sname,stock,price,desc;

String pedit=request.getParameter("pname");
int fixedpos=0,m,pos;
String sub,ninput="";
String line;
String fp="C:\\Users\\manas\\eclipse-workspace\\FSTrial\\prodfile.txt";
    String input = "";
    String farr[] = new String[50];
    int flen=0,asc=0;
    cname=request.getParameter("cname");
 	sname=request.getParameter("sname");
 	stock=request.getParameter("stock");
 	price=request.getParameter("price");
 	desc=request.getParameter("desc");
try {

pedit.toLowerCase();
char cha[]=pedit.toCharArray();
asc=0;
for(int j=1;j<=cha.length;j++)
{
		m=cha[j-1];
		System.out.println("m:"+m);
		asc=asc+m*j;
}
pos=(asc/cha.length)%50;
if(pos>=0)
  System.out.println("full:"+pos+" asc:"+asc);
fixedpos=pos;
BufferedReader br = new BufferedReader(new FileReader(fp));
       
while((line = br.readLine()) != null)
{
	   farr[flen]=line;
	   input += line + '\n';
	   flen++;
	   
}
br.close();
  System.out.println("1here");
  System.out.println(farr[pos]);
    boolean flag=false;

do {
       System.out.println("2here");
       	
     if(farr[pos].contains(pedit)) 
 	  {
    	 String samp[]=farr[pos].split("\\|");
    	 if(cname=="")
    		 cname=samp[1];
    	 if(sname=="")
    		 sname=samp[2];
    	 if(stock=="")
    		 stock=samp[4];
    	 if(price=="")
    		 price=samp[5];
    	 if(desc=="")
    		 desc=samp[6];
 		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		  Date date = new Date();  
		  System.out.println(formatter.format(date));  
		  String record="-"+pos+"|"+cname+"|"+sname+"|"+pedit+"|"+stock+"|"+price+"|"+desc+"|"+formatter.format(date)+"|";
		  System.out.println(record+"\n");
		  farr[pos]=record;
		  flag=true;
	     }
 	  else
 	  {
	         System.out.println("3here");

 		  pos=(pos+1)%50;
 		  if(fixedpos==pos) {
 			  System.out.println("Record not found");
 			  break;
 		  }  
 	  }
	  }while(!flag);
if(flag) {
input="";
   for(int h=0;h<farr.length;h++) {
		   input+=farr[h]+"\n";
	    }
BufferedWriter bw = new BufferedWriter(new FileWriter(fp));
   bw.write(input);
   bw.close();
   response.sendRedirect("view.jsp");
}
else{
	  System.out.println("Record not found");
	  response.sendRedirect("error.jsp");
}
}
catch(Exception e) {
System.out.println(e);
}

%>
</body>
</html>