/*    */ import java.io.PrintStream;
/*    */ import javax.net.ssl.SSLServerSocket;
/*    */ import javax.net.ssl.SSLServerSocketFactory;
/*    */ import javax.net.ssl.SSLSocket;
/*    */ 
/*    */ public class Main
/*    */ {
/*    */   public static void main(String[] argv)
/*    */     throws Exception
/*    */   {
/*  7 */     SSLServerSocketFactory factory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
/*  8 */     SSLServerSocket serverSocket = (SSLServerSocket)factory.createServerSocket(8080);
/*  9 */     String[] suites = serverSocket.getSupportedCipherSuites();
/* 10 */     for (int i = 0; i < suites.length; i++) {
/* 11 */       System.out.println(suites[i]);
/*    */     }
/* 13 */     serverSocket.setEnabledCipherSuites(suites);
/* 14 */     String[] protocols = serverSocket.getSupportedProtocols();
/* 15 */     for (int i = 0; i < protocols.length; i++) {
/* 16 */       System.out.println(protocols[i]);
/*    */     }
/* 18 */     SSLSocket socket = (SSLSocket)serverSocket.accept();
/* 19 */     socket.startHandshake();
/* 20 */     System.out.println(socket.getRemoteSocketAddress());
/*    */   }
/*    */ }


/* Location:           G:\Study\Project\
 * Qualified Name:     Main
 * JD-Core Version:    0.7.0.1
 */