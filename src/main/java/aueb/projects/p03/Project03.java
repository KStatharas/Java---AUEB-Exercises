package aueb.projects.p03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Project03 {
    public static void main(String[] args) throws IOException {

        Map<Character, Integer> charTable = new HashMap<Character, Integer>();
        char character;

        String ValuesFile = ".\\src\\main\\java\\aueb\\projects\\p03\\";

        try(BufferedReader chars = new BufferedReader(new FileReader(ValuesFile + "chars.txt"));) 
        {
            while(chars.ready()){
                character = (char)(chars.read());
                System.out.printf("%c ",character);
                if (charTable.containsKey(character)){
                    charTable.put(character, charTable.get(character)+1);
                }
                else{
                    charTable.put(character, 1);
                }
            }

            System.out.println(charTable.entrySet());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
