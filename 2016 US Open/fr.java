import java.util.*;
import java.io.*;

class coord implements Comparable<coord>{
    public int x;
    public int y;

    public coord(int x, int y){
        this.x = x;
        this.y = y;
    }  
    public int compareTo(coord c){
        return this.x - c.x;
    }
    public boolean reverseEquals(coord c){
        return this.x == c.y && this.y == c.x;
    }
}

public class fr {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("reduce.in"));
        PrintWriter w = new PrintWriter(new FileWriter("reduce.out"));
        int one, two, three, four, n = Integer.parseInt(sc.nextLine());
        coord[] x_y = new coord[n];
        coord[] y_x = new coord[n];
        
        for(int i = 0; i < n; i++){
            String[] arr = sc.nextLine().split("\\s+");
            x_y[i] = new coord(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            y_x[i] = new coord(Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));

        }

        Arrays.sort(x_y);
        Arrays.sort(y_x);

        if(x_y[0].reverseEquals(y_x[0])){
            one = (x_y[n-1].x-x_y[1].x)*(y_x[n-1].x-y_x[1].x);
        }
        else if(x_y[0].reverseEquals(y_x[n-1])) {
            one = (x_y[n-1].x-x_y[1].x)*(y_x[n-2].x-y_x[0].x);
        }
        else{
            one = (x_y[n-1].x-x_y[1].x)*(y_x[n-1].x-y_x[0].x);
        }

        if(x_y[n-1].reverseEquals(y_x[0])){
            two = (x_y[n-2].x-x_y[0].x)*(y_x[n-1].x-y_x[1].x);
        }
        else if(x_y[n-1].reverseEquals(y_x[n-1])) {
            two = (x_y[n-2].x-x_y[0].x)*(y_x[n-2].x-y_x[0].x);
        }
        else{
            two = (x_y[n-2].x-x_y[0].x)*(y_x[n-1].x-y_x[0].x);
        }

        if(x_y[0].reverseEquals(y_x[0])){
            three = (x_y[n-1].x-x_y[1].x)*(y_x[n-1].x-y_x[1].x);
        }
        else if(x_y[n-1].reverseEquals(y_x[0])) {
            three = (x_y[n-2].x-x_y[0].x)*(y_x[n-1].x-y_x[1].x);
        }
        else{
            three = (x_y[n-1].x-x_y[0].x)*(y_x[n-1].x-y_x[1].x);
        }

        if(x_y[0].reverseEquals(y_x[n-1])){
            four = (x_y[n-1].x-x_y[1].x)*(y_x[n-2].x-y_x[0].x);
        }
        else if(x_y[n-1].reverseEquals(y_x[n-1])) {
            four = (x_y[n-2].x-x_y[0].x)*(y_x[n-2].x-y_x[0].x);
        }
        else{
            four = (x_y[n-1].x-x_y[0].x)*(y_x[n-2].x-y_x[0].x);
        }

        w.println(Collections.min(Arrays.asList(one, two, three, four)));
        w.close();
    }
}
