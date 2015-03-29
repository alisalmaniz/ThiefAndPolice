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
public class Thief extends Data {
    
    private LinkedList listPNearD;
    
    public Thief(int pn, int x, int y , char[][] charArray){
    
        this.pn = pn;
        this.x = x;
        this.y = y;
        this.charArray = charArray;
        listPNearD = new LinkedList();
    }
    // public void p(){System.out.println(pn);}
    public LinkedList watch(LinkedList listPAndD){
        
        listPNearD = new LinkedList();
        int i=0;
        int j=0;
        
        int xElement =(int)listPAndD.get(listPAndD.size()-2);
        int yElement =(int)listPAndD.get(listPAndD.size()-1);

        for( i=xElement-2; i<=xElement+2; i++)
            for( j=yElement-2; j<=yElement+2; j++){
                if(i==xElement && j==yElement)
                    continue;
                if(i>=0 && i<x && j>=0 && j<y)
                    if(charArray[i][j]=='P'){
                        listPNearD.add(i);
                        listPNearD.add(j);
                    }
            }  

        return listPNearD;
    }
    
}
