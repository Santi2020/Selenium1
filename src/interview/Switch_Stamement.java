package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Switch_Stamement {
	public static void try_catch() {
		System.out.println("\n");
		System.out.println("\n"+ System.currentTimeMillis()); 
		
		
		Map<String, String> wordMap = new HashMap<String, String>();
		wordMap.put("One", "Raghu");
		wordMap.put("two", "santoshi");
		wordMap.put("three", "Tisha");
		wordMap.put("four", "Anika");
		Set<Entry<String, String>> set = wordMap.entrySet();
		System.out.println("\nset = " + set);
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(set);
		System.out.println("\nList " +list );
		for (Entry<String, String> str : list) {
			System.out.println("\nstr =" + str);
		}
				
	}
	
	public void tryCatch() {
		System.out.println("\n\n\nTry Catch block");	
		try{
			System.out.println("I am in try block");
			//System.exit(1);
			return;
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			System.out.println("I am in finally block!!!");
		}
	}
	
	public void switch_case() {
	int price = 6;
	switch (price) {
		//default: System.out.println("It is: default");
		default: System.out.println("It is: default");
			break;	
		case 2: 
			System.out.println("It is: 2");
			break;
		case 5: 
			System.out.println("It is: 5");
			break;
		case 9: 
			System.out.println("It is: 9");
			break;	
		}
	}
	
	public static void main(String a[]){
		
				try_catch();		
		
	}
}
