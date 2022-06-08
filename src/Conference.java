import java.util.ArrayList;

public class Conference {
    public String name;
    public Division div1;
    public Division div2;
    public int totalTeams;
    public boolean hasDivisions = false;
    public Game championship;

    public Conference(String name){
        this.name = name;
    }

    public Conference(String name, String d1, String d2, int totalTeams){
        this.name = name;
        this.div1 = new Division(d1);
        this.div2 = new Division(d2);
        this.totalTeams = totalTeams;
        this.hasDivisions = true;
    }

    public Conference(String name, int totalTeams) {
        this.name = name;
        this.totalTeams = totalTeams;
        this.div1 = new Division(name);
    }

    public void addTeam(Team team){
        if(hasDivisions) {
            if (div1.getSize() >= totalTeams / 2) {
                div2.addTeam(team);
                team.conference = this;
                team.setDivision(div2.name);
            } else {
                div1.addTeam(team);
                team.conference = this;
                team.setDivision(div1.name);
            }
        }
        else{
            div1.addTeam(team);
            team.conference = this;
            team.setDivision(div1.name);
        }
    }

    public void setChampionship(){
        if(hasDivisions)
            championship = new Game(div1.getWinner(),div2.getWinner(),div1.getWinner().teamRating-div2.getWinner().teamRating,50,14.5F,13.5F);
    }

    public void playChampionship(){
        if(hasDivisions) {
            Team div1Champ = div1.getWinner();
            Team div2Champ = div2.getWinner();

            float gameSpread = (div1Champ.teamRating + div1Champ.momentum) - (div2Champ.teamRating + div2Champ.momentum);

            if (Main.singleSeason) {
                System.out.println("Championship Game: " + div1Champ.name + " vs. " + div2Champ.name);
                System.out.println("Line: " + div1Champ.name + " -" + gameSpread);
            }

            championship.play();

            championship.winner.addChampionship();
            if (championship.winner.totalLosses <= 1)
                championship.winner.addPlayoff();
        }
    }

}
