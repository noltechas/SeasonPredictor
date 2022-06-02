import java.util.ArrayList;

public class Conference {
    public String name;
    public Division div1;
    public Division div2;
    public int totalTeams;

    public Conference(String name){
        this.name = name;
    }

    public Conference(String name, String d1, String d2, int totalTeams){
        this.name = name;
        this.div1 = new Division(d1);
        this.div2 = new Division(d2);
        this.totalTeams = totalTeams;
    }

    public void addTeam(Team team){
        if(div1.getSize() >= totalTeams/2){
            div2.addTeam(team);
            team.setDivision(div2.name);
        }
        else{
            div1.addTeam(team);
            team.setDivision(div1.name);
        }
    }

    public void showStandings(){
        System.out.println(div1.name);
        System.out.println("----------------");
        for(int i = 0; i < totalTeams/2; i++)
            System.out.println(div1.teams.get(i).name);
        System.out.println("----------------");
        System.out.println(div2.name);
        System.out.println("----------------");
        for(int i = 0; i < totalTeams/2; i++)
            System.out.println(div2.teams.get(i).name);
    }
}
