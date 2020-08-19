
package lab.ssafy.corona.chat;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{

	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>(); //채팅에 접속할 클라이언트를 담을 리스트
	private int port = 4101; //클라이언트 포트 번호와 동일한 네자리 숫자

	public void service() {
		try (ServerSocket ss = new ServerSocket(port);) { //서버 소캣 객체 생성
			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");
			
			while (true) { //접속이 들어올때까지 대기
				Socket s = ss.accept(); //클라이언트의 접속할 경우 만들어지는 소캣
				System.out.println("ChatClient 가 접속했습니다.");

				ChatThread t = new ChatThread(s); //접속한 클라이언트를 서비스 할 스레드 생성(클라이언트의 수 = 챗스레드의 수)
				synchronized (chatThreadList) { //해당 블럭이 마무리될 때까지 다른 스레드가 방해하지 못함
					chatThreadList.add(t); //생성된 스레드를 리스트에 넣어줌
				}
				t.start(); //해당 스레드를 start
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadcast( String message ) { //서버가 메세지를 받게 될 때 모든 클라이언트에게 해당 메세지를 방송
		synchronized (chatThreadList) { //해당 블럭이 마무리될 때까지 다른 스레드가 방해하지 못함
			for( ChatThread t : chatThreadList ){ //접속되어있는 모든 클라이언트에게
				try {
					t.sendMessage( message ); //스레드는 담당하고 있는 클라이언트에게 해당 메세지 전달
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) 	{
		new ChatServer().service(); //서버 서비스 시작
	}

	class ChatThread extends Thread {

		private Socket socket = null;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;
		
		public ChatThread(Socket socket) throws Exception { //클라이언트와 연결된 소캣으로 읽고 쓰기 위함
			this.socket = socket;
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		}

		public void run() {
			try {
				while (!isExit) { //채팅 종료조건
					String msg = (String) ois.readObject(); //담당한 클라이언트로부터 받는 메세지
					
					if("^".contentEquals(msg)) { //"^"를 받으면 종료
						synchronized (chatThreadList) { //해당 블럭이 마무리될 때까지 다른 스레드가 방해하지 못함
							chatThreadList.remove(this); //종료 시 자기 자신을 지움
						}
						isExit = true; //채팅 나가기
					}else {
						broadcast(msg); //서버를 이용해서 모든 클라이언트에게 해당 메세지를 방송
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				synchronized (chatThreadList) {
					chatThreadList.remove(this);
				}
			}
		}

		public void sendMessage(String message) throws Exception { //클라이언트에게 보내는 메세지
			oos.writeObject(message); //메세지를 써서 보냄
		}
	}
}

