//import java.io.*;
import java.util.Scanner;
public class fileclass{
   public static void main(String[] args) throws Exception {
	   Scanner sc=new Scanner(System.in);
	   //System.out.println("enter the name of product");
	   String name;
	   String arr[]= {"apple","orange","banana","kurkure","chocolate","sprite","appy","abc","abcd","abcde","abdef"};
	   int m,n,i=0,asc=0;
	   char a,b;
	   do {
		   name=arr[i];
	  /* if(name.length()>1) {
		   a=name.charAt(0);
		   b=name.charAt(1);
		   m=a;
		   n=b;
		   System.out.println(a+" "+b+" "+((m*n)%50));
	   }*/
	   i++;
	   //System.out.println("\n");
	   char cha[]=name.toCharArray();
	   for(int j=0;j<cha.length;j++) {
		   m=cha[j];
		   asc=asc+m*j;
	   }
	   System.out.println("full:"+(asc/cha.length)%50);
	   }while(i<11);
	   
	   sc.close();
	  
   }
}