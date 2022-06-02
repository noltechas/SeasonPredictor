import java.util.Random;

public class Game {

    public boolean print = true;

    public Team home = null;
    public Team away = null;
    public Team winner = null;
    public String homeName;
    public String awayName;

    public float spread;
    public float overUnder;
    public float spreadSD;
    public float overUnderSD;


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

    public Game(Team away, String home, float spread, float overUnder, float spreadSD, float overUnderSD){
        this.away = away;
        this.homeName = home;
        this.awayName = away.name;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
    }

    public Game(String away, Team home, float spread, float overUnder, float spreadSD, float overUnderSD){
        this.home = home;
        this.homeName = home.name;
        this.awayName = away;
        this.spread = -spread;
        this.overUnder = overUnder;
        this.spreadSD = spreadSD;
        this.overUnderSD = overUnderSD;
    }

    public void play(){
        int netMomentum = 0;
        if(home==null)
            netMomentum = -away.momentum;
        if(away==null)
            netMomentum = home.momentum;
        if(home!=null && away!=null)
            netMomentum = home.momentum-away.momentum;

        Random r = new Random();

        double val = r.nextGaussian() * this.overUnderSD + 0;
        int finalPoints = (int) (overUnder + val);

        if(this.spread+((float)netMomentum*1) > 0) {
            if (Main.singleSeason)
                System.out.println("Line: " + this.homeName + " " + -(this.spread + ((float) netMomentum * 0.5)));
        }
        if(this.spread+((float)netMomentum*1) <= 0){
            if(Main.singleSeason)
                System.out.println("Line: " + this.homeName + " +" + -(this.spread + ((float) netMomentum * 0.5)));
        }

        double val2 = r.nextGaussian() * this.spreadSD + this.spread+((float)netMomentum*0.5);

        int homeTeamPoints = finalPoints/2 + (int)val2/2;
        if(homeTeamPoints < 2)
            homeTeamPoints = 0;
        int awayTeamPoints = finalPoints/2 - (int)val2/2;
        if(awayTeamPoints < 2)
            awayTeamPoints = 0;

        if(homeTeamPoints == awayTeamPoints){
            homeTeamPoints+=3;
            if(Main.singleSeason)
                System.out.println(this.awayName + ": " + awayTeamPoints + ", " + this.homeName + ": " + homeTeamPoints + " (OT)");
        }else {
            if(Main.singleSeason)
                System.out.println(this.awayName + ": " + awayTeamPoints + ", " + this.homeName + ": " + homeTeamPoints);
        }

        if(homeTeamPoints > awayTeamPoints){
            if(home!=null) {
                home.addWin();
                this.winner = home;
                if(-this.spread > -14)
                    home.momentum++;
                if(-this.spread > 0)
                    home.momentum++;
                if(-this.spread > 7)
                    home.momentum++;
                if(-this.spread > 14)
                    home.momentum++;
            }
            if(away!=null) {
                if(-this.spread > -14)
                    away.momentum--;
                if(-this.spread > 0)
                    away.momentum--;
                if(-this.spread > 7)
                    away.momentum--;
                if(-this.spread > 14)
                    away.momentum--;
                away.addLoss();
                away.momentum--;
            }
            if(home!=null && away!=null) {
                home.addConferenceWin();
                away.addConferenceLoss();
                if (home.getDivision().equals(away.getDivision())) {
                    home.addDivisionWin();
                    away.addDivisionLoss();
                }
            }
        }
        if(awayTeamPoints > homeTeamPoints){
            if(home!=null) {
                home.addLoss();
                if(-this.spread < 14)
                    home.momentum--;
                if(-this.spread < 0)
                    home.momentum--;
                if(-this.spread < -7)
                    home.momentum--;
                if(-this.spread < -14)
                    home.momentum--;
            }
            if(away!=null) {
                this.winner = away;
                away.addWin();
                if(-this.spread < 14)
                    away.momentum++;
                if(-this.spread < 0)
                    away.momentum++;
                if(-this.spread < -7)
                    away.momentum++;
                if(-this.spread < -14)
                    away.momentum++;
            }
            if(home!=null && away!=null) {
                home.addConferenceLoss();
                away.addConferenceWin();
                if (home.getDivision() == away.getDivision()) {
                    home.addDivisionLoss();
                    away.addDivisionWin();
                }
            }
        }
    }
}