import java.io.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Scanner;
public class prodfile1{
	   static Scanner sc=new Scanner(System.in);
	   static String cname,sname,pname,stock,price,desc;
	   static int i,m,c;
	   static int pos;
    
	   public static void main(String[] args) throws Exception {
		 /* 
		  * BufferedWriter bw = new BufferedWriter(new FileWriter("prodfile.txt"));
		   for(int fi=0;fi<50;fi++) {
			   bw.write("*"+fi+"\t\n");
	   	   }
		   bw.close();
		   */
		   System.out.println("Enter the number of names to be added:");
    	   c=sc.nextInt();	
    	   addRecord(c);
    	   //editRecord();
    	   delRecord();
	   }
	   //method to add records
	   public static void addRecord(int c) {
		   int fixedpos=0;
		   String sub,ninput="",indninput="";
		   String line;
		       String input = "";
		       String farr[] = new String[51];
		       int flen,asc=0;
       try 
       {
    	   /*BufferedWriter bw = new BufferedWriter(new FileWriter("indprodfile.txt",true));
		   for(int k=0;k<50;k++) {
			   bw.write("*"+k+"\t\n");
	   	   }
		   bw.close();
		      */

		       BufferedReader br = new BufferedReader(new FileReader("prodfile.txt"));
		       
		       flen=0;
		       while((line = br.readLine()) != null && flen<50)
		       {
		    	   farr[flen]=line;
		    	   input += line + '\n';
		    	   flen++;
		    	   
		       }
		      br.close();
		      	 
    	   for(int count=0;count<c;count++)
    	   {
    		   System.out.println(count+" count\n");
    		   System.out.println("Enter category,subcategory and product\n");
    		   cname=sc.next();
    		   sname=sc.next();
    		   pname=sc.next();
    		   pname.toLowerCase();
    		   System.out.println("Enter stock, price and description\n");
    		   stock=sc.next();
    		   price=sc.next();
    		   desc=sc.next();
    		   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    		   Date date = new Date();  
    		   System.out.println(formatter.format(date));  
    		   asc=0;
    		   char cha[]=pname.toCharArray();
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
  		   	   
 		      /*br = new BufferedReader(new FileReader("indprodfile.txt"));
		       
		       String indline;
		       String indinput = "";
		       while((indline = br.readLine()) != null)
		       {
		           indinput += indline + '\n';
		       }
		      br.close();*/
 		      
 		       boolean flag=false;
 		       do {
 		    	  sub="*"+pos+"\t";
 		    	  if(farr[pos].contains(sub)) {
 		    		  //tarr=pos;
 		    		  String record="-"+pos+"|"+cname+"|"+sname+"|"+pname+"|"+stock+"|"+price+"|"+desc+"|"+formatter.format(date)+"|";
 		 		      System.out.println(record+"\n");
 		 		      String indrec="-"+pos+"|"+pname;
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
 		       
 		     
  		   }
    	   
		   	   input="";
		   	   for(int h=0;h<50;h++) {
		   		   //if(h==tarr)
		   			 //  input+=ninput+"\n";
		   		   //else
		   			   input+=farr[h]+"\n";
		   		   
		   	   }
		   	BufferedWriter	bw = new BufferedWriter(new FileWriter("prodfile.txt"));
		   	   bw.write(input);
		   	   bw.close();
		   	   bw = new BufferedWriter(new FileWriter("indprodfile.txt"));
	   	     bw.write(indninput);
	   	     bw.close();
  		   
    	   br = new BufferedReader(new FileReader("prodfile.txt"));
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
		   
		   /*br = new BufferedReader(new FileReader("indprodfile.txt"));
		   t=0;
		   System.out.println("Index");
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
*/
         
      }
      catch (IOException e) {
         System.out.println("exception occurred"+ e);
      }
	  }
	   
	  //Method to edit existing records
	   public static void editRecord() {
		   int tarr=0,fixedpos=0;
		   String sub,ninput="";
		   String line,pedit;
		       String input = "";
		       String farr[] = new String[50];
		       int flen=0,asc=0;
       try {
    	  System.out.println("Enter product name to edit");
    	  pedit=sc.next();
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
		  BufferedReader br = new BufferedReader(new FileReader("prodfile.txt"));
	              
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
		    	  if(farr[pos].contains(pedit)) 
		    	  {
		    		  
		    	  System.out.println("\nEnter category,subcategory\n");
	    		  cname=sc.next();
	    		  sname=sc.next();
	    		  System.out.println("Enter stock, price and description\n");
	    		  stock=sc.next();
	    		  price=sc.next();
	    		  desc=sc.next();
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
	   	BufferedWriter bw = new BufferedWriter(new FileWriter("prodfile.txt"));
	   	   bw.write(input);
	   	   bw.close();
	      }
	      else
	    	  System.out.println("Record not found");
	  }
      catch(Exception e) {
    	  System.out.println(e);
      }
   }

	//Method to delete record
	public static void delRecord(){
		String line;
	      String pdel,input = "";
	      String res=" ";
	      String src="";
	      String ninput="";
	       String farr[] = new String[50];
          int flen=0;
	  try {
	  
  	  System.out.println("Enter product name to delete");
  	  pdel=sc.next();
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
		  BufferedReader br = new BufferedReader(new FileReader("prodfile.txt"));
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
	     	BufferedWriter bw = new BufferedWriter(new FileWriter("prodfile.txt"));
	   	   bw.write(input);
	   	   bw.close();
	      }
	      else
	    	  System.out.println("Record not found");
	  }
		  
	  catch(Exception e) {
    	  System.out.println(e);
      }
}
}  
		  
     	  /* BufferedReader br = new BufferedReader(new FileReader("prodfile.txt"));
	      
	      while((line = br.readLine()) != null)
	      {
	          input += line + '\n';
	      }
	      br.close();
	      
	      src="-"+pos+"|";
	      if(input.contains(src)) {
	    	  do {
	    	  
	    	     src="-"+pos+"|";
	    		  int spos=input.indexOf(src);
		    	  int endpos=input.indexOf("\n", spos);
		    	  System.out.println("spos:"+spos+" epos:"+endpos);
		    	  res=input.substring(spos, endpos);
		    	 
		    	  if(res.contains(pdel)) 
		    	  {
		    	   String record="*"+pos+" ";
	    		  System.out.println(record+"\n");
	    		  ninput=input.replace(res,record);
	    	     }
		    	  else
		    	  {
		    		  pos=(pos+1)%50;
		    		  if(temp==pos) {
		    			  System.out.println("Record not found");
		    			  break;
		    		  }  
		    	  }
	    	  }while(!res.contains(pdel));
	    	  BufferedWriter bw = new BufferedWriter(new FileWriter("prodfile.txt"));
		       	  bw.write(ninput);
		       	  bw.close();
	    	}
	      else {
	    	  System.out.println("Record not found");
	      }
	  }*/
      