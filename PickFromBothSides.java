/* QUESTION:
Given an integer array A of size N.
You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.
Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then
You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc. you need to return the maximum possible sum of elements you can pick.
*/

// BRUTE FORCE: Does not work for large input values. Error-> Time Limit exceeded. 

// import java.util.*;
// public class PickFromBothSides {
//     public static void main(String[] args) {
//          Scanner sc = new Scanner(System.in);

//         System.out.print("Enter the number of elements in the list A: ");
//         int n = sc.nextInt();

//         ArrayList<Integer> A = new ArrayList<>();
//         System.out.println("Enter " + n + " integers:");
//         for (int i = 0; i < n; i++) {
//             A.add(sc.nextInt());
//         }

//         System.out.print("Enter the number of elements to pick (B): ");
//         int B = sc.nextInt();

//         PickFromBothSides sol = new PickFromBothSides();
//         int result = sol.solve(A, B);

//         System.out.println("Maximum sum of " + B + " picked elements: " + result);

//         sc.close();
//     }
//     public int solve(ArrayList<Integer> A, int B) {
//         int cs , ms = Integer.MIN_VALUE;
//         int N = A.size();
        
//         for(int k = 0; k<=B ; k++)
//         {
//             cs=0;
//             for(int i = 0; i<k ; i++)
//             {
//                 cs += A.get(i);
//             }
//             for(int i = 0; i<(B-k) ; i++)
//             {
//                 cs += A.get(N-1-i);
//             }
//             ms = Math.max(cs,ms);
//         }
       
//         return ms;
//     }
// }

// OPTIMIZED:
import java.util.*;
public class PickFromBothSides {
        public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the list A: ");
        int n = sc.nextInt();

        ArrayList<Integer> A = new ArrayList<>();
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }

        System.out.print("Enter the number of elements to pick (B): ");
        int B = sc.nextInt();

        PickFromBothSides sol = new PickFromBothSides();
        int result = sol.solve(A, B);

        System.out.println("Maximum sum of " + B + " picked elements: " + result);

        sc.close();
    }
    public int solve(ArrayList<Integer> A, int B) {
        int cs = 0 , ms = Integer.MIN_VALUE;
        int N = A.size();
        
        for(int i = 0; i<B ; i++)
        {
           cs += A.get(i); 
        }
        
        ms = cs;
        
        for(int i = 1; i<=B ; i++)
        {
            cs = cs - A.get(B-i) + A.get(N-i);
            ms = Math.max(cs,ms);
        }
       
        return ms;
    }
}
