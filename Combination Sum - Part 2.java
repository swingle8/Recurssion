// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            int B = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            List<List<Integer>> result = new ArrayList<>();
            result = ob.combinationSum(A, N, B);
            if(result.size() == 0)
            System.out.println("Empty");
            else{
                for(int i = 0;i < result.size(); i++){
                    System.out.print("(");
                    for(int j = 0;j < result.get(i).size();j++){
                        System.out.print(result.get(i).get(j));
                        if(j != result.get(i).size() - 1)
                        System.out.print(" ");
                    }
                    System.out.print(")");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for java
class Solution
{
    static List<List<Integer>> combinationSum(int A[], int N, int B)
    {
       LinkedHashSet<List<Integer>> ans = new LinkedHashSet<List<Integer>>();
        ArrayList<Integer> currAns = new ArrayList<Integer>();
        Arrays.sort(A);
      for (int i = 0 ; i < A.length ; i ++) {
            int sum = A[i];   
            currAns.add(A[i]);
            getCombinations (A, i, B, sum, ans, currAns);
            currAns.remove(new Integer(A[i]));
      }
       return new ArrayList<List<Integer>>(ans);
    }
    
    static void getCombinations (int [] A, int i, int B, int sum, LinkedHashSet<List<Integer>> ans, ArrayList<Integer> currAns) {
       
        if (sum == B) {
            ArrayList<Integer> ans1 = new ArrayList<Integer>(currAns);
            ans.add(ans1);
        }
        if (sum > B)
            return;
        
        for (int k = i+1 ; k < A.length ; k++) {
            sum = sum + A[k];
            currAns.add(A[k]);
            getCombinations (A, k, B, sum, ans, currAns);
            currAns.remove(new Integer(A[k]));
            sum = sum - A[k];
        }
        
            
    }
}