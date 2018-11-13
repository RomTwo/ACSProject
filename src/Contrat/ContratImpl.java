package Contrat;

import Classe.Competition;
import Classe.Scenario;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContratImpl extends UnicastRemoteObject implements Contrat {

    /**
     * Prevents warning with options -Xlint:all -Xdiags:verbose
     */
    private static final long serialVersionUID = 1;

    /**
     * User connected on server (key = id, val = name)
     */
    private Map<String, String> connected = new HashMap<>();

    /**
     * List of competitions
     */
    private ArrayList<Competition> competitions = new ArrayList<>();

    /**
     * Constructor
     *
     * @throws RemoteException
     */
    public ContratImpl() throws RemoteException {
        super();
        Scenario sc = new Scenario();
        this.competitions.add(sc.foot());
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
    public void followEvent(String userId, int eventId) throws RemoteException {
        System.out.println("you follow this event");
        for (Competition item : this.competitions) {
            if (item.getId() == eventId) {
                item.addViewers(getName(userId));
            }
        }
    }

    /**
     * Return username of user in function of his id
     *
     * @param id String
     * @return String
     */
    private String getName(String id) {
        for (Map.Entry<String, String> entry : this.connected.entrySet()) {
            if (id.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Verify if username it's not already used
     *
     * @param name username
     * @return boolean
     */
    private boolean nameExist(String name) {
        for (Map.Entry<String, String> entry : this.connected.entrySet()) {
            if (name.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

}
