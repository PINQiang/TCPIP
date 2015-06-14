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
			System.out.println("�˿�ʹ����...");
			System.out.println("��ص���س����������з�������");
			System.exit(0);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try{
			started = true;
			while(started){
				boolean bConnected = false;
				//����ʽ��
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
			//��ʾ�쳣��eg:EOFException����Ϣ
			//e.printStackTrace();
System.out.println("Client closed");
		//�ܻ�ִ��
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
