import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.Math.abs;

public class ChampionshipGUI {
    Team div1champ;
    Team div2champ;
    static Conference conference;
    Schedule schedule;
    static Game game;
    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel label;
    static JLabel r00 = new JLabel();static JLabel r01 = new JLabel();static JLabel r02 = new JLabel();
    static JLabel r10 = new JLabel();static JLabel r11 = new JLabel();static JLabel r12 = new JLabel();
    static JLabel r20 = new JLabel();static JLabel r21 = new JLabel();static JLabel r22 = new JLabel();
    static JLabel r30 = new JLabel();static JLabel r31 = new JLabel();static JLabel r32 = new JLabel();
    static JLabel r40 = new JLabel();static JLabel r41 = new JLabel();static JLabel r42 = new JLabel();
    static boolean placedLine = false;

    public ChampionshipGUI(Game game, Conference conference, Schedule schedule) {
        this.div1champ = game.away;
        this.div2champ = game.home;
        ChampionshipGUI.game = game;
        ChampionshipGUI.conference = conference;
        this.schedule = schedule;

        drawMatchup();
    }

    public void drawMatchup() {
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("B1G Championship");

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
        nextButton.addActionListener(new ChampionshipGUI.AdvanceWeekListener());
        panelHolder[4][1].add(nextButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("B1G Championship");
        frame.pack();
        ImageIcon img = new ImageIcon("./Logos/B1G.png");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
    }

    public static void placeTeams(){
        float line = (conference.div1.getWinner().teamRating+conference.div1.getWinner().momentum) - (conference.div2.getWinner().teamRating+conference.div2.getWinner().momentum);
        String lineText;
        if(line>0){
            lineText = conference.div1.getWinner().name + " -" + abs(line);
        }
        else{
            lineText = conference.div2.getWinner().name + " -" + abs(line);
        }
        r01.setText("B1G CHAMPIONSHIP GAME");
        if(!placedLine)
            r10.setText(conference.div1.getWinner().name + ": " + conference.div1.getWinner().totalWins + "-" + conference.div1.getWinner().totalLosses + " (" + conference.div1.getWinner().conferenceWins + "-" + conference.div1.getWinner().conferenceLosses + ")");
        if(!placedLine)
            r12.setText(conference.div2.getWinner().name + ": " + conference.div2.getWinner().totalWins + "-" + conference.div2.getWinner().totalLosses + " (" + conference.div2.getWinner().conferenceWins + "-" + conference.div2.getWinner().conferenceLosses + ")");
        if(!placedLine) {
            r11.setText("Line: " + lineText);
            placedLine = true;
        }
        else
            r11.setText("");
        r22.setText(String.valueOf(game.homeScore));
        r20.setText(String.valueOf(game.awayScore));
    }

    public class AdvanceWeekListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                Main.advanceWeek(schedule);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
