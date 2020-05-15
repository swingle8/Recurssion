import java.util.*;
public class PermutationNonRepeated {
    public static void main(String [] args) {
    	Scanner sc =  new Scanner(System.in);
    	int cases = sc.nextInt();
    	
    	while (cases --> 0) {
    		ArrayList<Integer> al = new ArrayList<Integer>();
			int n = sc.nextInt();
			for (int i = 0 ; i < n ; i ++) {
				al.add(sc.nextInt());
			}
			
			calculate (al, 0);
    	}
    }

    
         static void calculate (ArrayList<Integer> A, int index) {
            if (index == A.size()-1) {
                System.out.println(A);
                return;
            }
            
            for (int i = index ; i < A.size() ; i ++) {
                Collections.swap(A, index, i);
                calculate (A, index+1); 
                Collections.swap(A, index, i);
            }
        }

}
