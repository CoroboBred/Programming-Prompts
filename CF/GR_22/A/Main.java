import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < tests; tc++) {
            int n = Integer.parseInt(br.readLine());
            long[] a = new long[n];
            long[] b= new long[n];
            input = br.readLine().split(" ");
            for( int i = 0; i < n; i++) a[i] = Long.parseLong(input[i]);
            input = br.readLine().split(" ");
            for( int i = 0; i < n; i++) b[i] = Long.parseLong(input[i]);

            List<Long> fire = new ArrayList<>();
            List<Long> frost = new ArrayList<>();
            for( int i = 0; i < n; i++){
                if(a[i] == 0) fire.add(b[i]);
                else frost.add(b[i]);
            }
            Collections.sort(fire);
            Collections.sort(frost);

            long fireFirst = calc(fire, frost);
            long frostFirst = calc(frost, fire);
            sb.append(Math.max(fireFirst, frostFirst)).append('\n');
            
        }
        System.out.print(sb);
    }

    private static long calc(List<Long> fire, List<Long> frost){
        List<Long> l = new ArrayList<>();
        List<Boolean> isFire = new ArrayList<>();

        int j = frost.size()-1;
        for(int i = fire.size() -1; i >= 0; i--){
            l.add(fire.get(i));
            isFire.add(true);
            if(j != -1){
                l.add(frost.get(j));
                isFire.add(false);
                j--;
            }
        }

        for(; j != -1; j--){
            l.add(frost.get(j));
            isFire.add(false);
        }

        long sum = 0;
        for( int i = 0; i < l.size(); i++){
            sum += l.get(i);
            if(i +1 != l.size() && isFire.get(i+1) != isFire.get(i)) sum += l.get(i);
        }
        return sum;
    }
}
