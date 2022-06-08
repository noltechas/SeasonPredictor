import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean singleSeason = true;
    public static int week = 0;
    public static League league;

    public static void main(String[] args) throws IOException {

        Conference BigTen = new Conference("Big Ten","East","West",14);
        Conference Big12 = new Conference("Big 12",10);

        Team Michigan = new Team("Michigan",19F);
        Team OhioState = new Team("Ohio State", 29.5F);
        Team MichiganState = new Team("Michigan State", 10.5F);
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

        Team Oklahoma = new Team("Oklahoma",16F);
        Team Texas = new Team("Texas",15F);
        Team OKState = new Team("Oklahoma State",9.5F);
        Team Baylor = new Team("Baylor",8F);
        Team TCU = new Team("TCU",7F);
        Team IowaState = new Team("Iowa State",6.5F);
        Team KState = new Team("Kansas State",4.5F);
        Team WestVirginia = new Team("West Virginia",4.5F);
        Team TexasTech = new Team("Texas Tech",3.5F);
        Team Kansas = new Team("Kansas",-6.5F);
        Big12.addTeam(Oklahoma);Big12.addTeam(Texas);Big12.addTeam(OKState);Big12.addTeam(Baylor);Big12.addTeam(TCU);Big12.addTeam(IowaState);Big12.addTeam(KState);Big12.addTeam(WestVirginia);Big12.addTeam(TexasTech);Big12.addTeam(Kansas);

        ArrayList<Conference> conferences = new ArrayList<>();
        conferences.add(Big12);
        conferences.add(BigTen);
        league = new League(conferences);
        Schedule schedule = new Schedule(league);
        GUI gui;

        setSchedule(league);

        schedule.addGame(0,Nebraska,Northwestern, 12.5F,51.0F);
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
        schedule.addGame(1,WestVirginia,"Pitt", -7F,54.5F);
        schedule.addGame(1,"C Michigan",OKState, -21F,58F);
        schedule.addGame(1,"Tennessee Tech",Kansas, -30.5F,60F);
        schedule.addGame(1,TCU,"Colorado", 7.5F,54.5F);
        schedule.addGame(1,"SE Missouri St",IowaState, -35F,60F);
        schedule.addGame(1,"UTEP",Oklahoma, -35F,60F);
        schedule.addGame(1,"South Dakota",KState, -35F,60F);
        schedule.addGame(1,"Albany",Baylor, -35F,60F);
        schedule.addGame(1,"Murray State",TexasTech, -35F,60F);
        schedule.addGame(1,"UL Monroe",Texas, -38F,67F);

        schedule.addGame(2,IowaState,Iowa, -6F,48.5F);
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
        schedule.addGame(2,"Alabama",Texas, 15F,56.5F);
        schedule.addGame(2,"Missouri",KState, -2.5F,55F);
        schedule.addGame(2,"Houston",TexasTech, -5F,55F);
        schedule.addGame(2,Kansas,WestVirginia, -12F,55F);
        schedule.addGame(2,"Kent State",Oklahoma, -29.5F,60F);
        schedule.addGame(2,"Arizona State",OKState, -12F,60F);
        schedule.addGame(2,"Tarleton",TCU, -40F,65F);
        schedule.addGame(2,Baylor,"BYU", -1.5F,51.5F);

        schedule.addGame(3,Oklahoma,Nebraska, 3F,50F);
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
        schedule.addGame(3,"Texas State",Baylor, -27.5F,56F);
        schedule.addGame(3,"Towson",WestVirginia, -37.5F,60F);
        schedule.addGame(3,"Ohio",IowaState, -17.5F,58F);
        schedule.addGame(3,"Tulane",KState, -17.5F,58F);
        schedule.addGame(3,TexasTech,"NC State", -8.5F,48F);
        schedule.addGame(3,Kansas,"Houston", -15.5F,55F);
        schedule.addGame(3,"AR-Pine Bluff",OKState, -39.5F,64F);
        schedule.addGame(3,"UTSA",Texas, -29.5F,64F);


        schedule.addGame(4,"Chattanooga",Illinois, -23.5F,56F);
        schedule.addGame(4,Wisconsin,OhioState, -16F,50F);
        schedule.addGame(4,Iowa,Rutgers, 14.5F,50F);
        schedule.addGame(4,Minnesota,MichiganState, -10.5F,50F);
        schedule.addGame(4,"Miami (OH)",Northwestern, -8.5F,45.5F);
        schedule.addGame(4,Indiana,"Cincinnati", -9.5F,51F);
        schedule.addGame(4,"C Michigan",PennState, -32.5F,54F);
        schedule.addGame(4,Maryland,Michigan, -19.5F,56F);
        schedule.addGame(4,"FAU",Purdue, -20F,50F);
        schedule.addGame(4,WestVirginia,"Virginia Tech", 2.5F,48F);
        schedule.addGame(4,TCU,"SMU", 8.5F,52F);
        schedule.addGame(4,"Duke",Kansas, 4.5F,50F);
        schedule.addGame(4,Baylor,IowaState, -1.5F,50F);
        schedule.addGame(4,KState,Oklahoma, -9.5F,55F);
        schedule.addGame(4,Texas,TexasTech, 5F,55F);

        schedule.addGame(5,Michigan,Iowa, 3.5F,50F);
        schedule.addGame(5,Indiana,Nebraska, -14.5F,54F);
        schedule.addGame(5,Illinois,Wisconsin, -17.5F,56F);
        schedule.addGame(5,MichiganState,Maryland, -13.5F,50F);
        schedule.addGame(5,Northwestern,PennState, -24.5F,57F);
        schedule.addGame(5,Purdue,Minnesota, -2.5F,48F);
        schedule.addGame(5,Rutgers,OhioState, -27.5F,58F);
        schedule.addGame(5,OKState,Baylor, -1F,55F);
        schedule.addGame(5,IowaState,Kansas, 13.5F,55F);
        schedule.addGame(5,TexasTech,KState, -3.5F,55F);
        schedule.addGame(5,Oklahoma,TCU, 3.5F,55F);
        schedule.addGame(5,WestVirginia,Texas, -9.5F,56.5F);

        schedule.addGame(6,OhioState,MichiganState, 11.5F,50F);
        schedule.addGame(6,Nebraska,Rutgers, 10.5F,50F);
        schedule.addGame(6,Iowa,Illinois, 8.5F,50F);
        schedule.addGame(6,Wisconsin,Northwestern, 16.5F,50F);
        schedule.addGame(6,Purdue,Maryland, -2.5F,46F);
        schedule.addGame(6,Michigan,Indiana, 22.5F,53F);
        schedule.addGame(6,KState,IowaState, -4.5F,55F);
        schedule.addGame(6,TCU,Kansas, 11.5F,55F);
        schedule.addGame(6,Texas,Oklahoma, -1F,61F);
        schedule.addGame(6,TexasTech,OKState, -7.5F,55F);

        schedule.addGame(7,PennState,Michigan, -7F,50F);
        schedule.addGame(7,Wisconsin,MichiganState, -2F,50F);
        schedule.addGame(7,Nebraska,Purdue, 4.5F,50F);
        schedule.addGame(7,Maryland,Indiana, 3.5F,50F);
        schedule.addGame(7,Minnesota,Illinois, 5.5F,50F);
        schedule.addGame(7,Baylor,WestVirginia, 2.5F,55F);
        schedule.addGame(7,IowaState,Texas, -9F,55F);
        schedule.addGame(7,Kansas,Oklahoma, -21F,58F);
        schedule.addGame(7,OKState,TCU, 3.5F,55F);

        schedule.addGame(8,Iowa,OhioState, -21F,50F);
        schedule.addGame(8,Indiana,Rutgers, -1.5F,50F);
        schedule.addGame(8,Purdue,Wisconsin, -8.5F,50F);
        schedule.addGame(8,Northwestern,Maryland, -7F,50F);
        schedule.addGame(8,Minnesota,PennState, -10.5F,50F);
        schedule.addGame(8,Kansas,Baylor, -19.5F,55F);
        schedule.addGame(8,KState,TCU, -5.5F,55F);
        schedule.addGame(8,Texas,OKState, -1.5F,54.5F);
        schedule.addGame(8,WestVirginia,TexasTech, -4.5F,55F);

        schedule.addGame(9,OhioState,PennState, 12F,50F);
        schedule.addGame(9,MichiganState,Michigan, -8.5F,50F);
        schedule.addGame(9,Illinois,Nebraska, -15.5F,50F);
        schedule.addGame(9,Rutgers,Minnesota, -8.5F,50F);
        schedule.addGame(9,Northwestern,Iowa, -18.5F,50F);
        schedule.addGame(9,Oklahoma,IowaState, 4F,51.5F);
        schedule.addGame(9,Baylor,TexasTech, 5F,55F);
        schedule.addGame(9,OKState,KState, 6.5F,55F);
        schedule.addGame(9,TCU,WestVirginia, -2.5F,55F);

        schedule.addGame(10,Minnesota,Nebraska, -6.5F,50F);
        schedule.addGame(10,MichiganState,Illinois, 16.5F,50F);
        schedule.addGame(10,OhioState,Northwestern, 31.5F,50F);
        schedule.addGame(10,Iowa,Purdue, 4.5F,50F);
        schedule.addGame(10,Maryland,Wisconsin, -14.5F,50F);
        schedule.addGame(10,PennState,Indiana, 21.5F,50F);
        schedule.addGame(10,Michigan,Rutgers, 24.5F,50F);
        schedule.addGame(10,Baylor,Oklahoma, -9F,55F);
        schedule.addGame(10,WestVirginia,IowaState, -5.5F,55F);
        schedule.addGame(10,OKState,Kansas, -14.5F,55F);
        schedule.addGame(10,Texas,KState, 9.5F,55F);
        schedule.addGame(10,TexasTech,TCU, -3.5F,55F);

        schedule.addGame(11,Nebraska,Michigan, -12F,50F);
        schedule.addGame(11,Purdue,Illinois, 2.5F,50F);
        schedule.addGame(11,Wisconsin,Iowa, 5F,50F);
        schedule.addGame(11,Northwestern,Minnesota, -17.5F,50F);
        schedule.addGame(11,Rutgers,MichiganState, -22.5F,50F);
        schedule.addGame(11,Indiana,OhioState, -29.5F,50F);
        schedule.addGame(11,Maryland,PennState, -16.5F,50F);
        schedule.addGame(11,KState,Baylor, -9.5F,55F);
        schedule.addGame(11,IowaState,OKState, -7.5F,55F);
        schedule.addGame(11,Kansas,TexasTech, -13.5F,55F);
        schedule.addGame(11,Oklahoma,WestVirginia, 7.5F,55F);
        schedule.addGame(11,TCU,Texas, -13.5F,55F);

        schedule.addGame(12,Wisconsin,Nebraska, 3F,47.5F);
        schedule.addGame(12,Iowa,Minnesota, 5.5F,50F);
        schedule.addGame(12,Northwestern,Purdue, -11F,50F);
        schedule.addGame(12,OhioState,Maryland, 24.5F,50F);
        schedule.addGame(12,Illinois,Michigan, -27.5F,50F);
        schedule.addGame(12,Indiana,MichiganState, -25.5F,50F);
        schedule.addGame(12,PennState,Rutgers, 18.5F,50F);
        schedule.addGame(12,Oklahoma,OKState, 6F,55.5F);
        schedule.addGame(12,TCU,Baylor, -7.5F,55F);
        schedule.addGame(12,TexasTech,IowaState, -6.5F,55F);
        schedule.addGame(12,Texas,Kansas, -26.5F,58F);
        schedule.addGame(12,KState,WestVirginia, -7.5F,55F);

        schedule.addGame(13,MichiganState,PennState, -6F,50F);
        schedule.addGame(13,Michigan,OhioState, -13.5F,50F);
        schedule.addGame(13,Nebraska,Iowa, -3.5F,46.5F);
        schedule.addGame(13,Illinois,Northwestern, 7F,50F);
        schedule.addGame(13,Minnesota,Wisconsin, -7.5F,50F);
        schedule.addGame(13,Purdue,Indiana, 7.5F,50F);
        schedule.addGame(13,Rutgers,Maryland, -8.5F,50F);
        schedule.addGame(13,Baylor,Texas, -6F,53.5F);
        schedule.addGame(13,IowaState,TCU, -4.5F,55F);
        schedule.addGame(13,Kansas,KState, -18.5F,55F);
        schedule.addGame(13,Oklahoma,TexasTech, 9.5F,55F);
        schedule.addGame(13,WestVirginia,OKState, -8.5F,55F);

        if(!singleSeason) {

            Season season = new Season(schedule, 11000);

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
        if(singleSeason){
            gui = new GUI(Big12,schedule);
        }

    }

    private static void setSchedule(League league) {

    }

    public static void advanceWeek(Schedule schedule) throws IOException {
        ChampionshipGUI championshipGUI;
        if (week < 14) {
            schedule.playWeek(week);
            GUI.placeTeams();
        }
        else if (week == 14) {
            for(int i = 0; i < league.conferences.size(); i++) {
                league.conferences.get(i).setChampionship();
                championshipGUI = new ChampionshipGUI(league.conferences.get(i).championship, league.conferences.get(i), schedule);
                ChampionshipGUI.placeTeams();
            }
        }
        else{
            for(int i = 0; i < league.conferences.size(); i++) {
                league.conferences.get(i).playChampionship();
                ChampionshipGUI.placeTeams();
            }
        }
        week++;
    }

}
