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
</head>
<body>
<%
String email=request.getParameter("email");
String pswd=request.getParameter("pswd");
int tarr=0,fixedpos=0;
String sub,ninput="",indninput="";
String line;
    String input = "";
    String farr[] = new String[51];
    int flen,asc=0,pos,m;
    String fp="C:\\Users\\manas\\eclipse-workspace\\FSTrial\\customer.txt";

try 
{
	   //BufferedWriter bw = new BufferedWriter(new FileWriter(fp,true));
	   /*for(int k=0;k<50;k++) {
		   bw.write("*"+k+"\t\n");
	   }
	   bw.close();*/
	      

	       BufferedReader br = new BufferedReader(new FileReader(fp));
	       
	       flen=0;
	       while((line = br.readLine()) != null && flen<50)
	       {
	    	   farr[flen]=line;
	    	   input += line + '\n';
	    	   flen++;
	    	   
	       }
	      br.close();
	      	 
	       asc=0;
		   char cha[]=email.toCharArray();
	   	   for(int j=1;j<=cha.length;j++)
	   	   {
	   	   		m=cha[j-1];
	   	   		System.out.println("m:"+m);
	   	   		asc=asc+m*j;
	   	   }
	   	   pos=(asc/cha.length)%50;
	   	   fixedpos=pos;
	   	   if(pos>=0)
	   	   System.out.println("full:"+pos+" asc:"+asc);
	   	   
	   	  System.out.println(farr[pos]);
	      
	       boolean flag=false;
	       do {
	    	  sub="*"+pos+"\t";
	    	   
	    	  if(!farr[pos].contains(sub)){
	    	   String newa[]=farr[pos].split("\\|");
	    	  for(int tr=0;tr<newa.length;tr++)
	    		  System.out.println(newa[tr]);

	    	  if(newa[1].equals(email) && newa[2].equals(pswd)){
	    		  flag=true;
	    		  System.out.println("my name here");

	    	  }
	    		  
	    	  else {
	    		  System.out.println("pos1:"+pos);
	    		  pos=(pos+1)%50;
	    		  if(fixedpos==pos)
	    			  break;
	    		  System.out.println("pos2:"+pos);
	    	  }
	    	  }
	    	  else {
	    		  System.out.println("pos1:"+pos);
	    		  pos=(pos+1)%50;
	    		  if(fixedpos==pos)
	    			  break;
	    		  System.out.println("pos2:"+pos);
	    	  }
	       }while(!flag);
	       
	   	   if(flag)
	   		response.sendRedirect("view.jsp");
	   	   else
	   		response.sendRedirect("error.jsp");
	   
}
catch (IOException e) {
  System.out.println("exception occurred"+ e);
}
%>
</body>
</html>