/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.PrintStream;
/*    */ import java.security.KeyPair;
/*    */ import java.security.KeyPairGenerator;
/*    */ import java.security.PrivateKey;
/*    */ import java.security.PublicKey;
/*    */ import java.security.SecureRandom;
/*    */ import javax.crypto.Cipher;
/*    */ 
/*    */ class Encrypt
/*    */ {
/*    */   public void disp(String a)
/*    */     throws Exception
/*    */   {
/* 38 */     KeyPairGenerator keygenerator = KeyPairGenerator.getInstance("RSA");
/* 39 */     SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
/* 40 */     keygenerator.initialize(1024, random);
/*    */     
/* 42 */     KeyPair keypair = keygenerator.generateKeyPair();
/* 43 */     PrivateKey privateKey = keypair.getPrivate();
/* 44 */     PublicKey publicKey = keypair.getPublic();
/* 45 */     Cipher cipher = Cipher.getInstance("RSA");
/*    */     
/* 47 */     cipher.init(1, publicKey);
/*    */     
/* 49 */     String st = a;
/*    */     
/* 51 */     byte[] cleartext = null;
/* 52 */     byte[] ciphertext = null;
/* 53 */     byte[] plaintext = null;
/*    */     
/* 55 */     cleartext = st.getBytes();
/*    */     
/* 57 */     ciphertext = cipher.doFinal(cleartext);
/* 58 */     System.out.println("\n\tThe Encrypted text is= " + ciphertext.toString());
/*    */     
/* 60 */     System.out.println("Do you want the decrypted text\n Enter the password");
/*    */     
/*    */ 
/*    */ 
/* 64 */     BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
/* 65 */     for (int g = 0; g <= 2; g++)
/*    */     {
/* 69 */       String l = sin.readLine();
/* 73 */       if (l.equals("gajju"))
/*    */       {
/* 77 */         cipher.init(2, privateKey);
/*    */         
/*    */ 
/* 80 */         plaintext = cipher.doFinal(ciphertext);
/*    */         
/*    */ 
/* 83 */         System.out.println("\n\tThe Decrypted text is= " + new String(plaintext));
/*    */         
/* 85 */         break;
/*    */       }
/* 90 */       System.out.println("Try again" + g);
/*    */     }
/*    */   }
/*    */ }


/* Location:           G:\Study\Project\
 * Qualified Name:     Encrypt
 * JD-Core Version:    0.7.0.1
 */