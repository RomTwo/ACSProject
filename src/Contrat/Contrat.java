package Contrat;

import Classe.Competition;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Contrat extends Remote {
    /**
     * Create a unique key for the user and register the user in the hashMap
     *
     * @param name Username
     * @return String
     * @throws RemoteException
     */
    String getId(String name) throws RemoteException;

    /**
     * Delete user in the hashMap
     *
     * @param id unique id
     * @throws RemoteException
     */
    void close(String id) throws RemoteException;

    ArrayList<Competition> getCompetitions() throws RemoteException;

    void followEvent(String userId, int eventId) throws RemoteException;

    void unfollowEvent(String userId, int eventId) throws RemoteException;

}
