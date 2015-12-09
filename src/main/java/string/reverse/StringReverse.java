package string.reverse;

public class StringReverse {

	public static String EASY = "EASYWAY";
	
	public static String HARD = "HARDWAY";
	
	public static void main(String[] args){
		easyStringReverse(EASY);
		
		hardStringRevers(HARD);
		
	}

	private static void hardStringRevers(String s) {
		// TODO Auto-generated method stub
		StringBuilder sbuild = new StringBuilder();
		for(int i = s.length(); i > 0; i--){
			sbuild.append(s.subSequence(i - 1, i));		
			}
		
		System.out.println(sbuild);
	}

	private static void easyStringReverse(String s) {
		// TODO Auto-generated method stub
		System.out.println(new StringBuilder(s).reverse());
		
	}
}
