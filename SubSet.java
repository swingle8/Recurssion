import java.util.*;
public class SubSet {
    public static void main(String [] args) {
    	Scanner sc =  new Scanner(System.in);
    	int cases = sc.nextInt();
    	
    	while (cases --> 0) {
    		ArrayList<Integer> al = new ArrayList<Integer>();
			int n = sc.nextInt();
			for (int i = 0 ; i < n ; i ++) {
				al.add(sc.nextInt());
			}
			calculate (al, 0, "");
    	}
    }

    
         static void calculate (ArrayList<Integer> A, int index, String ans) {
            if (index == A.size()) {
                System.out.println(ans);	
                return;
            }
            
           calculate (A, index+1, ans);
           int num = A.get(index);
           //ans.add(num);
           calculate (A, index+1, ans+num);
			            
        }

}
