package accepted.Q131_Q140;

import java.util.HashSet;
import java.util.Set;

public class Q136 {

	public int singleNumber(int[] A) {
        Set<Integer> s = new HashSet<Integer>();
		
		for (int i = 0; i < A.length; i++) {
			if (s.contains(A[i])) {
				s.remove(A[i]);
			} else {
				s.add(A[i]);
			}
		}
		
		return (int) s.toArray()[0];
    }
	
}
