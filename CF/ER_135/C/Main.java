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
            String[] as = br.readLine().split(" ");
            String[] bs = br.readLine().split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for( int i = 0 ;i < n; i++){
                Integer c = map.get(as[i]);
                if(c == null) c = 0;
                c++;
                map.put(as[i], c);
            }
            List<String> bl = new ArrayList<>();
            for( int i = 0; i < n; i++){
                Integer c = map.get(bs[i]);
                if(c != null && !c.equals(0)){
                    c--;
                    map.put(bs[i], c);
                }else{
                    bl.add(bs[i]);
                }
            }
            List<String> al = new ArrayList<>();
            for(String key : map.keySet()){
                Integer c = map.get(key);
                for( int i =0; i < c; i++){
                    al.add(key);
                }
            }

            int ans = 0;
            for( int i = 0; i < bl.size(); i++){
                String s = bl.get(i);
                if(s.length() > 1){
                    bl.set(i, "" + s.length());
                    ans++;
                }
            }

            for( int i = 0; i < al.size(); i++){
                String s = al.get(i);
                if(s.length() > 1){
                    al.set(i, "" + s.length());
                    ans++;
                }
            }

            map = new HashMap<>();
            for(String s : al){
                Integer c= map.get(s);
                if(c == null) c=0;
                c++;
                map.put(s, c);
            }
            for(String s : bl){
                Integer c = map.get(s);
                if(c != null && !c.equals(0)){
                    c--;
                    map.put(s, c);
                }else if(!s.equals("1")) ans++;
            }
            for(String s : map.keySet()){
                if(s.equals("1"))continue;
                ans+=map.get(s);
            }
            System.out.println(ans);
        }
    }
}
