import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases -- > 0) {
            String s = sc.next();
            ArrayList<String> ans = new ArrayList<String>();
            String curr= "";
            getPermutations(s, 0, ans);
            
            for (String sAns : ans)
                System.out.print(sAns + " ");
            System.out.println();
        }
	}
	
	public static ArrayList<String> getPermutations (String s, int i, ArrayList<String> ans) {
	     if (i == s.length()-1) {
	         ans.add(s);
	         return ans;
	     }
	     
	      for (int j = i ; j < s.length() ; j++) {
	         s = swap (s, i, j);
	         i++;
	         getPermutations (s, i, ans);
	         i--;
	         s = swap(s, i, j);
	      }
            
        return ans;	     
	}
	
	public static String swap (String s, int i, int j) {
	    if (i >= s.length() || j >= s.length())
	        return s;
	    
	    StringBuffer sb = new StringBuffer(s);
	    sb.insert(i, s.charAt(j));
	    sb.deleteCharAt(i+1);
	    sb.insert(j, s.charAt(i));
	    sb.deleteCharAt(j+1);
	    
	    return sb.toString();
	}
}