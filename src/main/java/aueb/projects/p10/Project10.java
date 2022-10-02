package aueb.projects.p10;

import java.security.Signature;
import java.util.Scanner;

public class Project10 {
    public static void main(String[] args) {
        boolean[][] theater = new boolean[30][12];
        int select = 0;
        char col = ' ';
        int row = 0;
        Scanner input = new Scanner(System.in);
        do{
            select = Selector(input);
            if (select == 3) break;
            do{
                try{
                    System.out.println("Εισάγετε σειρά θέσης(1-30):");
                    row = input.nextInt();
                    System.out.println("Εισάγετε λωρίδα θέσης(A-L)");
                    col = input.next().toUpperCase().charAt(0);
                }
                catch(Exception e){
                    input.nextLine();
                    e.printStackTrace();
                    System.out.println();
                    if (row<1 || row>30 || col<65 || col>76) System.out.println("Αυτή η θέση δεν υπάρχει. Δοκιμάστε ξανά!");
                }
                if ((10%2)==0){
                    System.out.println("hi");
                }
                

            }while(row<1 || row>30 || col<65 || col>76);

            if (select==1) book(col, row-1, theater);
            else cancel(col, row-1, theater);
            


        }while(tryAgain(input));
        System.out.println("Έξοδος εφαρμογής.");
        


    }

    public static void book (char column, int row, boolean[][] arr ){
        if (isAvailable(column, row, arr)){
            arr[row][column - 65] = true;
            System.out.println("Επιτυχής κράτηση!");
        }     
        else System.out.println("Η θέση είναι πιασμένη!");
    }

    public static void cancel (char column, int row, boolean[][] arr){
        if (!isAvailable(column, row, arr)){
            arr[row][column - 65] = false;
            System.out.println("Επιτυχής ακύρωση κράτησης!");
        }
        else System.out.println("Η θέση δεν έχει κρατηθεί!");
    }

    public static boolean isAvailable (char c, int r, boolean[][] arr){
        return arr[r][c- 65] == false;
    }

    public static int Selector(Scanner in){
        
        System.out.println("Επιλέξτε αν θέλετε κράτηση ή ακύρωση κράτησης θέσης! (Εισάγετε 1 ή 2 ή 3): ");
        System.out.printf("\n1.Κράτηση θέσης\n2.Ακύρωση Κράτησης\n3.Έξοδος απο την εφαρμογή..\n");
        int choice = -1;

        while((choice!=1) && (choice!=2)&& (choice!=3)){
            try{
                
                choice = in.nextInt();
            }
            catch(Exception e){
                in.nextLine();
                e.printStackTrace();
                System.out.println();
                System.out.println("Μη έγκυρη τιμή, δοκιμάστε ξανά! (Εισάγετε 1 ή 2)");
                System.out.printf("\n1.Κράτηση θέσης\n2.Ακύρωση Κράτησης\n");
            }
            
        }
        
        

        return choice;
    }

    public static boolean tryAgain(Scanner in){
        System.out.println("Θέλετε να κάνετε νέα κράτηση/ακύρωση; (y/n)");
        char choice = in.next().toUpperCase().charAt(0);

        while (choice!='Y' && choice!='N'){
            System.out.println("Μη έγκυρη τιμή, δοκιμάστε ξανά! (Εισάγετε y ή n)");
            choice = in.next().toUpperCase().charAt(0);
        }
        
        return choice=='Y';
    }
}
