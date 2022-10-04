import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 5 2
// 7 10 =>    2 3
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < tests; tc++) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            long[] prefix = new long[k];
            input = br.readLine().split(" ");
            for (int i = 0; i < k; i++){
                prefix[i] = Integer.parseInt(input[i]);
            }


            long[] nums = new long[k-1];
            for( int i = 0; i < nums.length; i++){
                nums[i] = prefix[i+1] - prefix[i];
            }

            // check if given prefix is valid;
            boolean valid = true;
            for( int i = 0; i < nums.length-1;i++){
                if(nums[i] > nums[i+1]){
                    sb.append("No\n");
                    valid = false;
                    break;
                }
            }
            if(!valid) continue;
            // what if k == 1? 
            if(k == 1){
                sb.append("Yes\n");
                continue;
            }
            if(n == k){
                if(prefix[0] <= nums[0]) sb.append("Yes\n");
                else sb.append("No\n");
                continue;
            }

            if(prefix[0] <= 0){
                long m = nums[0] * (n-k);
                if(prefix[0] - m <= 0) sb.append("Yes\n");
                else sb.append("No\n");
                continue;
            }

            long m = nums[0] * (n-k);
            if(prefix[0] -m <= 0) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
    }
}
