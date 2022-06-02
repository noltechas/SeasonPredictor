import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {

    static Conference conference;
    static Schedule schedule;
    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel label;
    static JLabel e1= new JLabel();
    static JLabel e2= new JLabel();
    static JLabel e3= new JLabel();
    static JLabel e4= new JLabel();
    static JLabel e5= new JLabel();
    static JLabel e6= new JLabel();
    static JLabel e7= new JLabel();
    static JLabel w1= new JLabel();
    static JLabel w2= new JLabel();
    static JLabel w3= new JLabel();
    static JLabel w4= new JLabel();
    static JLabel w5= new JLabel();
    static JLabel w6= new JLabel();
    static JLabel w7= new JLabel();
    static JLabel e1result= new JLabel();
    static JLabel e2result= new JLabel();
    static JLabel e3result= new JLabel();
    static JLabel e4result= new JLabel();
    static JLabel e5result= new JLabel();
    static JLabel e6result= new JLabel();
    static JLabel e7result= new JLabel();
    static JLabel w1result= new JLabel();
    static JLabel w2result= new JLabel();
    static JLabel w3result= new JLabel();
    static JLabel w4result= new JLabel();
    static JLabel w5result= new JLabel();
    static JLabel w6result= new JLabel();
    static JLabel w7result= new JLabel();

    public GUI(Conference conference, Schedule schedule){
        GUI.conference = conference;
        GUI.schedule = schedule;

        try {
            drawStandings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawStandings() throws IOException {
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("B1G Conference Standings");

        int i = 10;
        int j = 7;
        JPanel[][] panelHolder = new JPanel[i-1][j-1];
        frame.setLayout(new GridLayout(i,j));

        for(int m = 0; m < i-1; m++) {
            for(int n = 0; n < j-1; n++) {
                panelHolder[m][n] = new JPanel();
                //panelHolder[m][n].add(new JLabel(m + "," + n));
                frame.add(panelHolder[m][n]);
            }
        }

        panelHolder[0][0].add(new JLabel("East"));
        panelHolder[0][3].add(new JLabel("West"));

        panelHolder[1][0].add(e1);panelHolder[2][0].add(e2);panelHolder[3][0].add(e3);panelHolder[4][0].add(e4);panelHolder[5][0].add(e5);panelHolder[6][0].add(e6);panelHolder[7][0].add(e7);
        panelHolder[1][1].add(e1result);panelHolder[2][1].add(e2result);panelHolder[3][1].add(e3result);panelHolder[4][1].add(e4result);panelHolder[5][1].add(e5result);panelHolder[6][1].add(e6result);panelHolder[7][1].add(e7result);
        panelHolder[1][3].add(w1);panelHolder[2][3].add(w2);panelHolder[3][3].add(w3);panelHolder[4][3].add(w4);panelHolder[5][3].add(w5);panelHolder[6][3].add(w6);panelHolder[7][3].add(w7);
        panelHolder[1][4].add(w1result);panelHolder[2][4].add(w2result);panelHolder[3][4].add(w3result);panelHolder[4][4].add(w4result);panelHolder[5][4].add(w5result);panelHolder[6][4].add(w6result);panelHolder[7][4].add(w7result);

        placeTeams();

        JButton nextButton = new JButton("Advance Week");
        nextButton.addActionListener(new GUI.AdvanceWeekListener());
        panelHolder[8][0].add(nextButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("B1G Conference Standings");
        frame.pack();
        ImageIcon img = new ImageIcon("./Logos/B1G.png");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
    }
    
    public static void placeTeams() throws IOException {

        e1.setText(conference.div1.getStandings().get(0).name + ": " + conference.div1.getStandings().get(0).totalWins + "-" + conference.div1.getStandings().get(0).totalLosses + " (" + conference.div1.getStandings().get(0).conferenceWins + "-" + conference.div1.getStandings().get(0).conferenceLosses + ")");
        e2.setText(conference.div1.getStandings().get(1).name + ": " + conference.div1.getStandings().get(1).totalWins + "-" + conference.div1.getStandings().get(1).totalLosses + " (" + conference.div1.getStandings().get(1).conferenceWins + "-" + conference.div1.getStandings().get(1).conferenceLosses + ")");
        e3.setText(conference.div1.getStandings().get(2).name + ": " + conference.div1.getStandings().get(2).totalWins + "-" + conference.div1.getStandings().get(2).totalLosses + " (" + conference.div1.getStandings().get(2).conferenceWins + "-" + conference.div1.getStandings().get(2).conferenceLosses + ")");
        e4.setText(conference.div1.getStandings().get(3).name + ": " + conference.div1.getStandings().get(3).totalWins + "-" + conference.div1.getStandings().get(3).totalLosses + " (" + conference.div1.getStandings().get(3).conferenceWins + "-" + conference.div1.getStandings().get(3).conferenceLosses + ")");
        e5.setText(conference.div1.getStandings().get(4).name + ": " + conference.div1.getStandings().get(4).totalWins + "-" + conference.div1.getStandings().get(4).totalLosses + " (" + conference.div1.getStandings().get(4).conferenceWins + "-" + conference.div1.getStandings().get(4).conferenceLosses + ")");
        e6.setText(conference.div1.getStandings().get(5).name + ": " + conference.div1.getStandings().get(5).totalWins + "-" + conference.div1.getStandings().get(5).totalLosses + " (" + conference.div1.getStandings().get(5).conferenceWins + "-" + conference.div1.getStandings().get(5).conferenceLosses + ")");
        e7.setText(conference.div1.getStandings().get(6).name + ": " + conference.div1.getStandings().get(6).totalWins + "-" + conference.div1.getStandings().get(6).totalLosses + " (" + conference.div1.getStandings().get(6).conferenceWins + "-" + conference.div1.getStandings().get(6).conferenceLosses + ")");
        e1result.setText(conference.div1.getStandings().get(0).results.get(0));
        e2result.setText(conference.div1.getStandings().get(1).results.get(0));
        e3result.setText(conference.div1.getStandings().get(2).results.get(0));
        e4result.setText(conference.div1.getStandings().get(3).results.get(0));
        e5result.setText(conference.div1.getStandings().get(4).results.get(0));
        e6result.setText(conference.div1.getStandings().get(5).results.get(0));
        e7result.setText(conference.div1.getStandings().get(6).results.get(0));
        w1.setText(conference.div2.getStandings().get(0).name + ": " + conference.div2.getStandings().get(0).totalWins + "-" + conference.div2.getStandings().get(0).totalLosses + " (" + conference.div2.getStandings().get(0).conferenceWins + "-" + conference.div2.getStandings().get(0).conferenceLosses + ")");
        w2.setText(conference.div2.getStandings().get(1).name + ": " + conference.div2.getStandings().get(1).totalWins + "-" + conference.div2.getStandings().get(1).totalLosses + " (" + conference.div2.getStandings().get(1).conferenceWins + "-" + conference.div2.getStandings().get(1).conferenceLosses + ")");
        w3.setText(conference.div2.getStandings().get(2).name + ": " + conference.div2.getStandings().get(2).totalWins + "-" + conference.div2.getStandings().get(2).totalLosses + " (" + conference.div2.getStandings().get(2).conferenceWins + "-" + conference.div2.getStandings().get(2).conferenceLosses + ")");
        w4.setText(conference.div2.getStandings().get(3).name + ": " + conference.div2.getStandings().get(3).totalWins + "-" + conference.div2.getStandings().get(3).totalLosses + " (" + conference.div2.getStandings().get(3).conferenceWins + "-" + conference.div2.getStandings().get(3).conferenceLosses + ")");
        w5.setText(conference.div2.getStandings().get(4).name + ": " + conference.div2.getStandings().get(4).totalWins + "-" + conference.div2.getStandings().get(4).totalLosses + " (" + conference.div2.getStandings().get(4).conferenceWins + "-" + conference.div2.getStandings().get(4).conferenceLosses + ")");
        w6.setText(conference.div2.getStandings().get(5).name + ": " + conference.div2.getStandings().get(5).totalWins + "-" + conference.div2.getStandings().get(5).totalLosses + " (" + conference.div2.getStandings().get(5).conferenceWins + "-" + conference.div2.getStandings().get(5).conferenceLosses + ")");
        w7.setText(conference.div2.getStandings().get(6).name + ": " + conference.div2.getStandings().get(6).totalWins + "-" + conference.div2.getStandings().get(6).totalLosses + " (" + conference.div2.getStandings().get(6).conferenceWins + "-" + conference.div2.getStandings().get(6).conferenceLosses + ")");
        w1result.setText(conference.div2.getStandings().get(0).results.get(0));
        w2result.setText(conference.div2.getStandings().get(1).results.get(0));
        w3result.setText(conference.div2.getStandings().get(2).results.get(0));
        w4result.setText(conference.div2.getStandings().get(3).results.get(0));
        w5result.setText(conference.div2.getStandings().get(4).results.get(0));
        w6result.setText(conference.div2.getStandings().get(5).results.get(0));
        w7result.setText(conference.div2.getStandings().get(6).results.get(0));

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
