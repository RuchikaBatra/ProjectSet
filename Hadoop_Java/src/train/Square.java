package train;

public class Square  {           
	int side;
	Square(){
		
	}
	Square(int s){
		side = s;
	}
	void calcArea()
	{
		int area = side * side;
	}
	 
	
	
	
	

	public static void main(String args[])
	{
		Square s = new Square(10);
	
		System.out.println(s.side);
		//s.calcArea();
	}
}









