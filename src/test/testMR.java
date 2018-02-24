package test;

public class testMR {
	private static boolean isPrint;
	static void testBoolean(boolean isPrint){
		if(!isPrint){
			isPrint = true;
		}
		System.out.println("============isPrint=============="+isPrint);
	}
	
	public static void main(String args[]){
		System.out.println(1);
		testBoolean(isPrint);
	}
}
