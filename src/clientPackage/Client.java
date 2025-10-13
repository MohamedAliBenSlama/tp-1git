package clientPackage;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException{
		// TODO Auto-generated method stub
		System.out.println("je suis un client pas encore connectee");
		Socket socket=new Socket("localhost",1234);
		System.out.println("je suis un client connectee");
		socket.close();

	}

}
