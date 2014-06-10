/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package largestsubmatrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author esamsai
 */
public class LargestSubMatrix {

    /**
     * @param args the command line arguments
     */
    static int[][] matrix = new int[22][22];
    static int[][] maxContained = new int[22][22];
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        int row = 1 ;
        int col = 0 ;
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        
        String line = "";
        
        while((line = br.readLine())!=null){
            
            String[] inputs = line.split(" ");
            col = inputs.length;
            for(int i = 0 ; i < inputs.length ; i++){
                matrix[row][i + 1] = Integer.parseInt(inputs[i]);
               //System.out.print(matrix[row][i + 1]+" ");
            }
          // System.out.println("");
            
            row++;
        }
        row--;
        /*
        Create the sum matrix
        */
        for(int i = 1 ; i <=row ; i++){
            for(int j = 1 ; j <=col ; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1] + matrix[i][j];
               // System.out.print(matrix[i][j] + " ");
            }
           // System.out.println("");
        }
        /*
        Now for max contained within
        */
         for(int i = 1 ; i <=row ; i++){
            for(int j = 1 ; j <=col ; j++){
                maxContained[i][j] = max(maxMat(i,j), max(maxContained[i-1][j], maxContained[i][j-1]));
               // System.out.print(maxContained[i][j] + " ");
            }
            //System.out.println("");
        }
        
        System.out.println(maxContained[row][col]);
    }

    private static int max(int i, int i0) {
       if(i > i0)
           return i;
       else
           return i0;
    }

    private static int maxMat(int maxi, int maxj) {
        /*
        Function to find the maximum sub-matrix ending at i,j including i,j
        */
        int max = matrix[maxi][maxj];
        for(int i = 1; i <=maxi ; i++){
            for(int j = 1 ; j <=maxj ; j++){
                int sum = matrix[maxi][maxj] - (matrix[i-1][maxj] + matrix[maxi][j-1] - matrix[i-1][j-1]);
                if(sum > max)
                    max = sum;
            }
        }
        
        return max;
    
    }
    
}
