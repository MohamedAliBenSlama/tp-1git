package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            InetAddress ipServeur = InetAddress.getLocalHost();
            int port = 1234;
            InetSocketAddress socketAddress = new InetSocketAddress(ipServeur, port);
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(socketAddress);
            System.out.println("Serveur démarré sur " + ipServeur.getHostAddress() + ":" + port);
            System.out.println("En attente d’un client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connecté depuis " + socket.getInetAddress().getHostAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            int operation = in.readInt(); 
            double a = in.readDouble();
            double b = in.readDouble();
            double resultat = 0;
            String symbole = "";
            switch (operation) {
                case 1:
                    resultat = a + b;
                    symbole = "+";
                    break;
                case 2:
                    resultat = a - b;
                    symbole = "-";
                    break;
                case 3:
                    resultat = a * b;
                    symbole = "*";
                    break;
                case 4:
                    if (b != 0) {
                        resultat = a / b;
                    } else {
                        out.writeUTF("Erreur : division par zero !");
                        in.close();
                        out.close();
                        socket.close();
                        serverSocket.close();
                        return;
                    }
                    symbole = "/";
                    break;
                default:
                    out.writeUTF("opération invalide !");
                    in.close();
                    out.close();
                    socket.close();
                    serverSocket.close();
                    return;
            }
            System.out.println("Calcul demandé : " + a + " " + symbole + " " + b + " = " + resultat);
            out.writeUTF("Résultat : " + a + " " + symbole + " " + b + " = " + resultat);
            System.out.println("Résultat envoyé au client.");
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
            System.out.println("Serveur arrêté.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
