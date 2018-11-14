import Contrat.Contrat;
import Ihm.Principale;

import java.rmi.Naming;

//Ceci est un test
public class Client {
    public static void main(String[] args) {
        try {

            System.out.println("Recherche de l'objet");
            String url = "rmi://" + args[0] + "/competition";
            Contrat objDist = (Contrat) Naming.lookup(url);

            String id = objDist.getId(args[1]);
            String followedEvent = null;

            if (id == null) {
                System.out.println("Connexion impossible cet utilisateur est déjà connecté...");
            } else {
                Principale p = new Principale(id, objDist);
            }

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
