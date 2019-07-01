import java.util.*;

public class OlympicCandles {
	public int numberOfNights(int[] candles){
		List<Integer> lst = new ArrayList<>();
		for(int k : candles) { 
			lst.add(k); 
		}
		Collections.sort(lst,Comparator.reverseOrder());	
		int ans = 1;
		boolean comp = true;
		while (comp == true) {
			
			for(int k=0; k < ans; k++) {
				lst.set(k, lst.get(k)-1);
			}
			Collections.sort(lst,Comparator.reverseOrder());	
			if (ans == lst.size()) {
				return ans;
			}	
			if (lst.get(ans) == 0) {
				return ans;
			}
			ans += 1;
		}
	return 0;
	}


}
