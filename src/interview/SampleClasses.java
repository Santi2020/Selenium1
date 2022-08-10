package interview;

public class SampleClasses {
	final int finalVar;// = 0;
	
	public SampleClasses(int n) {
		finalVar = n;
		System.out.println("Inside the cnstructor value of finalVar=" +finalVar);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fName="firstname";
		String lName="lastname";
		
		
		String txt = "Hello Everybody";
		System.out.println(txt.indexOf("el"));
		
		System.out.println(fName.concat(lName));
		SampleClasses s = new SampleClasses(100);
	
		try {
			System.out.println("Inside try block");
		}
		/*
		catch(Exception e) {
			System.out.println("Exception occured");
		}
		*/
		
		finally {
			System.out.println("Inside finally bolck");
		}
	}

}
