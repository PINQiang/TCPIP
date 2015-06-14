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
	TextArea textArea = new TextArea();// 显示内容
	TextField textField = new TextField();// 输入内容
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		add(textField, BorderLayout.SOUTH);
		add(textArea, BorderLayout.NORTH);
		pack(); // 可以看看效果
		//为 frame 添加事件处理
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
				System.exit(0);
			}
		});
		//为TextField添加事件处理
		textField.addActionListener(new TextFieldListener());
		setVisible(true);
		//connect
		connect();
	}

	public void connect(){
		try {
			//指定服务器端的ip，和port
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
	
	//私有化监听器
	private class TextFieldListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str=textField.getText().trim();
			//获取输出流，写出数据
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
