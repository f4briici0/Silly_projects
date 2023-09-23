
// Created by: f4briici0.

package multiplicationgame;

 
public class Cronometro extends Thread {
    
    public Cronometro(){
        start();
    }
    
    int a(){
        return 5;
    }
    
    public void run(){
        System.out.println("Executando!");
        a();
    }
}
