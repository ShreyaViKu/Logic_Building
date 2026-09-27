/*
FTP client 
*/

import java.io.*;
import java.net.*;
import java.util.*;

class program926
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);

        try
        {
            System.out.println("------------------------------------------------");
            System.out.println("------------Marvellous Client Started-----------");
            System.out.println("------------------------------------------------");

            Socket socket = new Socket(
                                    "127.0.0.1",
                                    9000);

            System.out.println("Connection with Server is Successful");

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.println(dis.readUTF());

            while(true)
            {
                System.out.println("------------------------------------------------");
                System.out.println("-----------------FTP Commands ------------------");
                System.out.println("------------------------------------------------");

                System.out.println("LIST");
                System.out.println("EXISTS <FileName>");
                System.out.println("INFO <FilenName>");
                System.out.println("SIZE <FilenName>");
                System.out.println("GET <FilenName>");
                System.out.println("PUT <FilenName>");
                System.out.println("DELETE <FilenName>");
                System.out.println("RENAME <OldFilenName> <NewFileName");
                System.out.println("QUIT");
                System.out.println("------------------------------------------------");

                System.out.println("Enter command : ");

                String command = sobj.nextLine();

                String parts[] = command.split(" ");

                String operation = parts[0].toUpperCase();

                if(operation.equals("GET"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : GET <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : PUT <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : INFO <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : SIZE <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("EXISTS"))
                { 
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : EXISTS <FileName>");
                        continue;
                    } 
                    dos.writeUTF(command); 
                }
                else if(operation.equals("RENAME"))
                {
                    if(parts.length != 3)
                    {
                        System.out.println("Usage : RENAME <OldFileName> <NewFileName>");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : DELETE <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        System.out.println("Usage : LIST");
                        continue;
                    }
                    dos.writeUTF(command);
                }
                else if(operation.equals("QUIT"))
                {
                    if(parts.length != 1)
                    {
                        System.out.println("Usage : QUIT");
                        continue;
                    }

                    System.out.println("Thank you for using Marvellous FTP Server");

                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println(response);

                    break;  // it will terminate client loop for command 
                }
                else
                {
                    System.out.println("There is no such command");
                    continue;
                }

            } // end of while

            socket.close();
            sobj.close();
            dis.close();
            dos.close();

        }// end of try
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }// end of main

}// end of class