import java.net.*;
import java.io.*;

public class TalkServer{
	public static void main(String args[]) throws Exception{
		//ServerSocket ss = new ServerSocket(4700);
		while(true){
		ServerSocket ss = new ServerSocket(4700);
		Socket socket = ss.accept();
		String line=null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		
		System.out.println("client:"+bufferedReader.readLine());
		BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
		line=sin.readLine();
		while(!line.equals("bye")){
			printWriter.println(line);
			printWriter.flush();
			System.out.println("server:"+line);
			System.out.println("client:"+bufferedReader.readLine());
			line=sin.readLine();
		}
		bufferedReader.close();
		printWriter.close();
		socket.close();
		ss.close();
		}
	}



}