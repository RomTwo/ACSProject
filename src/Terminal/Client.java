package Terminal;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.helpers.ParseConversionEventImpl;

import Terminal.Competition;
import Terminal.Pari;
import Terminal.PariThread;
import Terminal.Contrat;
import Terminal.ContratClient;


public class Client extends UnicastRemoteObject implements ContratClient, Runnable{

	private static final long serialVersionUID = 1;
	
	private String id;
	private static Contrat objDist;
	
	public Client(String id, Contrat contrat) throws RemoteException{
		this.id = id;
		Client.objDist = contrat;
		objDist.registerClient(this);
	}
	
	private void pari(Pari p, Contrat contrat) {
		Thread threadPari = new Thread(new PariThread(p, contrat));
		threadPari.start();
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String commande = "";
		while(!commande.equals("exit")) {
			commande = scanner.nextLine();
			if(commande.equals("PARI")) {
				System.out.println("Quel est votre montant ?");
				String montant = scanner.nextLine();
				System.out.println("Votre pari est de : " + montant + "e");
				Pari p = new Pari();
				pari(p, objDist);
				System.out.println(p.get());
			}
		}
		
	}

	public static void main(String[] args){
		try {
			System.out.println("Recherche de l'objet.");
			String url="rmi://"+args[0]+"/competition";//Création de l'url pour la connexion avec le serveur.
			objDist=(Contrat)Naming.lookup(url);//Connexion au serveur avec le contrat de l'objet distant.
			System.out.println("Connexion reussie");

			String id = objDist.getId(args[1]);

			System.out.println(id);

			if (id == null) {
				System.out.println("Connexion impossible cet utilisateur est déjà connecté...");
			} else {
				new Thread(new Client(id, objDist)).start();
			}

		}catch(Exception e){
			System.out.println(e);
		}
	}	

	@Override
	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
	}
}
