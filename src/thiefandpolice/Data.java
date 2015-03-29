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
        
        // move of polices
        
        if(how[0]==-1){
            
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
                        if(xP+r1-1>0 && xP+r1-1<x && yP+r2-1>0 && yP+r2-1<y && charArray[xP+r1-1][yP+r2-1]!='p'){

                            charArray[xP+r1-1][yP+r2-1]='p';
                            charArray[xP][yP]='-';
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
                for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='P'){

                            if( i<dx && j<dy ){
                                if( charArray[i+1][j+1]!='P' )
                                    charArray[i+1][j+1]='r';
                                else if(charArray[i+1][j]!='P' )
                                    charArray[i+1][j]='r';
                                else if(charArray[i][j+1]!='P' )
                                    charArray[i][j+1]='r';
                            }
                            else if( i<dx && j==dy ){
                                if(charArray[i+1][j]!='P' )
                                    charArray[i+1][j]='r';
                                else if(charArray[i+1][j+1]!='P' )
                                    charArray[i+1][j+1]='r';
                                else if(charArray[i+1][j-1]!='P' )
                                    charArray[i+1][j-1]='r';
                            }
                            else if( i<dx && j>dy ){
                                if(charArray[i+1][j-1]!='P' )
                                    charArray[i+1][j-1]='r';
                                else if(charArray[i+1][j]!='P' )
                                    charArray[i+1][j]='r';
                                else if(charArray[i][j-1]!='P' )
                                    charArray[i][j-1]='r';
                            }
                            else if( i==dx && j<dy ){
                                if(charArray[i][j+1]!='P' )
                                    charArray[i][j+1]='r';
                                else if(charArray[i+1][j+1]!='P' )
                                    charArray[i+1][j+1]='r';
                                else if(charArray[i-1][j+1]!='P' )
                                    charArray[i-1][j+1]='r';
                            }
                            else if( i==dx && j>dy ){
                                if(charArray[i][j-1]!='P' )
                                    charArray[i][j-1]='r';
                                else if(charArray[i+1][j-1]!='P' )
                                    charArray[i+1][j-1]='r';
                                else if(charArray[i-1][j-1]!='P' )
                                    charArray[i-1][j-1]='r';
                            }
                            else if( i>dx && j<dy ){
                                if(charArray[i-1][j+1]!='P' )
                                    charArray[i-1][j+1]='r';
                                else if(charArray[i][j+1]!='P' )
                                    charArray[i][j+1]='r';
                                else if(charArray[i-1][j]!='P' )
                                    charArray[i-1][j]='r';
                            }
                            else if( i<dx && j==dy ){
                                if(charArray[i-1][j]!='P' )
                                    charArray[i-1][j]='r';
                                else if(charArray[i-1][j+1]!='P' )
                                    charArray[i-1][j+1]='r';
                                else if(charArray[i-1][j-1]!='P' )
                                    charArray[i-1][j-1]='r';
                            }
                            else if( i<dx && j>dy ){
                                if(charArray[i-1][j-1]!='P' )
                                    charArray[i-1][j-1]='r';
                                else if(charArray[i][j-1]!='P' )
                                    charArray[i][j-1]='r';
                                else if(charArray[i-1][j-1]!='P' )
                                    charArray[i-1][j-1]='r';
                            }
                        }
            }
            for(int i=0; i<x; i++ )
                    for(int j=0; j<y; j++)
                        if(charArray[i][j]=='r')
                            charArray[i][j]='p';
        }
        
        //move of thief
        
        if(listPNearD.size()==0){
            
            int i=0;
            int r1;
            int r2;
            int xD;
            int yD;
            Random r= new Random();
                    
            xD=(int)listPAndD.get(i);
            yD=(int)listPAndD.get(i+1);
            for(int j=0;j<100;j++){

                r1=r.nextInt(3);
                r2=r.nextInt(3); 
                if(xD+r1-1>0 && xD+r1-1<x && yD+r2-1>0 && yD+r2-1<y){

                    charArray[xD+r1-1][yD+r2-1]='D';
                    charArray[xD][yD]='-';
                    break;
                }
            }
        }
        else{
            
            int ul=0;
            int ll=0;
            int dl=0;
            int uu=0;
            int dd=0;
            int ur=0;
            int rr=0;
            int dr=0;
            int xP=0;
            int yP=0;
            int xD=0;
            int yD=0;
            
            xD=(int)listPAndD.get(listPAndD.size()-2);
            yD=(int)listPAndD.get(listPAndD.size()-1);
            
            for(int i=0; i<listPNearD.size(); i=i+2){
                
                xP=(int)listPAndD.get(i);
                yP=(int)listPAndD.get(i+1);
                
                if(xP<xD && yP<yD )
                    ul++;
                else if(xP<xD && yP==yD)
                    uu++;
                else if(xP<xD && yP>yD)
                    ur++;
                else if(xP==xD && yP<yD)
                    ll++;
                else if(xP==xD && yP>yD)
                    rr++;
                else if(xP>xD && yP<yD)
                    dl++;
                else if(xP>xD && yP==yD)
                    dd++;
                else if(xP>xD && yP>yD)
                    dr++;
            }
            if(ul>uu && ul>ur && ul>ll && ul>rr && ul>dl && ul> dd && ul>dr){
                if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 &&charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(uu>ul && uu>ur && uu>ll && uu>rr && uu>dl && uu> dd && uu>dr){
                if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(ur>uu && ur>ul && ur>ll && ur>rr && ur>dl && ur> dd && ur>dr){
                if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(ll>uu && ll>ur && ll>ul && ll>rr && ll>dl && ll> dd && ll>dr){
                if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(rr>uu && rr>ur && rr>ll && rr>ul && rr>dl && rr> dd && rr>dr){
                if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(dl>uu && dl>ur && dl>ll && dl>rr && dl>ul && dl> dd && dl>dr){
                if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD*-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(dd>uu && dd>ur && dd>ll && dd>rr && dd>dl && dd> ul && dd>dr){
                if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
            else if(dr>uu && dr>ur && dr>ll && dr>rr && dr>dl && dr> dd && dr>ul){
                if(xD-1>0 && yD-1>0 && charArray[xD-1][yD-1]=='-'){
                    charArray[xD-1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD-1>0 && charArray[xD][yD-1]=='-'){
                    charArray[xD][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && charArray[xD-1][yD]=='-'){
                    charArray[xD-1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD-1>0 && charArray[xD+1][yD-1]=='-'){
                    charArray[xD+1][yD-1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD-1>0 && yD+1<y && charArray[xD-1][yD+1]=='-'){
                    charArray[xD-1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && charArray[xD+1][yD]=='-'){
                    charArray[xD+1][yD]='D';
                    charArray[xD][yD]='-';
                }
                else if(yD+1<y && charArray[xD][yD+1]=='-'){
                    charArray[xD][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else if(xD+1<x && yD+1<y && charArray[xD+1][yD+1]=='-'){
                    charArray[xD+1][yD+1]='D';
                    charArray[xD][yD]='-';
                }
                else{
                    charArray[xD][yD]='*';
                    System.exit(0);
                }
            }
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
