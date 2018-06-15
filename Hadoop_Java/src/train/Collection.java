package train;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection {
	 public static void main(String args[]){

	 ArrayList<Integer> a1 = new ArrayList<Integer>();
	 a1.add(1);
	 a1.add(2);
	
	 for(Integer i :a1)
		 
		 System.out.println(i);
	 Iterator itr = a1.iterator();
	 while(itr.hasNext())
	 {
		 System.out.println(itr.next());
	 }
	 
	 }
	 
}
