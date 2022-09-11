package aueb.projects.p09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project09 {
    
    public static void main(String[] args) {
        final int key = 300;
        Scanner input = new Scanner(System.in);
        boolean bool = printMenu(input);
        System.out.printf("Διαλέξατε%sρυπτογράφηση\nΕισάγετε το ", bool? " Κ" : " Αποκ");

        input.nextLine();
        if (bool){
            System.out.println("Δώστε το μήνυμα προς κρυπτογράφηση: ");
            String message = input.nextLine();
            StringBuilder mess = new StringBuilder(message);
            ArrayList<Integer> ciphed = new ArrayList<Integer>(encrypt(mess, key));
            System.out.printf("\n\nΚρυπτογραφημένο μήνυμα:\n");
            System.out.println(ciphed);
            
        }
        else{
            System.out.println("Δώστε το σύνθημα προς αποκρυπτογράφηση: ");
            String temp = input.nextLine();
            List<String> secretMessage =  new ArrayList<String>(Arrays.asList(temp.split(" +")));
            ArrayList<Integer> secret = new ArrayList<Integer>();
            
            for (String string : secretMessage) {
                secret.add(Integer.parseInt(string.trim()));
            }

            StringBuilder decicphed = new StringBuilder(decrypt(secret, key));
            System.out.printf("\n\nΑποκρυπτογραφημένο μήνυμα:\n");
            System.out.println(decicphed);
        }
        
    }

    public static boolean printMenu (Scanner in){
        System.out.println("Διαλέξτε μια επιλογή(1-2): ");
        System.out.println("1.Κρυπτογράφηση");
        System.out.println("2.Αποκρυπτογράφηση");

        return (in.nextInt()==1);
    }

    public static ArrayList<Integer> encrypt (StringBuilder sb, int k){
        ArrayList<Integer> ciph = new ArrayList<Integer>();
        int mod = 0;
        sb.append("#");
        ciph.add((int)(sb.charAt(0)));

        for (int i = 1; sb.charAt(i)!='#' ; i++){
            ciph.add((int)(sb.charAt(i)));
            mod = (ciph.get(i) + ciph.get(i-1)) % k;
            ciph.set(i,mod);
        }

        ciph.add(-1);

        return ciph;
    }

    public static StringBuilder decrypt (ArrayList<Integer> arr, int k){

        StringBuilder dec = new StringBuilder();
        char demod = (char)((int)arr.get(0));
        arr.add(-1);
        dec.append(demod);

        for (int i = 1; arr.get(i)!=-1; i++){
            demod = (char) (k + arr.get(i) - arr.get(i-1));
            while (demod > k) demod -= k;
            dec.append(demod);
        }

        dec.append("#");
        return dec;

    }
}
