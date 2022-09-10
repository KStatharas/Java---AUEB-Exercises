package aueb.projects.p04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Project04 {
    public static void main(String[] args) {
        ArrayList <ArrayList<Integer>> cars = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        TreeMap <Integer,Integer> car = new TreeMap<Integer,Integer>();
        List <Integer> values = new ArrayList<Integer>();

        int counter = 0;
        Random rand = new Random();
        int randomEntries = (rand.nextInt(9)+1)*2;

        for (int i = 0; i < randomEntries; i++){
            car.put((int)(Math.random()*2400),0);
        }
        car.put(car.firstKey(), 1);
        car.put(car.lastKey(), 0);

        int mid = car.size()-2; 

        for (int i = 0; i < mid/2; i++) values.add(1);
        for (int j = (mid/2); j <= mid; j++) values.add(0);
      
        Collections.shuffle(values);
        
        
        int vCount = 0;
        

        for (Map.Entry<Integer,Integer> en : car.entrySet()) {
          
            if(en.getKey()!=car.firstKey() && en.getKey()!=car.lastKey()){
                car.replace(en.getKey(), values.get(vCount));
                vCount++;
            
            }
            
        }

        int carCounter = 0;
        int maxCars = 0;
        for (Map.Entry<Integer,Integer> entry : car.entrySet()) {
            if (entry.getValue() == 1){
                carCounter++;
                if (maxCars < carCounter) maxCars++;
            }
            else if(carCounter!=0) carCounter--;

            
        }
        System.out.println("===== ΠΙΝΑΚΑΣ ΑΦΙΞΕΩΝ/ΑΝΑΧΩΡΗΣΕΩΝ ====");
        System.out.println(car);

        System.out.println("O μέγιστος αριθμός των σταθμευμένων αυτοκινήτων είναι " + maxCars);
      
    }
}
