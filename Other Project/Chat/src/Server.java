import java.io.*;
import java.awt.*;
import java.net.*;
import java.util.*;

public class Server {
	
	ArrayList clientOutputStreams;
	
	public static void main(String[] args){
		
		Server s = new Server();
		s.go();
	
	}
	
	public void go(){
		
		clientOutputStreams = new ArrayList();
		
		try{
			//���ü��Ӷ˿�
			
			ServerSocket serverSock  = new ServerSocket(5400);
			
			/*
			 * ���Ӷ˿�ѭ��
			 */
			
			while(true){
				Socket clientSocket =  serverSock.accept();//�ɽ�������
				PrintWriter writer = new PrintWriter (clientSocket.getOutputStream());//�����������д��
				clientOutputStreams.add(writer);//��Ӵ���������
				
				Thread t = new Thread(new ClientHandler(clientSocket));//�������߳�
				t.start();//��ʼ�߳�
				System.out.println("got a connection");
								
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public class ClientHandler implements Runnable{
		
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler(Socket clientSocket){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader= new BufferedReader(isReader);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		public void run(){
			String message;
			try{
				while((message=reader.readLine())!=null){
					System.out.println();
					tellEveryone(message);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
		
	}
	public void tellEveryone(String message){
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer =(PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
	}
}