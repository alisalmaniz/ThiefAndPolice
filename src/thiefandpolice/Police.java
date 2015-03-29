/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ali salmani
 */
public class Police extends Data{
    
    private int[] how;
    private int xElement;
    private int yElement;
    
    public Police(int pn, int x, int y , char[][] charArray){
    
        this.pn = pn;
        this.x = x;
        this.y = y; 
        this.charArray = charArray;
        how = new int[2];
        xElement=0;
        yElement=0;
 
    }
    //public void p(){System.out.println(pn);}
    public int[] watch(LinkedList listPAndD){

        int i=0;
        int j=0;
        int k=0;

        search:
        for( k=0; k<listPAndD.size()-2-1; k=k+2){
            
            xElement = (int)listPAndD.get(k);
            yElement= (int)listPAndD.get(k+1);
            for( i=xElement-2; i<=xElement+2; i++)
                for( j=yElement-2; j<=yElement+2; j++){
                    if(i==xElement && j==yElement)
                        continue;
                    if(i>=0 && i<x && j>=0 && j<y)
                        if(charArray[i][j]=='D')
                            break search;
                }  
        }
        
        if(k==listPAndD.size()-2){
            how[0]=-1;
            how[1]=-1;
        }
        else{
            how[0]=i;
            how[1]=j;
        }
        
        return how;
    }
    

}
