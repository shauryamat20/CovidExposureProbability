import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JComponent implements Runnable {

    ActionListener actionListener;
    
	JFrame welcomeFrame;
	JLabel welcomeText;
	JLabel secondText;
	JButton continueText;
	
	JFrame infoFrame;
	JLabel enterState;
	JLabel enterInteractions;
	JTextField numInteractions;
	JTextField yourState;
	JButton calculate;
	JLabel moreInfo;
	
	JFrame finalFrame;
	JLabel caseInfo;
	JLabel percentage;
	JLabel additionalInfoField;

	JLabel enterCounty;

	JTextField yourCounty;

	private JLabel note;
	
	public void run() {
		welcomeFrame = new JFrame("Welcome");
        Container content = welcomeFrame.getContentPane();
        welcomeFrame.setSize(400, 400);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        welcomeFrame.setBackground(Color.magenta);
        welcomeFrame.setVisible(true);
        
        JPanel panel = new JPanel(new GridLayout(10,1));
        panel.setBackground(Color.magenta);
        welcomeText = new JLabel("Welcome to the Covid Exposure Probability Calculator" , JLabel.CENTER);
        panel.add(welcomeText , BorderLayout.CENTER);
        secondText = new JLabel("Click continue to proceed next and enter location" , JLabel.CENTER);
        panel.add(secondText);
        continueText = new JButton("Continue");
        continueText.addActionListener(actionListener);
        panel.add(continueText);
        content.add(panel, BorderLayout.CENTER);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setVisible(true);
        
        infoFrame = new JFrame("Info");
        Container content2 = infoFrame.getContentPane();
        infoFrame.setSize(400, 400);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setBackground(Color.magenta);
        infoFrame.setVisible(false);
        
        JPanel pane2 = new JPanel(new GridLayout(10,1));
        pane2.setBackground(Color.magenta);
        enterState = new JLabel("Enter your state abbreviation below (2 letter abbseviation) : " , JLabel.CENTER);
        pane2.add(enterState , BorderLayout.CENTER);
        yourState = new JTextField("Enter your state ");
        pane2.add(yourState);
        enterCounty = new JLabel("Enter your county below:");
        pane2.add(enterCounty);
        yourCounty = new JTextField("Enter your county");
        pane2.add(yourCounty);
        enterInteractions = new JLabel("Enter the number of people you interacter with" , JLabel.CENTER);
        pane2.add(enterInteractions);
        numInteractions = new JTextField("Enter number here");
        pane2.add(numInteractions);
        calculate = new JButton("Calculate");
        calculate.addActionListener(actionListener);
        pane2.add(calculate);
        note = new JLabel("Note: not all county reporting has been accurate");
        pane2.add(note);
        content2.add(pane2, BorderLayout.CENTER);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setVisible(false);
        
        finalFrame = new JFrame("Results");
        Container content3 = finalFrame.getContentPane();
        finalFrame.setSize(400, 400);
        finalFrame.setLocationRelativeTo(null);
        finalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        finalFrame.setBackground(Color.magenta);
        finalFrame.setVisible(false);
        
        JPanel pane3 = new JPanel(new GridLayout(4,1));
        pane3.setBackground(Color.magenta);
        caseInfo = new JLabel("According to CDC info there have been number of cases in your state per"
        		+ "100k individuals. Given those many cases, below is the probability of you having interacted"
        		+ "with a covid positive individual given the number u inputted.");
        pane3.add(caseInfo , JLabel.CENTER);
        percentage = new JLabel("Percentage " , JLabel.CENTER);
        pane3.add(percentage , BorderLayout.CENTER);
        additionalInfoField = new JLabel("<html> PLEASE CONTINUE TO FOLLOW CDC GUIDELINES. STAY INDOORS, AVOID GATHERINGS AND WEAR MASKS. IN NO WAY SHOULD THIS CALCULATION BE\"\r\n" + 
        		        		" TAKEN AS A REASON TO SOCIALIZE OR VIOLATE QUARANTINE MANDATES.</html>" , JLabel.CENTER);
        pane3.add(additionalInfoField);
        moreInfo = new JLabel("<html> The covid case data had been obtained from usafacts.org while population data has been achieved from US census projections. </html>");
        pane3.add(moreInfo);
        content3.add(pane3, BorderLayout.CENTER);
        finalFrame.setLocationRelativeTo(null);
        finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finalFrame.setVisible(false); 
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Gui());
    }
	
}
