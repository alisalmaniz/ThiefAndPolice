/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

import java.util.Arrays;
import java.util.LinkedList;
/**
 *
 * @author Ali salmani
 */
public class ThiefAndPolice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        Data data= new Data();
        
        int x = data.getXElement();
        int y = data.getYElement();
        int pn = data.policeNumbers();
        if(pn > x*y-1)
            System.exit(-1);
        
        LinkedList listPAndD = data.makeMatrix();
        data.print();
        data.cls(x<38 ? 38-x : 0);
        
        
        Thief thief = new Thief(pn, x, y, data.getCharArray());
        thief.watch(listPAndD);
        
        Police police = new Police(pn, x, y, data.getCharArray());
        
        int[] how = new int[2];
        
        while(true){
            how = police.watch(data.changedList());
            data.moveThief(thief.watch(data.changedList()));
            data.changedList();
            data.movePolice(how);
            data.delay(2000);
            System.out.println("");
            data.print();
            data.cls(x<38 ? 38-x : 0);
        }
    
    }
    
    
}
