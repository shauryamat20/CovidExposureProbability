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

	static ArrayList<String> population = new ArrayList();
	static ArrayList<String> cases = new ArrayList();
	
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
	     String myState = data[0];
	     int numPeople = Integer.parseInt(data[1]);
	     String myCounty = data[2].toLowerCase();
	     
	     double myPopulation = getPopulation(myCounty, myState);
	     double myCases = getCases(myCounty , myState);
	     if(myPopulation == -1 || myCases == -1) {
	    	 writer.write("error");
	    	 writer.println();
	    	 writer.flush();
	     } else {
	    	 System.out.println(myPopulation + " " + myCases);
		     double chances = calculateChances((myCases*3)/myPopulation , numPeople);
		     System.out.println(chances);
		     writer.write(myCases + " " + chances);
		     writer.println();
		     writer.flush();
	     }
	     
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
            cases.add(line);
        }
        File f2 = new File("C:\\Users\\shaur\\git\\CovidExposureProbability\\src\\PopulationData");
        FileReader fr2 = new FileReader(f2);
        BufferedReader bfr2 = new BufferedReader(fr2);
        line = "";
        while (line != null) {
        	line = bfr2.readLine();
        	if(line == null || line.equals("")) {
        		break;
        	}
        	population.add(line);
        }
    }
	
	public static int getPopulation(String county, String state) {
		for (String i : population) {
			String[] data = i.split(",");
			if (data[0].toLowerCase().contains(county) && data[1].contains(state)) {
				return Integer.parseInt(data[2]);
			}
		}
		return -1;
	}
	
	public static int getCases(String county, String state) {
		for (String i : cases) {
			String[] data = i.split(",");
			if (data[0].toLowerCase().contains(county) && data[1].contains(state)) {
				return Integer.parseInt(data[2]);
			}
		}
		return -1;
	}
	public static double calculateChances(double p , int n) {
		return 100*(1 - Math.pow(1-p, n));
	}
	
	

}
