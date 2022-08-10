package interview;

public class MyTest {
	private static int sum;
	private static boolean initialized = false;
	
	static
    {
        System.out.println("Start static block");
    	initialize();
    	System.out.println("End static block");
    	System.out.println("==================================");
    }
      
    //private static int sum;
      
    public static int getSum()
    {
    	System.out.println("Start getSum. Value of initialized=" + initialized);
    	initialize();
    	System.out.println("End getSum. Value of initialized=" + initialized);
    	System.out.println("==============================");
    	return sum;
    }
  
    //private static boolean initialized = false;
  
    private static void initialize()
    {
    	System.out.println("Start initialize(). Value of initialized=" + initialized);
    	if (!initialized) {
            for (int i = 0; i < 5; i++)
                sum += i;
            System.out.println("Sum =" + sum);
            initialized = true;
        }
    	
    	System.out.println("End initialize(). Value of initialized=" + initialized);
    	System.out.println("==============================");
    }
}
 