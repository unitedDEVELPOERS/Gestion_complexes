/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ahmed
 */
import java.util.Timer;
import java.util.TimerTask;
 
public class TimerTest {
 
/**
 * @param args
 */
public static void main(String[] args) {
System.out.println("starting MAIN");
Timer t = new Timer();
t.schedule(new TimerTask() {
int i = 0;
 
public void run() {
                                //répéter chaque 3 secondes 
System.out.println("timer exec n°:" + ++i);
}
}, 0, 3000);
 
callMyService();

System.out.println("end MAIN");
t.cancel();
}
 
private static void callMyService() {
System.out.println("DEBUT appel bloquant");
try {
                        //le programme va attendre 7 secondes
Thread.currentThread().sleep(10000);
System.out.println("FIN appel bloquant");
} catch (InterruptedException e) {
System.out.println("appel bloquant interrompu");
}
}
}