import java.io.*;
import java.net.*;

public class Server {
/*
 * ��������
 */

String [] adviceList = {
		"a","b","c","d","e","f","g","h","i","j","k","l"
		};
	public void go(){
		try{
			ServerSocket serverSock = new ServerSocket(4000);
			
			while(true){
				
			Socket sock = serverSock.accept();//�ȴ�Ҫ�󵽴�
			
			PrintWriter w = new PrintWriter(sock.getOutputStream());
			String ad=getAdvice();
			w.println(ad);
			w.close();
			System.out.println(ad);
			}
						
		}catch(IOException ex){
			ex.printStackTrace();
		}
		}
	
	public String getAdvice(){
		int random = (int)(Math.random()*adviceList.length);
		return adviceList[random];
	}
	public static void main(String [] args){
		Server s = new Server();
		s.go();
	}
}
