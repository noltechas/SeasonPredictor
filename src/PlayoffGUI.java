import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import static java.lang.Math.abs;

public class PlayoffGUI {
    Schedule schedule;
    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel label;

    Team oneSeed,twoSeed,threeSeed,fourSeed;
    Game oneFour,twoThree,championship;
    float oneFourLine,twoThreeLine,championshipLine;

    public int step = 0;

    static JLabel r00 = new JLabel();static JLabel r01 = new JLabel();static JLabel r02 = new JLabel();
    static JLabel r10 = new JLabel();static JLabel r11 = new JLabel();static JLabel r12 = new JLabel();
    static JLabel r20 = new JLabel();static JLabel r21 = new JLabel();static JLabel r22 = new JLabel();
    static JLabel r30 = new JLabel();static JLabel r31 = new JLabel();static JLabel r32 = new JLabel();
    static JLabel r40 = new JLabel();static JLabel r41 = new JLabel();static JLabel r42 = new JLabel();
    static boolean placedLine = false;

    public PlayoffGUI(Schedule schedule) {
        League.getPoll();
        this.oneSeed = League.playoffRankings.get(0);
        this.twoSeed = League.playoffRankings.get(1);
        this.threeSeed = League.playoffRankings.get(2);
        this.fourSeed = League.playoffRankings.get(3);

        this.oneSeed.seed = "1";
        this.twoSeed.seed = "2";
        this.threeSeed.seed = "3";
        this.fourSeed.seed = "4";

        this.schedule = schedule;
        this.oneFourLine = (oneSeed.teamRating) - (fourSeed.teamRating);
        this.twoThreeLine = (twoSeed.teamRating) - (threeSeed.teamRating);

        drawMatchup();
    }

    public void drawMatchup() {
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("College Football Playoff");
        frame.setPreferredSize(new Dimension(800,350));

        int i = 6;
        int j = 4;
        JPanel[][] panelHolder = new JPanel[i-1][j-1];
        frame.setLayout(new GridLayout(i,j));

        for(int m = 0; m < i-1; m++) {
            for(int n = 0; n < j-1; n++) {
                panelHolder[m][n] = new JPanel();
                frame.add(panelHolder[m][n]);
            }
        }

        panelHolder[0][0].add(r00);panelHolder[0][1].add(r01);panelHolder[0][2].add(r02);
        panelHolder[1][0].add(r10);panelHolder[1][1].add(r11);panelHolder[1][2].add(r12);
        panelHolder[2][0].add(r20);panelHolder[2][1].add(r21);panelHolder[2][2].add(r22);
        panelHolder[3][0].add(r30);panelHolder[3][1].add(r31);panelHolder[3][2].add(r32);
        panelHolder[4][0].add(r40);panelHolder[4][1].add(r41);panelHolder[4][2].add(r42);

        JButton nextButton = new JButton("Play Game");
        nextButton.addActionListener(new PlayoffGUI.AdvanceWeekListener());
        panelHolder[4][1].add(nextButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("College Football Playoff");
        frame.pack();
        ImageIcon img = new ImageIcon("./Logos/CFP.png");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
        placeTeams();
    }

    public void placeTeams(){
        if(step == 0) {

            r01.setText("College Football Playoff");
            r10.setText("1. " + oneSeed.name + ": " + oneSeed.totalWins + "-" + oneSeed.totalLosses + " (" + oneSeed.conferenceWins + "-" + oneSeed.conferenceLosses + ")");
            r30.setText("4. " + fourSeed.name + ": " + fourSeed.totalWins + "-" + fourSeed.totalLosses + " (" + fourSeed.conferenceWins + "-" + fourSeed.conferenceLosses + ")");
            r12.setText("2. " + twoSeed.name + ": " + twoSeed.totalWins + "-" + twoSeed.totalLosses + " (" + twoSeed.conferenceWins + "-" + twoSeed.conferenceLosses + ")");
            r32.setText("3. " + threeSeed.name + ": " + threeSeed.totalWins + "-" + threeSeed.totalLosses + " (" + threeSeed.conferenceWins + "-" + threeSeed.conferenceLosses + ")");

            this.oneFour = new Game(fourSeed,oneSeed,-this.oneFourLine,50F,12.5F,13.5F);
            this.twoThree = new Game(threeSeed,twoSeed,-this.twoThreeLine,50F,12.5F,13.5F);
            this.oneFour.play();
            this.twoThree.play();

        }
        else if(step == 1){
            if(Objects.equals(oneFour.winner.name, oneSeed.name))
                r20.setText(oneFour.winner.name + " wins " + oneFour.homeScore + " - " + oneFour.awayScore);
            else
                r20.setText(oneFour.winner.name + " wins " + oneFour.awayScore + " - " + oneFour.homeScore);
            if(Objects.equals(twoThree.winner.name, twoSeed.name))
                r22.setText(twoThree.winner.name + " wins " + twoThree.homeScore + " - " + twoThree.awayScore);
            else
                r22.setText(twoThree.winner.name + " wins " + twoThree.awayScore + " - " + twoThree.homeScore);
            r11.setText(oneFour.winner.seed + ". " + oneFour.winner.name + ": " + oneFour.winner.totalWins + "-" + oneFour.winner.totalLosses + " (" + oneFour.winner.conferenceWins + "-" + oneFour.winner.conferenceLosses + ")");
            r31.setText(twoThree.winner.seed + ". " + twoThree.winner.name + ": " + twoThree.winner.totalWins + "-" + twoThree.winner.totalLosses + " (" + twoThree.winner.conferenceWins + "-" + twoThree.winner.conferenceLosses + ")");

            if(oneFour.winner.name == oneSeed.name) {
                championshipLine = (oneSeed.teamRating + oneSeed.momentum) - (twoThree.winner.teamRating + twoThree.winner.momentum);
                this.championship = new Game(twoThree.winner, oneFour.winner, -championshipLine, 50F, 12.5F, 13.5F);
            }
            else{
                championshipLine = (twoThree.winner.teamRating + twoThree.winner.momentum) - (fourSeed.teamRating + fourSeed.momentum);
                this.championship = new Game(oneFour.winner, twoThree.winner, -championshipLine, 50F, 12.5F, 13.5F);
            }
            this.championship.play();

        }
        else{
            r21.setText(championship.winner.seed + ". " + championship.winner.name + " wins " + championship.homeScore + " - " + championship.awayScore);
        }
        step++;
    }

    public class AdvanceWeekListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            placeTeams();
        }
    }
}
