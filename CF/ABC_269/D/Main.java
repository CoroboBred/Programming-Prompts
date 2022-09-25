import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        HashSet<String> blacks = new HashSet<>();
        for( int i = 0; i < n; i++){
            blacks.add(br.readLine());
        }

        int ans = 0;
        for( int i = -1000;i  <= 1000; i++){
            for( int j = -1000; j <= 1000; j++){
                String a = "" + i  + " " + j;
                if(blacks.contains(a)){
                    find(i, j , blacks, new HashSet<>());
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void find(int i , int j , HashSet<String> blacks, HashSet<String> seen){
        if(i < -1000 || i > 1000 | j < -1000 | j > 1000) return;
        String a = "" + i + " " + j;
        if(seen.contains(a)) return;
        if(!blacks.contains(a)) return;
        blacks.remove(a);
        seen.add(a);
        find(i-1, j-1, blacks, seen);
        find(i-1, j, blacks, seen);
        find(i, j-1, blacks, seen);
        find(i, j+1, blacks, seen);
        find(i+1, j, blacks, seen);
        find(i+1, j+1, blacks ,seen);

    }
}
