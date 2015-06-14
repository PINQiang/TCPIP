import java.awt.*;

public class ChatClient extends Frame {
	/**
	 * 
	 */
	TextArea taContent = new TextArea();// 显示内容
	TextField tfTxt = new TextField();//   输入内容
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		add(tfTxt, BorderLayout.SOUTH);
		add(taContent, BorderLayout.NORTH);
		pack(); // 可以看看效果
		setVisible(true);
	}

}
