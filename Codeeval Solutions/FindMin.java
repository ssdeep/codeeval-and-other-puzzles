/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findmin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author esamsai
 */
public class FindMin {

    /**
     * @param args the command line arguments
     */
    static int[] minHeap;
    static int index = -1;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line = "";
        
        while((line=br.readLine())!=null){
            
            String[] inputs = line.split(",");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            int a = Integer.parseInt(inputs[2]);
            int b = Integer.parseInt(inputs[3]);
            int c = Integer.parseInt(inputs[4]);
            int r = Integer.parseInt(inputs[5]);
            
            
            /*
            Building the initial array
            */
            
            int pos = -1;
            TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
            ArrayList<Integer>m = new ArrayList<Integer>();
            
            tm.put(a, ++pos);
            m.add(a);
            
            for(int i = 1 ; i < k ; i++){
                int val = (b*m.get(i - 1)+c)%r;
                m.add(val);
                tm.put(val, ++pos);
                //System.out.println(m);
                //System.out.println(tm.firstKey());
            }
            
            while(pos<n){
                int min=tm.firstKey();
                if(min > 0)
                    min = -1;
                while(m.contains(++min));
                m.add(min);
                tm.put(min, ++pos);
                tm.remove(m.get(0));
                m.remove(0);
                //System.out.println(m);
            }
            
            System.out.println(m.get(m.size() - 2));
            
        }
    }

    private static int getMin(ArrayList<Integer> m) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    int min = m.get(0);
    for(Integer mini : m)
        if(min > mini)
            min = mini;
    
    return min;
    
    }
    
}
