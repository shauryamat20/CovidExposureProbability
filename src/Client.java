import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Client {

	static Gui myGui;
	private static String myState;
	private static String myCounty;
	private static int numPeople;
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("localhost", 4242);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        
        SwingUtilities.invokeLater(myGui = new Gui());
        myGui.actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == myGui.continueText) {
                	myGui.welcomeFrame.setVisible(false);
                	myGui.infoFrame.setVisible(true);
                } else if (e.getSource() == myGui.calculate) {
                	myGui.infoFrame.setVisible(false);
                	myGui.finalFrame.setVisible(true);
                	myState = myGui.yourState.getText();
                	numPeople = Integer.parseInt(myGui.numInteractions.getText());
                	myCounty = myGui.yourCounty.getText();
                	writer.write(myState.toUpperCase() + " " + numPeople + " " + myCounty.toLowerCase());
                	writer.println();
                	writer.flush();
                	System.out.println(myState + " " + numPeople);
                	try {
						String output = reader.readLine();
						if (output.equals("error")) {
							myGui.finalFrame.setVisible(false);
		                	myGui.infoFrame.setVisible(true);
							JOptionPane.showMessageDialog(myGui, "Data for this county is either  unavailable, or incorrect county or state.");
							
						} else {
							String[] info = output.split(" ");
							myGui.caseInfo.setText("<html> There have been " + info[0] + " cases in your county in the last 7 days. Below"
									+ " is the likelihood of you interacting with a covid positive individual given on the number of interactions you "
									+ " provided in your county. </html>");
							myGui.percentage.setText(info[1]);
						}
						
                	} catch (IOException e1) {
						e1.printStackTrace();
					}
                	
                }

            }
        };
        
	}

}
