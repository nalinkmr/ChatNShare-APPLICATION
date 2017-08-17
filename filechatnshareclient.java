import java.net.*;
import java.io.*; 
public class filechatnshareclient {
public static void main (String [] args ) throws IOException {
	int filesize=1022386;
	 int bytesRead; 
	 int currentTot = 0;

	  Socket socket = new Socket("127.0.0.1",3000);
	  byte [] bytearray = new byte [filesize]; 
	  InputStream is = socket.getInputStream();
	  FileOutputStream fos = new FileOutputStream("C:/Users/nalinkmr/Desktop/copy.jpg");
	  BufferedOutputStream bos = new BufferedOutputStream(fos);
	  bytesRead = is.read(bytearray,0,bytearray.length); 
	  currentTot = bytesRead;
	       do
	        {
	        	   //  System.out.println("file recieved");
	         bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
	        if(bytesRead >= 0) currentTot += bytesRead; 
	    } 
	    while(bytesRead > -1); 
	   	System.out.println("file recieved");
	    bos.write(bytearray, 0 , currentTot);
	     bos.flush();
	      bos.close();
	     socket.close(); 
	 } 
	}
