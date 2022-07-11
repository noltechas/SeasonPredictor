import java.util.ArrayList;
import java.util.Random;

public class Game {

    public boolean print = false;
    public float momentumFactor = 0.5F;

    public Team home = null;
    public Team away = null;
    public Team winner = null;
    public String homeName;
    public String awayName;
    public int homeScore = 0;
    public int awayScore = 0;

    public float spread;
    public float overUnder;
    public float spreadSD;
    public float overUnderSD;
    public float homeWinChance = 0;
    public float originalHomeWinChance = 0;


    public Game(Team away, Team home, float spread, float overUnder, float spreadSD, float overUnderSD){
        this.away = away;
        this.home = home;
        this.homeName = home.name;
        this.awayName = away.name;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
    }

    public Game(Team away, Team home, float spread, float overUnder, float spreadSD, float overUnderSD, float homeWinChance){
        this.away = away;
        this.home = home;
        this.homeName = home.name;
        this.awayName = away.name;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
        this.homeWinChance = homeWinChance;
    }

    public Game(Team away, String home, float spread, float overUnder, float spreadSD, float overUnderSD){
        this.away = away;
        this.homeName = home;
        this.awayName = away.name;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
    }

    public Game(Team away, String home, float spread, float overUnder, float spreadSD, float overUnderSD, float homeWinChance){
        this.away = away;
        this.homeName = home;
        this.awayName = away.name;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
        this.homeWinChance = homeWinChance;
        this.originalHomeWinChance = homeWinChance;
    }

    public Game(String away, Team home, float spread, float overUnder, float spreadSD, float overUnderSD){
        this.home = home;
        this.homeName = home.name;
        this.awayName = away;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
        this.originalHomeWinChance = homeWinChance;
    }

    public Game(String away, Team home, float spread, float overUnder, float spreadSD, float overUnderSD, float homeWinChance){
        this.home = home;
        this.homeName = home.name;
        this.awayName = away;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
        this.homeWinChance = homeWinChance;
        this.originalHomeWinChance = homeWinChance;
    }

