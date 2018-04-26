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

public class Server {
    public static void main(String[] args) {
          try{
              //Try block to handle code that may cause exception
              ServerSocket sSocket = new ServerSocket(6688);
              
            //Listen for connections
            while(true){
                  System.out.println("Waiting for client on port "+ sSocket.getLocalPort()+"...");  
                  Socket cSock = sSocket.accept();
                  
                  //to read txt file which on your directory
                  File file = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\Server\\src\\miniproject\\Text.txt");
                  FileReader myfile = new FileReader(file);
                  char[] chars = new char[(int) file.length()];
                  myfile.read(chars);
                  String content = new String(chars);
                  myfile.close();
                  
                  String read = null;
                  int readNum;
 
                   //Write the data to the socket
                  do{
                  InputStream iStream = cSock.getInputStream();
                  BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
                  
                  read = bReader.readLine();
                  
                  int lineNum = 0;
                  readNum =  Integer.parseInt(read);
                  //if input received is 0, client exit.
                  if(readNum == 0){
                      System.out.println("Client exitting...");
                      System.exit(0);
                  }
                  
                  Scanner scan = new Scanner(content);
                  //if there is next line, continue loop
                  while(scan.hasNextLine()){
                      lineNum++;
                      String lineBline = scan.nextLine();
                      //to read a specific number of line from the content of file
                      if(lineNum == readNum){
                          PrintWriter pw = new PrintWriter(cSock.getOutputStream(),true);
                          //write the content to socket
                          pw.println(lineBline);
                          System.out.println("Received from client: "+lineNum);
                      }
                  }
                 }while(readNum != 0);
                  
                  //Close the socket 
                  //Resume to listen for connection
                  cSock.close();
              }
          }
          catch(IOException ioe){
              //This block is to catch io error
              System.err.println(ioe);
          }
    }
    
}
