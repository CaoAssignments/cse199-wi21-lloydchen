import java.util.*;
import java.io.*;

public class diamonds{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("diamond.in"));
        PrintWriter w = new PrintWriter(new FileWriter("diamond.out"));

        int end = 0, max = 0;
        String[] pm = sc.nextLine().split("\\s+"); //n = pm[0], k = pm[1]
        int[] a = new int[Integer.parseInt(pm[0])];

        for (int i = 0; i < a.length; i++){ 
            a[i] = Integer.parseInt(sc.nextLine());
        }
        
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++){ 
            while(end < a.length){
                if(a[end]-a[i] <= Integer.parseInt(pm[1])){
                    max = Math.max(max, end-i+1);    
                    end++;
                }
                else{
                    i++;
                }
            }
            if(end >= a.length){
                break;
            }
        }
        w.println(max);
        w.close();
    }

}