    public void play() {
        if (Main.usePercentage && this.homeWinChance != 0F) {
            double randomNumber = Math.random();

            float awayWinChance = 1-homeWinChance;
            float homeAndMomentum,awayAndMomentum;
            if(home != null)
                homeAndMomentum = this.homeWinChance+((float)home.momentum)/100;
            else
                homeAndMomentum = this.homeWinChance;
            if(away != null)
                awayAndMomentum = awayWinChance + ((float)away.momentum)/100;
            else
                awayAndMomentum = awayWinChance;

            this.homeWinChance = homeAndMomentum/(awayAndMomentum+homeAndMomentum);

            int winScore = 0,loseScore = 0;
            if(randomNumber <= homeWinChance){
                while(loseScore >= winScore){
                    ArrayList<Integer> scores = playLineGame();
                    winScore = scores.get(1);
                    loseScore = scores.get(0);
                }
            }
            else{
                while(loseScore >= winScore){
                    ArrayList<Integer> scores = playLineGame();
                    winScore = scores.get(0);
                    loseScore = scores.get(1);
                }
            }

            if(randomNumber <= homeWinChance){
                if (home != null) {
                    this.winner = home;
                    home.marginOfVictory += winScore - loseScore;
                    addResult(home, winScore, loseScore);
                    home.addWin();
                    if (homeWinChance >= 0.9)
                        home.momentum += 0.5*momentumFactor;
                    else if (homeWinChance >= 0.75)
                        home.momentum += 1.25*momentumFactor;
                    else if (homeWinChance >= 0.5)
                        home.momentum += 2*momentumFactor;
                    else if (homeWinChance >= 0.2)
                        home.momentum += 3*momentumFactor;
                    else if (homeWinChance >= 0.05)
                        home.momentum += 4*momentumFactor;
                    else if (homeWinChance >= -0.5)
                        home.momentum += 6*momentumFactor;
                    else{
                        System.out.println("ERROR IN MOMENTUM, home win");
                        System.out.println(homeName + " vs " + awayName);
                        System.out.println(homeWinChance);
                    }
                }
                if (away != null) {
                    away.marginOfVictory += loseScore - winScore;
                    addResult(away, winScore, loseScore);
                    if (homeWinChance >= 0.9)
                        away.momentum -= 0.5*momentumFactor;
                    else if (homeWinChance >= 0.75)
                        away.momentum -= 1.25*momentumFactor;
                    else if (homeWinChance >= 0.5)
                        away.momentum -= 2*momentumFactor;
                    else if (homeWinChance >= 0.2)
                        away.momentum -= 3*momentumFactor;
                    else if (homeWinChance >= 0.05)
                        away.momentum -= 4*momentumFactor;
                    else if (homeWinChance >= -0.5)
                        away.momentum -= 6*momentumFactor;
                    else{
                        System.out.println("ERROR IN MOMENTUM, home win");
                        System.out.println(homeName + " vs " + awayName);
                        System.out.println(homeWinChance);
                    }
                    away.addLoss();
                }
                if (home != null && away != null) {
                    this.homeScore = winScore;
                    this.awayScore = loseScore;
                    home.teamsBeat.add(away);
                    away.teamsLost.add(home);
                    if (home.sameConference(away)) {
                        home.addConferenceWin();
                        away.addConferenceLoss();
                    }
                    if (home.getDivision().equals(away.getDivision())) {
                        home.addDivisionWin();
                        away.addDivisionLoss();
                    }
                }
            } else{
                if (home != null) {
                    home.addLoss();
                    home.marginOfVictory += loseScore - winScore;
                    addResult(home, winScore, loseScore);
                    if (homeWinChance >= 0.9)
                        home.momentum -= 4*momentumFactor;
                    else if (homeWinChance >= 0.75)
                        home.momentum -= 3*momentumFactor;
                    else if (homeWinChance >= 0.5)
                        home.momentum -= 2.5*momentumFactor;
                    else if (homeWinChance >= 0.2)
                        home.momentum -= 2*momentumFactor;
                    else if (homeWinChance >= 0.05)
                        home.momentum -= 1.25*momentumFactor;
                    else if (homeWinChance >= -0.5)
                        home.momentum -= 0.5*momentumFactor;
                    else{
                        System.out.println("ERROR IN MOMENTUM, away win");
                        System.out.println(homeName + " vs " + awayName);
                        System.out.println(home.momentum + " vs " + away.momentum);
                        System.out.println(homeWinChance);
                    }
                }
                if (away != null) {
                    this.winner = away;
                    away.marginOfVictory += winScore - loseScore;
                    addResult(away, winScore, loseScore);
                    away.addWin();
                    if (homeWinChance >= 0.9)
                        away.momentum += 4*momentumFactor;
                    else if (homeWinChance >= 0.75)
                        away.momentum += 3*momentumFactor;
                    else if (homeWinChance >= 0.5)
                        away.momentum += 2.5*momentumFactor;
                    else if (homeWinChance >= 0.2)
                        away.momentum += 2*momentumFactor;
                    else if (homeWinChance >= 0.05)
                        away.momentum += 1.25*momentumFactor;
                    else if (homeWinChance >= -0.5)
                        away.momentum += 0.5*momentumFactor;
                    else{
                        System.out.println("ERROR IN MOMENTUM, away win");
                        System.out.println(homeName + " vs " + awayName);
                        System.out.println(home.momentum + " vs " + away.momentum);
                        System.out.println(homeWinChance);
                    }
                }
                if (home != null && away != null) {
                    this.homeScore = loseScore;
                    this.awayScore = winScore;
                    home.teamsLost.add(away);
                    away.teamsBeat.add(home);
                    if (home.sameConference(away)) {
                        home.addConferenceLoss();
                        away.addConferenceWin();
                    }
                    if (home.getDivision() == away.getDivision()) {
                        home.addDivisionLoss();
                        away.addDivisionWin();
                    }
                }
            }

        } else {
            int netMomentum = 0;
            if (home == null)
                netMomentum = -away.momentum;
            if (away == null)
                netMomentum = home.momentum;
            if (home != null && away != null)
                netMomentum = home.momentum - away.momentum;

            Random r = new Random();

            double val = r.nextGaussian() * this.overUnderSD + 0;
            int finalPoints = (int) (overUnder + val);

            if (this.spread + ((float) netMomentum * 1) > 0) {
                if (Main.singleSeason)
                    System.out.println("Line: " + this.homeName + " " + -(this.spread + ((float) netMomentum * 0.75)));
            }
            if (this.spread + ((float) netMomentum * 1) <= 0) {
                if (Main.singleSeason)
                    System.out.println("Line: " + this.homeName + " +" + -(this.spread + ((float) netMomentum * 0.75)));
            }

            double val2 = r.nextGaussian() * this.spreadSD + this.spread + ((float) netMomentum * 0.8);

            int homeTeamPoints = finalPoints / 2 + (int) val2 / 2;
            if (homeTeamPoints < 2)
                homeTeamPoints = 0;
            int awayTeamPoints = finalPoints / 2 - (int) val2 / 2;
            if (awayTeamPoints < 2)
                awayTeamPoints = 0;

            if (homeTeamPoints == awayTeamPoints) {
                homeTeamPoints += 3;
                if (Main.singleSeason)
                    System.out.println(this.awayName + ": " + awayTeamPoints + ", " + this.homeName + ": " + homeTeamPoints + " (OT)");
            } else {
                if (Main.singleSeason)
                    System.out.println(this.awayName + ": " + awayTeamPoints + ", " + this.homeName + ": " + homeTeamPoints);
            }

            if (homeTeamPoints > awayTeamPoints) {
                if (home != null) {
                    this.winner = home;
                    home.marginOfVictory += homeTeamPoints - awayTeamPoints;
                    addResult(home, homeTeamPoints, awayTeamPoints);
                    home.addWin();
                    if (-this.spread > -14)
                        home.momentum++;
                    if (-this.spread > 0)
                        home.momentum++;
                    if (-this.spread > 7)
                        home.momentum++;
                    if (-this.spread > 14)
                        home.momentum++;
                }
                if (away != null) {
                    away.marginOfVictory += awayTeamPoints - homeTeamPoints;
                    addResult(away, homeTeamPoints, awayTeamPoints);
                    if (-this.spread > -14)
                        away.momentum--;
                    if (-this.spread > 0)
                        away.momentum--;
                    if (-this.spread > 7)
                        away.momentum--;
                    if (-this.spread > 14)
                        away.momentum--;
                    away.addLoss();
                    away.momentum--;
                }
                if (home != null && away != null) {
                    this.homeScore = homeTeamPoints;
                    this.awayScore = awayTeamPoints;
                    home.teamsBeat.add(away);
                    away.teamsLost.add(home);
                    if (home.sameConference(away)) {
                        home.addConferenceWin();
                        away.addConferenceLoss();
                    }
                    if (home.getDivision().equals(away.getDivision())) {
                        home.addDivisionWin();
                        away.addDivisionLoss();
                    }
                }
            }
            if (awayTeamPoints > homeTeamPoints) {
                if (home != null) {
                    home.addLoss();
                    home.marginOfVictory += homeTeamPoints - awayTeamPoints;
                    addResult(home, awayTeamPoints, homeTeamPoints);
                    if (-this.spread < 14)
                        home.momentum--;
                    if (-this.spread < 0)
                        home.momentum--;
                    if (-this.spread < -7)
                        home.momentum--;
                    if (-this.spread < -14)
                        home.momentum--;
                }
                if (away != null) {
                    this.winner = away;
                    away.marginOfVictory += awayTeamPoints - homeTeamPoints;
                    addResult(away, awayTeamPoints, homeTeamPoints);
                    away.addWin();
                    if (-this.spread < 14)
                        away.momentum++;
                    if (-this.spread < 0)
                        away.momentum++;
                    if (-this.spread < -7)
                        away.momentum++;
                    if (-this.spread < -14)
                        away.momentum++;
                }
                if (home != null && away != null) {
                    this.homeScore = homeTeamPoints;
                    this.awayScore = awayTeamPoints;
                    home.teamsLost.add(away);
                    away.teamsBeat.add(home);
                    if (home.sameConference(away)) {
                        home.addConferenceLoss();
                        away.addConferenceWin();
                    }
                    if (home.getDivision() == away.getDivision()) {
                        home.addDivisionLoss();
                        away.addDivisionWin();
                    }
                }
            }
        }

        if(home!=null)
            if(home.momentum < -5)
                home.momentum = -5;
        if(away!=null)
            if(away.momentum < -5)
                away.momentum = -5;
        this.homeWinChance = this.originalHomeWinChance;
    }

