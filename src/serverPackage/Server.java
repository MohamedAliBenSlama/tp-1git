package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket socketServer;
		try {
			socketServer = new ServerSocket(1234);
		
		System.out.println("je suis un client pas encore connectee");
		Socket socket=socketServer.accept();
		System.out.println("je suis un client connectee");
		socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
