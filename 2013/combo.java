import java.util.*;
import java.io.*;

public class combo{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("1.in"));
        int n = sc.nextInt();
        int[] fj = new int[3];
        int[] master = new int[3];
        int count = 0;
        for(int i = 0; i < 3; i++){
            fj[i] = sc.nextInt();
        }
        for(int i = 0; i < 3; i++){
            master[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(lock(n, i, j, k, fj) || lock(n, i, j, k, master)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }
    private static boolean lock(int n, int c1, int c2, int c3, int[] combo){
        return ((Math.abs(c1-combo[0]) <= 2 || Math.abs(c1-combo[0]) >= n-2)
            && (Math.abs(c2-combo[1]) <= 2 || Math.abs(c2-combo[1]) >= n-2)
            && (Math.abs(c3-combo[2]) <= 2 || Math.abs(c3-combo[2]) >= n-2));
    }
}

