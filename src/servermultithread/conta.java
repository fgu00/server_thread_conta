/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import static servermultithread.ServerMultiThread.h;


/**
 *
 * @author russo.salvatore
 */
public class conta implements Runnable{
 private int valore;
    public conta(int a){
        valore=a;
    }
    @Override
    public void run() {
      h=h+valore;
    }
    
}
