
import java.net.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;

public class Client{
	public static void main(String args[])throws IOException{
		Socket s=null;
		BufferedReader b=null;
		try{
			s=new Socket("192.168.38.72",98);
			b=new BufferedReader(new InputStreamReader(s.getInputStream()));
		}catch(Exception e){
			System.out.println("I do not host");
			e.printStackTrace();
		}
		String inp;
		Encrypt eob=new Encrypt();
		try{
		while((inp=b.readLine())!=null){
			
			
			eob.disp(inp);
			
		}
	}
		catch(Exception e){}
		b.close();
		s.close();
	}
}

class Encrypt {


public void disp (String a) throws Exception{
KeyPairGenerator keygenerator = KeyPairGenerator.getInstance("RSA");
SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
keygenerator.initialize(1024, random);

KeyPair keypair = keygenerator.generateKeyPair();
PrivateKey privateKey = keypair.getPrivate();
PublicKey publicKey = keypair.getPublic();
Cipher cipher = Cipher.getInstance("RSA");

cipher.init(Cipher.ENCRYPT_MODE, publicKey);

String st=a;

byte[] cleartext = null;
byte[] ciphertext = null;
byte[] plaintext= null;

cleartext = st.getBytes();

ciphertext = cipher.doFinal(cleartext);
System.out.println("\n\tThe Encrypted text is= "+ciphertext.toString());

System.out.println("Do you want the decrypted text\n Enter the password");

        
		String l;
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
		for(int g=0;g<=2;g++)
		{
		
		
		l=sin.readLine();
		
		

   		if(l.equals("gajju"))
			
		{
		
cipher.init(Cipher.DECRYPT_MODE, privateKey);


plaintext = cipher.doFinal(ciphertext);


System.out.println("\n\tThe Decrypted text is= "+ new String(plaintext));

break;

		}
		else
		{
			System.out.println("Try again"+g);
			
		}

}
		}
}


