import java.net.*;
import java.io.*;

public class TalkClient{
	public static void main(String args[]) throws Exception{
		Socket s= new Socket("localhost",4700);
		PrintWriter printWriter = new PrintWriter(s.getOutputStream());
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		line = sin.readLine();
		while(!line.equals("bye")){
			printWriter.println(line);
			printWriter.flush();
			System.out.println("client:"+line);
			System.out.println("server:"+bufferedReader.readLine());
			line= sin.readLine();
		}
		printWriter.close();
		bufferedReader.close();
		s.close();
		
	}

}