/*
FTP client 
*/

import java.io.*;
import java.net.*;
import java.util.*;

class program935
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
                System.out.println("-----------------FTP Commands-------------------");
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

                    String response = dis.readUTF();

                    if(response.equals("FILE_NOT_FOUND"))
                    {
                        System.out.println("File not found on server");
                        continue;
                    }

                    long filesize = dis.readLong();

                    System.out.println("File size is : "+filesize);

                    String NewFileName = "Download_"+parts[1];

                    FileOutputStream fos = new FileOutputStream(NewFileName);

                    byte Buffer[] = new byte[1024];

                    long received = 0;

                    while(received < filesize)
                    {
                        long remaining = filesize-received;

                        int toread;

                        if(remaining > Buffer.length)
                        {
                            toread = Buffer.length;
                        }
                        else
                        {
                            toread = (int)remaining;
                        }

                        int bytesread = dis.read(Buffer,0,toread);

                        if(bytesread == -1)
                        {
                            break;
                        }

                        fos.write(Buffer,0,bytesread);

                        received = received + bytesread;
                    }// end of while

                    fos.close();

                    if(received == filesize)
                    {
                        System.out.println("Download completed successfully");
                    }
                    else
                    {
                        System.out.println("Download failed");
                    }
                }
                else if(operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : PUT <FileName>");
                        continue;
                    }

                    File file = new File(parts[1]);

                    if(file.exists() == false || file.isFile() == false)
                    {
                        System.out.println("File not exists");
                        continue;
                    } 
                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    if(response.equals("READY"))
                    {
                        long filesize = file.length();

                        dos.writeLong(filesize);

                        FileInputStream fis = new FileInputStream(file);

                        byte buffer[] = new byte[1024];

                        int bytesread = 0;

                        while((bytesread = fis.read(buffer)) != -1)
                        {
                            dos.write(buffer,0,bytesread);
                        }
                        dos.flush();
                        fis.close();

                        System.out.println(dis.readUTF());
                    }

                }
                //DONE
                else if(operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : INFO <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println("------------------------------------------------");
                    System.out.println("File Information : ");
                    System.out.println(response);
                    System.out.println("------------------------------------------------");
                }
                //DONE
                else if(operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : SIZE <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println("------------------------------------------------");
                    System.out.println(response);
                    System.out.println("------------------------------------------------");
                }
                //DONE
                else if(operation.equals("EXISTS"))
                { 
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : EXISTS <FileName>");
                        continue;
                    } 
                    dos.writeUTF(command); 

                    String response = dis.readUTF();

                    System.out.println("------------------------------------------------");
                    System.out.println(response);
                    System.out.println("------------------------------------------------");
                }
                //DONE
                else if(operation.equals("RENAME"))
                {
                    if(parts.length != 3)
                    {
                        System.out.println("Usage : RENAME <OldFileName> <NewFileName>");
                        continue;
                    }
                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println(response);
                }
                //DONE
                else if(operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        System.out.println("Usage : DELETE <FileName>");
                        continue;
                    }
                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println(response);
                }
                //DONE
                else if(operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        System.out.println("Usage : LIST");
                        continue;
                    }
                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println("------------------------------------------------");
                    System.out.println("Files present on server are : ");
                    System.out.println(response);
                    System.out.println("------------------------------------------------");
                }
                //DONE
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