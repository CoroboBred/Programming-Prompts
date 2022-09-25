import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            input = br.readLine().split(" ");
            int max = 0;
            int index = -1;
            for( int i = 0; i < n; i++){
                int c = Integer.parseInt(input[i]);
                if(c > max){
                    max = c;
                    index = i+1;
                }
            }
            System.out.println(index);
        }
    }
}
