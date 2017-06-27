import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;


public class Chat {
	JTextField out;
	JTextArea incoming;
	BufferedReader reader;
	JFrame frame;
	Socket sock;
	PrintWriter writer;
	
	public static void main(String [] args){
		Chat c = new Chat();
		c.go();
	}
	public void go(){
		frame = new JFrame("This is a chat");
		JPanel panel  =new JPanel();
		
		incoming = new JTextArea(15,50);
		
		incoming.setLineWrap(true);
		incoming.setEditable(false);
		incoming.setWrapStyleWord(true);
		
		JScrollPane qScroller =  new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		out  = new JTextField(20);
		
		JButton send = new JButton("send");
		send.addActionListener(new SendButtonListener());
						
		panel.add(qScroller);
		panel.add(out);
		panel.add(send);
		setUpNetworking();
		
		/*
		 * 启动新线程。以内部类为任务，此任务是读取服务器的socket串流显示在文本区域
		 */
		
		Thread readerThread = new Thread(new IncomingReader());
		
	
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		
		frame.setSize(600,400);
		frame.setVisible(true);
		
			
	}
	public void setUpNetworking(){
		try{
			 sock = new Socket("127.0.0.1",5400);
			 InputStreamReader streamReader  = new InputStreamReader(sock.getInputStream());
			 reader = new BufferedReader(streamReader);
			 writer = new PrintWriter(sock.getOutputStream());
			System.out.println("online success");

		}catch(IOException ex){
			
			ex.printStackTrace();
		
		}
	}
	
	
	public class SendButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				writer.println(out.getText());
				writer.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			out.setText(" ");
			out.requestFocus();
		}
	}
	
	
	public class IncomingReader implements Runnable{
		public void run(){
			String message;
			try{
				
				while ((message = reader.readLine())!=null){
					System.out.println("read"+message);
					incoming.append(message+"\n");
				}
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
	}
}
