import java.io.*;
import java.net.*;

public class Client {
	public void go(){
	try
	{
		Socket s = new Socket ("127.0.0.1",4000);//建立连接
		
		InputStreamReader stream = new InputStreamReader(s.getInputStream());//建立输入流
		BufferedReader reader = new BufferedReader(stream);//链接数据串流
		
		String message = reader.readLine();
		
		System.out.println("Today you shold :"+message);
		
		reader.close();
		
		
	}catch(IOException ex){
		ex.printStackTrace();
	}
	}
	public static void main(String[] args){
		Client d = new Client();
		d.go();
	}

}
