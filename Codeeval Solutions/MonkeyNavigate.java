/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monkeynavigate;

/**
 *
 * @author esamsai
 */
public class MonkeyNavigate {

    /**
     * @param args the command line arguments
     */
    static boolean[][] floor = new boolean[300][300];
    static int count = 0;
    static int extra = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(floor[199][200]);
        int x = 0 ;
        int y = 0 ;
        
        traverse(x,y);
       System.out.println(count*4 - 3 - 2*extra);
     /*  for(int i = 0; i < 300 ; i++){
            for(int j = 0 ; j < 300 ; j++){
                if(floor[i][j])
                    System.out.print(" ");
                else
                    System.out.print("1");
            }
            System.out.println("");
        }*/
    }

    private static void traverse(int x, int y) {

    int realx = Math.abs(x);
    int realy = Math.abs(y);
    
    
    if(realx > 300 || realx < 0)
        return;
    if(realy > 300 || realy < 0)
        return;
    if(floor[realx][realy])
        return;
    
    if(sumOfDigits(x,y)<=19){
        count++;
        if((x==0&&y!=0)||(y==0&&x!=0))
            extra++;
        floor[realx][realy] = true;
    
       // if(realy-1>=0 && !floor[realx][realy - 1])
         //   traverse(x, y - 1);
        if(realy+1<300 && !floor[realx][realy+1])
            traverse(x, y+1);
        if(realx+1<300 && !floor[realx+1][realy])
            traverse(x+1, y);
       // if(realx-1>=0 && !floor[realx-1][realy])
         //   traverse(x-1, y);
        
        
    } 
    
    
    
    }

    private static int sumOfDigits(int x, int y) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        int sumDigits = 0;
        
        while(x>0){
            sumDigits+=x%10;
            x=x/10;
        }
        while(y>0){
            sumDigits+=y%10;
            y=y/10;
        }
        
        return sumDigits;
        
    }
    
}
