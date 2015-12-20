package count.vowels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CountVowels {
	public static ArrayList<String> vowels = new ArrayList<String>();
	static{
		
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");
		
	}
	
	public Map<String, Integer> count(String s){
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(StringUtils.isNotBlank(s)){
			for(int i = 0; i < s.length(); i++){
				if(vowels.contains(s.substring(i, i+1))){
					if(map.containsKey(s.substring(i, i+1))){
						int j = map.get(s.substring(i, i+1));
						map.put(s.substring(i, i+1), j+1);
					}else{
						map.put(s.substring(i, i+1), 1);
					}
					
				}
				
			}
			return map;
		}
		return null;
	}
}
