package aueb.projects.p01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Project01 {
    public static void main(String[] args) throws FileNotFoundException {

        String ValuesFile = ".\\src\\main\\java\\aueb\\projects\\p01\\";
        

        try(
            PrintStream in = new PrintStream(new FileOutputStream(ValuesFile + "values.txt",true),true);
            Scanner don = new Scanner(new FileReader(ValuesFile + "values.txt"));
            PrintStream result = new PrintStream(new FileOutputStream(ValuesFile + "kataliksi.txt",true),true);)
        {
            ArrayList<Integer> numArr = new ArrayList<Integer>();
            int num;
            int count = (int) ((Math.random()*43)) + 6;


            for (int i = 0; i < count; i++){
                in.print((int) ((Math.random()*48))+ 1 + " ");
            }
            in.print(-1);

            while ((num = don.nextInt()) != -1){
                numArr.add(num);
            }

            
            Collections.sort(numArr);
            combinatons(numArr, result);
            
            

        }
        catch(IOException e){
            e.printStackTrace();
        }
            

    }

    public static void combinatons (ArrayList<Integer> arr, PrintStream res){
        int[] hex = new int[6];
        int window = arr.size() - 6; 
        for (int i = 0; i <= window ; i++){
            for (int j = i+1; j <= window + 1; j++){
                for (int k = j+1; k <= window + 2; k++){
                    for (int l = k+1; l <= window + 3; l++){
                        for (int o = l+1; o <= window + 4; o++){
                            for (int f = o+1; f <= window + 5; f++){
                                
                                hex[0] = arr.get(i);
                                hex[1] = arr.get(j);
                                hex[2] = arr.get(k);
                                hex[3] = arr.get(l);
                                hex[4] = arr.get(o);
                                hex[5] = arr.get(f);
                                if (isEven(hex) || isOdd(hex) || isContiguous(hex) || isSameEnding(hex) || isSameTen(hex)){
                                    continue;
                                }
                                else{
                                    // System.out.printf("%d %d %d %d %d %d ",arr.get(i),arr.get(j),arr.get(k),arr.get(l),arr.get(o),arr.get(f));
                                    // System.out.println();
                                    res.printf("%d %d %d %d %d %d \n",arr.get(i),arr.get(j),arr.get(k),arr.get(l),arr.get(o),arr.get(f));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isEven(int[] arr){
        int count = 0;
        for (int i : arr) {
            if (i % 2 == 0){
                count++;
            }
        }
        return count > 4;
    }

    public static boolean isOdd(int[] arr){
        int count = 0;
        for (int i : arr) {
            if (i % 2 != 0){
                count++;
            }
        }
        return count > 4;
    }

    public static boolean isContiguous(int[] arr){
        for (int i = 2; i < arr.length -1; i++){
            if (arr[i] == arr[i-1] && arr[i-1] == arr[i-2]) return true;
        }
        return false;
    }

    public static boolean isSameEnding(int[] arr){
       int count = 0;
       for (int i = 2; i < arr.length-1; i++){
            if (arr[i] == arr[i+1]) count++;
       }
       return count == 3; 
    }

    public static boolean isSameTen(int[] arr){
        int res = 0;
        int[] tens = new int [5];
        for (int i = 0; i < arr.length; i++){
             res = arr[i] / 10;
             tens[res] ++;
        }
        for (int i : tens) {
            if (i > 3) return true;
        }
        return false;
        
     }




  


}
