
package lab.ssafy.corona.chat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChatClient{
	
	public static void main(String[] args) 	{
		String ip = "localhost";
		int port = 4101; //서버 포트번호와 동일한 네자리 숫자
		
		ChatClientSwing ui = new ChatClientSwing( ip, port ); //접속한 클라이언트를 위한 ui생성
		
		ui.setTitle("SSAFY V1 - connected to " + ip + ":" + port);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);
        
        String name = JOptionPane.showInputDialog("이름을 입력하세요.");
        ui.getChatConnect().setName(name);
	}
}

