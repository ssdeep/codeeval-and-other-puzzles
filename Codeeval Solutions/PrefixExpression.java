/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prefixexpression;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author esamsai
 */
class Stack{
    double[] data;
    int top = -1;
    Stack(int size){
        data = new double[size];
    }
    public void push(double value){
        data[++top] = value;
    }
    public double pop(){
        if(top <= - 1){
            System.out.println("Error!! No Elemet");
            return 0;
        }
        
        return data[top--];
        
    }
}
public class PrefixExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line="";
       // System.out.println(args[0]);
        while((line = br.readLine())!=null){
           // System.out.println(line);
            String[] input = line.split(" ");
            Stack stack = new Stack(input.length);
           // System.out.println(input.length);
            for(int i = input.length - 1 ; i >= 0 ; i--){
                //System.out.println(input[i].charAt(0));
                switch(input[i].charAt(0)){
                    case '*': stack.push(stack.pop() * stack.pop());
                              break;
                    case '/': stack.push((double)stack.pop() / stack.pop());
                              break;
                    case '+': stack.push(stack.pop() + stack.pop());
                              break;
                    default : stack.push(Double.parseDouble(input[i]));
                              break;
                        
                }
            }
            System.out.println((int)stack.pop());
            
        }
        
    }
    
}
