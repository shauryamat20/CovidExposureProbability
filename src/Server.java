import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	static ArrayList<String> states = new ArrayList();
	static ArrayList<Double> cases = new ArrayList();
	public static void main(String[] args) throws IOException {
		readInfo();
		 ServerSocket serverSocket = new ServerSocket(4242);
	     System.out.println("Waiting for the client to connect...");
	     Socket socket = serverSocket.accept();
	     System.out.println("Client Connected!");
	     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	     PrintWriter writer = new PrintWriter(socket.getOutputStream());
	     String recieved = reader.readLine();
	     String[] data = recieved.split(" ");
	     String state = data[0];
	     int people = Integer.parseInt(data[1]);
	     System.out.println("Recieved: " + state + people);
	     double numCases = cases.get(findState(state));
	     double chances = calculateChances((cases.get(findState(state))*3) / 100000 , people );
	     writer.write(numCases + " " + chances);
	     writer.println();
	     writer.flush();
	     
	}
	
	public static void readInfo() throws IOException, NumberFormatException {
        File f = new File("C:\\Users\\shaur\\git\\CovidExposureProbability\\src\\StateCovidRate");
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        String line = "";
        while (line != null) {
            line = bfr.readLine();
            if (line == null || line.equals("")) {
                break;
            }
            //System.out.println(line);
            String[] info = line.split(",");
            states.add(info[0].toLowerCase());
            cases.add(Double.parseDouble(info[1]));
            //System.out.println(info[0] + info[1]);
        }
    }
	
	public static  int findState(String state) {
		for (int i = 0 ; i< states.size() ; i++) {
			if (states.get(i).equals(state)) {
				return i;
			}
		}
		return -1;
	}
	
	public static double calculateChances(double p , int n) {
		return (1 - Math.pow(1-p, n));
	}
	
	

}
