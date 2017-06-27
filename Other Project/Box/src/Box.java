import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Box implements Serializable {
	private int width;
	private int height;
	
	public void setWidth(int w){
		width = w;
		
	}
	public void setHeight(int h){
		height = h;
	}
	public static void main(String[] args){
		Box myBox = new Box();
		myBox.setHeight(50);
		myBox.setWidth(30);
		
		try{//可能抛出异常
			FileOutputStream fs = new FileOutputStream("foo.ser");//如果不存在就会被创建
			ObjectOutputStream os = new ObjectOutputStream(fs);//设定链接
			os.writeObject(myBox);
			os.close();
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
}
