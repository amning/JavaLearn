
public class GuessGame {

	public void startGame(){
		Player p1=new Player();
		Player p2=new Player();
		Player p3=new Player();
		
		int guessp1=0;
		int guessp2=0;
		int guessp3=0;
		boolean p1isRight=false;
		boolean p2isRight=false;
		boolean p3isRight=false;
		
		int targerNumber = (int)(Math.random()*10);
		System.out.println("i'm thinking of a number between 0 and 9...");
		
		while(true)
		{
			System.out.println("Numer to guess is"+ targerNumber);
			p1.guess();
			p2.guess();
			p3.guess();
			guessp1=p1.number;
			System.out.println("Play one guessed£º"+guessp1);
			guessp2=p2.number;
			System.out.println("Play two guessed£º"+guessp2);
			guessp3=p3.number;
			System.out.println("Play three guessed£º"+guessp3);
			if(guessp1==targerNumber)
			{
				p1isRight=true;
			}
			if(guessp2==targerNumber)
			{
				p2isRight=true;
			}
			if(guessp3==targerNumber)
			{
				p3isRight=true;
			}
			if(p1isRight||p2isRight||p3isRight)
			{
				System.out.println("We have a winner");
				System.out.println("Player one is right?"+p1isRight);
				System.out.println("Player two is right?"+p2isRight);
				System.out.println("Player three is right?"+p3isRight);
				System.out.println("Game is over");
				break;
			}
			else
			{
				System.out.println("Players will have to try again");
			}
		
	}
	}
}
