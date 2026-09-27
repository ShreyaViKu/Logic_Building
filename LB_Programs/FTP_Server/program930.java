/*
FTP server 
*/

import java.io.*;
import java.net.*;

class program930
{
    public static int ClientCount = 1;
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

    // REquest handler for each clirnt request
    public static void HandleClientRequest(Socket socket)
    {
        System.out.println("New thread gets created for client no : "+ClientCount);
        ClientCount++;

        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to Marvellous Server");

            while(true)
            {
                //Read command from client
                String command = dis.readUTF();

                System.out.println("Command received from client : "+command);

                String parts[] = command.split(" ");

                String Operation = parts[0].toUpperCase();

                if(Operation.equals("QUIT"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : QUIT");
                        continue;
                    }

                    dos.writeUTF("Disconnected from server");

                    ClientCount--;

                    break;
                }

                if(Operation.equals("GET"))
                {
                   if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : GET <FileName>");
                        continue;
                    }
                }
                else if(Operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : PUT <FileName>");
                        continue;
                    }
                }
                else if(Operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : INFO <FileName>");
                        continue;
                    }
                    File file = new File(parts[1]);

                    if(file.exists())
                    {
                        String info = "";

                        info = info + "File name : "+file.getName()+"\n";
                        info = info + "File Size : "+file.length()+"\n";
                        info = info + "Readable : "+file.canRead()+"\n";
                        info = info + "Writeable : "+file.canWrite()+"\n";

                        dos.writeUTF(info);
                    }
                    else
                    {
                        dos.writeUTF("File does not exists");
                    }
                }
                //SIZE Demo.txt
                else if(Operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : SIZE <FileName>");
                        continue;
                    }

                    File file = new File(parts[1]);

                    if(file.exists() && file.isFile())
                    {
                        dos.writeUTF("File size : "+file.length()+" bytes");
                    }
                    else
                    {
                        dos.writeUTF("File does not exists");
                    }
                    
                }
                else if(Operation.equals("EXISTS"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : EXISTS <FileName>");
                        continue;
                    }
                    File file = new File(parts[1]);

                    if(file.exists())
                    {
                        dos.writeUTF("File Exists");
                    }
                    else
                    {
                        dos.writeUTF("File does not exists");
                    }
                }
                // RENAME Demo.txt DemoX.txt
                else if(Operation.equals("RENAME"))
                {
                   if(parts.length != 3)
                    {
                        dos.writeUTF("Usage : RENAME <OldFileName> <NewFileName>");
                        continue;
                    }

                    File oldFile = new File(parts[1]);

                    File newFile = new File(parts[2]);

                    if(oldFile.exists() == false)
                    {
                        dos.writeUTF("Source file does not exists");

                        continue;
                    }
                    if(oldFile.renameTo(newFile))
                    {
                        dos.writeUTF("File renamed successfully");
                    }
                    else
                    {
                        dos.writeUTF("Unable to rename the file");
                    }
                }
                else if(Operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : DELETE <FileName>");
                        continue;
                    }

                    File file = new File(parts[1]);

                    if(file.exists() == false)
                    {
                        dos.writeUTF("There is no such file to delete");
                        continue;
                    }
                    if(file.delete())
                    {
                        dos.writeUTF("File Deleted Successfully");
                    }
                    else
                    {
                        dos.writeUTF("Unable to Delete the file");
                    }

                }
                else if(Operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : LIST");
                        continue;
                    }
                    // Current directory cha object banavala
                    File folder= new File(".");

                    File files[] = folder.listFiles();

                    String result = "";

                    if(files != null)
                    {
                        for (File f : files)
                        {
                            if(f.isFile())
                            {
                                result = result + f.getName()+"\n";
                            }
                        }
                    }
                    if(result.length() == 0)
                    {
                        result = "No files available";
                    }
                    
                    dos.writeUTF(result);

                }
                else
                {
                    dos.writeUTF("Invalid Operation");
                }

            }// end of while

            socket.close();
            dis.close();
            dos.close();

            System.out.println("Client Disconnected");
            
        }//end of try
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e);
        }
    }// end of handleclientrequest method 

}// end of class