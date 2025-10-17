package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez l’adresse IP du serveur : ");
            String ipServeur = scanner.nextLine();
            int port = 1234;
            InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(ipServeur), port);
            System.out.println("Connexion au serveur...");
            Socket socket = new Socket();
            socket.connect(socketAddress);
            System.out.println("Connecté au serveur " + ipServeur);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("\n=== CALCULATRICE ===");
            System.out.println("1 - Addition (+)");
            System.out.println("2 - Soustraction (-)");
            System.out.println("3 - Multiplication (*)");
            System.out.println("4 - Division (/)");
            System.out.print("Choisissez une opération : ");
            int choix = scanner.nextInt();
            System.out.print("Entrez le premier nombre : ");
            double a = scanner.nextDouble();
            System.out.print("Entrez le deuxième nombre : ");
            double b = scanner.nextDouble();
            out.writeInt(choix);
            out.writeDouble(a);
            out.writeDouble(b);
            String resultat = in.readUTF();
            System.out.println("\n" + resultat);
            in.close();
            out.close();
            socket.close();
            scanner.close();
            System.out.println("\nClient terminé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
