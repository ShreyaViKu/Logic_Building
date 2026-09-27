/*
FTP server 
*/

import java.io.*;
import java.net.*;

class program924
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

            while(true)
            {
                String command = dis.readUTF();

                System.out.println("Command received from client : "+command);

                String parts[] = command.split(" ");

                String Operation = parts[0].toUpperCase();

                if(Operation.equals("QUIT"))
                {
                    dos.writeUTF("Disconnected from server");

                    break;
                }

                if(parts.length != 3)
                {
                    dos.writeUTF("Invalid Command format");
                    continue;
                }

                double no1 = Double.parseDouble(parts[1]);
                double no2 = Double.parseDouble(parts[2]);
                double result = 0.0;

                if(Operation.equals("ADD"))
                {
                    result = no1 + no2;

                    dos.writeUTF("Result is : "+result);
                }
                else if(Operation.equals("SUB"))
                {
                    result = no1 - no2;

                    dos.writeUTF("Result is : "+result);
                }
                else
                {
                    dos.writeUTF("Invalid Operation");
                }

            }// end of while

            socket.close();

            System.out.println("Client Disconnected");
            
        }//end of try
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }
}// end of class