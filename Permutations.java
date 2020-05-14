import java.util.*;
public class Permutations {
    public static void main(String [] args) {
    	Scanner sc =  new Scanner(System.in);
    	int cases = sc.nextInt();
    	
    	while (cases --> 0) {
    		ArrayList<Integer> al = new ArrayList<Integer>();
			int n = sc.nextInt();
			for (int i = 0 ; i < n ; i ++) {
				al.add(sc.nextInt());
			}
			
			AllPermute(al, 0);
    	}
    }
    
    public static void AllPermute (ArrayList<Integer> A, int index) {
        if (index == A.size()-1) {
            System.out.println(A);
            return;
        }
        
        Set<Integer> s = new HashSet<Integer>();
        for (int i = index ; i < A.size() ; i ++) {
            int num = A.get(i);
            if (! s.contains(num)) {
                Collections.swap(A, index, i); 
                
                AllPermute(A, index+1);
                
                Collections.swap(A, i, index); 
                
                s.add(num);
            }
            
        }
    }
}
