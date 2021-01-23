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
                	writer.write(myState.toLowerCase() + " " + numPeople);
                	writer.println();
                	writer.flush();
                	System.out.println(myState + " " + numPeople);
                	try {
						String output = reader.readLine();
						String[] info = output.split(" ");
						myGui.percentage.setText(Double.toString(Double.parseDouble(info[1])*100));
						String myString = "According to CDC info there have been " +  info[0]+ " cases in your state per 100K individuals";
						myGui.caseInfo.setText("<html>" + myString + " Below is the probability computed by the information provided using a Binomial Probability algorithm</html>");
						myGui.caseInfo.validate();
                	} catch (IOException e1) {
						e1.printStackTrace();
					}
                	
                }

            }
        };
        
	}

}
