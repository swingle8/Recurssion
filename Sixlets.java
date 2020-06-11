// SIXLETS
// Problem Description
// 
// Given a array of integers A of size N and an integer B.
// 
// Return number of non-empty subsequences of A of size B having sum <= 1000.
// 
// 
// 
// Problem Constraints
// 1 <= N <= 20
// 
// 1 <= A[i] <= 1000
// 
// 1 <= B <= N
// 
// 
// 
// Input Format
// The first argument given is the integer array A.
// 
// The second argument given is the integer B.
// 
// 
// 
// Output Format
// Return number of subsequences of A of size B having sum <= 1000.
// 
// 
// 
// Example Input
// Input 1:
// 
//     A = [1, 2, 8]
//     B = 2
// Input 2:
// 
//     A = [5, 17, 1000, 11]
//     B = 4
// 
// 
// Example Output
// Output 1:
// 
// 3
// Output 2:
// 
// 0
// 
// 
// Example Explanation
// Explanation 1:
// 
//  {1, 2}, {1, 8}, {2, 8}
// Explanation 1:
// 
//  No valid subsequence

public class Solution {
    int count = 0;
    public int solve(ArrayList<Integer> A, int B) {
      count = 0;
      ArrayList<Integer> set = new ArrayList<Integer>();
      calculate (A, set, B, 0, 0);
      return count;
    }
    
    public void calculate (ArrayList<Integer> A, ArrayList<Integer> set, int B, int index, int sum) {
        if (sum > 1000)
            return;
        
        if (set.size() == B) {
            count++;
            return;
        }
        
        if (index == A.size())
            return;
        
    for (int i = index ; i < A.size() ; i++) {   
        int num = A.get(i);
        set.add(num);
        sum = sum + num;
        
        calculate (A, set, B, i+1, sum);
        
        set.remove(set.size()-1);
        sum = sum - num;
        
    }
        
    }
}
