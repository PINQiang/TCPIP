import java.net.*;
import java.io.*;
public class TCPServer{
	public static void main(String[] args) throws Exception{
	/* 	InetAddress localAddress =null;
		String localIP="219.245.71.100";
		try{
			localAddress = InetAddress.getByName(localIP);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		//ServerSocket ss=new ServerSocket(6666,30,localAddress);//阻塞式的，等待着 */
		ServerSocket ss=new ServerSocket(6666);
		System.out.println("wait connecting ---\n");
		while(true){
			Socket s=ss.accept();
			System.out.println("A client connect---\n");
			InputStream in = s.getInputStream();
			DataInputStream dis =new DataInputStream(in);
			System.out.println(dis.readUTF()); //readUTF 也是阻塞式的
			dis.close();
			s.close();
		}
	}
}
