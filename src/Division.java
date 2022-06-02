import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<Team> getStandings(){
        teams.sort(Comparator.comparing(Team::getTeamRating));
        teams.sort(Comparator.comparingInt(Team::getLosses));
        teams.sort(Comparator.comparingInt(Team::getWins));
        teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(teams);
        return teams;
    }
}
