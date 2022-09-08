package aueb.projects.p02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<String>> contacts = new ArrayList<ArrayList<String>>();
        int choice = 0;


        do{

            printMenu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    newContact(contacts, input);
                    break;
                case 2:
                    searchContact(contacts, input);
                    break;
                case 3:
                    updateContact(contacts, input);
                    break;
                case 4:
                    deleteContact(contacts, input);
                    break;
                case 5:
                    System.out.println("'Εξοδος προγράμματος.");
                    break;
                default:
                    System.out.println("Μη επιτρεπτή τιμή.");
                    break;
            }
        }while(choice!=5);



    }

    public static void printMenu () {
        System.out.printf("1) Εισαγωγή Επαφής\n2) Αναζήτηση Επαφής\n3) Ενημέρωση Επαφής\n4) Διαγραφή Επαφής\n5) Έξοδος\n\nΕπιλέξτε ενέργεια: ");
        
    }

    public static void newContact (ArrayList <ArrayList<String>> con, Scanner in) {
        System.out.printf("\n\n===== ΔΗΜΙΟΥΡΓΙΑ ΕΠΑΦΗΣ =====\n\n");
        System.out.println("Εισάγετε τηλέφωνο: ");
        String mob = in.next();
        if (!con.isEmpty()){
            for (ArrayList<String> row : con) {
                if (row.contains(mob)){ 
                    System.out.println("Αυτή η επαφή υπάρχει ήδη! Ακύρωση διαδικασίας.");
                    return;
                }
            }
        }
 
        System.out.println("Εισάγετε όνομα: ");
        String name = in.next();
        System.out.println("Εισάγετε επώνυμο: ");
        String surname = in.next();
        con.add(new ArrayList<String>(Arrays.asList(surname,name,mob)));
        System.out.printf("\n\n===== ΔΗΜΙΟΥΡΓΙΑ ΕΠΙΤΥΧΗΣ! =====\n\n");
    }

    public static void searchContact (ArrayList <ArrayList<String>> con, Scanner in){
        System.out.printf("\n\n=====  ΑΝΑΖΗΤΗΣΗ ΕΠΑΦΗΣ =====\n\n");
        System.out.println("Εισάγετε το τηλέφωνο της επαφής προς αναζήτηση: ");
        String num = in.next();
        if (!con.isEmpty()){
            for (ArrayList<String> row : con) {
                if (row.contains(num)){
                    System.out.printf("\n%-10s \n%-10s \n%-10s \n%-10s\n\n","Στοιχεία επαφής:",row.get(0),row.get(1),row.get(2));
                    return;
                }
            }
        }
        System.out.println("Αυτή η επαφή δεν υπάρχει.");
    }

    public static void updateContact (ArrayList <ArrayList<String>> con, Scanner in){
        System.out.printf("\n\n=====  ΕΝΗΜΕΡΩΣΗ ΕΠΑΦΗΣ =====\n\n");
        System.out.println("Εισάγετε το τηλέφωνο της επαφής προς ενημέρωση: ");
        String num = in.next();
        if (!con.isEmpty()){
            for (ArrayList<String> row : con)  {
                if (row.contains(num)){
                    System.out.printf("Εισάγετε τον αριθμό του στοιχείου που θέλετε να αλλάξετε: \n1) Επώνυμο\n2) Όνομα\n3) Τηλέφωνο\n\n");
                    int i = in.nextInt();
                    System.out.println("Εισάγετε την νέα τιμή: ");
                    row.set(i-1,in.next());
                    System.out.printf("\n\n=====  ΕΝΗΜΕΡΩΣΗ ΕΠΑΦΗΣ ΕΠΙΤΥΧΗΣ! =====\n\n");
                    return;
                }
            }
        }
        System.out.println("Αυτή η επαφή δεν υπάρχει.");
    }

    public static void deleteContact (ArrayList <ArrayList<String>> con, Scanner in){
        System.out.printf("\n\n=====  ΔΙΑΓΡΑΦΗ ΕΠΑΦΗΣ =====\n\n");
        System.out.println("Εισάγετε το τηλέφωνο της επαφής προς διαγραφή: ");
        String num = in.next();
        if (!con.isEmpty()){
            for (ArrayList<String> row : con) {
                if (row.contains(num)){
                    con.remove(row);
                    System.out.printf("\n\n=====  ΔΙΑΓΡΑΦΗ ΕΠΑΦΗΣ ΕΠΙΤΥΧΗΣ =====\n\n");
                    return;
                }
            }
        }
        System.out.println("Αυτή η επαφή δεν υπάρχει.");
    }
}
