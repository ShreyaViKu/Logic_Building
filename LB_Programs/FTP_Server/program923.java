/*
FTP server 
*/

import java.io.*;
import java.net.*;

class program923
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);

            System.out.println("------------------------------------------------");
            System.out.println("------------Marvellous Server Started-----------");
            System.out.println("------------------------------------------------");

            //loop for multiple client request
            while(true)
            {
                System.out.println("Server is waiting for client request");

                Socket clientsocket = serversocket.accept();

                System.out.println("Client Connected Successfully");

                //Thread gets created for each client
                Thread t = new Thread(()-> HandleClientRequest(clientsocket));

                t.start();
            }// end of while

        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }// end of main

    public static void HandleClientRequest(Socket socket)
    {
        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to Marvellous Server");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }
}// end of class