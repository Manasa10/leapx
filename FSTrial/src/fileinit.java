import java.io.*;

public class fileinit {
	 public static void main(String[] args) throws Exception {
		/* BufferedWriter bw = new BufferedWriter(new FileWriter("prodfile.txt"));
		   for(int fi=0;fi<50;fi++) {
			   bw.write("*"+fi+"\t\n");
	   	   }
		   bw.close();*/
		   
		   BufferedWriter bw = new BufferedWriter(new FileWriter("customer.txt"));
		   for(int fi=0;fi<50;fi++) {
			   bw.write("*"+fi+"\t\n");
	   	   }
		   bw.close();
		   
	 }

}
