package Terminal;

import java.io.Serializable;
import java.util.ArrayList;

public class Competition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
    private String title;
    private String type;
    private Team team1;
    private Team team2;
    private ArrayList<String> viewers;


    public Competition(int id, String title, String t, Team t1, Team t2) {
        this.id = id;
        this.title = title;
        this.type = t;
        this.team1 = t1;
        this.team2 = t2;
        this.viewers = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void addViewers(String viewer) {
        this.viewers.add(viewer);
    }

    public void removeViewers(String viewer) {
        this.viewers.remove(viewer);
    }
    
    public String toString() {
    	return "Competition : " + this.getId() + " Titre : " + this.getTitle() + " Type : " + this.getType() + "\n";
    }

}
