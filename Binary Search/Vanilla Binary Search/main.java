import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int binarySearch(List<Integer> arr, int target) {
        
        if (arr == null || arr.size() ==0) return -1;
        
        int left =0; 
        int right = arr.size()-1;
        
        while(left <= right) {
             int mid = left + (right -left)/2;
            if (arr.get(mid) == target) return mid;
            else if (arr.get(mid) < target) {
                left = mid+1;
            }else  {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = binarySearch(arr, target);
        System.out.println(res);
    }
}
