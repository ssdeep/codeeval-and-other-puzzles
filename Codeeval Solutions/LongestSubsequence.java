/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestsubsequence;

import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author esamsai
 */
public class LongestSubsequence {
    private static int[] array;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] array = {20, -90, 4, -6, 3, 90, -10, -2, -10, 20,100};

        
        System.out.println("Largest contiguous sum:"+ lcsum(array));
        System.out.println("Longest increasing subsequence:" + lcseq(array));
        System.out.println("Longest palindromic subsequence:" + lpalin(array));
        ArrayList<Integer> alist = new ArrayList<Integer>();
        alist.add(1);
        alist.add(5);
        System.out.println(alist);
        
    }

    private static int lcsum(int[] array) {
       int endingHere = 0;
       int soFar = 0;
        
       for(int i = 0 ; i < array.length ; i++){
           endingHere = max(endingHere + array[i], 0);
           soFar = max(soFar, endingHere);
           System.out.println(endingHere + "--" + soFar);
       }
       
       
       
       return soFar;
       
       
    }

    private static int lcseq(int[] array) {
        
         int[] answers = new int[array.length];
         answers[0] = 1 ;
         int max = 1 ;
         int maxind = 0;
         int[] jump = new int[array.length];
         jump[0] = -1;
        for(int i = 1 ; i < array.length ; i++){
            
            for(int j = i - 1 ; j >= 0 ;  j--){
                if(array[j] < array[i] && answers[i] < answers[j])
                {
                    answers[i] = answers[j];
                    jump[i] = j;
                   // break;
                }
                
            }
            answers[i] = answers[i] + 1 ;
            if(answers[i] == 1)
                jump[i] = -1;
            if(answers[i] > max)
            {max = answers[i];
             maxind = i;
            }
            
        }
        
        System.out.println("The sequence is");
        do{
            System.out.print(array[maxind]+" ");
            maxind = jump[maxind];
        }while(maxind!= -1);
            
        
        
        return max;
        
        
    }

    private static String lpalin(int[] array) {
        
        int[] revarray = reverse(array);
      
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "a0b0c0d0e0f0g0h0i0j0k0l0m0n0o0p0q0r0s0t0u0v0w0x0y0z0";
        return findLCS(s1.toCharArray(), s2.toCharArray());
    
    }

    private static int[] reverse(int[] array) {

        int[] reversed = new int[array.length];
        for(int i = 0 ; i < array.length ; i++){
            reversed[i] = array[array.length - i - 1];
        }
    return reversed;
    }

    private static String findLCS(char[] s1, char[] s2) {
       
        int[][] maxLong = new int[s1.length + 1][s2.length + 1];
        
        for(int i = 1 ; i <= s1.length ; i++){
            
            for(int j = 1 ; j <= s2.length ; j++){
                if(s1[i-1] == s2[j-1])
                {
                    maxLong[i][j] = maxLong[i-1][j-1] + 1;
                }
                else{
                    if(maxLong[i][j-1] > maxLong[i-1][j])
                         maxLong[i][j] = maxLong[i][j-1];
                    else
                         maxLong[i][j] = maxLong[i-1][j];
                }
            }
            
           
            
            
        }
        
        
        for(int i = 0 ; i <= s1.length; i++){
            for(int j = 0 ; j <= s2.length ; j++){
                System.out.print(maxLong[i][j]+" ");
            }
            System.out.println("");
        }
        
         int i = s1.length;
         int j = s2.length;
         String answer="";
         System.out.println("Longest sequence:");
         while(i>0 && j>0){
             
            if(maxLong[i][j-1]<maxLong[i][j] && maxLong[i-1][j] < maxLong[i][j]){
                System.out.print(s1[i-1]+" ");
                answer = s1[i-1] + answer;
                i = i - 1;
                j = j - 1;
                continue;
            }
            else if(maxLong[i][j-1] == maxLong[i][j])
            {
                j = j - 1;
                continue;
            }
            else if(maxLong[i-1][j] == maxLong[i][j]){
                i = i - 1 ;
                continue;
            }
            
         }
        
        return answer;
        
    
    }
    
}
