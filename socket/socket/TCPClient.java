import java.net.*;
import java.io.*;
public class TCPClient{
	public static void main(String args[]) throws Exception{
		String localIP="127.0.0.1";
	/* 	String remoteIP="219.245.71.100";
		InetAddress remoteAddress=null;
		InetAddress localAddress =null;
		try{
				localAddress = InetAddress.getByName(localIP);
				remoteAddress = InetAddress.getByName(remoteIP);
		}catch(UnknownHostException e){
			e.printStackTrace();
		} */
		
		//Socket s=new Socket(localAddress,6666);
		Socket s=new Socket("127.3.2.3",6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos =new DataOutputStream(os);
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		s.close();
	}

}