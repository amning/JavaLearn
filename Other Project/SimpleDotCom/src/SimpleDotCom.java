
import java.util.ArrayList;
public class SimpleDotCom {
 private ArrayList<String> locationCells;
	//int numOfHits=0;
 //int[] locationCells;
  
public void setLocationCell(ArrayList<String> locs)
{		
	locationCells = locs;
}
public String checkYourself(String userInput)
{
	int index = Integer.parseInt(userInput);//Integer��java�ڽ���  parsetInt:java�ķ��� ��String���� 
	
	String result = "miss";//���Ĭ��Ϊmiss
	if(index>=0)
	{
		locationCells.remove(index);
		
		if(locationCells.isEmpty()){
			result="kill";
		}else{
			result="hit";
		}
	}
	/*
	for(int cell : locationCells){
		if(guess == cell){
			result = "hit";
			numOfHits++;
			break;
		}
	}
	if (numOfHits==locationCells.length){
		result = "kill";
	}
	System.out.println(result);
	*/
	return result;
	
}
 
}
