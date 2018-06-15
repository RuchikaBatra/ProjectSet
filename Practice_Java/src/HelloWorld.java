import java.util.Scanner;


public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[10];
		
		Scanner S=new Scanner(System.in);
		//System.out.print("enter number");
		for(int i =0; i<10;i++)
		{
			 array[i] = S.nextInt(); 
		}
		for(int i=0;i<10;i++)
		{
			System.out.println("This is array["+i+"]:"+array[i]);
		}
			
      //s System.out.println("sum:" +sum);
       }

}
