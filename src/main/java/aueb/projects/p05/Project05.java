package aueb.projects.p05;

public class Project05 {
    public static void main(String[] args) {
        int[] array = {0,1,1,2,3,5,6,6,6,7,7,7,7,7,8,8,9};
        int theKey = 7;

        int [] indexes = getLowAndHighIndexOf(array, theKey);
        if (indexes[0]==0 && indexes[1] ==0 )
            System.out.println("The key's index was not found");
        else 
            System.out.println("Lowest index of key is: " + indexes[0] + ".\nHighest index of key is " + indexes[1] + ".");
    }
    
    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int[] result = {0,0}; 
        int lowPoint = 0;
        int highPoint = arr.length-1;
        int givenNum = key; //Lowest/highest index of number to be found

        while ((lowPoint < highPoint) && ((arr[lowPoint]!=givenNum) || (arr[highPoint]!=givenNum))){
            if (arr[lowPoint]!=givenNum) lowPoint++;  
            if (arr[highPoint]!=givenNum) highPoint--; 
        }
        if (((lowPoint < highPoint) || (arr[lowPoint] == givenNum && arr[highPoint] == givenNum))){
            result[0] = lowPoint;
            result[1] = highPoint;
        }

        return result;
    }
}
