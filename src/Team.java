import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Team {
    public String name;
    public String division = "";
    public Conference conference;
    public ArrayList<String> results = new ArrayList<>();
    public ArrayList<Team> teamsBeat = new ArrayList<>();
    public ArrayList<Team> teamsLost = new ArrayList<>();

    public int momentum = 0;
    public int marginOfVictory = 0;
    public int winsOfOpponents = 0;
    public int winsOfTeamsBeat = 0;
    // These need to update every week
    public boolean conferenceChamp;

    public float teamRating;

    public int championships = 0;
    public int playoffs = 0;
    public int bowling = 0;
    public int totalWins;
    public int totalLosses;
    public int conferenceWins;
    public int conferenceLosses;
    public int divisionWins;
    public int divisionLosses;

    public int zeroWinSeasons = 0;
    public int oneWinSeasons = 0;
    public int twoWinSeasons = 0;
    public int threeWinSeasons = 0;
    public int fourWinSeasons = 0;
    public int fiveWinSeasons = 0;
    public int sixWinSeasons = 0;
    public int sevenWinSeasons = 0;
    public int eightWinSeasons = 0;
    public int nineWinSeasons = 0;
    public int tenWinSeasons = 0;
    public int elevenWinSeasons = 0;
    public int twelveWinSeasons = 0;
    public int thirteenWinSeasons = 0;
    public int totalSeasons = 0;
    public int firstPlace = 0;
    public int secondPlace = 0;
    public int thirdPlace = 0;
    public int fourthPlace = 0;
    public int fifthPlace = 0;
    public int sixthPlace = 0;
    public int seventhPlace = 0;

    public Team(String name, float rating){
        this.teamRating  = rating;
        this.name = name;
        this.results.add("");
    }

    public void clearStats(){
        this.totalWins = 0;
        this.totalLosses = 0;
        this.conferenceLosses = 0;
        this.conferenceWins = 0;
        this.divisionWins = 0;
        this.divisionLosses = 0;
        this.momentum = 0;
        this.conferenceChamp = false;
        this.teamsBeat.clear();
        this.teamsLost.clear();
        this.results.clear();
        this.marginOfVictory = 0;
    }

    public void addWin(){
        this.totalWins++;
    }
    public void addLoss(){
        this.totalLosses++;
    }

    public void addConferenceWin(){
        this.conferenceWins++;
    }
    public void addConferenceLoss(){
        this.conferenceLosses++;
    }

    public void addDivisionWin(){
        this.divisionWins++;
    }
    public void addDivisionLoss(){
        this.divisionLosses++;
    }

    public String getDivision(){
        return this.division;
    }

    public void setDivision(String division){
        this.division = division;
    }

    public int getConferenceWins() {
        return this.conferenceWins;
    }

    public int getDivisionWins() {
        return this.divisionWins;
    }

    public int getLosses() {
        return -this.totalLosses;
    }

    public int getConferenceLosses() {
        return -this.conferenceLosses;
    }

    public int getDivisionLosses() {
        return -this.divisionLosses;
    }

    public int getWins() {
        return this.totalWins;
    }

    public int getTeamRating(){
        return (int) this.teamRating;
    }

    public float getRecord(){
        return (float)this.totalWins/(float)(this.totalWins+this.totalLosses);
    }

    public float getConferenceRecord(){
        return (float)this.conferenceWins/(float)(this.conferenceWins+this.conferenceLosses);
    }

    public float getDivisionRecord(){
        return (float)this.divisionWins/(float)(this.divisionWins+this.divisionLosses);
    }

    public void recordResults(ArrayList<Team> standings) {
        this.totalSeasons++;
        if(this.totalWins == 0)
            this.zeroWinSeasons++;
        if(this.totalWins == 1)
            this.oneWinSeasons++;
        if(this.totalWins == 2)
            this.twoWinSeasons++;
        if(this.totalWins == 3)
            this.threeWinSeasons++;
        if(this.totalWins == 4)
            this.fourWinSeasons++;
        if(this.totalWins == 5)
            this.fiveWinSeasons++;
        if(this.totalWins == 6)
            this.sixWinSeasons++;
        if(this.totalWins == 7)
            this.sevenWinSeasons++;
        if(this.totalWins == 8)
            this.eightWinSeasons++;
        if(this.totalWins == 9)
            this.nineWinSeasons++;
        if(this.totalWins == 10)
            this.tenWinSeasons++;
        if(this.totalWins == 11)
            this.elevenWinSeasons++;
        if(this.totalWins == 12)
            this.twelveWinSeasons++;
        if(this.totalWins == 13)
            this.thirteenWinSeasons++;
        if(this.totalWins >= 6)
            this.bowling++;

        if(standings.size() > 0) {
            if (standings.get(0).name.equals(this.name))
                this.firstPlace++;
            if (standings.get(1).name.equals(this.name))
                this.secondPlace++;
            if (standings.get(2).name.equals(this.name))
                this.thirdPlace++;
            if (standings.get(3).name.equals(this.name))
                this.fourthPlace++;
            if (standings.get(4).name.equals(this.name))
                this.fifthPlace++;
            if (standings.get(5).name.equals(this.name))
                this.sixthPlace++;
            if (standings.get(6).name.equals(this.name))
                this.seventhPlace++;
        }
        if (League.playoffRankings.get(0).name.equals(this.name) || League.playoffRankings.get(1).name.equals(this.name) || League.playoffRankings.get(2).name.equals(this.name) || League.playoffRankings.get(3).name.equals(this.name)) {
            this.playoffs++;
        }

        if(this.totalSeasons <= 0)
            System.out.println("ERROR WITH " + name);
        clearStats();
    }

    public void printResults() {
        System.out.println(name + " Results:");
        System.out.println("Winless Seasons: " + this.zeroWinSeasons + " (" + ((float)this.zeroWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("One Win Seasons: " + this.oneWinSeasons + " (" + ((float)this.oneWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Two Win Seasons: " + this.twoWinSeasons + " (" + ((float)this.twoWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Three Win Seasons: " + this.threeWinSeasons + " (" + ((float)this.threeWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Four Win Seasons: " + this.fourWinSeasons + " (" + ((float)this.fourWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Five Win Seasons: " + this.fiveWinSeasons + " (" + ((float)this.fiveWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Six Win Seasons: " + this.sixWinSeasons + " (" + ((float)this.sixWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Seven Win Seasons: " + this.sevenWinSeasons + " (" + ((float)this.sevenWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Eight Win Seasons: " + this.eightWinSeasons + " (" + ((float)this.eightWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Nine Win Seasons: " + this.nineWinSeasons + " (" + ((float)this.nineWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Ten Win Seasons: " + this.tenWinSeasons + " (" + ((float)this.tenWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Eleven Win Seasons: " + this.elevenWinSeasons + " (" + ((float)this.elevenWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Twelve Win Seasons: " + this.twelveWinSeasons + " (" + ((float)this.twelveWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Undefeated Seasons: " + this.thirteenWinSeasons + " (" + ((float)this.thirteenWinSeasons/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division Championships: " + this.firstPlace + " (" + ((float)this.firstPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division Runner-Ups: " + this.secondPlace + " (" + ((float)this.secondPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division 3rd Places: " + this.thirdPlace + " (" + ((float)this.thirdPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division 4rd Places: " + this.fourthPlace + " (" + ((float)this.fourthPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division 5rd Places: " + this.fifthPlace + " (" + ((float)this.fifthPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division 6rd Places: " + this.sixthPlace + " (" + ((float)this.sixthPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Division Last Places: " + this.seventhPlace + " (" + ((float)this.seventhPlace/(float)this.totalSeasons)*100 + "%)");
        System.out.println("B1G Championships: " + this.championships + " (" + ((float)this.championships/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Bowl Game Berths: " + this.bowling + " (" + ((float)this.bowling/(float)this.totalSeasons)*100 + "%)");
        System.out.println("Playoff Appearences: " + this.playoffs + " (" + ((float)this.playoffs/(float)this.totalSeasons)*100 + "%)");
        if(this.name == "Nebraska")
            System.out.println("Frost Stays: " + (this.eightWinSeasons+this.nineWinSeasons+this.tenWinSeasons+this.elevenWinSeasons+this.twelveWinSeasons+this.thirteenWinSeasons) + " (" + ((float)(this.eightWinSeasons+this.nineWinSeasons+this.tenWinSeasons+this.elevenWinSeasons+this.twelveWinSeasons+this.thirteenWinSeasons)/(float)this.totalSeasons)*100 + "%)");
        System.out.println();

    }

    public void addChampionship() {
        this.championships++;
        this.conferenceChamp = true;
    }

    public void addPlayoff() {
        this.playoffs++;
    }

    public int getResult(Team opponent){
        if(teamsBeat.contains(opponent)){
            return 1;
        }
        if(teamsLost.contains(opponent)){
            return -1;
        }
        return 0;
    }

    public boolean sameConference(Team opponent){
        if(conference == null || opponent.conference == null)
            return false;
        return Objects.equals(opponent.conference.name, this.conference.name);
    }

    public float getR(){
        float totalTeams = teamsBeat.size()+totalLosses;
        return((float)(1+teamsBeat.size())/(2F+totalTeams));
    }

    public float getFirstCorrection(){
        float wins = (float) teamsBeat.size();
        float losses = (float) totalLosses;
        return ((wins-losses)/2F) + (1F-getR());
    }

    public float getSecondR(){
        float totalTeams = teamsBeat.size()+totalLosses;
        return((1F + getFirstCorrection()) / (2F + totalTeams));
    }

    public float getSecondCorrection(){
        float wins = (float) teamsBeat.size();
        float losses = (float) totalLosses;
        return ((wins-losses)/2F) + (1F-getSecondR());
    }

    public float getFinalRatings(){
        float totalTeams = teamsBeat.size()+totalLosses;
        return (1F + getSecondCorrection()) / (2 + totalTeams);
    }

    public float getTeamsBeatRankings(){
        float score = 0;
        for(int i = 0; i < this.teamsBeat.size(); i++){
            if(this.teamsBeat.get(i).getFinalRatings() > 0)
                score += this.teamsBeat.get(i).getFinalRatings();
        }
        return score;
    }

    public float getSOR(){
        float score = 0;
        for(int i = 0; i < teamsBeat.size(); i++){
            score += teamsBeat.get(i).totalWins;
        }
        return score/(totalWins + totalLosses);
    }

    public float getSOS(){
        float score = 0;
        ArrayList<Team> opponents = new ArrayList<>(teamsBeat);
        opponents.addAll(teamsLost);
        for(int i = 0; i < opponents.size(); i++){
            score += opponents.get(i).totalWins;
        }
        return score/(totalWins + totalLosses);
    }

    public float getAdjustedScore(){
        String conferenceName;
        if(conference != null)
            conferenceName = conference.name;
        else
            conferenceName = "Independent";

        float score = 1.2F*getTeamsBeatRankings() + 1.5F*getFinalRatings() + getTeamRating()*0.01F + getMOV()*0.075F;
        if(conferenceChamp)
            score += 0.55F;

        if(totalLosses > 1)
            score -= 0.53F*totalLosses;
        else
            score -= 0.15F*totalLosses;
        if(totalLosses < 2)
            if(!Objects.equals(conferenceName, "American"))
                score += 0.85;
        else
            score -= 0.45;

        if(totalWins > 11)
            score += 0.411F;
        if(conferenceName == "American")
            score -= 0.22F;

        if(conferenceChamp && totalLosses <= 1 && !conferenceName.equals("American"))
            score += 0.33F;

        if(totalLosses+totalWins == 13)
            score += 0.21F;

        if(totalWins == 13 && !conferenceName.equals("American"))
            score += 0.45;

        score += (getSOR()/2);
        score += (getSOS()/11);

        return score;

    }

    public float getMOV(){
        return (float)marginOfVictory/((float)totalWins+(float)totalLosses);
    }

    public int getPlayoffs() {
        return this.playoffs;
    }

    public float getPlayoffRate(){
        return (float)getPlayoffs()/totalSeasons;
    }

    public float getAverageWins(){
        int totalWins = oneWinSeasons+twoWinSeasons*2+threeWinSeasons*3+fourWinSeasons*4+fiveWinSeasons*5+sixWinSeasons*6+sevenWinSeasons*7+eightWinSeasons*8+nineWinSeasons*9+tenWinSeasons*10+elevenWinSeasons*11+twelveWinSeasons*12+thirteenWinSeasons*13-championships;
        if((float)totalWins / (float)totalSeasons < 2)
            System.out.println(name + " " + totalWins + " " + totalSeasons);
        return (float)totalWins / (float)totalSeasons;
    }
}
