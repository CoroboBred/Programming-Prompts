import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        ArrayList<Long> bits = new ArrayList<>();
        for( long i = 1; i < (2L<< 60); i = i << 1){
            if((i & n) != 0)bits.add(i);
        }
        recurse(0, 0, bits);
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < ans.size();i ++){
            sb.append(ans.get(i)).append('\n');
        }
        System.out.print(sb);
    }


    static List<Long> ans = new ArrayList<>();
    public static void recurse(long num ,int i, List<Long> bits){
        if(i == bits.size()){
            ans.add(num);
            return;
        }

        recurse(num | bits.get(i), i+1, bits);
        recurse(num, i+1, bits);
    }
}
