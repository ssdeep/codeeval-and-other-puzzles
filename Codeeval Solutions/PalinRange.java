/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palinrange;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author esamsai
 */
public class PalinRange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner sc = new Scanner(new File(args[0]));
        
        while(sc.hasNext()){
            String[] inputs = sc.nextLine().split(" ");
            int LR = Integer.parseInt(inputs[0]);
            int RR = Integer.parseInt(inputs[1]);
           // System.out.println("Calling "+LR+":"+RR);
            System.out.println(numRanges(LR, RR));
        }
        
    }
    private static boolean isPalin(int num){
        String s = ""+num;
        
        if(s.length() == 1)
            return true;
        
        char[] carray = s.toCharArray();
        int lastin = carray.length - 1;
        for(int i = 0 ; i <= carray.length/2 ; i++){
            if(carray[i] != carray[lastin - i]){
                return false;
            }
        }
        
        return true;
        
    }

    private static int numRanges(int LR, int RR) {
        /*
         the array indices start from LR to RR
        */
        int[] countArray = new int[RR - LR + 2];
        
        /*
        build the count array so that you count up all the palindromes upto LR+i-1
        */
        for(int i = 1; i < countArray.length ; i++){
           // System.out.println(LR+i-1);
            if(isPalin(LR+i-1))
                countArray[i]=1;
            countArray[i] = countArray[i] + countArray[i - 1];
        }
    
        
        /*
        now the good ranges from LR to i
        */
       // int[] goodRanges = new int[countArray.length];
        int good = 0;
        for(int i = 1; i < countArray.length ; i++){
            for(int j=i ; j>=1 ; j--){
                /*
                total palins between [j,i]
                */
                int palinij = countArray[i] - countArray[j - 1];
                
                if(palinij%2 == 0){
                    //System.out.println("Good Range "+ (LR+j-1)+" and "+(LR+i-1));
                    good++;
                }
            }
        }
    return good;
    }
    
}
