package rough;

import java.io.*;
import java.util.Scanner;
public class Test {
    public static void main(String args[] ) throws Exception {
    	Scanner stdin = new Scanner(System.in);
    	String[] lines = null;
    	int j=0;
        while(stdin.hasNextLine())
        {
            lines[j++] = stdin.nextLine();
        }
        int N = Integer.parseInt(lines[0]);
        String[] tokens = lines[1].split(" ");
        int[] AP = new int[tokens.length];
        for(int i=0;i<tokens.length;i++){
            AP[i] = Integer.parseInt(tokens[i]);
        }
        int num = -1;

       int[] diff = new int[AP.length-1];
       for(int i=1;i<AP.length-1;i++){
           diff[i-1] = AP[i]-AP[i-1];
           if(i>1){
               if(diff[i]>diff[i-1]){
                   num = AP[i-1]+((AP[i]-AP[i-1])/2);
                   break;
               }else if(i==AP.length-2 && num == -1){
                   num = AP[i]+((AP[i]-AP[i-1])/2);
               }
           }
       }
        System.out.println(num);
    }
}