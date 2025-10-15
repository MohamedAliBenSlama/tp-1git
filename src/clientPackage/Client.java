package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client : en attente de connexion...");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Client connecté au serveur !");

            // Création des flux
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            // Lecture de l’entier saisi par l’utilisateur
            System.out.print("Entrez un entier x : ");
            int x = scanner.nextInt();

            // Envoi de l’entier au serveur
            out.writeInt(x);
            System.out.println("Client a envoyé x = " + x);

            // Réception du résultat
            int resultat = in.readInt();
            System.out.println("Résultat reçu du serveur : " + resultat);

            // Fermeture
            in.close();
            out.close();
            socket.close();
            scanner.close();
            System.out.println("Client terminé.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}