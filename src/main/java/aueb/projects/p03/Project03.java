package aueb.projects.p03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Project03 {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> charTable = new HashMap<String, Integer>();
        String ch;
        int newlineCounter = 0;
        String line;

        String ValuesFile = ".\\src\\main\\java\\aueb\\projects\\p03\\";

        try(FileInputStream fis = new FileInputStream(ValuesFile + "chars.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader chars = new BufferedReader(isr);) 
        {

            while(chars.ready()){
                line = chars.readLine();
                newlineCounter++;

                for (int i = 0; i < line.length(); i++){
                    ch = String.valueOf(line.charAt(i));
                    if (ch.isBlank()) ch = "[space]";

                    if (charTable.containsKey(ch))
                        charTable.put(ch, charTable.get(ch)+1);
                    
                    else
                            charTable.put(ch, 1);
                }
            }
            charTable.put("[\\n]",newlineCounter);
            System.out.println("==== SORTED BY KEY ====");
            System.out.println(charTable.entrySet());

            LinkedHashMap <String, Integer> sortedMap = new LinkedHashMap<>();
            ArrayList<Integer> list = new ArrayList<>();

            for (Map.Entry <String, Integer> entry : charTable.entrySet()) {
                list.add(entry.getValue());
            }

            Collections.sort(list);

            for (int i : list) {
                for (Entry <String,Integer> en : charTable.entrySet()) {
                    if (en.getValue().equals(i))
                        sortedMap.put(en.getKey(), i);
                }
            }

            System.out.println("\n==== SORTED BY VALUE ====");
            System.out.println(sortedMap.entrySet());

            // NavigableMap dmap = charTable.descendingMap();
            // SortedSet<String> keys = new TreeSet<>(charTable.keySet());
            // for (String key : keys) { 
            // String value = charTable.get(key);
            // // do something
            // }
                
            // System.out.println(dmap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
