import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class League {

    public static ArrayList<Conference> conferences;
    public static ArrayList<Team> independents;
    public static ArrayList<Team> playoffRankings = new ArrayList<>();

    public League(ArrayList<Conference> conferences, ArrayList<Team> independents){
        League.conferences = new ArrayList<>(conferences);
        League.independents = independents;
    }

    public static ArrayList<Team> getPoll(){
        ArrayList<Team> poll = new ArrayList<>(independents);
        for (Conference conference : conferences) {
            poll.addAll(conference.getTeams());
        }
        poll.sort(pollComparator2);
        Collections.reverse(poll);
        playoffRankings = poll;
        return poll;
    }

    public static Comparator<Team> pollComparator = new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            float result = t1.getFinalRatings() - t2.getFinalRatings();
            // Head to Head
            if (result == 0)
                result = t1.getResult(t2);
            if (result == 0)
                result = t1.getTeamRating() - t2.getTeamRating();
            if (result == 0)
                result = t1.marginOfVictory - t2.marginOfVictory;
            result = result*1000;
            return (int) result;
        }
    };

    public static Comparator<Team> pollComparator2 = new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            float result = t1.getAdjustedScore() - t2.getAdjustedScore();
            // Head to Head
            if (result == 0)
                result = t1.getResult(t2);
            if (result == 0)
                result = t1.getTeamRating() - t2.getTeamRating();
            if (result == 0)
                result = t1.marginOfVictory - t2.marginOfVictory;
            result = result*1000;
            return (int) result;
        }
    };

    public static void printPoll(){
        getPoll();
        ArrayList<Team> poll = new ArrayList<>(playoffRankings);
        for(int i = 0; i < 25; i++){
            System.out.println((i+1) + ". " + poll.get(i).name + " (" + poll.get(i).totalWins + "-" + poll.get(i).totalLosses + ") Score: " + poll.get(i).getAdjustedScore() + " (SOR: " + poll.get(i).getSOR() + ")" + " (SOS: " + poll.get(i).getSOS() + ")"+ " (MOV: " + poll.get(i).getMOV()*0.075F + ")");
        }
        System.out.println("------------------------------------------");
    }

    public static void printAllResults(){
        ArrayList<Team> sortedTeams = new ArrayList<>(independents);
        for (Conference conference : conferences) {
            sortedTeams.addAll(conference.getTeams());
        }
        sortedTeams.sort(Comparator.comparing(Team::getAverageWins));
        Collections.reverse(sortedTeams);
        for(int i = 0; i < 35; i++){
            System.out.println(i+1 + ". " + sortedTeams.get(i).name + ": " + sortedTeams.get(i).getPlayoffRate()*100 + "% Playoff Rate, " + sortedTeams.get(i).getAverageWins() + " Average Wins");
        }
    }
}
