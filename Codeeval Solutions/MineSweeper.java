/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author esamsai
 */
public class MineSweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line="";
        
        while((line = br.readLine())!=null){
            
            String[] inputs = line.split(";");
            String[] dimensions = inputs[0].split(",");
            int M = Integer.parseInt(dimensions[0]);
            int N = Integer.parseInt(dimensions[1]);
            
            int[][] mines = new int[M][N];
            for(int i = 0 ; i < inputs[1].length() ; i++)
            {
               
                int x = i/N;
                int y = i%N;
                if(inputs[1].charAt(i) == '*')
                { 
                    mines[x][y] = -1;
                    
                    if(x>0 && mines[x-1][y] != -1)
                        mines[x-1][y]++;
                    if(x>0 && y>0 && mines[x-1][y-1] != -1)
                        mines[x-1][y-1]++;
                    if(x>0 && y < (N-1) && mines[x-1][y+1] != -1)
                        mines[x-1][y+1]++;
                    if(y>0 && mines[x][y -1] != -1)
                        mines[x][y-1]++;
                    if(y<(N-1) && mines[x][y+1] != -1)
                        mines[x][y+1]++;
                    if(x<(M-1) && mines[x+1][y] != -1)
                        mines[x+1][y]++;
                    if(x<(M-1) && y>0 && mines[x+1][y-1] != -1)
                        mines[x+1][y-1]++;
                    if(x<(M-1)&& y <(N-1) && mines[x+1][y+1] != -1)
                        mines[x+1][y+1]++;
                    
                }
                
               
            }
            for(int i = 0 ; i < M ; i++)
            {
                for(int j = 0 ; j < N ; j++)
                {
                    int count = 0 ;
                    
                   
                    if(mines[i][j] == -1)
                        System.out.print("*");
                    else
                        System.out.print(mines[i][j]);
                }
              //  System.out.println("");
            }
            System.out.println("");
        }
    }
    
}
