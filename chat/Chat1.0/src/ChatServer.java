import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println("�˿�ʹ����...");
			System.out.println("��ص���س����������з�������");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while (started) {
				// ����ʽ��
				Socket s = ss.accept();
				Client client = new Client(s);
				new Thread(client).start();
				System.out.println("server:A client connneted!");
				// dis.close();
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Client closed");
			// �ܻ�ִ��
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
		boolean bConnected = false;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			bConnected = true;
			try {
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("Client closed");
			} finally {
				try {
					if (dis != null)
						dis.close();
					if (s != null)
						s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
