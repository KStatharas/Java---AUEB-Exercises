package aueb.projects.p06;

import java.util.ArrayList;
import java.util.Collections;

public class Project06 {
    public static void main(String[] args) {
        int[] kadane = new int [10];
        int [] localMax = new int [kadane.length];
        ArrayList <Integer> maxSubArray = new ArrayList<Integer>(); 
        int globalMaximum = 0;
        int indexofMax = 0;
        int totalSum =0;

        System.out.println("=== ΠΙΝΑΚΑΣ ΤΙΜΩΝ ===");
        for (int i = 0; i < kadane.length; i++){
            kadane[i] = (int) ((Math.random() < 0.5 ? -1 : 1)*(int)Math.ceil(Math.random()*11));
            System.out.printf("%d " ,kadane[i]);
        }
        System.out.println();

        for (int i = 0; i < kadane.length; i++){         //Αυτό το for είναι το μοναδικό που
            if                                           // χρησιμοποιείται για τον υπολογισμό των sums με βάση τον αλγόριθμο του Kadane.
                (i==0) localMax[i] = kadane[i];          //Τα υπόλοιπα είναι κυρίως για την εμφάνιση πινάκων.
            else
                localMax[i] = Math.max(kadane[i], kadane[i] + localMax[i-1]);
            
        }
        
        System.out.println("==== ΠΙΝΑΚΑΣ ΤΩΝ LOCAL MAX ==="); 

        for (int i = 0; i < localMax.length; i++){
            System.out.printf("%d ",localMax[i]);
            if (globalMaximum < localMax[i]) globalMaximum = localMax[i];
        }

        for (int i = 0; i < localMax.length; i++){
            if (localMax[i]== globalMaximum){
                indexofMax = i;
            } 
        }

        while (totalSum < globalMaximum){
            maxSubArray.add(kadane[indexofMax]);
            totalSum += kadane[indexofMax];
            indexofMax--;
        }
        Collections.reverse(maxSubArray);

        System.out.printf("\n\n");
        System.out.println("Το συνολικό μέγιστο είναι " + globalMaximum);
        System.out.println("Ο υποπίνακας του συνολικού μέγιστου είναι:");
        System.out.println(maxSubArray);



    }
    
}
