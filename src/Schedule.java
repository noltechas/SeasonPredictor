import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Schedule {

    public ArrayList<Week> weeks;
    public float spreadSD = 12.5F;
    public float overUnderSD = 13.5F;
    public League league;

    public Schedule(League league){
        this.league = league;
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
        for(int i = 0; i < this.league.conferences.size(); i++) {
            if(this.league.conferences.get(i).hasDivisions) {
                ArrayList<Team> div1teams = new ArrayList<>(this.league.conferences.get(i).div1.teams);
                div1teams.sort(Division.teamComparator);
                Collections.reverse(div1teams);
                ArrayList<Team> div2teams = new ArrayList<>(this.league.conferences.get(i).div2.teams);
                div2teams.sort(Division.teamComparator);
                Collections.reverse(div2teams);
                for (int j = 0; j < 7; j++) {
                    this.league.conferences.get(j).div1.teams.get(j).recordResults(div1teams);
                    this.league.conferences.get(j).div2.teams.get(j).recordResults(div2teams);
                }
            }
            else{
                ArrayList<Team> div1teams = new ArrayList<>(this.league.conferences.get(i).div1.teams);
                div1teams.sort(Division.teamComparator);
                Collections.reverse(div1teams);
                for (int j = 0; j < 7; j++) {
                    this.league.conferences.get(j).div1.teams.get(j).recordResults(div1teams);
                }
            }
        }
    }
}