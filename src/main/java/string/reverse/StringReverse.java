package string.reverse;

import org.apache.commons.lang3.StringUtils;

public class StringReverse {

	public static String EASY = "EASYWAY";
	
	public static String HARD = "HARDWAY";
	
	public String hardStringReverse(String s) {
		//not actually hard but different
		if(!StringUtils.isBlank(s)){
			StringBuilder sbuild = new StringBuilder();
			for(int i = s.length(); i > 0; i--){
				sbuild.append(s.subSequence(i - 1, i));		
				}
			return sbuild.toString();
		}
		return null;
	}

	public String easyStringReverse(String s) {
		if(!StringUtils.isBlank(s)){
			return new StringBuilder(s).reverse().toString();
		}
		return null;
		
	}
}
