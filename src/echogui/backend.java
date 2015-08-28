/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package echogui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Trey
 */
class backend {
  public static void sphereOn () throws UnknownHostException, IOException{
    
    }
    public static void sphereOff () throws UnknownHostException, IOException{
        
    }
    public static void openPlaylist(String x) throws UnknownHostException, IOException{
        Socket sosSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        InetAddress SOS = InetAddress.getByName("10.10.111.30");
        System.out.println("program running");
        try {
            sosSocket = new Socket(SOS, 2468);
            out = new PrintWriter(sosSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        sosSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: localhost.");
            System.exit(1);
        }
        System.out.println("Connected");
        out.println("enable");
        System.out.println(in.readLine());
	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;
	while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("Sent: " + userInput);
            //System.out.println(stdIn.readLine());
	    System.out.println(in.readLine());
        }
        out.println("open_playlist " + x);
	out.close();
	in.close();
	stdIn.close();
	sosSocket.close();
       
       
    }
    public static void playClipNumber(String y) throws UnknownHostException, IOException{
        Socket sosSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        InetAddress SOS = InetAddress.getByName("10.10.111.30");
        System.out.println("program running");
        try {
            sosSocket = new Socket(SOS, 2468);
            out = new PrintWriter(sosSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        sosSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: localhost.");
            System.exit(1);
        }
        System.out.println("Connected");
        out.println("enable");
        System.out.println(in.readLine());
	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;
	while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("Sent: " + userInput);
            //System.out.println(stdIn.readLine());
	    System.out.println(in.readLine());
        }
        out.println("play " + y);
	out.close();
	in.close();
	stdIn.close();
	sosSocket.close();
    }
}