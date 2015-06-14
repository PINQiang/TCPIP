import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {

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
				System.exit(0);
			}
		});
		//ΪTextField����¼�����
		textField.addActionListener(new TextFieldListener());
		setVisible(true);
	}
	//˽�л�������
	private class TextFieldListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s=textField.getText().trim();
			textArea.setText(s);
			textField.setText("");

		}
	} 
	

}
