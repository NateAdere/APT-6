import java.util.*;

public class PrefixCode {
	public String isOne(String[] words) {
		for(int index=0; index < words.length; index+=1) {	
			for(int i=0; i < words.length; i+=1) {
				if (i == index) {
					continue;
				}
				if (words[i].startsWith(words[index])) {
					return "No, "+index;
				}
			}
		}
		return "Yes";

    }

}
