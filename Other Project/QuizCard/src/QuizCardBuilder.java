import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizCardBuilder {
	
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
public static void main(String[] args){
	QuizCardBuilder builder = new QuizCardBuilder();
	builder.go();
}
	public void go(){
		//����ui
		frame = new JFrame("Quiz Card Builder");//�������
		JPanel mainPanel = new JPanel();//����panel
		Font bigFont = new Font("sanserif",Font.BOLD,24);//�����ַ������ʽ
		question = new JTextArea(6,20); //����question�ı����� 6��20����
		/*
		 * ���ı������������
		 * 
		 */
		//question
		question.setLineWrap(true);//�����Զ�����
		question.setFont(bigFont);//�����ַ���ʽ
		question.setWrapStyleWord(true);//
		
		JScrollPane qS = new JScrollPane(question);
		qS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//answer
		answer= new JTextArea(6,20);
		answer.setLineWrap(true);//�����Զ�����
		answer.setFont(bigFont);//�����ַ���ʽ
		answer.setWrapStyleWord(true);//
		
		JScrollPane aS = new JScrollPane(answer);
		aS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//����Next Card��ť
		JButton nextButton = new JButton("Next Card");
		
		cardList = new ArrayList<QuizCard>();
		//��������label
		JLabel qLabel = new JLabel("Question");
		JLabel aLabel = new JLabel("Answer");
		//�Ѹ�������Ԫ�����ӵ�����
		mainPanel.add(qLabel);
		mainPanel.add(qS);
		mainPanel.add(aLabel);
		mainPanel.add(aS);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());//����nextButto��ť�¼�����
		
		//�˵���
		JMenuBar menuBar  = new JMenuBar();//�����˵�bar
		JMenu fileMenu = new JMenu("file");//����file�˵�
		JMenuItem newMenuItem = new JMenuItem("new");//����new�˵�
		JMenuItem saveMenuItem = new JMenuItem("save");
		newMenuItem.addActionListener(new NewMenuListener());//���� new�˵��¼�����
		saveMenuItem.addActionListener(new NewMenuListener());//����save�˵��¼�����
		
		//�˵�����
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		
		menuBar.add(fileMenu);//����file�˵�
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
		
		
		
		
		
		
	}
	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			QuizCard card  = new QuizCard(question.getText(),answer.getText());
						
			cardList.add(card);
			clearCard();
			//���б������ӵ�ǰ��Ƭ������ı���
		}
		
	}
	public class SaveMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			QuizCard card = new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
			
			//���ɶԻ���
			//�����û�������������
		}
	}
	public class NewMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cardList.clear();
			clearCard();
			//���card�б����ı���
		}
	}
	public void saveFile(File file){
		try{
			//���������� ������ʱд�뻺����
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for(QuizCard card:cardList){
				writer.write(card.getQuestion()+"/ ");
				writer.write(card.getAnswer()+"\n");
			}
			writer.close();
		}catch(IOException ex){
			System.out.println("couldn't write the cardList out");
			ex.printStackTrace();
			
		}
		
		//���б������һ���ı��ļ�
		
	}

	public void clearCard(){
		question.setText(" ");
		answer.setText(" ");
		question.requestDefaultFocus();
		}
}