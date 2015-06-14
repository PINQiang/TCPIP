import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
public class ChatServer {
	public static void main(String[] args) {
		boolean started = false;
		ServerSocket ss=null;
		DataInputStream dis=null;
		try{
			ss = new ServerSocket(8888);
		}catch(BindException e){
			System.out.println("端口使用中...");
			System.out.println("请关掉相关程序并重新运行服务器！");
			System.exit(0);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try{
			started = true;
			while(started){
				boolean bConnected = false;
				//阻塞式的
				Socket s = ss.accept();
System.out.println("server:A client connneted!");
				bConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while(bConnected){
					String str=dis.readUTF();
					System.out.println(str);
				}
				//dis.close();
			}
		}catch(IOException e){
			//提示异常（eg:EOFException）信息
			//e.printStackTrace();
System.out.println("Client closed");
		//总会执行
		}finally{
			try{
				if(dis != null) dis.close();
				if(ss != null) ss.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
