import java.io.*;
import java.util.Scanner;
public class userfile{
   public static void main(String[] args) throws Exception {
	   Scanner sc=new Scanner(System.in);
	   String fname,lname,email,phno,city;
	   int i,m;
      try {
         /*
         out.write("aString1\n");
         out.close();
         out = new BufferedWriter(new FileWriter("ex.txt",true));
         out.write("aString2\n");
         out.close();
         out = new BufferedWriter(new FileWriter("ex.txt",true));
         out.write("aString3\n");
         out.close();*/
    	  
    	 System.out.println("Enter the number of names to be added:");
    	 m=sc.nextInt();
    	 for(i=0;i<m;i++) {
         System.out.println("Enter first name,last name\n");
         fname=sc.next();
         lname=sc.next();
         System.out.println("Enter Email, contact and city\n");
         email=sc.next();
         phno=sc.next();
         city=sc.next();
    	 
         BufferedWriter out = new BufferedWriter(new FileWriter("userFile.txt",true));
         out.write(" "+fname+" | "+lname+" | "+email+" | "+phno+" | "+city+" |\n");
         out.close();
    	 }
         BufferedReader in = new BufferedReader(new FileReader("userFile.txt"));
         String str;
         while ((str = in.readLine()) != null) {
            System.out.println(str);
         }
         in.close();
         
      }
     
      catch (IOException e) {
         System.out.println("exception occurred"+ e);
      }
   }
}