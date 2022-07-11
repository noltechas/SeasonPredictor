import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean singleSeason = true;
    public static boolean usePercentage = true;
    public static int week = 0;
    public static League league;

    public static void main(String[] args) throws IOException {

        Conference BigTen = new Conference("Big Ten","East","West",14);
        Conference Big12 = new Conference("Big 12",10);
        Conference Pac12 = new Conference("Pac 12",12);
        Conference ACC = new Conference("ACC","Atlantic","Coastal",14);
        Conference SEC = new Conference("SEC","East","West",14);
        Conference American = new Conference("American",11);

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

        Team USC = new Team("USC", 19F);
        Team Utah = new Team("Utah", 16.5F);
        Team Oregon = new Team("Oregon", 15.5F);
        Team UCLA = new Team("UCLA", 12.5F);
        Team Washington = new Team("Washington", 7.5F);
        Team ArizonaState = new Team("Arizona State", 5F);
        Team OregonState = new Team("Oregon State", 2F);
        Team WashingtonState = new Team("Washington State", 1.5F);
        Team Stanford = new Team("Stanford", 1.5F);
        Team Cal = new Team("Cal", 1F);
        Team Colorado = new Team("Colorado", -3F);
        Team Arizona = new Team("Arizona", -4.5F);
        Pac12.addTeam(USC);Pac12.addTeam(Utah);Pac12.addTeam(Oregon);Pac12.addTeam(UCLA);Pac12.addTeam(Washington);Pac12.addTeam(ArizonaState);Pac12.addTeam(OregonState);Pac12.addTeam(WashingtonState);Pac12.addTeam(Stanford);Pac12.addTeam(Cal);Pac12.addTeam(Colorado);Pac12.addTeam(Arizona);

        Team BostonCollege = new Team("Boston College",5F);
        Team Clemson = new Team("Clemson",25F);
        Team FloridaState = new Team("Florida State",11F);
        Team Louisville = new Team("Louisville",4.5F);
        Team NCState = new Team("NC State",15.5F);
        Team Syracuse = new Team("Syracuse",2F);
        Team WakeForest = new Team("Wake Forest",13F);
        Team Duke = new Team("Duke",-2F);
        Team GeorgiaTech = new Team("Georgia Tech",3F);
        Team Miami = new Team("Miami",17F);
        Team NorthCarolina = new Team("North Carolina",14.5F);
        Team Pitt = new Team("Pitt",16F);
        Team Virginia = new Team("Virginia",11F);
        Team VirginiaTech = new Team("Virginia Tech",4F);
        ACC.addTeam(BostonCollege);ACC.addTeam(Clemson);ACC.addTeam(FloridaState);ACC.addTeam(Louisville);ACC.addTeam(NCState);ACC.addTeam(Syracuse);ACC.addTeam(WakeForest);ACC.addTeam(Duke);ACC.addTeam(GeorgiaTech);ACC.addTeam(Miami);ACC.addTeam(NorthCarolina);ACC.addTeam(Pitt);ACC.addTeam(Virginia);ACC.addTeam(VirginiaTech);

        Team Georgia = new Team("Georgia", 31);
        Team Kentucky = new Team("Kentucky", 15);
        Team Tennessee = new Team("Tennessee", 13.5F);
        Team Missouri = new Team("Missouri", 12);
        Team SouthCarolina = new Team("South Carolina", 13);
        Team Florida = new Team("Florida", 15);
        Team Vanderbilt = new Team("Vanderbilt", 3.5F);
        Team Alabama = new Team("Alabama", 33F);
        Team OleMiss = new Team("Ole Miss", 21F);
        Team Arkansas = new Team("Arkansas", 17.5F);
        Team MississippiState = new Team("Mississippi State", 12.5F);
        Team TexasAM = new Team("Texas A&M", 20F);
        Team Auburn = new Team("Auburn", 10F);
        Team LSU = new Team("LSU", 10.5F);
        SEC.addTeam(Georgia);SEC.addTeam(Kentucky);SEC.addTeam(Tennessee);SEC.addTeam(Missouri);SEC.addTeam(SouthCarolina);SEC.addTeam(Florida);SEC.addTeam(Vanderbilt);SEC.addTeam(Alabama);SEC.addTeam(OleMiss);SEC.addTeam(Arkansas);SEC.addTeam(MississippiState);SEC.addTeam(TexasAM);SEC.addTeam(Auburn);SEC.addTeam(LSU);

        Team Cincinnati = new Team("Cincinnati",17F);
        Team Houston = new Team("Houston",13F);
        Team UCF = new Team("UCF",15F);
        Team EastCarolina = new Team("East Carolina",7.5F);
        Team Tulsa = new Team("Tulsa",7.5F);
        Team SMU = new Team("SMU",8F);
        Team Memphis = new Team("Memphis",10F);
        Team Navy = new Team("Navy",5F);
        Team Temple = new Team("Temple",4.5F);
        Team USF = new Team("USF",2.5F);
        Team Tulane = new Team("Tulane",1.5F);
        American.addTeam(Cincinnati);American.addTeam(Houston);American.addTeam(UCF);American.addTeam(EastCarolina);American.addTeam(Tulsa);American.addTeam(SMU);American.addTeam(Memphis);American.addTeam(Navy);American.addTeam(Temple);American.addTeam(USF);American.addTeam(Tulane);

        Team NotreDame = new Team("Notre Dame", 18);
        Team BYU = new Team("BYU", 16);
        ArrayList<Team> independents = new ArrayList<>();
        independents.add(NotreDame);independents.add(BYU);

        ArrayList<Conference> conferences = new ArrayList<>();
        conferences.add(BigTen);
        conferences.add(Big12);
        conferences.add(Pac12);
        conferences.add(ACC);
        conferences.add(SEC);
        conferences.add(American);
        league = new League(conferences, independents);
        Schedule schedule = new Schedule(league);
        GUI gui;

        setSchedule(league);

        schedule.addGame(0,Nebraska,Northwestern, 12.5F,51.0F,.213F);
        schedule.addGame(0,"Wyoming",Illinois, -10F,46F,.751F);
        schedule.addGame(0,"Duquesne",FloridaState, -33.5F,56F,.995F);
        schedule.addGame(0,"Florida A&M",NorthCarolina, -31.5F,57F,.996F);
        schedule.addGame(0,Vanderbilt,"Hawaii", 7F,55F,.72F);

        schedule.addGame(1,PennState,Purdue, 3.5F,54.5F,.398F);
        schedule.addGame(1,"New Mexico State",Minnesota, -38.0F,57F,.984F);
        schedule.addGame(1,"Western Michigan",MichiganState, -18.5F,54.5F,.941F);
        schedule.addGame(1,Illinois,Indiana, -5.5F,48.5F,.663F);
        schedule.addGame(1,"North Dakota",Nebraska, -25.5F,58.5F,.984F);
        schedule.addGame(1,"S Dakota St",Iowa, -24.5F,60.5F,.91F);
        schedule.addGame(1,"Buffalo",Maryland, -21.0F,63.5F,.882F);
        schedule.addGame(1,"Colorado State",Michigan, -27.5F,57.5F,.976F);
        schedule.addGame(1,Rutgers,BostonCollege, -7.5F,51.0F,.703F);
        schedule.addGame(1,"Illinois State",Wisconsin, -27.5F,60.0F,.974F);
        schedule.addGame(1,NotreDame,OhioState, -14.5F,58.5F,.835F);
        schedule.addGame(1,WestVirginia,Pitt, -7F,54.5F,.781F);
        schedule.addGame(1,"C Michigan",OKState, -21F,58F,.942F);
        schedule.addGame(1,"Tennessee Tech",Kansas, -30.5F,60F,.971F);
        schedule.addGame(1,TCU,Colorado, 7.5F,54.5F,.315F);
        schedule.addGame(1,"SE Missouri St",IowaState, -35F,60F,.986F);
        schedule.addGame(1,"UTEP",Oklahoma, -32.5F,56F,.979F);
        schedule.addGame(1,"South Dakota",KState, -35F,60F,.964F);
        schedule.addGame(1,"Albany",Baylor, -35F,60F,.985F);
        schedule.addGame(1,"Murray State",TexasTech, -35F,60F,.99F);
        schedule.addGame(1,"SC State",UCF, -31F,61F,.992F);
        schedule.addGame(1,"Ball State",Tennessee, -30.5F,68F,.951F);
        schedule.addGame(1,"VMI",WakeForest, -29.5F,63F,.997F);
        schedule.addGame(1,"LA Tech",Missouri, -19F,59F,.771F);
        schedule.addGame(1,"N Arizona",ArizonaState, -29F,54F,.977F);
        schedule.addGame(1,VirginiaTech,"Old Dominion", 8F,52.5F,.337F);
        schedule.addGame(1,Temple,Duke, -8F,52F,.759F);
        schedule.addGame(1,NCState,EastCarolina, 11F,56.5F,.252F);
        schedule.addGame(1,"Delaware",Navy, -21.5F,57.5F,.901F);
        schedule.addGame(1,NorthCarolina,"App State", 3F,57.5F,.376F);
        schedule.addGame(1,"Sam Houston",TexasAM, -40.5F,67.5F,.984F);
        schedule.addGame(1,"Richmond",Virginia, -24.5F,62F,.967F);
        schedule.addGame(1,"Bowling Green",UCLA, -25.5F,57F,.969F);
        schedule.addGame(1,"B-Cookman",Miami, -36.5F,63F,.998F);
        schedule.addGame(1,Tulsa,"Wyoming", 1F,46F,.474F);
        schedule.addGame(1,Arizona,"San Diego St", -5F,48.5F,.671F);
        schedule.addGame(1,Houston,"UTSA", 4.5F,48.5F,.376F);
        schedule.addGame(1,Cincinnati,Arkansas, -7F,53.5F,.596F);
        schedule.addGame(1,Oregon,Georgia, -17.5F,50.5F,.915F);
        schedule.addGame(1,"UC Davis",Cal, -19.5F,50F,.921F);
        schedule.addGame(1,BYU,USF, -12F,57.5F,.352F);
        schedule.addGame(1,"Troy",OleMiss, -24F,61F,.889F);
        schedule.addGame(1,"Rice",USC, -35.5F,64.5F,.961F);
        schedule.addGame(1,"UMASS",Tulane, -29.5F,60F,.939F);
        schedule.addGame(1,Utah,Florida, 2F,52.5F,.521F);
        schedule.addGame(1,"Miami (OH)",Kentucky, -20.5F,50.5F,.933F);
        schedule.addGame(1,"Mercer",Auburn, -36.5F,60.5F,.996F);
        schedule.addGame(1,"Elon",Vanderbilt, -29.5F,55.5F,.886F);
        schedule.addGame(1,SMU,"North Texas", 9F,70F,.272F);
        schedule.addGame(1,"Utah State",Alabama, -38F,62.5F,.992F);
        schedule.addGame(1,"Georgia State",SouthCarolina, -13F,56F,.825F);
        schedule.addGame(1,Memphis,MississippiState, -17F,56.5F,.773F);
        schedule.addGame(1,"LA-Monroe",Texas, -38.5F,67.5F,.989F);
        schedule.addGame(1,Louisville,Syracuse, -3.5F,59.5F,.418F);
        schedule.addGame(1,"Colgate",Stanford, -27.5F,54F,.983F);
        schedule.addGame(1,"Idaho",WashingtonState, -29.5F,56F,.954F);
        schedule.addGame(1,"Boise State",OregonState, -3.5F,60F,.498F);
        schedule.addGame(1,"Kent State",Washington, -22.5F,60.5F,.916F);
        schedule.addGame(1,FloridaState,LSU, -3F,51.5F,.71F);
        schedule.addGame(1,Clemson,GeorgiaTech, 19.5F,50F,.057F);

        schedule.addGame(2,IowaState,Iowa, -6F,48.5F,.52F);
        schedule.addGame(2,"Georgia Southern",Nebraska, -29F,58F,.92F);
        schedule.addGame(2,"Western Illinois",Minnesota, -27F,58F,.988F);
        schedule.addGame(2,Duke,Northwestern, -2.5F,50F,.754F);
        schedule.addGame(2,"Arkansas State",OhioState, -38.5F,60F,.993F);
        schedule.addGame(2,"Ohio",PennState, -18.5F,58F,.975F);
        schedule.addGame(2,WashingtonState,Wisconsin, -11.5F,50F,.888F);
        schedule.addGame(2,Maryland,"Charlotte", -20.5F,50F,.204F);
        schedule.addGame(2,Virginia,Illinois, 10.5F,56F,.474F);
        schedule.addGame(2,"Indiana State",Purdue, -30.5F,58F,.986F);
        schedule.addGame(2,"Akron",MichiganState, -35.5F,60F,.98F);
        schedule.addGame(2,"Wagner",Rutgers, -31.5F,60F,.991F);
        schedule.addGame(2,"Idaho",Indiana, -31.5F,60F,.966F);
        schedule.addGame(2,"Hawaii",Michigan, -40.5F,55F,.98F);
        schedule.addGame(2,Alabama,Texas, 15F,56.5F,.247F);
        schedule.addGame(2,Missouri,KState, -2.5F,55F,.683F);
        schedule.addGame(2,Houston,TexasTech, -5F,55F,.557F);
        schedule.addGame(2,Kansas,WestVirginia, -12F,55F,.864F);
        schedule.addGame(2,"Kent State",Oklahoma, -29.5F,60F,.971F);
        schedule.addGame(2,ArizonaState,OKState, -12F,60F,.817F);
        schedule.addGame(2,"Tarleton",TCU, -40F,65F,.998F);
        schedule.addGame(2,Baylor,BYU, -1.5F,51.5F,.428F);
        schedule.addGame(2,Louisville,UCF, -7.5F,57.5F,.632F);
        schedule.addGame(2,"Lafayette",Temple, -19.5F,58F,.955F);
        schedule.addGame(2,"Southern Miss",Miami, -20.5F,55F,.955F);
        schedule.addGame(2,SouthCarolina,Arkansas, -7.5F,48.5F,.722F);
        schedule.addGame(2,NorthCarolina,"Georgia State", 14.5F,48.5F,.166F);
        schedule.addGame(2,WakeForest,Vanderbilt, 6.5F,47.5F,.128F);
        schedule.addGame(2,"Charleston So",NCState, -25.5F,57.5F,.995F);
        schedule.addGame(2,"Southern Utah",Utah, -28.5F,58F,.994F);
        schedule.addGame(2,"Kennesaw St",Cincinnati, -29.5F,58F,.975F);
        schedule.addGame(2,Tennessee,Pitt, 3.5F,58.5F,.627F);
        schedule.addGame(2,"Furman",Clemson, -43.5F,68.5F,.994F);
        schedule.addGame(2,Memphis,Navy, -3.5F,54.5F,.274F);
        schedule.addGame(2,Colorado,"Air Force", -6.5F,50F,.631F);
        schedule.addGame(2,"App State",TexasAM, -17.5F,54.5F,.844F);
        schedule.addGame(2,"UNLV",Cal, -13.5F,51.5F,.82F);
        schedule.addGame(2,"Portland State",Washington, -26.5F,57.5F,.982F);
        schedule.addGame(2,"Samford",Georgia, -46.5F,77.5F,.999F);
        schedule.addGame(2,"Alabama St",UCLA, -31.5F,66F,.998F);
        schedule.addGame(2,"Old Dominion",EastCarolina, -8.5F,60F,.776F);
        schedule.addGame(2,"Lamar",SMU, -26.5F,62F,.992F);
        schedule.addGame(2,"Alcorn State",Tulane, -21.5F,63F,.975F);
        schedule.addGame(2,"W Carolina",GeorgiaTech, -23.5F,64F,.992F);
        schedule.addGame(2,"Howard",USF, -18.5F,62F,.996F);
        schedule.addGame(2,"N Illinois",Tulsa, -6.5F,57.5F,.699F);
        schedule.addGame(2,"C Arkansas",OleMiss, -26.5F,67.5F,.985F);
        schedule.addGame(2,Syracuse,"UConn", 22.5F,67.5F,.104F);
        schedule.addGame(2,USC,Stanford, 11F,55.5F,.383F);
        schedule.addGame(2,"San Jose St",Auburn, -21.5F,56.5F,.963F);
        schedule.addGame(2,"Southern U",LSU, -26.5F,55F,.995F);
        schedule.addGame(2,BostonCollege,VirginiaTech, -5.5F,50F,.511F);
        schedule.addGame(2,"Eastern Washington",Oregon, -19.5F,57F,.966F);
        schedule.addGame(2,OregonState,"Fresno State", 3.5F,50F,.516F);
        schedule.addGame(2,MississippiState,Arizona, 16.5F,52F,.189F);
        schedule.addGame(2,Kentucky,Florida, -4F,50F,.511F);
        schedule.addGame(2,"Marshall",NotreDame, -26F,54F,.908F);

        schedule.addGame(3,Oklahoma,Nebraska, 3F,50F,.395F);
        schedule.addGame(3,PennState,Auburn, -1F,50F,.626F);
        schedule.addGame(3,Rutgers,Temple, 9.5F,52F,.257F);
        schedule.addGame(3,"UConn",Michigan, -50F,62F,.991F);
        schedule.addGame(3,"S Illinois",Northwestern, -30F,60F,.914F);
        schedule.addGame(3,Purdue,Syracuse, 9.5F,50F,.447F);
        schedule.addGame(3,"Western KY",Indiana, -9F,50F,.529F);
        schedule.addGame(3,Colorado,Minnesota, -12.5F,50F,.834F);
        schedule.addGame(3,"New Mexico State",Wisconsin, -42.5F,60F,.988F);
        schedule.addGame(3,"Toledo",OhioState, -47.5F,64F,.98F);
        schedule.addGame(3,MichiganState,Washington, 3F,50F,.393F);
        schedule.addGame(3,"Nevada",Iowa, -29F,60F,.904F);
        schedule.addGame(3,SMU,Maryland, -17F,53F,.71F);
        schedule.addGame(3,"Texas State",Baylor, -27.5F,56F,.944F);
        schedule.addGame(3,"Towson",WestVirginia, -37.5F,60F,.948F);
        schedule.addGame(3,"Ohio",IowaState, -17.5F,58F,.961F);
        schedule.addGame(3,Tulane,KState, -17.5F,58F,.756F);
        schedule.addGame(3,TexasTech,NCState, -8.5F,48F,.748F);
        schedule.addGame(3,Kansas,Houston, -15.5F,55F,.889F);
        schedule.addGame(3,"AR-Pine Bluff",OKState, -39.5F,64F,.999F);
        schedule.addGame(3,"UTSA",Texas, -29.5F,64F,.924F);
        schedule.addGame(3,FloridaState,Louisville, 7.5F,50F,.524F);
        schedule.addGame(3,"Wofford",VirginiaTech, -27.5F,55F,.917F);
        schedule.addGame(3,Georgia,SouthCarolina, 14.5F,50F,.079F);
        schedule.addGame(3,"Ab Christian",Missouri, -24.5F,57F,.982F);
        schedule.addGame(3,"Youngstown St",Kentucky, -25.5F,58F,.982F);
        schedule.addGame(3,Cincinnati,"Miami (OH)", 19.5F,54F,.117F);
        schedule.addGame(3,"Old Dominion",Virginia, -18.5F,50F,.856F);
        schedule.addGame(3,"S Alabama",UCLA, -22.5F,56F,.926F);
        schedule.addGame(3,Cal,NotreDame, -16F,51.5F,.941F);
        schedule.addGame(3,BYU,Oregon, -6.5F,49F,.741F);
        schedule.addGame(3,OleMiss,GeorgiaTech, 10.5F,55F,.227F);
        schedule.addGame(3,Vanderbilt,"N Illinois", 6.5F,50F,.575F);
        schedule.addGame(3,"LA-Monroe",Alabama, -36.5F,64F,.998F);
        schedule.addGame(3,"Colorado State",WashingtonState, -11.5F,52.5F,.797F);
        schedule.addGame(3,"Liberty",WakeForest, -7.5F,50F,.839F);
        schedule.addGame(3,"NC A&T",Duke, -24.5F,56F,.873F);
        schedule.addGame(3,"Campbell",EastCarolina, -24.5F,57F,.989F);
        schedule.addGame(3,MississippiState,LSU, -3.5F,50F,.682F);
        schedule.addGame(3,"Arkansas State",Memphis, -13.5F,56F,.869F);
        schedule.addGame(3,"Jax State",Tulsa, -17.5F,52F,.927F);
        schedule.addGame(3,"Missouri State",Arkansas, -23.5F,54.5F,.994F);
        schedule.addGame(3,"Akron",Tennessee, -21.5F,53.5F,.973F);
        schedule.addGame(3,"Maine",BostonCollege, -22.5F,55.5F,.949F);
        schedule.addGame(3,USF,Florida, -18.5F,54F,.877F);
        schedule.addGame(3,Pitt,"W Michigan", 13.5F,54F,.124F);
        schedule.addGame(3,UCF,"FAU", 10.5F,52.5F,.23F);
        schedule.addGame(3,"LA Tech",Clemson, -23.5F,56.5F,.977F);
        schedule.addGame(3,"Montana St",OregonState, -21.5F,54.5F,.886F);
        schedule.addGame(3,Miami,TexasAM, -7.5F,50F,.563F);
        schedule.addGame(3,"San Diego St",Utah, -12.5F,51F,.902F);
        schedule.addGame(3,"Fresno State",USC, -18.5F,49.5F,.801F);
        schedule.addGame(3,"ND State",Arizona, 3.5F,46.5F,.532F);
        schedule.addGame(3,"E Michigan",ArizonaState, -13.5F,50F,.905F);


        schedule.addGame(4,"Chattanooga",Illinois, -23.5F,56F,.964F);
        schedule.addGame(4,Wisconsin,OhioState, -16F,50F,.92F);
        schedule.addGame(4,Iowa,Rutgers, 14.5F,50F,.31F);
        schedule.addGame(4,Minnesota,MichiganState, -10.5F,50F,.745F);
        schedule.addGame(4,"Miami (OH)",Northwestern, -8.5F,45.5F,.705F);
        schedule.addGame(4,Indiana,Cincinnati, -9.5F,51F,.829F);
        schedule.addGame(4,"C Michigan",PennState, -32.5F,54F,.938F);
        schedule.addGame(4,Maryland,Michigan, -19.5F,56F,.826F);
        schedule.addGame(4,"FAU",Purdue, -20F,50F,.847F);
        schedule.addGame(4,WestVirginia,VirginiaTech, 2.5F,48F,.437F);
        schedule.addGame(4,TCU,SMU, 7.5F,52F,.451F);
        schedule.addGame(4,Duke,Kansas, 4.5F,50F,.575F);
        schedule.addGame(4,Baylor,IowaState, -1.5F,50F,.537F);
        schedule.addGame(4,KState,Oklahoma, -9.5F,55F,.805F);
        schedule.addGame(4,Texas,TexasTech, 5F,55F,.241F);
        schedule.addGame(4,Virginia,Syracuse, 2.5F,50F,.56F);
        schedule.addGame(4,"UMASS",Temple, -15.5F,50F,.706F);
        schedule.addGame(4,Arizona,Cal, -5.5F,50F,.721F);
        schedule.addGame(4,UCLA,Colorado, 12.5F,50F,.301F);
        schedule.addGame(4,Utah,ArizonaState, 6.5F,50F,.323F);
        schedule.addGame(4,"Rice",Houston, -16.5F,50F,.94F);
        schedule.addGame(4,"North Texas",Memphis, -13.5F,50F,.803F);
        schedule.addGame(4,"Southern Miss",Tulane, -6.5F,50F,.774F);
        schedule.addGame(4,GeorgiaTech,UCF, -8.5F,55F,.8F);
        schedule.addGame(4,"Rhode Island",Pitt, -18.5F,55F,.993F);
        schedule.addGame(4,Oregon,WashingtonState, 6.5F,55F,.233F);
        schedule.addGame(4,USC,OregonState, 13.5F,50F,.42F);
        schedule.addGame(4,"UConn",NCState, -27.5F,50F,.979F);
        schedule.addGame(4,Stanford,Washington, -8.5F,50F,.664F);
        schedule.addGame(4,Navy,EastCarolina, -2.5F,50F,.721F);
        schedule.addGame(4,BostonCollege,FloridaState, -6.5F,50F,.79F);
        schedule.addGame(4,Clemson,WakeForest, 9F,59F,.208F);
        schedule.addGame(4,USF,Louisville, -12.5F,53F,.86F);
        schedule.addGame(4,"Middle Tenn",Miami, -18.5F,56F,.93F);
        schedule.addGame(4,NotreDame,NorthCarolina, 6.5F,50F,.433F);
        schedule.addGame(4,"Bowling Green",MississippiState, -17.5F,50F,.976F);
        schedule.addGame(4,Missouri,Auburn, -9.5F,50F,.856F);
        schedule.addGame(4,"Kent State",Georgia, -28.5F,60F,.994F);
        schedule.addGame(4,Tulsa,OleMiss, -17.5F,58F,.924F);
        schedule.addGame(4,Vanderbilt,Alabama, -37.5F,62F,.993F);
        schedule.addGame(4,"N Illinois",Kentucky, -22.5F,57F,.951F);
        schedule.addGame(4,"Charlotte",SouthCarolina, -24.5F,58F,.861F);
        schedule.addGame(4,Florida,Tennessee, -3.5F,50F,.602F);
        schedule.addGame(4,Arkansas,TexasAM, -5.5F,53.5F,.602F);
        schedule.addGame(4,"New Mexico",LSU, -20.5F,56.5F,.986F);
        schedule.addGame(4,"Wyoming",BYU, -19.5F,54.5F,.866F);

        schedule.addGame(5,Michigan,Iowa, 3.5F,50F,.3F);
        schedule.addGame(5,Indiana,Nebraska, -14.5F,54F,.84F);
        schedule.addGame(5,Illinois,Wisconsin, -17.5F,56F,.864F);
        schedule.addGame(5,MichiganState,Maryland, -13.5F,50F,.418F);
        schedule.addGame(5,Northwestern,PennState, -24.5F,57F,.901F);
        schedule.addGame(5,Purdue,Minnesota, -2.5F,48F,.603F);
        schedule.addGame(5,Rutgers,OhioState, -27.5F,58F,.985F);
        schedule.addGame(5,OKState,Baylor, -1F,55F,.491F);
        schedule.addGame(5,IowaState,Kansas, 13.5F,55F,.143F);
        schedule.addGame(5,TexasTech,KState, -3.5F,55F,.636F);
        schedule.addGame(5,Oklahoma,TCU, 3.5F,55F,.32F);
        schedule.addGame(5,WestVirginia,Texas, -9.5F,56.5F,.885F);
        schedule.addGame(5,Tulane,Houston, -11.5F,55.5F,.733F);
        schedule.addGame(5,Washington,UCLA, -8.5F,50F,.665F);
        schedule.addGame(5,Temple,Memphis, -9.5F,50F,.925F);
        schedule.addGame(5,ArizonaState,USC, -8.5F,50F,.696F);
        schedule.addGame(5,Colorado,Arizona, -1.5F,40F,.536F);
        schedule.addGame(5,SMU,UCF, -8F,52F,.733F);
        schedule.addGame(5,Stanford,Oregon, 11.5F,52.5F,.82F);
        schedule.addGame(5,Cal,WashingtonState, -3.5F,50F,.555F);
        schedule.addGame(5,"Wagner",Syracuse, -19.5F,54F,.994F);
        schedule.addGame(5,GeorgiaTech,Pitt, -11.5F,50F,.855F);
        schedule.addGame(5,Louisville,BostonCollege, -7.5F,50F,.425F);
        schedule.addGame(5,NCState,Clemson, -7.5F,53.5F,.874F);
        schedule.addGame(5,Virginia,Duke, 7.5F,53.5F,.288F);
        schedule.addGame(5,Cincinnati,Tulsa, 7F,55F,.193F);
        schedule.addGame(5,OregonState,Utah, -14.5F,50F,.849F);
        schedule.addGame(5,EastCarolina,USF, 2F,50F,.521F);
        schedule.addGame(5,VirginiaTech,NorthCarolina, -4F,50F,.86F);
        schedule.addGame(5,WakeForest,FloridaState, -5.5F,50F,.571F);
        schedule.addGame(5,"Eastern Wash",Florida, -21.5F,50F,.969F);
        schedule.addGame(5,TexasAM,MississippiState, 4.5F,50F,.512F);
        schedule.addGame(5,LSU,Auburn, -1.5F,50F,.574F);
        schedule.addGame(5,Kentucky,OleMiss, -5.5F,50F,.599F);
        schedule.addGame(5,"SC State",SouthCarolina, -25.5F,58F,.988F);
        schedule.addGame(5,Alabama,Arkansas, 16.5F,60.5F,.12F);
        schedule.addGame(5,Georgia,Missouri, 22.5F,58.5F,.059F);
        schedule.addGame(5,Navy,"Air Force", -2.5F,50F,.795F);
        schedule.addGame(5,"Utah State",BYU, -12.5F,50F,.82F);

        schedule.addGame(6,OhioState,MichiganState, 11.5F,50F,.169F);
        schedule.addGame(6,Nebraska,Rutgers, 10.5F,50F,.276F);
        schedule.addGame(6,Iowa,Illinois, 8.5F,50F,.322F);
        schedule.addGame(6,Wisconsin,Northwestern, 16.5F,50F,.207F);
        schedule.addGame(6,Purdue,Maryland, -2.5F,46F,.611F);
        schedule.addGame(6,Michigan,Indiana, 22.5F,53F,.141F);
        schedule.addGame(6,KState,IowaState, -4.5F,55F,.664F);
        schedule.addGame(6,TCU,Kansas, 11.5F,55F,.193F);
        schedule.addGame(6,Texas,Oklahoma, -1F,61F,.446F);
        schedule.addGame(6,TexasTech,OKState, -7.5F,55F,.795F);
        schedule.addGame(6,Houston,Memphis, 4.5F,55F,.509F);
        schedule.addGame(6,Oregon,Arizona, 15.5F,55F,.182F);
        schedule.addGame(6,Washington,ArizonaState, 3.5F,55F,.578F);
        schedule.addGame(6,EastCarolina,Tulane, 3.5F,55F,.659F);
        schedule.addGame(6,USF,Cincinnati, 13.5F,55F,.89F);
        schedule.addGame(6,VirginiaTech,Pitt, -5.5F,50F,.866F);
        schedule.addGame(6,Louisville,Virginia, -6.5F,50F,.438F);
        schedule.addGame(6,Duke,GeorgiaTech, -8F,50F,.772F);
        schedule.addGame(6,Clemson,BostonCollege, 8F,50F,.1F);
        schedule.addGame(6,FloridaState,NCState, -4F,50F,.62F);
        schedule.addGame(6,WashingtonState,USC, -7.5F,50F,.832F);
        schedule.addGame(6,Utah,UCLA, 3F,53.5F,.416F);
        schedule.addGame(6,OregonState,Stanford, -3.5F,50F,.565F);
        schedule.addGame(6,"Army",WakeForest, -6.5F,50F,.787F);
        schedule.addGame(6,NorthCarolina,Miami, -4.5F,50F,.719F);
        schedule.addGame(6,Arkansas,MississippiState, -1.5F,50F,.607F);
        schedule.addGame(6,Missouri,Florida, -9.5F,50F,.783F);
        schedule.addGame(6,OleMiss,Vanderbilt, 13.5F,50F,.104F);
        schedule.addGame(6,TexasAM,Alabama, -15.5F,56.5F,.909F);
        schedule.addGame(6,Auburn,Georgia, -18F,50F,.887F);
        schedule.addGame(6,Tennessee,LSU, -2.5F,50F,.677F);
        schedule.addGame(6,SouthCarolina,Kentucky, -3.5F,50F,.765F);
        schedule.addGame(6,Tulsa,Navy, -2.5F,55F,.518F);
        schedule.addGame(6,BYU,NotreDame, -6.5F,55F,.816F);

        schedule.addGame(7,PennState,Michigan, -7F,50F,.669F);
        schedule.addGame(7,Wisconsin,MichiganState, -2F,50F,.626F);
        schedule.addGame(7,Nebraska,Purdue, 4.5F,50F,.513F);
        schedule.addGame(7,Maryland,Indiana, 3.5F,50F,.361F);
        schedule.addGame(7,Minnesota,Illinois, 5.5F,50F,.302F);
        schedule.addGame(7,Baylor,WestVirginia, 2.5F,55F,.378F);
        schedule.addGame(7,IowaState,Texas, -9F,55F,.794F);
        schedule.addGame(7,Kansas,Oklahoma, -21F,58F,.96F);
        schedule.addGame(7,OKState,TCU, 3.5F,55F,.381F);
        schedule.addGame(7,Temple,UCF, -9.5F,55F,.958F);
        schedule.addGame(7,Navy,SMU, -4.5F,55F,.881F);
        schedule.addGame(7,Cal,Colorado, -1.5F,55F,.523F);
        schedule.addGame(7,NorthCarolina,Duke, 8.5F,50F,.121F);
        schedule.addGame(7,NCState,Syracuse, 12.5F,50F,.383F);
        schedule.addGame(7,Arizona,Washington, -13F,50F,.841F);
        schedule.addGame(7,Memphis,EastCarolina, -2F,55F,.441F);
        schedule.addGame(7,Tulane,USF, -2F,55F,.459F);
        schedule.addGame(7,WashingtonState,OregonState, 1F,50F,.693F);
        schedule.addGame(7,USC,Utah, -2.5F,50F,.731F);
        schedule.addGame(7,Clemson,FloridaState, 4.5F,50F,.199F);
        schedule.addGame(7,Miami,VirginiaTech, 2.5F,50F,.176F);
        schedule.addGame(7,Arkansas,BYU, 5.5F,50F,.464F);
        schedule.addGame(7,MississippiState,Kentucky, -4.5F,50F,.63F);
        schedule.addGame(7,Auburn,OleMiss, -6.5F,50F,.546F);
        schedule.addGame(7,Vanderbilt,Georgia, -31.5F,57F,.992F);
        schedule.addGame(7,LSU,Florida, -3F,52F,.447F);
        schedule.addGame(7,Alabama,Tennessee, 13.5F,60F,.119F);
        schedule.addGame(7,Stanford,NotreDame, -15.5F,48.5F,.928F);

        schedule.addGame(8,Iowa,OhioState, -21F,50F,.95F);
        schedule.addGame(8,Indiana,Rutgers, -1.5F,50F,.571F);
        schedule.addGame(8,Purdue,Wisconsin, -8.5F,50F,.715F);
        schedule.addGame(8,Northwestern,Maryland, -7F,50F,.799F);
        schedule.addGame(8,Minnesota,PennState, -10.5F,50F,.753F);
        schedule.addGame(8,Kansas,Baylor, -19.5F,55F,.941F);
        schedule.addGame(8,KState,TCU, -5.5F,55F,.552F);
        schedule.addGame(8,Texas,OKState, -1.5F,54.5F,.469F);
        schedule.addGame(8,WestVirginia,TexasTech, -4.5F,55F,.671F);
        schedule.addGame(8,Virginia,GeorgiaTech, -4F,50F,.507F);
        schedule.addGame(8,Tulsa,Temple, -2F,55F,.321F);
        schedule.addGame(8,Cincinnati,SMU, 6.5F,55F,.377F);
        schedule.addGame(8,Washington,Cal, 6.5F,50F,.433F);
        schedule.addGame(8,ArizonaState,Stanford, -2.5F,50F,.473F);
        schedule.addGame(8,Memphis,Tulane, 3F,55F,.494F);
        schedule.addGame(8,UCLA,Oregon, -4F,53F,.699F);
        schedule.addGame(8,Syracuse,Clemson, -29.5F,58F,.952F);
        schedule.addGame(8,Houston,Navy, 6F,55F,.202F);
        schedule.addGame(8,UCF,EastCarolina, 6.5F,55F,.29F);
        schedule.addGame(8,Colorado,OregonState, -11F,50F,.742F);
        schedule.addGame(8,BostonCollege,WakeForest, -2F,50F,.789F);
        schedule.addGame(8,Pitt,Louisville, 4.5F,50F,.466F);
        schedule.addGame(8,Duke,Miami, -12.5F,50F,.956F);
        schedule.addGame(8,MississippiState,Alabama, -20.5F,56F,.928F);
        schedule.addGame(8,"TN-Martin",Tennessee, -30.5F,59.5F,.985F);
        schedule.addGame(8,TexasAM,SouthCarolina, 2.5F,51F,.366F);
        schedule.addGame(8,OleMiss,LSU, -1F,55.5F,.63F);
        schedule.addGame(8,Vanderbilt,Missouri, -6.5F,50F,.866F);
        schedule.addGame(8,BYU,"Liberty", 9.5F,50F,.419F);
        schedule.addGame(8,"UNLV",NotreDame, -21.5F,56F,.983F);

        schedule.addGame(9,OhioState,PennState, 12F,50F,.171F);
        schedule.addGame(9,MichiganState,Michigan, -8.5F,50F,.695F);
        schedule.addGame(9,Illinois,Nebraska, -15.5F,50F,.835F);
        schedule.addGame(9,Rutgers,Minnesota, -8.5F,50F,.832F);
        schedule.addGame(9,Northwestern,Iowa, -18.5F,50F,.816F);
        schedule.addGame(9,Oklahoma,IowaState, 4F,51.5F,.408F);
        schedule.addGame(9,Baylor,TexasTech, 5F,55F,.389F);
        schedule.addGame(9,OKState,KState, 6.5F,55F,.379F);
        schedule.addGame(9,TCU,WestVirginia, -2.5F,55F,.52F);
        schedule.addGame(9,VirginiaTech,NCState, -7.5F,50F,.841F);
        schedule.addGame(9,Utah,WashingtonState, 6.5F,50F,.189F);
        schedule.addGame(9,EastCarolina,BYU, -9.5F,50F,.8F);
        schedule.addGame(9,Oregon,Cal, 14.5F,50F,.265F);
        schedule.addGame(9,USF,Houston, -12.5F,55F,.809F);
        schedule.addGame(9,USC,Arizona, 18.5F,52F,.226F);
        schedule.addGame(9,ArizonaState,Colorado, 12.5F,51F,.378F);
        schedule.addGame(9,Cincinnati,UCF, -2.5F,57F,.552F);
        schedule.addGame(9,NotreDame,Syracuse, 20.5F,53F,.166F);
        schedule.addGame(9,Miami,Virginia, 9.5F,50F,.261F);
        schedule.addGame(9,Stanford,UCLA, -10.5F,50F,.741F);
        schedule.addGame(9,SMU,Tulsa, -1.5F,55F,.335F);
        schedule.addGame(9,WakeForest,Louisville, -5.5F,50F,.527F);
        schedule.addGame(9,Pitt,NorthCarolina, -1F,56.5F,.621F);
        schedule.addGame(9,GeorgiaTech,FloridaState, -8F,50F,.821F);
        schedule.addGame(9,Arkansas,Auburn, 2F,50F,.699F);
        schedule.addGame(9,Kentucky,Tennessee, -3.5F,57F,.474F);
        schedule.addGame(9,Missouri,SouthCarolina, -10F,52F,.681F);
        schedule.addGame(9,OleMiss,TexasAM, -7F,52F,.608F);
        schedule.addGame(9,BostonCollege,"UConn", 22.5F,55F,.117F);
        schedule.addGame(9,Temple,Navy, -4.5F,55F,.734F);
        schedule.addGame(9,Florida,Georgia, -14.5F,50.5F,.904F);


        schedule.addGame(10,Minnesota,Nebraska, -6.5F,50F,.639F);
        schedule.addGame(10,MichiganState,Illinois, 16.5F,50F,.195F);
        schedule.addGame(10,OhioState,Northwestern, 31.5F,50F,.032F);
        schedule.addGame(10,Iowa,Purdue, 4.5F,50F,.596F);
        schedule.addGame(10,Maryland,Wisconsin, -14.5F,50F,.71F);
        schedule.addGame(10,PennState,Indiana, 21.5F,50F,.247F);
        schedule.addGame(10,Michigan,Rutgers, 24.5F,50F,.114F);
        schedule.addGame(10,Baylor,Oklahoma, -9F,55F,.695F);
        schedule.addGame(10,WestVirginia,IowaState, -5.5F,55F,.747F);
        schedule.addGame(10,OKState,Kansas, -14.5F,55F,.108F);
        schedule.addGame(10,Texas,KState, 9.5F,55F,.256F);
        schedule.addGame(10,TexasTech,TCU, -3.5F,55F,.631F);
        schedule.addGame(10,Duke,BostonCollege, -11.5F,50F,.79F);
        schedule.addGame(10,OregonState,Washington, -9.5F,50F,.662F);
        schedule.addGame(10,USF,Temple, -8.5F,55F,.312F);
        schedule.addGame(10,Houston,SMU, 6.5F,55F,.513F);
        schedule.addGame(10,Oregon,Colorado, 16.5F,55F,.218F);
        schedule.addGame(10,UCF,Memphis, 9.5F,55F,.48F);
        schedule.addGame(10,UCLA,ArizonaState, 7.5F,50F,.494F);
        schedule.addGame(10,Navy,Cincinnati, -12.5F,55F,.926F);
        schedule.addGame(10,Syracuse,Pitt, -16.5F,53F,.82F);
        schedule.addGame(10,NorthCarolina,Virginia, 4.5F,50F,.318F);
        schedule.addGame(10,WashingtonState,Stanford, 5.5F,50F,.672F);
        schedule.addGame(10,Tulane,Tulsa, -5F,55F,.395F);
        schedule.addGame(10,Cal,USC, -13F,51F,.798F);
        schedule.addGame(10,WakeForest,NCState, -14F,52F,.601F);
        schedule.addGame(10,Arizona,Utah, -16.5F,53F,.933F);
        schedule.addGame(10,"JMU",Louisville, -8.5F,50F,.938F);
        schedule.addGame(10,GeorgiaTech,VirginiaTech, -9F,50F,.563F);
        schedule.addGame(10,FloridaState,Miami, -9.5F,50F,.745F);
        schedule.addGame(10,"Liberty",Arkansas, -12.5F,50F,.841F);
        schedule.addGame(10,Auburn,MississippiState, -1.5F,50F,.523F);
        schedule.addGame(10,Alabama,LSU, 15.5F,56.5F,.185F);
        schedule.addGame(10,Tennessee,Georgia, -15.5F,52F,.926F);
        schedule.addGame(10,SouthCarolina,Vanderbilt, 14.5F,56F,.224F);
        schedule.addGame(10,Florida,TexasAM, -7F,49F,.703F);
        schedule.addGame(10,Kentucky,Missouri, 8.5F,51F,.299F);
        schedule.addGame(10,Clemson,NotreDame, 2.5F,53F,.4F);
        schedule.addGame(10,BYU,"Boise State", 4.5F,50F,.57F);


        schedule.addGame(11,Nebraska,Michigan, -11.5F,48.5F,.8F);
        schedule.addGame(11,Purdue,Illinois, 2.5F,50F,.339F);
        schedule.addGame(11,Wisconsin,Iowa, 2F,44.5F,.456F);
        schedule.addGame(11,Northwestern,Minnesota, -17.5F,50F,.813F);
        schedule.addGame(11,Rutgers,MichiganState, -22.5F,50F,.905F);
        schedule.addGame(11,Indiana,OhioState, -29.5F,50F,.98F);
        schedule.addGame(11,Maryland,PennState, -16.5F,50F,.732F);
        schedule.addGame(11,KState,Baylor, -9.5F,55F,.723F);
        schedule.addGame(11,IowaState,OKState, -7.5F,55F,.696F);
        schedule.addGame(11,Kansas,TexasTech, -13.5F,55F,.874F);
        schedule.addGame(11,Oklahoma,WestVirginia, 7.5F,55F,.27F);
        schedule.addGame(11,TCU,Texas, -13.5F,55F,.834F);
        schedule.addGame(11,Tulsa,Memphis, -8.5F,55F,.795F);
        schedule.addGame(11,EastCarolina,Cincinnati, -13.5F,55F,.83F);
        schedule.addGame(11,Colorado,USC, -20.5F,60F,.853F);
        schedule.addGame(11,ArizonaState,WashingtonState, -2.5F,50F,.427F);
        schedule.addGame(11,Temple,Houston, -9.5F,55F,.946F);
        schedule.addGame(11,UCF,Tulane, 9.5F,55F,.35F);
        schedule.addGame(11,Washington,Oregon, -9.5F,47.5F,.737F);
        schedule.addGame(11,Pitt,Virginia, 4.5F,50F,.319F);
        schedule.addGame(11,FloridaState,Syracuse, 14.5F,50F,.39F);
        schedule.addGame(11,Louisville,Clemson, 14.5F,50F,.903F);
        schedule.addGame(11,VirginiaTech,Duke, 9.5F,50F,.399F);
        schedule.addGame(11,Miami,GeorgiaTech, 7.5F,50F,.192F);
        schedule.addGame(11,BostonCollege,NCState, -8.5F,50F,.794F);
        schedule.addGame(11,Arizona,UCLA, -15.5F,54F,.862F);
        schedule.addGame(11,Cal,OregonState, -6.5F,50F,.666F);
        schedule.addGame(11,Stanford,Utah, -14F,48F,.86F);
        schedule.addGame(11,SMU,USF, 2F,55F,.377F);
        schedule.addGame(11,NorthCarolina,WakeForest, 5.5F,50F,.515F);
        schedule.addGame(11,LSU,Arkansas, -2.5F,53.5F,.458F);
        schedule.addGame(11,Vanderbilt,Kentucky, -13.5F,50F,.948F);
        schedule.addGame(11,Alabama,OleMiss, 13.5F,56F,.175F);
        schedule.addGame(11,SouthCarolina,Florida, -6.5F,56F,.699F);
        schedule.addGame(11,TexasAM,Auburn, 7.5F,50F,.612F);
        schedule.addGame(11,Georgia,MississippiState, 15.5F,53F,.144F);
        schedule.addGame(11,Missouri,Tennessee, -12.5F,52F,.785F);
        schedule.addGame(11,NotreDame,Navy, 13F,50F,.043F);

        schedule.addGame(12,Wisconsin,Nebraska, 3F,47.5F,.512F);
        schedule.addGame(12,Iowa,Minnesota, 5.5F,50F,.574F);
        schedule.addGame(12,Northwestern,Purdue, -11F,50F,.8F);
        schedule.addGame(12,OhioState,Maryland, 24.5F,50F,.094F);
        schedule.addGame(12,Illinois,Michigan, -27.5F,50F,.931F);
        schedule.addGame(12,Indiana,MichiganState, -25.5F,50F,.877F);
        schedule.addGame(12,PennState,Rutgers, 18.5F,50F,.172F);
        schedule.addGame(12,OKState,Oklahoma, 6F,55.5F,.639F);
        schedule.addGame(12,TCU,Baylor, -7.5F,55F,.711F);
        schedule.addGame(12,TexasTech,IowaState, -6.5F,55F,.718F);
        schedule.addGame(12,Texas,Kansas, -26.5F,58F,.064F);
        schedule.addGame(12,KState,WestVirginia, -7.5F,55F,.517F);
        schedule.addGame(12,SMU,Tulane, 2.5F,55F,.49F);
        schedule.addGame(12,USF,Tulsa, -4.5F,55F,.585F);
        schedule.addGame(12,Cincinnati,Temple, 8F,55F,.072F);
        schedule.addGame(12,Stanford,Cal, -2F,50F,.523F);
        schedule.addGame(12,"N Alabama",Memphis, -21.5F,55F,.995F);
        schedule.addGame(12,WashingtonState,Arizona, 10.5F,50F,.509F);
        schedule.addGame(12,OregonState,ArizonaState, -6.5F,50F,.659F);
        schedule.addGame(12,Utah,Oregon, -2F,49.5F,.524F);
        schedule.addGame(12,Navy,UCF, -9F,55F,.916F);
        schedule.addGame(12,"Coastal Carolina",Virginia, -8.5F,50F,.735F);
        schedule.addGame(12,Duke,Pitt, -13F,50F,.932F);
        schedule.addGame(12,Miami,Clemson, -8.5F,52.5F,.8F);
        schedule.addGame(12,Colorado,Washington, -14F,50F,.799F);
        schedule.addGame(12,Houston,EastCarolina, 4.5F,55F,.391F);
        schedule.addGame(12,USC,UCLA, 5F,60F,.543F);
        schedule.addGame(12,NCState,Louisville, 9F,50F,.516F);
        schedule.addGame(12,"LA-Lafayette",FloridaState, -12.5F,54F,.824F);
        schedule.addGame(12,GeorgiaTech,NorthCarolina, -11.5F,50F,.852F);
        schedule.addGame(12,Syracuse,WakeForest, -12F,50F,.786F);
        schedule.addGame(12,VirginiaTech,"Liberty", 7F,50F,.566F);
        schedule.addGame(12,OleMiss,Arkansas, 4.5F,57F,.503F);
        schedule.addGame(12,"UAB",LSU, -19.5F,55F,.884F);
        schedule.addGame(12,Georgia,Kentucky, 16F,46.5F,.167F);
        schedule.addGame(12,Tennessee,SouthCarolina, 4.5F,50F,.441F);
        schedule.addGame(12,"New Mexico State",Missouri, -20.5F,56.5F,.963F);
        schedule.addGame(12,"East Tenn",MississippiState, -27.5F,56.5F,.995F);
        schedule.addGame(12,"UMASS",TexasAM, -36.5F,61.5F,.987F);
        schedule.addGame(12,Florida,Vanderbilt, 15.5F,50F,.132F);
        schedule.addGame(12,"W Kentucky",Auburn, -25.5F,56F,.885F);
        schedule.addGame(12,"Austin Peay",Alabama, -40.5F,69F,.998F);
        schedule.addGame(12,BostonCollege,NotreDame, -14.5F,52F,.915F);
        schedule.addGame(12,"Utah Tech",BYU, -34.5F,63.5F,.997F);

        schedule.addGame(13,MichiganState,PennState, -6F,50F,.586F);
        schedule.addGame(13,Michigan,OhioState, -13.5F,50F,.848F);
        schedule.addGame(13,Nebraska,Iowa, -3.5F,46.5F,.535F);
        schedule.addGame(13,Illinois,Northwestern, 7F,50F,.556F);
        schedule.addGame(13,Minnesota,Wisconsin, -7.5F,50F,.702F);
        schedule.addGame(13,Purdue,Indiana, 7.5F,50F,.368F);
        schedule.addGame(13,Rutgers,Maryland, -8.5F,50F,.821F);
        schedule.addGame(13,Baylor,Texas, -6F,53.5F,.734F);
        schedule.addGame(13,IowaState,TCU, -4.5F,55F,.51F);
        schedule.addGame(13,Kansas,KState, -18.5F,55F,.889F);
        schedule.addGame(13,Oklahoma,TexasTech, 9.5F,55F,.28F);
        schedule.addGame(13,WestVirginia,OKState, -8.5F,55F,.829F);
        schedule.addGame(13,MississippiState,OleMiss, -5.5F,62F,.633F);
        schedule.addGame(13,Tulsa,Houston, -8.5F,55F,.839F);
        schedule.addGame(13,Tulane,Cincinnati, -18.5F,55F,.82F);
        schedule.addGame(13,UCF,USF, 13.5F,55F,.236F);
        schedule.addGame(13,NCState,NorthCarolina, 4F,50.5F,.622F);
        schedule.addGame(13,Arkansas,Missouri, 9F,50F,.354F);
        schedule.addGame(13,ArizonaState,Arizona, 8.5F,50F,.311F);
        schedule.addGame(13,UCLA,Cal, 15F,50F,.359F);
        schedule.addGame(13,Florida,FloridaState, 2F,50F,.557F);
        schedule.addGame(13,Utah,Colorado, 20F,50F,.163F);
        schedule.addGame(13,Memphis,SMU, 6.5F,55F,.604F);
        schedule.addGame(13,EastCarolina,Temple, -1.5F,55F,.24F);
        schedule.addGame(13,Washington,WashingtonState, -1F,53.5F,.381F);
        schedule.addGame(13,SouthCarolina,Clemson, -14F,55.5F,.922F);
        schedule.addGame(13,Syracuse,BostonCollege, -9,50F,.583F);
        schedule.addGame(13,WakeForest,Duke, 3.5F,50F,.151F);
        schedule.addGame(13,BYU,Stanford, 11.5F,50F,.471F);
        schedule.addGame(13,NotreDame,USC, -2.5F,56.5F,.336F);
        schedule.addGame(13,Oregon,OregonState, 7F,49.5F,.319F);
        schedule.addGame(13,Virginia,VirginiaTech, -7F,50F,.465F);
        schedule.addGame(13,Pitt,Miami, -6.5F,50F,.696F);
        schedule.addGame(13,GeorgiaTech,Georgia, -28F,52.5F,.977F);
        schedule.addGame(13,Auburn,Alabama, -24F,51F,.899F);
        schedule.addGame(13,LSU,TexasAM, -7.5F,50F,.555F);
        schedule.addGame(13,Louisville,Kentucky, -9F,50F,.709F);
        schedule.addGame(13,Tennessee,Vanderbilt, 10F,50F,.121F);

        if(!singleSeason) {

            //Season season = new Season(schedule, 1);
            for(int p = 0; p < 100000; p++) {
                for (int i = 0; i < 14; i++)
                    schedule.playWeek(i);

                for (int i = 0; i < League.conferences.size(); i++) {
                    League.conferences.get(i).setChampionship();
                }

                for (int i = 0; i < League.conferences.size(); i++) {
                    League.conferences.get(i).playChampionship();
                }
                League.getPoll();
                schedule.recordResults();
                checkWins();
            }

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

            League.printAllResults();
        }
        if(singleSeason){
            gui = new GUI(BigTen,schedule);
        }

    }

    public static void checkWins() {
        for(int i = 0; i < League.conferences.size(); i++)
            for(int j = 0; j < League.conferences.get(i).getTeams().size(); j++) {
                League.conferences.get(i).getTeams().get(j).clearStats();
                League.conferences.get(i).getTeams().get(j).clearStats();
            }
        League.independents.get(0).clearStats();
        League.independents.get(1).clearStats();
    }

    private static void setSchedule(League league) {

    }

    public static ArrayList<Team> getTeams(){
        ArrayList<Team> teams = new ArrayList<>();
        for(int i = 0; i < League.conferences.size(); i++){
            teams.addAll(League.conferences.get(i).getTeams());
        }
        return teams;
    }

    public static void advanceWeek(Schedule schedule) throws IOException {
        ChampionshipGUI championshipGUI;
        if (week < 14) {
            schedule.playWeek(week);
            GUI.placeTeams();
        }
        else if (week == 14) {
            for(int i = 0; i < League.conferences.size(); i++) {
                League.conferences.get(i).setChampionship();
            }
            System.out.println(League.conferences.get(0).championship.away.name);
            championshipGUI = new ChampionshipGUI(League.conferences.get(0).championship, League.conferences.get(0), schedule);
            ChampionshipGUI.placeTeams();
        }
        else if (week == 15){
            for(int i = 0; i < League.conferences.size(); i++) {
                League.conferences.get(i).playChampionship();
            }
            ChampionshipGUI.placeTeams();
            League.printPoll();
        }
        else{
            PlayoffGUI playoffGUI = new PlayoffGUI(schedule);
        }
        week++;
    }

}
