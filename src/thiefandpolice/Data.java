/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali salmani
 */
public class Data {
    
    protected int pn;
    protected int x;
    protected int y;
    protected char [][] charArray;
    protected LinkedList listPAndD; 
    
    public Data(){
     
        pn = 0;
        x = 0;
        y = 0;
        listPAndD =new LinkedList();
    }
    
    public int policeNumbers(){
        
        String pn2 = JOptionPane.showInputDialog("Enter The number of plices");
        pn = Integer.parseInt(pn2);
        return pn;
    }
    
    public int getXElement(){
        
        String x2 = JOptionPane.showInputDialog("Enter The x element");
        x = Integer.parseInt(x2);
        return x;
    }
    
    public int getYElement(){
        
        String y2 = JOptionPane.showInputDialog("Enter The y element");
        y = Integer.parseInt(y2);
        return y;
    }
    
    public LinkedList makeMatrix(){
        
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
            listPAndD.add(r1);
            r2=r.nextInt(y);
            listPAndD.add(r2);
            if(charArray[r1][r2]!='P'){
                charArray[r1][r2] = 'P';
                i++;
            }
        }

        i=0;
        while( i<1 ){
            r1=r.nextInt(x);
            listPAndD.add(r1);
            r2=r.nextInt(y);
            listPAndD.add(r2);
            if(charArray[r1][r2]!='P'){
                charArray[r1][r2] = 'D';
                break;
            }
        }
        return listPAndD;
    }
    
    public void print(){
        
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++)
                System.out.print(" "+ charArray[i][j]+ " ");
              
            System.out.println("");
        }
    }
    
        public void move(int[] how, LinkedList listPNearD){
        
        if(how[0]==-1){
            
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
        }
        else{
            int dx=(int)listPAndD.get(listPAndD.size()-2);
            int dy=(int)listPAndD.get(listPAndD.size()-1);
            for(int k=0; k<Math.max(Math.max(dx, x-1-dx), Math.max(dy, y-1-dy)); k++){
                for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='P'){

                            if( i<dx && j<dy ){
                                if(charArray[i+1][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j+1]='r';
                                else if(charArray[i+1][j]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j]='r';
                                else if(charArray[i][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i][j+1]='r';
                            }
                            else if( i<dx && j==dy ){
                                if(charArray[i+1][j]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j]='r';
                                else if(charArray[i+1][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j+1]='r';
                                else if(charArray[i+1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j-1]='r';
                            }
                            else if( i<dx && j>dy ){
                                if(charArray[i+1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j-1]='r';
                                else if(charArray[i+1][j]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j]='r';
                                else if(charArray[i][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i][j-1]='r';
                            }
                            else if( i==dx && j<dy ){
                                if(charArray[i][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i][j+1]='r';
                                else if(charArray[i+1][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j+1]='r';
                                else if(charArray[i-1][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j+1]='r';
                            }
                            else if( i==dx && j>dy ){
                                if(charArray[i][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i][j-1]='r';
                                else if(charArray[i+1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i+1][j-1]='r';
                                else if(charArray[i-1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j-1]='r';
                            }
                            else if( i>dx && j<dy ){
                                if(charArray[i-1][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j+1]='r';
                                else if(charArray[i][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i][j+1]='r';
                                else if(charArray[i-1][j]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j]='r';
                            }
                            else if( i<dx && j==dy ){
                                if(charArray[i-1][j]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j]='r';
                                else if(charArray[i-1][j+1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j+1]='r';
                                else if(charArray[i-1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j-1]='r';
                            }
                            else if( i<dx && j>dy ){
                                if(charArray[i-1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j-1]='r';
                                else if(charArray[i][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i][j-1]='r';
                                else if(charArray[i-1][j-1]!='P' || charArray[i+1][j+1]!='r')
                                    charArray[i-1][j-1]='r';
                            }
                        }
            }
            for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='r')
                            charArray[i][j]='p';
        }
    }
        
    public LinkedList changedList(){
        
        int k=0;
        for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='p'){
                            listPAndD.set(k, i);
                            k++;
                            listPAndD.set(k, j);
                            k++;
                        }
        for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='D'){
                            listPAndD.set(k, i);
                            k++;
                            listPAndD.set(k, j);
                        }
        return listPAndD;
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

    public void setList(LinkedList listPAndD) {
        this.listPAndD = listPAndD;
    }

    public LinkedList getList() {
        return listPAndD;
    }
}
