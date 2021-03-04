/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static servermultithread.ServerMultiThread.h;

/**
 *
 * @author pogliani.mattia
 */
public class ServerThread implements Runnable {
    
    private Socket clientSocket;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Serverino  partito: "
                + clientSocket.getInetAddress());
        try {

            PrintWriter out
                    = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String richiesta = "";
            
                System.out.println("serverino in ascolto...");
                richiesta = in.readLine();
                int numero=Integer.parseInt(richiesta);
                for(int p=0;p<numero;p++){
                    conta w=new conta(p+1);
                    Thread f=new Thread(w);
                    f.start();
                    Thread.sleep(100);
                    f.stop();
                }
                
                
            

            out.close();
            clientSocket.close();
            Thread.sleep(100);
            System.out.println(h);
            System.out.println("chiusura connessione effettuata");

        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
