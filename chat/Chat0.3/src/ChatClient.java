import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
	/**
	 * 
	 */
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
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

}
