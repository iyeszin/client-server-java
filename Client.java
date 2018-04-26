package miniproject;

/*
 * This server will wait for a client connection using the accept() method.
 * When a client connection is received, the server will loop, performing the following steps:
 * - Read data from the socket into a buffer.
 * - Respond to the client based on the contents of the buffer. 
 * The respond is listed in a text file stored locally. 
 * 
 * The server will break out of the loop only when it has determined that the client has closed the connection.
 * 
 * This mini project is done by Wong Siew Lee, Ang Iye Szin, Lee Jie Yu and Neoh Yee Jin.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
       try{
           //Try block to handle code that may cause exception
           //Open a socket on port 6688
           System.out.println("Connecting to localhost on port 6688"); 
           //make connection to the server socket
           Socket cSock = new Socket("127.0.0.1",6688);
           
           Scanner input = new Scanner(System.in);
           int lineNum;

           PrintWriter pw = new PrintWriter(cSock.getOutputStream(),true);
           //The server will stop looping when client is lost connection
           do{
                //Read the input of client
                System.out.print("Enter any number(1-10, 0 to exit): ");
                lineNum = input.nextInt();
                    //if the input received is between 1 and 10, data from the socket is printed out
                    //else the input received is 0, system exit.
                    if(lineNum > 0 || lineNum < 11){
                        //write lineNum to the socket
                        pw.println(lineNum);
                    
                        //Open input and output streams
                        InputStream iStream = cSock.getInputStream();
                        BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
                    
                        String line;
                        //read the data from the socket
                        line = bReader.readLine();
                        //Determine that client has closed the connection
                        if(lineNum == 0){
                            System.out.println("Exit...");
                            System.exit(0);
                        }
                        else if(lineNum != 0){
                            System.out.println(line);
                            System.out.println();
                    }
                }
           }while(lineNum != 0);
           
           pw.println(lineNum);
           //Close the socket connection
           cSock.close();
       }
       catch(IOException ioe){
              //This block is to catch io error
              System.err.println(ioe);
          }
    }
}
