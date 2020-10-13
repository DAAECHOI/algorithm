
package lab.ssafy.corona.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatConnect { //실제로 서버와의 통신을 담당
	private String ip;
	private int port;
	private String name;
	private Socket s;

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ChatClientSwing ui;
	
	public ChatConnect(ChatClientSwing ui, String ip, int port, String name){
		this.ui = ui;
		this.ip = ip;
		this.port = port;
		this.name = name;
		connect(); //전달받은 ui, ip, port, name으로 서버에 접속
	}

	public void setName(String name) {
    	this.name = name;
    }
	
	public void connect( ){ //서버와의 연결에 성공한다면 chatThread와 통신
		try {
             s = new Socket(ip, port); //서버 연결을 위한 소캣 객체 생성

			 oos = new ObjectOutputStream( s.getOutputStream() );
			 ois = new ObjectInputStream( s.getInputStream() );

			 new Thread(){ //Thread를 만들어 start
				 public void run(){
					 try{
						while( true ) { //서버로부터 받을 내용이 생길때까지 대기
							String message = (String) ois.readObject(); //서버로부터 전송된 메세지를 읽었다면
							ui.updateChat(message); //해당 메세지를 띄우기 위해 Swing에게 보냄
						}
					 }catch(Exception e ) {
						 e.printStackTrace();
					 }
				 }				 
			 }.start();
			 
			 //lambda
//			 new Thread( () -> {
//                 try{
//                    while( true ) {
//                        String message = (String) ois.readObject();
//                        ui.updateChat(message);
//                    }
//                 }catch(Exception e ) {
//                     e.printStackTrace();
//                 }
//                 
//             } ).start();
			 
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	public void send(String msg){ //Swing으로부터 받은 메세지
		try {
			oos.writeObject("[" + name + "] " + msg); //"[사용자 이름] 메세지" 형태로 서버에 보내기
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void sendExit(){
		try {
			oos.writeObject("^"); //"^"를 받으면 종료
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}