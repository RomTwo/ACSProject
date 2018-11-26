package Terminal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import Classe.Competition;
import Classe.Scenario;

public class ContratImpl extends UnicastRemoteObject implements Contrat{
	
	private static final long serialVersionUID = 1;
	
	/**
     * User connected on server (key = id, val = name)
     */
    private Map<String, String> connected = new HashMap<>();
    
    private ArrayList<ContratClient> clients = new ArrayList<>();
    
    private ArrayList<Competition> competitions = new ArrayList<>();
    
    private ArrayList<String> events = new ArrayList<>();
    
    SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss");;
    
    Date aujourdhui = null;
	
	public ContratImpl() throws RemoteException {
		super();
		Scenario sc = new Scenario();
        this.competitions.add(sc.foot());
        this.competitions.add(sc.foot2());
	}

	@Override
	public String getId(String name) throws RemoteException {
		String id = null;
        if (!nameExist(name)) {
            id = UUID.randomUUID().toString();
            this.connected.put(id, name);
        }
        System.out.println("Number of customers on server = " + this.connected.size());
        return id;
	}
	
	private boolean nameExist(String name) {
        for (Map.Entry<String, String> entry : this.connected.entrySet()) {
            if (name.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

	@Override
	public void close(String id) throws RemoteException {
		this.connected.remove(id);
		System.out.println("Number of customers on server = " + this.connected.size());
	}

	@Override
	public ArrayList<Competition> getCompetitions() throws RemoteException {
		System.out.println("There is " + this.competitions.size() + " Competitions");
        return this.competitions;
	}

	@Override
	public int addPari() throws RemoteException {
		return 34;
	}

	@Override
	public void registerClient(ContratClient client) throws RemoteException {
		this.clients.add(client);
		System.out.println("Ajout d'un client");
		int i = 0;
		if(events.size() == 0) {
			clients.get(clients.size() - 1).retrieveMessage("La compétition n'a pas encore démarrée...Un peu de patience ");
		}
		while(i < events.size()) {
			clients.get(clients.size() - 1).retrieveMessage(events.get(i));
			i++;
		}
	}

	@Override
	public void addEvent(String message) throws RemoteException {
		int i = 0;
		aujourdhui = new Date();
		String date = formater.format(aujourdhui);
		String event = date + " : " + message;
		System.out.println("Envoi du message suivant : " + event);
		this.events.add(event);
		while(i < clients.size()) {
			clients.get(i++).retrieveMessage(event);
		}
		
	}
	
}
