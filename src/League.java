import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class League {

    public static ArrayList<Conference> conferences;
    public static ArrayList<Team> independents;

    public League(ArrayList<Conference> conferences, ArrayList<Team> independents){
        this.conferences = new ArrayList<>(conferences);
        this.independents = independents;
    }

    public static ArrayList<Team> getPoll(){
        ArrayList<Team> poll = new ArrayList<>(independents);
        for(int i = 0; i < conferences.size(); i++){
            poll.addAll(conferences.get(i).getTeams());
        }
        Collections.sort(poll,pollComparator2);
        Collections.reverse(poll);
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
        ArrayList<Team> poll = new ArrayList<>(getPoll());
        for(int i = 0; i < 25; i++){
            System.out.println((i+1) + ". " + poll.get(i).name + " (" + poll.get(i).totalWins + "-" + poll.get(i).totalLosses + ") Score: " + poll.get(i).getAdjustedScore());
        }
    }
}
