/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package largestrepeatedstring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author esamsai
 */
public class LargestRepeatedString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line="";
        while((line=br.readLine())!=null){
            String largest = "";
            //line="MADMAD i asdadjka MADMAD i adsjkdahsdkh";
           // System.out.println(largest.length());
            for(int i = 0 ; i < line.length() ; i++){
                
                String answer = findLRS(line.substring(0, i).toCharArray(), line.substring(i, line.length()).toCharArray());
                //String answer = findLCS("MADMAD", "MAD")
                if(answer.length() > largest.length())
                    largest = answer;
            }
            largest=largest.trim();
            if(largest.length()>=1)
                System.out.println(largest);
            else
                System.out.println("NONE");
        }
    }
    
     private static String findLRS(char[] s1, char[] s2) {
       /*
         Starting at s
         */
         int s = 0;
         int[][] matrix = new int[s1.length][s2.length];
         int z = 0 ;
         String ret = "";
         if(s1.length == 0 || s2.length == 0)
             return "";
             for(int i = 0 ; i < s1.length ; i++){
                 for(int j = 0; j < s2.length ; j++){
                     
                     if(s1[i] == s2[j]){
                         if(i == 0 || j == 0)
                             matrix[i][j] = 1;
                         else
                         {
                             matrix[i][j] = matrix[i-1][j-1] + 1;
                         }
                         
                         if(matrix[i][j] > z){
                             ret = getString(s1,s2, i, j);
                             z = matrix[i][j];
                         }
                     }
                     else
                         matrix[i][j] = 0 ;
                     
                 }
      
             }
             return ret;
    
    }

    private static String getString(char[] s1, char[] s2, int i, int j) {
      
        String ret="";
                
        while(i>=0 && j>=0){
            if(s1[i] != s2[j]){
                return ret;
            }
            ret = s1[i]+ret;
            i--;
            j--;
        }
        
        return ret;
        
    }
    
}
