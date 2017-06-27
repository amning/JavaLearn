import java.util.*;

public class DotComBust {

	//���� ��ʼ������	
	private GameHelp help = new GameHelp();
	private int numOfGuesses=0;
	ArrayList<DotCom> dotComLists= new ArrayList<DotCom>();
	
	/*
	 * setUpGame ���� 
	 * object��Dotcom 
	 *  
	 */
	private void setUpGame(){
		//��������������ָ�����Ʋ�ֱ��ArraList
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two  = new DotCom();
		two.setName("eToy.com");
		DotCom three  = new DotCom();
		three.setName("Go2.com");
		dotComLists.add(one);
		dotComLists.add(two);
		dotComLists.add(three);
		//�г����̵���ʾ
		System.out.println("your goal is to sing three dot coms.");
		System.out.println("Pets.com,eToy.com,Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		//
		for (DotCom dotComToSet:dotComLists)//��list�е�ÿһ��DotCom�ظ�һ��
		{
			ArrayList<String> newLocation = help.placeDotCom(3);//Ҫ��DotCom��λ�á�
			dotComToSet.setLocationCells(newLocation);//����dotCom��setter������ָ�ɸ�ȡ�õ�λ��
		}
	}
	
	/*
	 * startPlaying()
	 */
	private void startPlaying(){
		while(!dotComLists.isEmpty()){//�ж�DotCom��list�Ƿ�Ϊ��
			String userGuess = help.getUserInput("Enter a guess");//ȡ���������
			checkUserGuess(userGuess);//����checkUserGuess
		}//close while
		finishGame();//����finshGame����
	}//close startPlaying method
	
	/*
	 * checkUserGuess(String userGuess)
	 */
	private void checkUserGuess(String userGuess){
		numOfGuesses++;//������Ҳ²����
		String result = "miss";//�ȼ���δ����
		for(DotCom dotComToTest : dotComLists){//��list�����е�DotCom�ظ�
			result = dotComToTest.checkYourself(userGuess);//Ҫ��DotCom����Ƿ�����
			if (result.equals("hit"))
				break;//��ǰ����ѭ��
			if(result.equals("kill"))
				dotComLists.remove(dotComToTest);
			break;//��һ�ҵ���
		}//close for
		System.out.println(result);//�г����
	}
	
	/*
	 * finishGame()
	 */
	private void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		
			System.out.println("It took you "+numOfGuesses+"  guess");//�г���ҳɼ�
		}
	public static void main(String[] args) 
	{
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
		
			
	}
	
	
		
		
		/*
		 * simple code:
		 * int numOfGuesses=0;
		GameHelp help = new GameHelp();
		DotCom Dot=new DotCom();
		
	
		int randomNum = (int)(Math.random()*5);
		int[] locations = {randomNum,randomNum+1,randomNum+2};
		
		Dot.setLocationCell(locations);
		
		boolean isAlive = true;
		
		while(isAlive==true)
		{
			String guess = help.getUserInput("enter a number");
			
			String result = Dot.checkYourself(guess);
			
			numOfGuesses++;
			
			if (result.equals("kill"))
			{
				isAlive=false;
				System.out.println("you took "+numOfGuesses+" guesses ");
			}
			*/
		
		
		
		
		
		
		
		
		
		/* 
		 * Test code��
		SimpleDotCom dot = new SimpleDotCom();//��ʼ��һ��SimpleDotCom����
		
		int[] locations = {2,3,4};//��������dotcom λ�õ����� 2 3 4 ��Ϊλ�ã�
		dot.setLocationCell(locations);//����setter
		
		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		String testResult="failed";
		
		if(result.equals("hit")){
			testResult = "passed";
		}
		System.out.println(testResult);
		 */
	
}
