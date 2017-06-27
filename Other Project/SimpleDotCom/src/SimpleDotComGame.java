import java.util.ArrayList;

public class SimpleDotComGame {
	public static void main(String[] args) 
	{
		int numOfGuesses=0;
		GameHelp help = new GameHelp();
		SimpleDotCom Dot=new SimpleDotCom();
		
	
		int randomNum = (int)(Math.random()*5);
		int[] locations = {randomNum,randomNum+1,randomNum+2};
		//ArrayList.add(randomNum);
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
		}
		
		
		
		
		
		  
		
		
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
}
