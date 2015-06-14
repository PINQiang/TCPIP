import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	
	List<Client> clients = new ArrayList<Client>();
	
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println("端口使用中...");
			System.out.println("请关掉相关程序并重新运行服务器！");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while (started) {
				// 阻塞式的
				Socket s = ss.accept();
				Client client = new Client(s);
				new Thread(client).start();
				clients.add(client);
				System.out.println("server:A client connneted!");
				// dis.close();
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Client closed");
			// 总会执行
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void send(String str) {
				try {
					dos.writeUTF(str);
				} catch (IOException e) {
					clients.remove(this);
					System.out.println("SERVER:a client quit,remove this client from list");
					//e.printStackTrace();
				}
		}
		
		public void run() {
			bConnected = true;
			Client c = null;
			try {
				while (bConnected) {
					String str = dis.readUTF();
System.out.println(str);
					for(int i=0;i<clients.size();i++){
						c = clients.get(i);
						if(c!=this)
						c.send(str);
					}
					//2内部锁定效率不高
					/*for(Iterator<Client> it=clients.iterator();it.hasNext()){
						Client c = it.next();
						c.send(str);
					}*/
					
					//3
					/*Iterator<Client> it = clients.iterator();
					while(it.hasNext()){
						Client c = it.next();
						c.send(str);
					}*/
				}
			}catch(EOFException e){
				//e.printStackTrace();
				System.out.println(" SERVER:Client close,but server still read");
			}catch(SocketException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(dis != null)
						dis.close();
					if(dos !=null)
						dos.close();
					if(s != null)
						s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
