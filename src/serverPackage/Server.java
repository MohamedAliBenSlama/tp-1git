package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Création du serveur sur le port 1234
            ServerSocket socketServer = new ServerSocket(1234);
            System.out.println("Serveur démarré, en attente d’un client...");

            // Attente de la connexion d’un client
            Socket socket = socketServer.accept();
            System.out.println("Un client est connecté !");

            // Création des flux d’entrée/sortie
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Lecture de l’entier envoyé par le client
            int x = in.readInt();
            System.out.println("Serveur a reçu x = " + x);

            // Traitement : produit par 5
            int resultat = x * 5;
            System.out.println("Serveur a calculé : " + x + " * 5 = " + resultat);

            // Envoi du résultat au client
            out.writeInt(resultat);
            System.out.println("Résultat envoyé au client.");

            // Fermeture
            in.close();
            out.close();
            socket.close();
            socketServer.close();
            System.out.println("Serveur arrêté.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
