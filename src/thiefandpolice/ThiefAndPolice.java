/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

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
        
        Police police = new Police(pn, x, y, data.getCharArray());
        Thief thief = new Thief(pn, x, y, data.getCharArray());

        police.watch(listPAndD);
        thief.watch(listPAndD);
        
        System.out.println("*");
        //System.out.println(data.changedList());
        
        while(true){
            data.move(police.watch(data.changedList()), thief.watch(data.changedList()));
            data.print();
        }
    
    }
    
    
}
