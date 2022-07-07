import java.util.ArrayList;

public class Week {

    public int number;
    public ArrayList<Game> games;

    public Week(int number){
        this.number = number;
        this.games = new ArrayList<>();
    }

    public void addGame(Team team1, Team team2, float spread, float overUnder, float spreadSD, float overUnderSD){
        games.add(new Game(team1,team2,spread,overUnder,spreadSD,overUnderSD));
    }

    public void addGame(String team1, Team team2, float spread, float overUnder, float spreadSD, float overUnderSD){
        games.add(new Game(team1,team2,spread,overUnder,spreadSD,overUnderSD));
    }

    public void addGame(Team team1, String team2, float spread, float overUnder, float spreadSD, float overUnderSD){
        games.add(new Game(team1,team2,spread,overUnder,spreadSD,overUnderSD));
    }

    public void addGame(Team team1, Team team2, float spread, float overUnder, float spreadSD, float overUnderSD, float homeWinChance){
        games.add(new Game(team1,team2,spread,overUnder,spreadSD,overUnderSD,homeWinChance));
    }

    public void addGame(String team1, Team team2, float spread, float overUnder, float spreadSD, float overUnderSD, float homeWinChance){
        games.add(new Game(team1,team2,spread,overUnder,spreadSD,overUnderSD,homeWinChance));
    }

    public void addGame(Team team1, String team2, float spread, float overUnder, float spreadSD, float overUnderSD, float homeWinChance){
        games.add(new Game(team1,team2,spread,overUnder,spreadSD,overUnderSD,homeWinChance));
    }

    public void printGames(){
        for(int i = 0; i < games.size(); i++){
            System.out.println(games.get(i).away.name + " vs. " + games.get(i).home.name);
        }
    }

    public void playGames(){
        for(int i = 0; i < games.size(); i++){
            games.get(i).play();
        }
    }
}
