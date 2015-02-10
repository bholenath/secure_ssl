import java.net.*;
import java.io.*;



public class Server{
	public static void main(String args[])throws IOException{
		ServerSocket s1=null;
		try{
			s1=new ServerSocket(98);
		}catch(Exception e){
			System.out.println("Port not found");
			e.printStackTrace();
		}
		Socket c=null;
		try{
			c=s1.accept();
			System.out.println("Connection from"+c);
		}catch(Exception e){
			System.out.println("not accepted");
			e.printStackTrace();
		}
		PrintWriter out=new PrintWriter(c.getOutputStream(),true);
		BufferedReader in=new BufferedReader(new InputStreamReader(c.getInputStream()));
		String l;
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("I am ready type now");
		while((l=sin.readLine())!=null){
			out.println(l);
		}
		out.close();
		sin.close();
		c.close();
		s1.close();
	}
}

