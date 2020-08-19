
package lab.ssafy.corona.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientSwing extends JFrame { //JFrame = Windows. UI 역할

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
    private JTextField inputTextField;
    private JButton sendButton;

    private ChatConnect chatConnect; //서버와 통신하기 위함
    private String name;

    public ChatClientSwing(String ip, int port) {
    	chatConnect = new ChatConnect( this, ip, port, name); //전달받은 ip와 port를 가지고 서버와 통신
    	createUI();
    }
    
    public ChatConnect getChatConnect() {
    	return chatConnect;
    }
    

    private void createUI() {
    	//전달받은 텍스트와 전달할 텍스트를 띄울 공간
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        //전달할 내용을 담은 텍스트 박스와 send버튼
        Box box = Box.createHorizontalBox();
        add(box, BorderLayout.SOUTH);
        inputTextField = new JTextField();
        sendButton = new JButton("Send");
        box.add(inputTextField);
        box.add(sendButton);

		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 사용자 입력 값 
				String str = inputTextField.getText();
				if ( str != null && str.trim().length() > 0 ) {
					chatConnect.send(str); //서버로 메세지 전송
				}
				//초기화
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
		};
        
        inputTextField.addActionListener(sendListener);
        sendButton.addActionListener(sendListener);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { //종료 조건
            	chatConnect.sendExit(); //서버 종료 메소드 호출
            }
        });
    }

    public void updateChat(String message) { //전송된 메세지를 받아 채팅UI에 띄워주기
    	textArea.append(message);
        textArea.append("\n");
    }
}
