import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < tests; tc++) {
            int n = Integer.parseInt(br.readLine());
        
            input = br.readLine().split(" ");
            int[] a = new int[n];
            int[] b = new int[n];
            for( int i = 0; i < n; i++) a[i] = Integer.parseInt(input[i]);
            input = br.readLine().split(" ");
            for( int i = 0; i < n; i++) b[i] = Integer.parseInt(input[i]);

            int[] max = new int[n];
            int[] min = new int[n];
            for(int i = 0; i < n; i++){
                int l = 0;
                int r = i;
                while(r-l >1){
                    int m = (l+r)/2;
                    if(b[m] > a[i]){
                        r = m;
                    }else if(b[m] < a[i]){
                        l = m+1;
                    }else{
                        l = m;
                    }
                }
                min[i] = b[l] >= a[i] ? b[l] -a[i]: b[r] - a[i];

                l = i;
                r = n-1;
                while(r-l >1){
                    int m = (l+r)/2;
                    if(a[m] <= b[i]){
                        l = m;
                    }else if(a[m] > b[i]){
                        r = m-1;
                    }
                }
                max[i]= a[r] <= b[i] ? b[r] - a[i]: b[l] - a[i];
            }
            for( int i = 0; i < n;i ++){
                sb.append(min[i]);
                if(i != n-1)
                sb.append(" ");
            }
            sb.append("\n");
            for( int i = 0; i < n; i++){
                sb.append(max[i]);
                if(i != n-1)
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
