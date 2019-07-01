import java.util.*;

public class VoteRigging {
	 public int minimumVotes(int[] votes) {
		 if (votes.length <= 1) {
			 return 0;	
		 }
		 
		 List<Integer> lst = new ArrayList<>();
		 for(int v : votes) {
			 lst.add(v);
		 }
		 
		 int n = lst.size();
		 int ans = 0;
		 List<Integer> list = lst.subList(1, n);
		 while (lst.get(0) <= Collections.max(list)) {
			 Collections.sort(list,Collections.reverseOrder());
			 lst.set(0, lst.get(0)+1);
			 lst.set(1, lst.get(1)-1);
			 ans ++;
		}
		return ans;

     }

}
