import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;




public class QuizCardPlayer {
	private JFrame frame;
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int cuttentCardIndex;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	public static void main(String [] args){
		QuizCardPlayer player = new QuizCardPlayer();
		player.go();
	}
	public void go(){
		//����ui
		frame = new JFrame("Quiz Card Builder");//�������
		JPanel mainPanel = new JPanel();//����panel
		Font bigFont = new Font("sanserif",Font.BOLD,24);//�����ַ������ʽ
		
		/*
		 * ���Ŵ�������
		 */
		display = new JTextArea(10,20);//�������Ŵ���
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(false);
		
		JScrollPane qS = new JScrollPane(display);
		qS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		nextButton = new JButton("show question");//show��ť����
		
		//���ӿؼ����������
		mainPanel.add(qS);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
				
		//�˵���
		JMenuBar menuBar  = new JMenuBar();//�����˵�bar
		JMenu fileMenu = new JMenu("file");//����file�˵�
		JMenuItem loadMenuItem = new JMenuItem("Load card set");//����new�˵�

		loadMenuItem.addActionListener(new OpenMenuListener());//���� load�˵��¼�����
			
		//�˵�����
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);//����file�˵�
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640,500);
		frame.setVisible(true);
				
		//����ui
	}
	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(isShowAnswer){//���isShowAnswer���жϿ����������⻹�Ǵ� ���ݻش���ִ���ʵ��Ĺ���
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}else{
				if(cuttentCardIndex<cardList.size()){
					showNextCard();
					
				}else{//���һ����Ƭ
					display.setText("That was last card");
					nextButton.setEnabled(false);
					
				}
			}
			//����Ǹ����⣬��ʾ�𰸣�������ʾ��һ������
			//��һ����ʶ���������Ѿ������������
		}
	}
	public class OpenMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
			
			//����һ���ļ��Ի���
			//���û���һ����Ƭ���ô�
		}
	}
	
	private void loadFile(File file){
		cardList =  new ArrayList<QuizCard>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine())!=null){
				makeCard(line);
			}
			reader.close();
		}catch(Exception ex){
			System.out.println("couldn't read the card file");
			ex.printStackTrace();
		}
		//������Ƭ���飬�����ı��ж�ȡ����
		//����OpenMenuListener�¼���������ÿ�δ��ļ��ж�ȡһ��
		//����makeCard()��������һ���µĿ�Ƭ
		//
	}
	
	public void showNextCard() {
		currentCard  = cardList.get(cuttentCardIndex);
		cuttentCardIndex++;
		display.setText("Show Answer");
		nextButton.setText("Show Answer");
		isShowAnswer = true;
		// TODO Auto-generated method stub
		
	}
	private void makeCard(String LineToParse){
		String[] result = LineToParse.split("/");
		QuizCard card = new QuizCard(result[0],result[1]);
		cardList.add(card);
		System.out.println("made a card");
		
		//����LoadFile���������ı��ж�ȡһ��
		//����һ���µ�QuizCard ͨ������CardLis�������뵽������
	}
}