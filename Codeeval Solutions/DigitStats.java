/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package digitstats;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author esamsai
 */
public class DigitStats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line="";
        
        while((line=br.readLine())!=null){
            
            long[] digitCounts = new long[10];
            String[] inputs = line.split(" ");
            
            int e = Integer.parseInt(inputs[0]);
            long x = Long.parseLong(inputs[1]);
            //System.out.println(Long.MAX_VALUE);
            int num = 1;
            int i = 0;
            
            if(e == 5 || e == 6)
            {
                digitCounts[e] = x;
                                
            }
            
            else if(e == 9 || e == 4){
                long val = x/2;
                digitCounts[e] = val + x%2;
                digitCounts[(e*e)%10] = val;
                
               // continue;
            }
            else{
                long val = x/4;
                long rem = x%4;
                int exp = e;
                for( i = 0 ; i < 4 ; i++){
                    digitCounts[e] = val ;
                    if(i<rem)
                        digitCounts[e]+=1;
                    e = (e*exp)%10;
                    
                }
                
                
            }
           
            for( i = 0 ; i < 9 ; i++){
                System.out.print(i+": "+digitCounts[i]+", ");
                }
                System.out.println("9: "+digitCounts[9]);
            
            
        }
        
        
    }
    
}