    public void addResult(Team team, int winningScore, int losingScore){
        String text;
        String vsText;
        String opponentName;
        if(homeName == team.name){
            opponentName = awayName;
        }
        else{
            opponentName = homeName;
        }
        if(team == this.home){
            vsText = " vs. ";
        }
        else{
            vsText = " @ ";
        }
        if(team == this.winner){
            text = "W " + winningScore + "-" + losingScore + vsText + opponentName;
        }
        else{
            text = "L " + winningScore + "-" + losingScore + vsText + opponentName;
        }

        team.results.add(0,text);
    }

    public ArrayList<Integer> playLineGame(){
        int netMomentum = 0;
        if (home == null)
            netMomentum = -away.momentum;
        if (away == null)
            netMomentum = home.momentum;
        if (home != null && away != null)
            netMomentum = home.momentum - away.momentum;

        Random r = new Random();

        double val = r.nextGaussian() * this.overUnderSD + 0;
        int finalPoints = (int) (overUnder + val);

        double val2 = r.nextGaussian() * this.spreadSD + this.spread + ((float) netMomentum * 0.8);

        int homeTeamPoints = finalPoints / 2 + (int) val2 / 2;
        if (homeTeamPoints < 2)
            homeTeamPoints = 0;
        int awayTeamPoints = finalPoints / 2 - (int) val2 / 2;
        if (awayTeamPoints < 2)
            awayTeamPoints = 0;

        if (homeTeamPoints == awayTeamPoints)
            homeTeamPoints += 1;

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(homeTeamPoints);
        scores.add(0,awayTeamPoints);
        return scores;
    }

    public float getSpread(){
        return this.spread;
    }
}