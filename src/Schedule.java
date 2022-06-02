import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Schedule {

    public ArrayList<Week> weeks;
    public float spreadSD = 14.5F;
    public float overUnderSD = 13.5F;
    public Conference conference;
    public Game championship;

    public Schedule(Conference conference){
        this.conference = conference;
        weeks = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            weeks.add(new Week(i));
        }
    }

    public void printWeek(int weekNumber){
        weeks.get(weekNumber).printGames();
    }

    public void playWeek(int weekNumber){
        weeks.get(weekNumber).playGames();
    }


    public void addGame(int week, Team away, Team home, float spread, float overUnder){
        weeks.get(week).addGame(away,home,spread,overUnder,spreadSD,overUnderSD);
    }

    public void addGame(int week, String away, Team home, float spread, float overUnder){
        weeks.get(week).addGame(away,home,spread,overUnder,spreadSD,overUnderSD);
    }

    public void addGame(int week, Team away, String home, float spread, float overUnder){
        weeks.get(week).addGame(away,home,spread,overUnder,spreadSD,overUnderSD);
    }

    public void recordResults() {
        ArrayList<Team> div1teams = new ArrayList<>(conference.div1.teams);
        div1teams.sort(Division.teamComparator);
        Collections.reverse(div1teams);
        ArrayList<Team> div2teams = new ArrayList<>(conference.div2.teams);
        div2teams.sort(Division.teamComparator);
        Collections.reverse(div2teams);
        for(int i = 0; i < 7; i++){
            conference.div1.teams.get(i).recordResults(div1teams);
            conference.div2.teams.get(i).recordResults(div2teams);
        }
    }

    public void setChampionship(){
        championship = new Game(conference.div1.getWinner(),conference.div2.getWinner(),conference.div1.getWinner().teamRating-conference.div2.getWinner().teamRating,50,spreadSD,overUnderSD);
    }

    public void playChampionship(){
        Team div1Champ = conference.div1.getWinner();
        Team div2Champ = conference.div2.getWinner();

        float gameSpread = (div1Champ.teamRating+div1Champ.momentum) - (div2Champ.teamRating+div2Champ.momentum);

        if(Main.singleSeason){
            System.out.println("Championship Game: " + div1Champ.name + " vs. " + div2Champ.name);
            System.out.println("Line: " + div1Champ.name + " -" + gameSpread);
        }

        championship.play();

        championship.winner.addChampionship();
        if(championship.winner.totalLosses <= 1)
            championship.winner.addPlayoff();
    }
}