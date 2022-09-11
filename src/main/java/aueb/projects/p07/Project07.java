package aueb.projects.p07;

import java.util.Arrays;

public class Project07 {
    public static void main(String[] args) {
        int[][] numarray = {{4, 5, 6},{13, 14, 75},{5,42,12},{12,53,88},{1,3,4}};
        int[][] shallowcopy = shallowCopy(numarray);
        int[][] deepcopy = deepCopy(numarray);

        System.out.println("===== ΑΡΧΙΚΟΣ ΠΙΝΑΚΑΣ ====");
        arrayPrinter(numarray);

        System.out.println("===== ΠΙΝΑΚΑΣ SHALLOWCOPY ====");
        arrayPrinter(shallowcopy);

        shallowcopy[1][2] = 3; //Αλλαγή τιμής πίνακα  Shallowcopy

        System.out.println("===== ΑΡΧΙΚΟΣ ΠΙΝΑΚΑΣ ΜΕΤΑ ΑΠΟ ΑΛΛΑΓΗ ΤΙΜΗΣ ΣΤΟ SHALLOWCOPY  ====");
        arrayPrinter(numarray);
        
        shallowcopy[1][2] = 75; //Αλλαγή τιμής πίνακα  Shallowcopy στην κανονική της τιμή

        System.out.println("===== ΑΡΧΙΚΟΣ ΠΙΝΑΚΑΣ ====");
        arrayPrinter(numarray);

        System.out.println("===== ΠΙΝΑΚΑΣ DEEPCOPY ====");
        arrayPrinter(deepcopy);

        deepcopy[3][0] = 1; //Αλλαγή τιμής πίνακα Deepcopy

        System.out.println("===== ΑΡΧΙΚΟΣ ΠΙΝΑΚΑΣ ΜΕΤΑ ΑΠΟ ΑΛΛΑΓΗ ΤΙΜΗΣ ΣΤΟ DEEPCOPY  ====");
        arrayPrinter(numarray);

        System.out.println("===== ΠΙΝΑΚΑΣ DEEPCOPY ΜΕΤΑ ΤΗΝ ΑΛΛΑΓΗ ΤΙΜΗΣ ====");
        arrayPrinter(deepcopy);




    }

    public static int[][] shallowCopy(int[][] arr){
        return Arrays.copyOf(arr, arr.length);
    }

    public static int[][] deepCopy(int[][] arr){
        int[][] ripoff = new int [arr.length][arr[0].length]; 

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                ripoff[i][j] = arr[i][j];
            }
        }

        return ripoff;
    }

    public static void arrayPrinter(int[][]arr){
        for (int[] row : arr) {
            System.out.printf("[");
            for (int num : row) {
                System.out.printf(" %d ",num);
            }
            System.out.printf("]\n");
        }
    }
}
