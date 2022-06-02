import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Schedule {

    public ArrayList<Week> weeks;
    public float spreadSD = 14.5F;
    public float overUnderSD = 13.5F;
    public Conference conference;

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

    public void printStandings(){
        ArrayList<Team> div1teams = new ArrayList<>(conference.div1.teams);
        div1teams.sort(Comparator.comparingInt(Team::getLosses));
        div1teams.sort(Comparator.comparingInt(Team::getWins));
        div1teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        div1teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(div1teams);
        ArrayList<Team> div2teams = new ArrayList<>(conference.div2.teams);
        div2teams.sort(Comparator.comparingInt(Team::getLosses));
        div2teams.sort(Comparator.comparingInt(Team::getWins));
        div2teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        div2teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(div2teams);

        System.out.println(conference.div1.name);
        System.out.println("----------------");
        for(int i = 0; i < conference.div1.getSize(); i++){
            System.out.println(div1teams.get(i).name + ": " + div1teams.get(i).totalWins + "-" + div1teams.get(i).totalLosses + " (" + div1teams.get(i).conferenceWins + "-" + div1teams.get(i).conferenceLosses + ")");
        }
        System.out.println();
        System.out.println(conference.div2.name);
        System.out.println("----------------");
        for(int i = 0; i < conference.div2.getSize(); i++){
            System.out.println(div2teams.get(i).name + ": " + div2teams.get(i).totalWins + "-" + div2teams.get(i).totalLosses + " (" + div2teams.get(i).conferenceWins + "-" + div2teams.get(i).conferenceLosses + ")");
        }
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
        div1teams.sort(Comparator.comparingInt(Team::getLosses));
        div1teams.sort(Comparator.comparingInt(Team::getWins));
        div1teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        div1teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(div1teams);
        ArrayList<Team> div2teams = new ArrayList<>(conference.div2.teams);
        div2teams.sort(Comparator.comparingInt(Team::getLosses));
        div2teams.sort(Comparator.comparingInt(Team::getWins));
        div2teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        div2teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(div2teams);
        for(int i = 0; i < 7; i++){
            conference.div1.teams.get(i).recordResults(div1teams);
            conference.div2.teams.get(i).recordResults(div2teams);
        }
    }

    public void playChampionship(){
        ArrayList<Team> div1teams = new ArrayList<>(conference.div1.teams);
        div1teams.sort(Comparator.comparingInt(Team::getLosses));
        div1teams.sort(Comparator.comparingInt(Team::getWins));
        div1teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        div1teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(div1teams);
        ArrayList<Team> div2teams = new ArrayList<>(conference.div2.teams);
        div2teams.sort(Comparator.comparingInt(Team::getLosses));
        div2teams.sort(Comparator.comparingInt(Team::getWins));
        div2teams.sort(Comparator.comparingInt(Team::getDivisionWins));
        div2teams.sort(Comparator.comparingInt(Team::getConferenceWins));
        Collections.reverse(div2teams);

        Team div1Champ = div1teams.get(0);
        Team div2Champ = div2teams.get(0);

        float gameSpread = (div1Champ.teamRating+div1Champ.momentum) - (div2Champ.teamRating+div2Champ.momentum);

        if(Main.singleSeason){
            System.out.println("Championship Game: " + div1Champ.name + " vs. " + div2Champ.name);
            System.out.println("Line: " + div1Champ.name + " -" + gameSpread);
            Scanner myObj = new Scanner(System.in);
            System.out.println("Click Enter to See Result");
            String userName = myObj.nextLine();
        }

        Game championship = new Game(div1Champ,div2Champ,div1Champ.teamRating-div2Champ.teamRating,50,spreadSD,overUnderSD);
        championship.play();

        championship.winner.addChampionship();
        if(championship.winner.totalLosses <= 1)
            championship.winner.addPlayoff();

    }
}