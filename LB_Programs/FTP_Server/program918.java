/*
FTP server project for Arithematic derver started
server created as listening
*/

import java.io.*;
import java.net.*;

class program918
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);

            System.out.println("------------------------------------------------");
            System.out.println("------------Marvellous Server Started-----------");
            System.out.println("------------------------------------------------");

            System.out.println("Server is waiting for client request");

            Socket clientsocket = serversocket.accept();

            System.out.println("Client Connected Successfully");

        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }
}