import java.io.*;
import java.util.*;

public class Fixer {

	public static void main(String[] args) {
		Scanner in;
		try{
			in = new Scanner(new File("staticentity.txt"));
		    PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
		    while (in.hasNext()){
		    	int id = in.nextInt();
				int x = in.nextInt();
				int y = in.nextInt();
				int wi = in.nextInt();
				int he = in.nextInt();
		    	writer.println(id + " " + x + " " + (y+2) + " " + wi + " " + he);
		    }
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
}