import java.util.*;

public class ErdosNumber {
	TreeSet<String> myAuthors;
	
	private TreeSet<String> getCoAuthors(String author, String[] pubs){
		TreeSet<String> set = new TreeSet<>();
		for(String s : pubs) {
			Set<String> names = new TreeSet<>(Arrays.asList(s.split(" ")));
			if (names.contains(author)) {
				names.retainAll(myAuthors);
				set.addAll(names);
			}
		}
		set.remove(author); // I didn't write with myself
		return set;
	}
	
	public String[] calculateNumbers(String[] pubs) {
		
		myAuthors = new TreeSet<>();
		for(String s : pubs) {
			myAuthors.addAll(Arrays.asList(s.split(" ")));
		}
		
		TreeMap<String,Integer> map = new TreeMap<>();
		map.put("ERDOS", 0);
		myAuthors.remove("ERDOS");
		for(String s : myAuthors) map.put(s, -1);
		
		// INVARIANT: any author NOT in myAuthors has had distance from ERDOS
		// determined already and in map
		// REWORDED: all authors in myAuthors yet to have distance determined
		
		TreeSet<String> current = new TreeSet<>();
		current.add("ERDOS");
		
		int distance = 1;
		while (myAuthors.size() > 0) {
			TreeSet<String> nextCoAuthors
			= new TreeSet<>();
			for(String s : current) {
				nextCoAuthors.addAll(getCoAuthors(s, pubs));
			}
			
			if (nextCoAuthors.size() == 0) break; // no co-authors, done
			
			for(String s : nextCoAuthors) {
				map.put(s, distance);
			}
			
			myAuthors.removeAll(nextCoAuthors); // re-establish invariant
			current = nextCoAuthors;
			distance += 1;
		}
	
		ArrayList<String> result = new ArrayList<>();
		for(String s : map.keySet()) {
			String num = "";
			if (map.get(s) != -1) num = " "+map.get(s);
			result.add(s + num);
		}
		return result.toArray(new String[0]);
	}


}
