package Terminal;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContratClient extends Remote {
	void retrieveMessage(String message) throws RemoteException;
}
