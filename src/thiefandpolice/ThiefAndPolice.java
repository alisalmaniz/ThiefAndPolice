/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

import java.awt.Graphics;

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
        
        data.xElement();
        data.yElement();
        data.policeNumbers();
        data.makeMatrix();
        data.print();
        
        
        Man man = new Man();
    }
    
}
