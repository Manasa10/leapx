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
String line;
String pdel,input = "";
String res=" ";
String src="";
String ninput="";
 String farr[] = new String[50];
int flen=0,m=0,pos;
String fp="C:\\Users\\manas\\eclipse-workspace\\FSTrial\\prodfile.txt";
try {

pdel=request.getParameter("pname");
pdel.toLowerCase();
char cha[]=pdel.toCharArray();
int asc=0;
for(int j=1;j<=cha.length;j++)
{
		m=cha[j-1];
 		System.out.println("m:"+m);
 		asc=asc+m*j;
}
pos=(asc/cha.length)%50;
int temp=pos;
if(pos>=0)
    System.out.println("full:"+pos+" asc:"+asc);
int fixedpos=pos;
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
        	
		  /*int spos=input.indexOf(src);
  	  int endpos=input.indexOf("\n", spos);
  	  System.out.println("spos:"+spos+" epos:"+endpos);
  	  res=input.substring(spos, endpos);
  	 */
  	  if(farr[pos].contains(pdel)) 
  	  {
  		  farr[pos]="*"+pos+"\t";
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
else
	  System.out.println("Record not found");
      response.sendRedirect("error.jsp");
}

catch(Exception e) {
System.out.println(e);
}
%>
</body>
</html>