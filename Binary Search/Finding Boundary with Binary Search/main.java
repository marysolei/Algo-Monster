/* An array of boolean values is divided into two sections; the left section consists of all false and the right section consists of all true. Find the boundary of the right section, i.e. the index of the first true element. If there is no true element, return -1.

Input: arr = [false, false, true, true, true]

Output: 2

Explanation: first true's index is 2. */

import java.io.IOException;
import java.util.Scanner;

class Solution {

    public static int findBoundary(boolean[] arr) {
        //check edge cases 
        if (arr == null || arr.length ==0) return -1;
        int index = arr.length ;
        int left = 0; 
        int right= arr.length -1;
        while (left <= right) {
            int mid = left + (right -left)/2;
            if (arr[mid] == true && mid < index) {
                index = mid; 
                right = mid-1; 
            }else {
                left = mid+1;
            }
        
        }
        if (index == arr.length) index = -1;
       return index; 
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        scanner.close();
        boolean[] arr = new boolean[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = input[i].equals("true");
        }
        System.out.println(findBoundary(arr));
    }

}
