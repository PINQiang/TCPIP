import java.net.*;
import java.io.*;

public class TestUDPClientLong{
	public static void main(String args[]) throws Exception{
	
		/***
		*send long type data
		*/
		long n=2000l;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		byte [] buf =baos.toByteArray();
		System.out.println(buf.length);
		DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",5678));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
	
	}

}