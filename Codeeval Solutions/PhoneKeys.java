/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phonekeys;

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
public class PhoneKeys {

    /**
     * @param args the command line arguments
     */
    static HashMap<Character, String> layout = new HashMap<>();
    static ArrayList<String> allStrings = new ArrayList<String>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         BufferedReader br = new BufferedReader(new FileReader(args[0]));
         String line="";
        // Setting up the layout
        layout.put('0', "0");
        layout.put('1', "1");
        layout.put('2', "abc");
        layout.put('3', "def");
        layout.put('4', "ghi");
        layout.put('5', "jkl");
        layout.put('6', "mno");
        layout.put('7', "pqrs");
        layout.put('8', "tuv");
        layout.put('9', "wxyz");
        
        while((line=br.readLine())!=null){
            
            allStrings.clear();
            printStrings(line.toCharArray(), 0, "");
            
            /*
            Now print all strings
            */
            for(int i = 0 ; i < allStrings.size() - 1 ; i++){
                System.out.print(allStrings.get(i)+",");
            }
            System.out.println(allStrings.get(allStrings.size() - 1));
        }
        
       
        
    }

    private static void printStrings(char[] digits, int pos, String soFar) {
        if(pos >= digits.length)
            return;
        
        char[] charAtDigits = layout.get(digits[pos]).toCharArray();
        
        if(pos == digits.length - 1){
            for(int i = 0 ; i < charAtDigits.length ; i++){
                allStrings.add(soFar+charAtDigits[i]);
            }
            return;
        }
        
        for(int i = 0 ; i < charAtDigits.length ; i++){
            printStrings(digits, pos + 1, soFar + charAtDigits[i]);
        }
        
    }
    
}
