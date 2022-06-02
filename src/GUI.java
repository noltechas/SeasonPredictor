import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        int i = 9;
        int j = 4;
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
        panelHolder[0][2].add(new JLabel("West"));

        panelHolder[1][0].add(e1);panelHolder[2][0].add(e2);panelHolder[3][0].add(e3);panelHolder[4][0].add(e4);panelHolder[5][0].add(e5);panelHolder[6][0].add(e6);panelHolder[7][0].add(e7);
        panelHolder[1][2].add(w1);panelHolder[2][2].add(w2);panelHolder[3][2].add(w3);panelHolder[4][2].add(w4);panelHolder[5][2].add(w5);panelHolder[6][2].add(w6);panelHolder[7][2].add(w7);

        placeTeams();

        JButton nextButton = new JButton("Advance Week");
        nextButton.addActionListener(new GUI.AdvanceWeekListener());
        panelHolder[7][1].add(nextButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("B1G Conference Standings");
        frame.pack();
        frame.setVisible(true);


    }
    
    public static void placeTeams() throws IOException {

        e1.setText(conference.div1.getStandings().get(0).name + ": " + conference.div1.getStandings().get(0).totalWins + "-" + conference.div1.getStandings().get(0).totalLosses + " (" + conference.div1.getStandings().get(0).divisionWins + "-" + conference.div1.getStandings().get(0).divisionLosses + ")");
        e2.setText(conference.div1.getStandings().get(1).name + ": " + conference.div1.getStandings().get(1).totalWins + "-" + conference.div1.getStandings().get(1).totalLosses + " (" + conference.div1.getStandings().get(1).divisionWins + "-" + conference.div1.getStandings().get(1).divisionLosses + ")");
        e3.setText(conference.div1.getStandings().get(2).name + ": " + conference.div1.getStandings().get(2).totalWins + "-" + conference.div1.getStandings().get(2).totalLosses + " (" + conference.div1.getStandings().get(2).divisionWins + "-" + conference.div1.getStandings().get(2).divisionLosses + ")");
        e4.setText(conference.div1.getStandings().get(3).name + ": " + conference.div1.getStandings().get(3).totalWins + "-" + conference.div1.getStandings().get(3).totalLosses + " (" + conference.div1.getStandings().get(3).divisionWins + "-" + conference.div1.getStandings().get(3).divisionLosses + ")");
        e5.setText(conference.div1.getStandings().get(4).name + ": " + conference.div1.getStandings().get(4).totalWins + "-" + conference.div1.getStandings().get(4).totalLosses + " (" + conference.div1.getStandings().get(4).divisionWins + "-" + conference.div1.getStandings().get(4).divisionLosses + ")");
        e6.setText(conference.div1.getStandings().get(5).name + ": " + conference.div1.getStandings().get(5).totalWins + "-" + conference.div1.getStandings().get(5).totalLosses + " (" + conference.div1.getStandings().get(5).divisionWins + "-" + conference.div1.getStandings().get(5).divisionLosses + ")");
        e7.setText(conference.div1.getStandings().get(6).name + ": " + conference.div1.getStandings().get(6).totalWins + "-" + conference.div1.getStandings().get(6).totalLosses + " (" + conference.div1.getStandings().get(6).divisionWins + "-" + conference.div1.getStandings().get(6).divisionLosses + ")");
        w1.setText(conference.div2.getStandings().get(0).name + ": " + conference.div2.getStandings().get(0).totalWins + "-" + conference.div2.getStandings().get(0).totalLosses + " (" + conference.div2.getStandings().get(0).divisionWins + "-" + conference.div2.getStandings().get(0).divisionLosses + ")");
        w2.setText(conference.div2.getStandings().get(1).name + ": " + conference.div2.getStandings().get(1).totalWins + "-" + conference.div2.getStandings().get(1).totalLosses + " (" + conference.div2.getStandings().get(1).divisionWins + "-" + conference.div2.getStandings().get(1).divisionLosses + ")");
        w3.setText(conference.div2.getStandings().get(2).name + ": " + conference.div2.getStandings().get(2).totalWins + "-" + conference.div2.getStandings().get(2).totalLosses + " (" + conference.div2.getStandings().get(2).divisionWins + "-" + conference.div2.getStandings().get(2).divisionLosses + ")");
        w4.setText(conference.div2.getStandings().get(3).name + ": " + conference.div2.getStandings().get(3).totalWins + "-" + conference.div2.getStandings().get(3).totalLosses + " (" + conference.div2.getStandings().get(3).divisionWins + "-" + conference.div2.getStandings().get(3).divisionLosses + ")");
        w5.setText(conference.div2.getStandings().get(4).name + ": " + conference.div2.getStandings().get(4).totalWins + "-" + conference.div2.getStandings().get(4).totalLosses + " (" + conference.div2.getStandings().get(4).divisionWins + "-" + conference.div2.getStandings().get(4).divisionLosses + ")");
        w6.setText(conference.div2.getStandings().get(5).name + ": " + conference.div2.getStandings().get(5).totalWins + "-" + conference.div2.getStandings().get(5).totalLosses + " (" + conference.div2.getStandings().get(5).divisionWins + "-" + conference.div2.getStandings().get(5).divisionLosses + ")");
        w7.setText(conference.div2.getStandings().get(6).name + ": " + conference.div2.getStandings().get(6).totalWins + "-" + conference.div2.getStandings().get(6).totalLosses + " (" + conference.div2.getStandings().get(6).divisionWins + "-" + conference.div2.getStandings().get(6).divisionLosses + ")");
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
