import java.util.ArrayList;

public class DotCom {
 private String name;
 private ArrayList<String> locationCells;
public void setName(String n)
{		
	name = n;
	
}
public void setLocationCells(ArrayList<String> loc){
	
	locationCells = loc;
	
}
public String checkYourself(String userInput)
{
	int guess = locationCells.indexOf(userInput);
	
	String result = "miss";//结果默认为miss
	
	if(guess>=0){
		locationCells.remove(guess);
	}
	
	
		if(locationCells.isEmpty()){
			result = "kill";
			System.out.println("you sunk " +name+ ":(");
				}
		else{
			result = "hit";
			
		}
		return result;
		
	
	}

	
	
}

 

