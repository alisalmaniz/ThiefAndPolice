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
        
        
        Thief thief = new Thief(pn, x, y, data.getCharArray());

        //police.watch(listPAndD);
        thief.watch(listPAndD);
        
        System.out.println("*");
        char c = '\n';
        int length = 40;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
        //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        //System.out.println(data.changedList());
        
        System.out.print("\033[H\033[2J");

        while(true){
            data.move(thief.watch(data.changedList()));
            data.print();
        }
    
    }
    
    
}
