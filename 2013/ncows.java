import java.util.*;
import java.io.*;

public class ncows{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("1.in"));
        int n = sc.nextInt(); //total cows
        int x = sc.nextInt(); //cold
        int y = sc.nextInt(); //comfy
        int z = sc.nextInt(); //hot
        int max = n*x;
        int curr = n*x;
        int[] temp_low = new int[n];
        int[] temp_high =  new int[n];
        for(int i = 0; i < n; i++){
            temp_low[i] = sc.nextInt();
            temp_high[i] = sc.nextInt();
        }
        Arrays.sort(temp_low);
        Arrays.sort(temp_high);
        int i = 0, j = 0;
        while (i < n && j < n){
            if(temp_low[i] <= temp_high[j]){
                curr += y-x;
                i++;
            } else {
                curr += z-y;
                j++;
            }
            max = Math.max(curr, max);
        }
        System.out.println(max);
    }
}

