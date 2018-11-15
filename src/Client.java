import Contrat.Contrat;
import Ihm.Admin;
import Ihm.Principale;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {

            System.out.println("Recherche de l'objet");
            String url = "rmi://" + args[0] + "/competition";
            Contrat objDist = (Contrat) Naming.lookup(url);

            String id = objDist.getId(args[1]);
            //String followedEvent = null;

            if (id == null) {
                System.out.println("Connexion impossible cet utilisateur est déjà connecté...");
            } else if (args[1].equals("admin")) {
                Admin admin = new Admin(id, objDist);
            } else {
                Principale p = new Principale(id, objDist);
            }

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
