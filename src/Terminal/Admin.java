package Terminal;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

import Terminal.Contrat;

public class Admin {
	
	public static void main(String[] args)
	{
		try {
			System.out.println("Recherche de l'objet.");
			String url="rmi://"+args[0]+"/competition";
			System.out.println("Je suis la");
			Contrat objdist=(Contrat)Naming.lookup(url);
			System.out.println("Connexion reussie");
			Scanner scan = new Scanner(System.in);
			String commande = "";
			while(!commande.equals("close")) {
				commande = scan.nextLine();
				if(commande.equals("SET")) {
					objdist.addEvent("SECOND POTEAU PAVARD");
				}else if(commande.equals("GET")) {
					objdist.getCompetitions();
					System.out.println(objdist.getCompetitions());
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
