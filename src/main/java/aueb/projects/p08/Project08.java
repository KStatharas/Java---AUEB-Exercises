package aueb.projects.p08;

import java.util.Arrays;
import java.util.Scanner;

public class Project08 {
    public static void main(String[] args) {
        char[][] triliza = { { '-', '-', '-' },
                { '-', '-', '-' },
                { '-', '-', '-' } };

        int posX = 0;
        int posY = 0;
        char play;
        boolean win = false;

        Scanner input = new Scanner(System.in);
        do {
            System.out.printf("Σειρά του %sου παίκτη", playerChecker(triliza) ? "2" : "1");

            do {

                trilizaPrinter(triliza);
                System.out.println("Διάλεξε θέση στον πίνακα (Δώσε δύο ακέραιους (1-3) ως συντεταγμένες): ");
                posX = input.nextInt();
                posY = input.nextInt();

            } while ((posX < 1 || posX > 3) || (posY < 1 || posY > 3));
            positioner(posX - 1, posY - 1, playerChecker(triliza), triliza);
            win = WinCondition(triliza);
        } while (!win);
        trilizaPrinter(triliza);

    }

    public static void trilizaPrinter(char[][] arr) {
        System.out.printf("\n=====");
        for (char[] row : arr) {
            System.out.println();
            for (char c : row) {
                System.out.printf("%c ", c);
            }

        }
        System.out.printf("\n=====\n");
        System.out.println();
    }

    public static boolean WinCondition(char[][] arr) {
        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            if ((arr[i][0] == arr[i][1]) && (arr[i][1] == arr[i][2])) {
                if (arr[i][0] == 'O') {
                    System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 2!");
                    return true;
                } else if (arr[i][0] == 'X') {
                    System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 1!");
                    return true;
                }
            }
            for (int j = 0; j < 3; j++) {
                if ((arr[0][j] == arr[1][j]) && (arr[1][j] == arr[2][j])) {
                    if (arr[0][j] == 'O') {
                        System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 2!");
                        return true;
                    } else if (arr[0][j] == 'X') {
                        System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 1!");
                        return true;
                    }
                }
            }
        }

        if (((arr[0][0]) == (arr[1][1])) && ((arr[1][1]) == (arr[2][2]))) {
            if (arr[1][1] == 'O') {
                System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 2!");
                return true;
            } else if (arr[1][1] == 'X') {
                System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 1!");
                return true;
            }
        }
        if (((arr[0][2]) == (arr[1][1])) && ((arr[1][1]) == (arr[2][0]))) {
            if (arr[1][1] == 'O') {
                System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 2!");
                return true;
            } else if (arr[1][1] == 'X') {
                System.out.println("ΝΙΚΗ ΠΑΙΚΤΗ 1!");
                return true;
            }
        }
        for (char[] row : arr) {
            for (char ch : row) {
                if (ch == '-') {
                    flag = false;
                }
            }
        }
        if (flag) System.out.println("ΙΣΟΠΑΛΙΑ!");
        return flag;
    }

    public static void positioner(int i, int j, boolean p2, char[][] arr) {
        char[][] array = Arrays.copyOf(arr, arr.length);

        if (array[i][j] == '-') {
            if (p2)
                array[i][j] = 'O';
            else
                array[i][j] = 'X';
        } else {
            System.out.println("Αυτή η θέση δεν είναι διαθέσιμη!");
        }

    }

    public static boolean playerChecker(char[][] arr) {
        int xCounter = 0;
        int oCounter = 0;

        for (char[] row : arr) {
            for (char ch : row) {
                if (ch == 'X')
                    xCounter++;
                if (ch == 'O')
                    oCounter++;
            }
        }
        return xCounter > oCounter;
    }
}
