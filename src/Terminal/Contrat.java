package Terminal;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Classe.Competition;

public interface Contrat extends Remote{
	
	String getId(String name) throws RemoteException;
	
	void registerClient(ContratClient Client) throws RemoteException;
	
	void close(String id) throws RemoteException;
	
	ArrayList<Competition> getCompetitions() throws RemoteException;
	
	int addPari() throws RemoteException;
	
	void addEvent(String message) throws RemoteException;
}
