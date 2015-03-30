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
        LinkedList listPAndD = data.makeMatrix();
        data.print();
        data.cls(x<37 ? 37-x : 1);
        
        
        Thief thief = new Thief(pn, x, y, data.getCharArray());
        thief.watch(listPAndD);
        
        Police police = new Police(pn, x, y, data.getCharArray());

        while(true){
            data.moveThief(thief.watch(data.changedList()));
            data.movePolice(police.watch(data.changedList()));
            data.delay(2000);
            data.print();
            data.cls(x<37 ? 37-x : 1);
        }
    
    }
    
    
}
