import java.util.*;

public class FriendScore {
	Map<Integer,Set<Integer>> myGraph;
	 public Map<Integer, Set<Integer>> makeGraph(String[] friends) {
	        myGraph = new HashMap<>();
	        for (int i=0; i < friends.length; i++) {
	            Set<Integer> mySet = new HashSet<>();
	            for (int k = 0; k < friends[i].length(); k++) {
	                if (friends[i].charAt(k) == 'Y') {
	                    mySet.add(k);
	                }
	            }
	         System.out.println(mySet);

	         myGraph.putIfAbsent(i,mySet);
	        }
	        return myGraph;
	        
	    }
	private Set<Integer> getFriends(int index) {
        Set<Integer> set = new HashSet<>();
        set.addAll(myGraph.get(index));
        System.out.println(set);
        for(int friend : myGraph.get(index)) {
                   System.out.println(myGraph.get(friend));

            set.addAll(myGraph.get(friend));
           
        }
        set.remove(index);
        return set;
    }

	public int highestScore(String[] friends) {
	       makeGraph(friends);
	       int max = 0;
	       for (int k = 0; k < friends.length; k++) {
	           Set<Integer> set = getFriends(k);
	          max = Math.max(set.size(), max);
	       }
	        return max;

	        
	     }

}
