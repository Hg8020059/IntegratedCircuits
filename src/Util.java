import java.lang.Math;

public class Util {
    public static int toInt(Boolean val){
        return val ? 1 : 0;
    }

    //returns true if the number is anything other than 0
    public static boolean toBool(int val){
        return val != 0;
    }

    //Takes a number of inputs and generates an array of all the possible input combinations for that number of inputs
    public static int[][] testValues(int val){
        int numCombinations = (int) Math.pow(2,val);
        int[][] arr = new int[numCombinations][val];
        int pos = val - 1;

        for (int i = 0; i < numCombinations; i++) {
            for (int j = 0; j < val; j++) {
                arr[i][pos] = (i & (int) Math.pow(2,j)) >> j;
                pos--;
            }
            pos = val - 1;
        }
        return arr;
    }

    //Takes a given amount of inputs and an output, assumes that they are connected, then prints the output for all
    //possible combinations of inputs in the form of a truth table
    //This allows an easy way of seeing the truth table for any system, you just need to provide the inputs and outputs
    public static String truthTable(Input[] inputs, Wire output){
        String str = "";
        int numIn = inputs.length;

        //Start of print statements for debugging while working
        for (Input i : inputs) {
           System.out.println("Input: " + i.name);
        }
        System.out.println("Output: " + output.name);
        System.out.println("Number of Inputs: " + numIn);

        //End of print statements for debugging while working

        return str;
    }

    public static void main(String[] args){
        int[][] arr = testValues(3);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
