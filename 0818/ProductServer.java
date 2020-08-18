package com.ssafy.work;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductServer {
	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(9999);) {
			System.out.println("server is ready");
			while(true) {
				Socket forClient = ss.accept();
				ObjectInputStream oin = new ObjectInputStream(forClient.getInputStream());
				Object read = oin.readObject();
				System.out.println("TV 정보 수신 완료 " + read);
				read = oin.readObject();
				System.out.println("Refrigerator 정보 수신 완료 " + read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
