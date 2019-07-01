import java.util.*;

public class HuffmanDecoding {
	private String Char(String pref, String[] dict) {
		String empty = "";
		for(int k=0; k < dict.length; k++) {
			if (dict[k].equals(pref)) {
				return empty+ (char)('A'+k);
			}
		}
		return empty;
	}
	public String decode(String archive, String[] dictionary) {
		String ans = "";
		int size = 1;
		int start = 0;
		while (start < archive.length()) {
			String pref = archive.substring(start, start+size);
			String code = Char(pref,dictionary);
			if (code.length() > 0) {
				ans += code;
				start = start+size;
				size = 1;
			}
			else {
				size ++;
			}
		}
		
		return ans;
	}


}
