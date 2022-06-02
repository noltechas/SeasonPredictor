import java.util.Scanner;

public class Main {
    public static boolean singleSeason = true;
    public static void main(String[] args){

        Conference BigTen = new Conference("Big Ten","East","West",14);

        Team Michigan = new Team("Michigan",19F);
        Team OhioState = new Team("Ohio State", 29.5F);
        Team MichiganState = new Team("Michigan State", 1.5F);
        Team PennState = new Team("Penn State", 11.5F);
        Team Maryland = new Team("Maryland", 5.5F);
        Team Rutgers = new Team("Rutgers", 2.5F);
        Team Indiana = new Team("Indiana", 3.5F);
        Team Iowa = new Team("Iowa",11F);
        Team Wisconsin = new Team("Wisconsin",13.5F);
        Team Minnesota = new Team("Minnesota",6.5F);
        Team Purdue = new Team("Purdue",7F);
        Team Illinois = new Team("Illinois",3F);
        Team Nebraska = new Team("Nebraska",12F);
        Team Northwestern = new Team("Northwestern", 0F);
        BigTen.addTeam(Michigan);BigTen.addTeam(OhioState);BigTen.addTeam(MichiganState);BigTen.addTeam(PennState);BigTen.addTeam(Maryland);BigTen.addTeam(Rutgers);BigTen.addTeam(Indiana);BigTen.addTeam(Iowa);BigTen.addTeam(Wisconsin);BigTen.addTeam(Minnesota);BigTen.addTeam(Purdue);BigTen.addTeam(Illinois);BigTen.addTeam(Nebraska);BigTen.addTeam(Northwestern);

        Schedule schedule = new Schedule(BigTen);

        schedule.addGame(0,Nebraska,Northwestern, 13F,51.0F);
        schedule.addGame(0,"Wyoming",Illinois, -10F,46F);

        schedule.addGame(1,PennState,Purdue, 3.5F,54.5F);
        schedule.addGame(1,"New Mexico State",Minnesota, -38.0F,57F);
        schedule.addGame(1,"Western Michigan",MichiganState, -18.5F,54.5F);
        schedule.addGame(1,Illinois,Indiana, -5.5F,48.5F);
        schedule.addGame(1,"North Dakota",Nebraska, -25.5F,58.5F);
        schedule.addGame(1,"S Dakota St",Iowa, -24.5F,60.5F);
        schedule.addGame(1,"Buffalo",Maryland, -21.0F,63.5F);
        schedule.addGame(1,"Colorado State",Michigan, -27.5F,57.5F);
        schedule.addGame(1,Rutgers,"Boston College", -7.5F,51.0F);
        schedule.addGame(1,"Illinois State",Wisconsin, -27.5F,60.0F);
        schedule.addGame(1,"Notre Dame",OhioState, -14.5F,58.5F);

        schedule.addGame(2,"Iowa State",Iowa, -6F,48.5F);
        schedule.addGame(2,"Georgia Southern",Nebraska, -29F,58F);
        schedule.addGame(2,"Western Illinois",Minnesota, -27F,58F);
        schedule.addGame(2,"Duke",Northwestern, -2.5F,50F);
        schedule.addGame(2,"Arkansas State",OhioState, -38.5F,60F);
        schedule.addGame(2,"Ohio",PennState, -18.5F,58F);
        schedule.addGame(2,"Washington State",Wisconsin, -11.5F,50F);
        schedule.addGame(2,Maryland,"Charlotte", -20.5F,50F);
        schedule.addGame(2,"Virginia",Illinois, 10.5F,56F);
        schedule.addGame(2,"Indiana State",Purdue, -30.5F,58F);
        schedule.addGame(2,"Akron",MichiganState, -35.5F,60F);
        schedule.addGame(2,"Wagner",Rutgers, -31.5F,60F);
        schedule.addGame(2,"Idaho",Indiana, -31.5F,60F);
        schedule.addGame(2,"Hawaii",Michigan, -40.5F,55F);

        schedule.addGame(3,"Oklahoma",Nebraska, 5F,50F);
        schedule.addGame(3,PennState,"Auburn", -1F,50F);
        schedule.addGame(3,Rutgers,"Temple", 9.5F,52F);
        schedule.addGame(3,"UConn",Michigan, -50F,62F);
        schedule.addGame(3,"S Illinois",Northwestern, -30F,60F);
        schedule.addGame(3,Purdue,"Syracuse", 9.5F,50F);
        schedule.addGame(3,"Western KY",Indiana, -9F,50F);
        schedule.addGame(3,"Colorado",Minnesota, -12.5F,50F);
        schedule.addGame(3,"New Mexico State",Wisconsin, -42.5F,60F);
        schedule.addGame(3,"Toledo",OhioState, -47.5F,64F);
        schedule.addGame(3,MichiganState,"Washington", 3F,50F);
        schedule.addGame(3,"Nevada",Iowa, -29F,60F);
        schedule.addGame(3,"SMU",Maryland, -17F,53F);

        schedule.addGame(4,"Chattanooga",Illinois, -23.5F,56F);
        schedule.addGame(4,Wisconsin,OhioState, -16F,50F);
        schedule.addGame(4,Iowa,Rutgers, 14.5F,50F);
        schedule.addGame(4,Minnesota,MichiganState, -10.5F,50F);
        schedule.addGame(4,"Miami (OH)",Northwestern, -8.5F,45.5F);
        schedule.addGame(4,Indiana,"Cincinnati", -9.5F,51F);
        schedule.addGame(4,"C Michigan",PennState, -32.5F,54F);
        schedule.addGame(4,Maryland,Michigan, -19.5F,56F);
        schedule.addGame(4,"FAU",Purdue, -20F,50F);

        schedule.addGame(5,Michigan,Iowa, 3.5F,50F);
        schedule.addGame(5,Indiana,Nebraska, -14.5F,54F);
        schedule.addGame(5,Illinois,Wisconsin, -17.5F,56F);
        schedule.addGame(5,MichiganState,Maryland, -13.5F,50F);
        schedule.addGame(5,Northwestern,PennState, -24.5F,57F);
        schedule.addGame(5,Purdue,Minnesota, -2.5F,48F);
        schedule.addGame(5,Rutgers,OhioState, -27.5F,58F);

        schedule.addGame(6,OhioState,MichiganState, 11.5F,50F);
        schedule.addGame(6,Nebraska,Rutgers, 10.5F,50F);
        schedule.addGame(6,Iowa,Illinois, 8.5F,50F);
        schedule.addGame(6,Wisconsin,Northwestern, 16.5F,50F);
        schedule.addGame(6,Purdue,Maryland, -2.5F,46F);
        schedule.addGame(6,Michigan,Indiana, 22.5F,53F);

        schedule.addGame(7,PennState,Michigan, -7F,50F);
        schedule.addGame(7,Wisconsin,MichiganState, -2F,50F);
        schedule.addGame(7,Nebraska,Purdue, 4.5F,50F);
        schedule.addGame(7,Maryland,Indiana, 3.5F,50F);
        schedule.addGame(7,Minnesota,Illinois, 5.5F,50F);

        schedule.addGame(8,Iowa,OhioState, -21F,50F);
        schedule.addGame(8,Indiana,Rutgers, -1.5F,50F);
        schedule.addGame(8,Purdue,Wisconsin, -8.5F,50F);
        schedule.addGame(8,Northwestern,Maryland, -7F,50F);
        schedule.addGame(8,Minnesota,PennState, -10.5F,50F);

        schedule.addGame(9,OhioState,PennState, 12F,50F);
        schedule.addGame(9,MichiganState,Michigan, -8.5F,50F);
        schedule.addGame(9,Illinois,Nebraska, -13.5F,50F);
        schedule.addGame(9,Rutgers,Minnesota, -8.5F,50F);
        schedule.addGame(9,Northwestern,Iowa, -18.5F,50F);

        schedule.addGame(10,Minnesota,Nebraska, -6.5F,50F);
        schedule.addGame(10,MichiganState,Illinois, 16.5F,50F);
        schedule.addGame(10,OhioState,Northwestern, 31.5F,50F);
        schedule.addGame(10,Iowa,Purdue, 4.5F,50F);
        schedule.addGame(10,Maryland,Wisconsin, -14.5F,50F);
        schedule.addGame(10,PennState,Indiana, 21.5F,50F);
        schedule.addGame(10,Michigan,Rutgers, 24.5F,50F);

        schedule.addGame(11,Nebraska,Michigan, -12F,50F);
        schedule.addGame(11,Purdue,Illinois, 2.5F,50F);
        schedule.addGame(11,Wisconsin,Iowa, 5F,50F);
        schedule.addGame(11,Northwestern,Minnesota, -17.5F,50F);
        schedule.addGame(11,Rutgers,MichiganState, -22.5F,50F);
        schedule.addGame(11,Indiana,OhioState, -29.5F,50F);
        schedule.addGame(11,Maryland,PennState, -16.5F,50F);

        schedule.addGame(12,Wisconsin,Nebraska, -1.5F,50F);
        schedule.addGame(12,Iowa,Minnesota, 5.5F,50F);
        schedule.addGame(12,Northwestern,Purdue, -11F,50F);
        schedule.addGame(12,OhioState,Maryland, 24.5F,50F);
        schedule.addGame(12,Illinois,Michigan, -27.5F,50F);
        schedule.addGame(12,Indiana,MichiganState, -25.5F,50F);
        schedule.addGame(12,PennState,Rutgers, 18.5F,50F);

        schedule.addGame(13,MichiganState,PennState, -6F,50F);
        schedule.addGame(13,Michigan,OhioState, -13.5F,50F);
        schedule.addGame(13,Nebraska,Iowa, -3.5F,50F);
        schedule.addGame(13,Illinois,Northwestern, 7F,50F);
        schedule.addGame(13,Minnesota,Wisconsin, -7.5F,50F);
        schedule.addGame(13,Purdue,Indiana, 7.5F,50F);
        schedule.addGame(13,Rutgers,Maryland, -8.5F,50F);

        if(!singleSeason) {

            Season season = new Season(schedule, 1000000);

            OhioState.printResults();
            Michigan.printResults();
            PennState.printResults();
            MichiganState.printResults();
            Maryland.printResults();
            Rutgers.printResults();
            Indiana.printResults();

            Iowa.printResults();
            Wisconsin.printResults();
            Purdue.printResults();
            Minnesota.printResults();
            Illinois.printResults();
            Northwestern.printResults();
            Nebraska.printResults();
        }
        else {
            Scanner myObj = new Scanner(System.in);
            for (int i = 0; i < 14; i++) {
                System.out.println("Click Enter to Continue");
                String userName = myObj.nextLine();
                System.out.println();
                schedule.playWeek(i);
                System.out.println();
                schedule.printStandings();
            }
            System.out.println("Click Enter to Advance to Championship");
            String userName = myObj.nextLine();
            schedule.playChampionship();
        }




    }

}
