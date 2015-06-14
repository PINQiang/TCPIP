import java.awt.*;
import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.*;
public class ChatClient extends Frame {
	Socket s=null;
	DataOutputStream dos = null;
	TextArea textArea = new TextArea();// ��ʾ����
	TextField textField = new TextField();// ��������
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		add(textField, BorderLayout.SOUTH);
		add(textArea, BorderLayout.NORTH);
		pack(); // ���Կ���Ч��
		//Ϊ frame ����¼�����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
				System.exit(0);
			}
		});
		//ΪTextField����¼�����
		textField.addActionListener(new TextFieldListener());
		setVisible(true);
		//connect
		connect();
	}

	public void connect(){
		try {
			//ָ���������˵�ip����port
				s = new Socket("127.0.0.1",8888);
				dos = new DataOutputStream(s.getOutputStream());
System.out.println("client:connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disConnect(){
		try {
			dos.close();
			s.close();
		}catch(UnknownHostException e2){
			e2.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	//˽�л�������
	private class TextFieldListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str=textField.getText().trim();
			//��ȡ�������д������
			try {
				dos.writeUTF(str);
				dos.flush();
				//dos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			textArea.setText(str);
			textField.setText("");

		}
	} 
	

}
