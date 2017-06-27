import java.util.*;

public class DotComBust {

	//声明 初始化变量	
	private GameHelp help = new GameHelp();
	private int numOfGuesses=0;
	ArrayList<DotCom> dotComLists= new ArrayList<DotCom>();
	
	/*
	 * setUpGame 函数 
	 * object：Dotcom 
	 *  
	 */
	private void setUpGame(){
		//创建三个变量并指派名称并直入ArraList
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two  = new DotCom();
		two.setName("eToy.com");
		DotCom three  = new DotCom();
		three.setName("Go2.com");
		dotComLists.add(one);
		dotComLists.add(two);
		dotComLists.add(three);
		//列出剪短的提示
		System.out.println("your goal is to sing three dot coms.");
		System.out.println("Pets.com,eToy.com,Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		//
		for (DotCom dotComToSet:dotComLists)//对list中的每一个DotCom重复一次
		{
			ArrayList<String> newLocation = help.placeDotCom(3);//要求DotCom的位置、
			dotComToSet.setLocationCells(newLocation);//调用dotCom的setter方法来指派刚取得的位置
		}
	}
	
	/*
	 * startPlaying()
	 */
	private void startPlaying(){
		while(!dotComLists.isEmpty()){//判断DotCom的list是否为空
			String userGuess = help.getUserInput("Enter a guess");//取得玩家输入
			checkUserGuess(userGuess);//调用checkUserGuess
		}//close while
		finishGame();//调用finshGame方法
	}//close startPlaying method
	
	/*
	 * checkUserGuess(String userGuess)
	 */
	private void checkUserGuess(String userGuess){
		numOfGuesses++;//递增玩家猜测次数
		String result = "miss";//先假设未命中
		for(DotCom dotComToTest : dotComLists){//对list中所有的DotCom重复
			result = dotComToTest.checkYourself(userGuess);//要求DotCom检查是否命中
			if (result.equals("hit"))
				break;//提前跳出循环
			if(result.equals("kill"))
				dotComLists.remove(dotComToTest);
			break;//这家伙挂掉了
		}//close for
		System.out.println(result);//列出结果
	}
	
	/*
	 * finishGame()
	 */
	private void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		
			System.out.println("It took you "+numOfGuesses+"  guess");//列出玩家成绩
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
		 * Test code：
		SimpleDotCom dot = new SimpleDotCom();//初始化一个SimpleDotCom对象
		
		int[] locations = {2,3,4};//创建带有dotcom 位置的数组 2 3 4 即为位置；
		dot.setLocationCell(locations);//调用setter
		
		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		String testResult="failed";
		
		if(result.equals("hit")){
			testResult = "passed";
		}
		System.out.println(testResult);
		 */
	
}
