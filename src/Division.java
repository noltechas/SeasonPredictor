import java.util.ArrayList;
import java.util.Arrays;
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
        Collections.sort(this.teams,teamComparator);
        Collections.reverse(this.teams);
        return this.teams;
    }

    public static Comparator<Team> teamComparator = new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            int result = t1.getConferenceWins() - t2.getConferenceWins();
            if (result == 0)
                result = t1.getConferenceLosses() - t2.getConferenceLosses();
            if (result == 0)
                result = t1.getDivisionWins() - t2.getDivisionWins();
            if (result == 0)
                result = t1.getDivisionLosses() - t2.getDivisionLosses();
            if (result == 0)
                result = t1.getResult(t2);
            if (result == 0)
                result = t1.getLosses() - t2.getLosses();
            if (result == 0)
                result = t1.getWins() - t2.getWins();
            if (result == 0)
                result = t1.getTeamRating() - t2.getTeamRating();
            return result;
        }
    };

    public Team getWinner(){
        ArrayList<Team> div1teams = new ArrayList<>(this.teams);
        div1teams.sort(Division.teamComparator);
        Collections.reverse(div1teams);
        return div1teams.get(0);
    }

    public Team getRunnerUp(){
        ArrayList<Team> div1teams = new ArrayList<>(this.teams);
        div1teams.sort(Division.teamComparator);
        Collections.reverse(div1teams);
        return div1teams.get(1);
    }
}
