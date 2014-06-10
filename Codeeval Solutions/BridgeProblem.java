/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bridgeproblem;

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
class Segment{
    int id;
    double[]p;
    double[]q;
    TreeMap<Integer, Segment>with = new TreeMap<Integer, Segment>();
    Segment(double[] p, double[] q, int id){
        this.p = p;
        this.q = q;
        this.id = id;
    }
}
public class BridgeProblem {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Segment> allSegs = new ArrayList<Segment>();
    static int count = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
       
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line="";
        
        while((line=br.readLine())!=null)
        {
       
        
        line=line.replaceAll(":", ",");
        line = line.replaceAll("\\s", "");
        line=line.replaceAll("[\\(\\[\\]\\)]", "");
       // System.out.println(line);
        String[] vals = line.split(",");
        int id = Integer.parseInt(vals[0]);
        double[] p = {Double.parseDouble(vals[1]),Double.parseDouble(vals[2])};
        double[] q = {Double.parseDouble(vals[3]), Double.parseDouble(vals[4])};
        Segment s = new Segment(p, q, id);
        crossAdd(s);
        
            
        }
        /*System.out.println("-----------------------------");
        for(Segment s : allSegs){
            System.out.println("Segment "+s.id);
            for(Integer w : s.with.keySet()){
                System.out.println(w);
            }
        }
        */
      // System.out.println("-----------------------------");
        while(count>0){
            
            /* 
            Find and remove the maximum degree node
            */
            int maxind = 0;
            for(int i = 0 ; i < allSegs.size() ; i++){
                if(allSegs.get(i).with.size() > allSegs.get(maxind).with.size()){
                    maxind = i;
                }
            }
            //System.out.println("maxind = "+maxind);
            /*
            remove the max node along with all the links to other nodes
            */
            
            count = count - allSegs.get(maxind).with.size();
            Segment maxObj = allSegs.get(maxind);
            for(Integer ind : maxObj.with.keySet()){
                
                maxObj.with.get(ind).with.remove(maxObj.id);
                
            }
            allSegs.remove(maxind);
           /* for(Segment is : allSegs)
            {
                System.out.println("Segment ID :"+is.id);
                for(Integer in : is.with.keySet())
                    System.out.println(in);
                
            }
            */
            
            //return;
            
        }
       // System.out.println("-------------------------");
        for(int i = 0 ; i < allSegs.size() ; i++)
            System.out.println(allSegs.get(i).id);
                
    }

    private static void crossAdd(Segment s) {
        
        for(Segment seg: allSegs){
            
            if(intersect(seg, s)){
                s.with.put(seg.id, seg);
                seg.with.put(s.id, s);
                
                count++;
                
            }
            
        }
        allSegs.add(s);
        
        
    }

    private static boolean intersect(Segment seg, Segment s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double[] rseg = {seg.q[0] - seg.p[0], seg.q[1] - seg.p[1]};
        double[] r = {s.q[0]-s.p[0], s.q[1] - s.p[1]};
        /*
        The two lines are 
        seg + rseg and s + r
        */
        double rseg_r = cross(rseg, r);
        double[] s_seg = {s.p[0] - seg.p[0], s.p[1] - seg.p[1]};
        
        double s_seg_r = cross(s_seg, r);
        
        if(rseg_r == 0){
            
          if(s_seg_r != 0)
              return false;
          
          double r2 = r[0]*r[0] + r[1]*r[1];
          double rseg2 = rseg[0]*rseg[0] + rseg[1]*rseg[1];
          
          double s_segdot = ((s.p[0] - seg.p[0])*rseg[0]+(s.p[1] - seg.p[1])*rseg[1]);
          double seg_sdot = ((seg.p[0] - s.p[0])*r[0]+(seg.p[1] - s.p[1])*r[1]);
          
          if(s_segdot<=rseg2 || seg_sdot<=r2)
              return true;
          else
              return false;
            
        }
        else{
            double t = cross(s_seg, r)/rseg_r;
            double u = cross(s_seg, rseg)/rseg_r;
            
            if(t>=0 && t<=1 && u>=0 && u<=1)
                return true;
            else 
                return false;
            
        }
        
       // return true;
    
    }

    private static double cross(double[] rseg, double[] r) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return rseg[0]*r[1] - rseg[1]*r[0];
    }
    
}
