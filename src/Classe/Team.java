package Classe;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private int id;
    private String name;
    private ArrayList<Player> players = new ArrayList<>();

    public Team(int id, String name, ArrayList<Player> p) {
        this.id = id;
        this.name = name;
        this.players = p;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
