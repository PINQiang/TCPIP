import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
public class ChatServer {
	public static void main(String[] args) {
		boolean started = false;
		try{
			ServerSocket ss = new ServerSocket(8888);
			started = true;
			while(started){
				boolean bConnected = false;
				Socket s = ss.accept();
System.out.println("server:A client connneted!");
				bConnected = true;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while(bConnected){
					String str=dis.readUTF();
					System.out.println(str);
				}
				dis.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//出现异常也会执行
		System.out.println("hhhhh");
	}
}
