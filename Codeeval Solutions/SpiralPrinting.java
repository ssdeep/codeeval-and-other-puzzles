/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spiralprinting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author esamsai
 */
public class SpiralPrinting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line = "";
        
        while((line=br.readLine())!=null){
            String[] inputs = line.split(";");
            int rows = Integer.parseInt(inputs[0]);
            int cols = Integer.parseInt(inputs[1]);
            
            HashMap<Integer, Integer> rowIndices = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> colIndices = new HashMap<Integer, Integer>();
            
            String[][] matrix = new String[rows][cols];
            String[] chain = inputs[2].split(" ");
            int index = 0;
            for(int i = 0 ; i < rows ; i++){
                rowIndices.put(i, i);
                for(int j = 0 ; j < cols ; j++){
                    matrix[i][j] = chain[index++];
                   // System.out.print(matrix[i][j]+" ");
                    colIndices.put(j, j);
                }
                //System.out.println("");
            }
            
            int rincr = 1;
            int cincr = 1;
            int total = rows*cols;
            int rptr = 0;
            int cptr = 0;
            outerloop:
            while(total>0){
                for(int i = 0 ; i < colIndices.size() - 1 ; i++, cptr = cptr + cincr){
                    System.out.print(matrix[rptr][cptr]+" ");
                    total--;
                    if(total == 0)
                        break outerloop;
                    
                }
                System.out.print(matrix[rptr][cptr]+" ");
                total--;
                if(total<=0)
                    break outerloop;
                
                rowIndices.remove(rptr);
                rptr = rptr + rincr;
                cincr = -cincr;
                for(int i = 0 ; i < rowIndices.size() - 1; i++, rptr = rptr + rincr){
                    System.out.print(matrix[rptr][cptr]+" ");
                    total--;
                    if(total == 0)
                        break outerloop;
                }
                System.out.print(matrix[rptr][cptr]+" ");
                total--;
                if(total<=0)
                    break outerloop;
                colIndices.remove(cptr);
                cptr = cptr + cincr;
                rincr = -rincr;
            }
           
            System.out.println("");
        }
        
                
    }
    
}
