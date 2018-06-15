package train;

public class Rectangle extends Shape{

	Rectangle(){
		System.out.println("rect const");
	}
	
	Rectangle(int w,int h,String color){
		this();
		width = w;
		height = h;
		color = this.color;
		
	}
public void sayHi(){
	 System.out.println("hello");
 }
}
