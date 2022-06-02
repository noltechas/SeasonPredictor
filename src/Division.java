import java.util.ArrayList;

public class Division {
    public String name;
    public ArrayList<Team> teams;
    public Division(String name){
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }

    public int getSize(){
        return teams.size();
    }
}
