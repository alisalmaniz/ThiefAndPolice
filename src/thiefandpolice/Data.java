/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali salmani
 */
public class Data {
    
    private int pn;
    private int x;
    private int y;
    private char [][] charArray;
    
    public Data(){
     
        pn = 0;
        x = 0;
        y = 0;
        
    }
    
    public void policeNumbers(){
        
        String pn2 = JOptionPane.showInputDialog("Enter The number of plices");
        pn = Integer.parseInt(pn2);
    }
    
    public void xElement(){
        
        String x2 = JOptionPane.showInputDialog("Enter The x element");
        x = Integer.parseInt(x2);
    }
    
    public void yElement(){
        
        String y2 = JOptionPane.showInputDialog("Enter The y element");
        y = Integer.parseInt(y2);
    }
    
    public void makeMatrix(){
        
        charArray = new char[x][y];
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++)
                charArray[i][j] = '-';
        
        int i=0;
        int r1;
        int r2;
        Random r= new Random();
        while( i<pn ){
            r1=r.nextInt(x);
            r2=r.nextInt(y);
            if(charArray[r1][r2]!='P'){
                charArray[r1][r2] = 'P';
                i++;
            }
        }

        i=0;
        while( i<1 ){
            r1=r.nextInt(x);
            r2=r.nextInt(y);
            if(charArray[r1][r2]!='P'){
                charArray[r1][r2] = 'D';
                break;
            }
        }
        
    }
    
    public void print(){
        
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++)
                System.out.print(" "+ charArray[i][j]+ " ");
              
            System.out.println("");
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
    
    public void setPn(int pn) {
        this.pn = pn;
    }
 
    public int getPn() {
        return pn;
    }

    public void setCharArray(char[][] charArray) {
        this.charArray = charArray;
    }

    public char[][] getCharArray() {
        return charArray;
    }
    
}
