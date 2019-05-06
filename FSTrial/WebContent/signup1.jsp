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
String rpswd=request.getParameter("rpswd");
System.out.println("m:"+email+" p:"+pswd+" rp:"+rpswd);  

if(pswd.equals(rpswd)){
	
	int tarr=0,fixedpos=0;
	   String sub,ninput="",indninput="";
	   String line;
	       String input = "";
	       String farr[] = new String[51];
	       int flen,asc=0,pos,m;
	       String fp="C:\\Users\\manas\\eclipse-workspace\\FSTrial\\customer.txt";
    try 
    {
	  BufferedReader br = new BufferedReader(new FileReader(fp));
	       
	       flen=0;
	       while((line = br.readLine()) != null && flen<50)
	       {
	    	   farr[flen]=line;
	    	   input += line + '\n';
	    	   flen++;
	    	   
	       }
	      br.close();
	      	 
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		   Date date = new Date();  
		   System.out.println(formatter.format(date));  
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
	   	   
	      
	      
	       boolean flag=false;
	       do {
	    	  sub="*"+pos+"\t";
	    	  if(farr[pos].contains(sub)) {
	    		  String record="-"+pos+"|"+email+"|"+pswd+"|"+formatter.format(date)+"|";
	 		      System.out.println(record+"\n");
	    		  System.out.println("Space available");
	    		  farr[pos]=record;
	    		  //indninput=indinput.replace(sub, indrec);
	    		  flag=true;
	    	  }
	    	  else {
	    		  System.out.println("pos1:"+pos);
	    		  pos=(pos+1)%50;
	    		  if(fixedpos==pos)
	    			  break;
	    		  System.out.println("pos2:"+pos);
	    	  }
	       }while(!flag);
	   if(flag){
	   	   input="";
	   	   for(int h=0;h<50;h++) 
	   		      input+=farr[h]+"\n";
	   		
	   	   BufferedWriter bw = new BufferedWriter(new FileWriter(fp));
	   	   bw.write(input);
	   	   bw.close();
	   	   
	   }
	   br = new BufferedReader(new FileReader(fp));
	   String str;
	   int t=0;
	   while ((str = br.readLine())!=null)
	   {
		   String rep="*"+t+"\t";
		   if(!str.contains(rep))
		 	   System.out.println(str);
	   	   t++;
	   	   if(t>50)
	   		   break;
	   }
	   br.close();
	   response.sendRedirect("view.jsp");
	   
}
catch (IOException e) {
  System.out.println("exception occurred "+ e);
}

}
else
response.sendRedirect("error.jsp");



%>
</body>
</html>