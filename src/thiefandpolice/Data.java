/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefandpolice;

import java.util.Arrays;
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
    private int PND;
    private int nOfThiefMove;
    private int nOfPolicesfMove;
    public Data(){
     
        pn = 0;
        x = 0;
        y = 0;
        listPAndD =new LinkedList();
        PND = 0;
        nOfThiefMove=0;
        nOfPolicesfMove=0;
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
            r2=r.nextInt(y);
            if(charArray[r1][r2]!='P'){
                charArray[r1][r2] = 'P';
                listPAndD.add(r1);
                listPAndD.add(r2);
                i++;
            }
        }

        while( true ){
            r1=r.nextInt(x);
            r2=r.nextInt(y);
            if(charArray[r1][r2]!='P'){
                charArray[r1][r2] = 'D';
                listPAndD.add(r1);
                listPAndD.add(r2);
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
        System.out.println("");
        
    }
    
    public void delay(int s){
        
        try {
        Thread.sleep(s);
        } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
        }
    }
    
    public void cls(int l){
        
        char c = '\n';
        int length = l;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }
    
    public LinkedList changedList(){
        


        int k=0;
        for(int i=0; i<x; i++ )
            for(int j=0; j<y; j++)
                if(charArray[i][j]=='P'){
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
    
    public void moveThief( LinkedList listPNearD){
        
        //move of thief

        
        if(listPNearD.size()==0){
            // random move
            int i=0;
            int r1;
            int r2;
            int xD;
            int yD;
            Random r= new Random();
                    
            xD=(int)listPAndD.get(listPAndD.size()-2);
            yD=(int)listPAndD.get(listPAndD.size()-1);
            for(int j=0;j<100;j++){

                r1=r.nextInt(3);
                r2=r.nextInt(3); 
                if(xD+r1-1>=0 && xD+r1-1<x && yD+r2-1>=0 && yD+r2-1<y){

                    charArray[xD][yD]='-';
                    charArray[xD+r1-1][yD+r2-1]='D';
                    nOfThiefMove++;
                    break;
                }
            }
        }
        else{
            PND=1;
            
            int ul=0;      //these are directions
            int ll=0;
            int dl=0;
            int uu=0;
            int dd=0;
            int ur=0;
            int rr=0;
            int dr=0;
            int xP;
            int yP;
            int xD;
            int yD;
            
            xD=(int)listPAndD.get(listPAndD.size()-2);
            yD=(int)listPAndD.get(listPAndD.size()-1);
            
            for(int i=0; i<listPNearD.size(); i=i+2){
                
                xP=(int)listPNearD.get(i);
                yP=(int)listPNearD.get(i+1);
                
                if(xP<xD && yP<yD ){  
                    ul+=7;           //levels of danger
                    uu+=5;
                    ll+=5;
                    ur+=2;
                    dl+=2;
                    rr++;
                    dd++;
                }
                else if(xP<xD && yP==yD){
                    uu+=7;
                    ul+=5;
                    ur+=5;
                    rr+=2;
                    ll+=2;
                    dr++;
                    dl++;
                }
                else if(xP<xD && yP>yD){
                    ur+=7;
                    uu+=5;
                    rr+=5;
                    ul+=2;
                    dr+=2;
                    ll++;
                    dd++;
                }
                else if(xP==xD && yP<yD){
                    ll+=7;
                    ul+=5;
                    dl+=5;
                    uu+=2;
                    dd+=2;
                    ur++;
                    dr++;
                }
                else if(xP==xD && yP>yD){
                    rr+=7;
                    ur+=5;
                    dr+=5;
                    uu+=2;
                    dd+=2;
                    ul++;
                    dl++;
                }
                else if(xP>xD && yP<yD){
                    dl+=7;
                    dd+=5;
                    ll+=5;
                    ul+=2;
                    dr+=2;
                    rr++;
                    uu++;
                }
                else if(xP>xD && yP==yD){
                    dd+=7;
                    dr+=5;
                    dl+=5;
                    rr+=2;
                    ll+=2;
                    ur++;
                    ul++;
                }
                else if(xP>xD && yP>yD){
                    dr+=7;
                    dd+=5;
                    rr+=5;
                    ur+=2;
                    dl+=2;
                    ll++;
                    uu++;
                }
            }
            if(dr<=uu && dr<=ur && dr<=ll && dr<=rr && dr<=dl && dr<=dd && dr<=ul){
                //shows that dr is safer than other directions
                // but some times cant move in this direction
                if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>=0 &&charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(dd<=ul && dd<=ur && dd<=ll && dd<=rr && dd<=dl && dd<=uu && dd<=dr){
                if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(dl<=uu && dl<=ul && dl<=ll && dl<=rr && dl<=ur && dl<=dd && dl<=dr){
                if(xD+1<x && yD-1>=0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(rr<=uu && rr<=ur && rr<=ul && rr<=ll && rr<=dl && rr<=dd && rr<=dr){
                if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>=0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(ll<=uu && ll<=ur && ll<=rr && ll<=ul && ll<=dl && ll<=dd && ll<=dr){
                if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>=0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(ur<=uu && ur<=dl && ur<=ll && ur<=rr && ur<=ul && ur<=dd && ur<=dr){
                if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>=0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(uu<=dd && uu<=ur && uu<=ll && uu<=rr && uu<=dl && uu<=ul && uu<=dr){
                if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>=0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
            else if(ul<=uu && ul<=ur && ul<=ll && ul<=rr && ul<=dl && ul<=dd && ul<=dr){
                if(xD-1>=0 && yD-1>=0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD-1>=0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD-1>=0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD-1>=0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                    nOfThiefMove++;       
                }
            }
        }
    }
    
    public void movePolice(int[] how){
        
        // move of polices


        
        if(how[0]==-1 && PND==0){
            //random move
            int i=0;
            int r1;
            int r2;
            int xP;
            int yP;
            Random r= new Random();
                while( i<2*pn ){
                    
                    xP=(int)listPAndD.get(i);
                    yP=(int)listPAndD.get(i+1);
                    for(int j=0;j<100;j++){
                       
                        r1=r.nextInt(3);
                        r2=r.nextInt(3); 
                        if(xP+r1-1>0 && xP+r1-1<x && yP+r2-1>0 && yP+r2-1<y && charArray[xP+r1-1][yP+r2-1]!='P'){

                            charArray[xP+r1-1][yP+r2-1]='P';
                            charArray[xP][yP]='-';
                            nOfPolicesfMove++;       
                            break;
                        }
                    }
                    i=i+2;
                }
        }
        else{
            int dx=(int)listPAndD.get(listPAndD.size()-2);
            int dy=(int)listPAndD.get(listPAndD.size()-1);            
            for(int k=0; k<Math.max(Math.max(dx, x-1-dx), Math.max(dy, y-1-dy)); k++){
                //the table will chek more than 1 times
                
                for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='P'){

                            if( i<dx && j<dy ){
                                //the movement changes in the effect of P and D position
                                //every psition has three way of move
                                if( charArray[i+1][j+1]!='P' && charArray[i+1][j+1]!='r' ){
                                    charArray[i+1][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;
                                }
                                else if(charArray[i+1][j]!='P' && charArray[i+1][j]!='r' ){
                                    charArray[i+1][j]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i][j+1]!='P' && charArray[i][j+1]!='r' ){
                                    charArray[i][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i<dx && j==dy ){
                                if(charArray[i+1][j]!='P' && charArray[i+1][j]!='P' ){
                                    charArray[i+1][j]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(j+1<y && charArray[i+1][j+1]!='P' && charArray[i+1][j+1]!='r' ){
                                    charArray[i+1][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                    }
                                else if(j-1>=0 && charArray[i+1][j-1]!='P' && charArray[i+1][j-1]!='r' ){
                                    charArray[i+1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i<dx && j>dy ){
                                if(charArray[i+1][j-1]!='P' && charArray[i+1][j-1]!='r' ){
                                    charArray[i+1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i+1][j]!='P' && charArray[i+1][j]!='r' ){
                                    charArray[i+1][j]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i][j-1]!='P' && charArray[i][j-1]!='r' ){
                                    charArray[i][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i==dx && j<dy ){
                                if(charArray[i][j+1]!='P' && charArray[i][j+1]!='r' ){
                                    charArray[i][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(i+1<x && charArray[i+1][j+1]!='P' && charArray[i+1][j+1]!='r' ){
                                    charArray[i+1][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(i-1>=0 && charArray[i-1][j+1]!='P' && charArray[i-1][j+1]!='r' ){
                                    charArray[i-1][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i==dx && j>dy ){
                                if(charArray[i][j-1]!='P' && charArray[i][j-1]!='r' ){
                                    charArray[i][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(i+1<x && charArray[i+1][j-1]!='P' && charArray[i+1][j-1]!='r' ){
                                    charArray[i+1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(i-1>=0 && charArray[i-1][j-1]!='P' && charArray[i-1][j-1]!='r' ){
                                    charArray[i-1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i>dx && j<dy ){
                                if(charArray[i-1][j+1]!='P' && charArray[i-1][j+1]!='r' ){
                                    charArray[i-1][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i][j+1]!='P' && charArray[i][j+1]!='r'){
                                    charArray[i][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i-1][j]!='P' && charArray[i-1][j]!='r'){
                                    charArray[i-1][j]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i>dx && j==dy ){
                                if(charArray[i-1][j]!='P' && charArray[i-1][j]!='r' ){
                                    charArray[i-1][j]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(j+1<y && charArray[i-1][j+1]!='P' && charArray[i-1][j+1]!='r' ){
                                    charArray[i-1][j+1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(j-1>=0 && charArray[i-1][j-1]!='P' && charArray[i-1][j-1]!='r' ){
                                    charArray[i-1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                            else if( i>dx && j>dy ){
                                if(charArray[i-1][j-1]!='P' && charArray[i-1][j-1]!='r') {
                                    charArray[i-1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i][j-1]!='P' && charArray[i][j-1]!='r' ){
                                    charArray[i][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                                else if(charArray[i-1][j-1]!='P' && charArray[i-1][j-1]!='r' ){
                                    charArray[i-1][j-1]='r';
                                    charArray[i][j]='-';
                                    nOfPolicesfMove++;  
                                }
                            }
                        }
            }
            for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='r')
                            charArray[i][j]='P';
            
            // In the end:
            if(charArray[dx][dy]=='P'){
                charArray[dx][dy]='*';
                this.delay(2000);
                this.print();
                this.cls(x<37 ? 35-x-1 : 1);
                if(nOfPolicesfMove>1)
                    System.out.println("The numbers of polices move: "+ nOfPolicesfMove);
                else
                    System.out.println("The number of police move: "+ nOfPolicesfMove);
                if(nOfThiefMove>1)
                    System.out.println("The numbers of thief move: "+ nOfThiefMove);
                else
                    System.out.println("The number of thief move: "+ nOfThiefMove);
                
                System.exit(0);
            }
            
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

    public void setList(LinkedList listPAndD) {
        this.listPAndD = listPAndD;
    }

    public LinkedList getList() {
        return listPAndD;
    }

    public int getPND() {
        return PND;
    }

    public void setPND(int PND) {
        this.PND = PND;
    }

    public LinkedList getListPAndD() {
        return listPAndD;
    }

    public void setListPAndD(LinkedList listPAndD) {
        this.listPAndD = listPAndD;
    }

    public void setnOfPolicesfMove(int nOfPolicesfMove) {
        this.nOfPolicesfMove = nOfPolicesfMove;
    }

    public int getnOfPolicesfMove() {
        return nOfPolicesfMove;
    }

    public void setnOfThiefMove(int nOfThiefMove) {
        this.nOfThiefMove = nOfThiefMove;
    }

    public int getnOfThiefMove() {
        return nOfThiefMove;
    }
       
}
