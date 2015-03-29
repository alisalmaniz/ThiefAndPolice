/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

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
        data.makeMatrix();
        data.print();
        
        Police police = new Police(pn, x, y, data.getCharArray());
        Thief thief = new Thief(pn, x, y, data.getCharArray());
        
        police.watch(data.makeMatrix());
        thief.watch(data.makeMatrix());
        
        while(true){
            data.move(police.watch(data.changedList()), thief.watch(data.changedList()));
            data.print();
        }
    
    }
    
    
}
