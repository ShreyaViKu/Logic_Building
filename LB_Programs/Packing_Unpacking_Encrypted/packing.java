/*
Packing file with encryption with GUI
and handling whitespaces in filename
*/

import java.io.*;
import javax.swing.*;

class Packing
{
    public boolean packFiles(String foldername, String filename) throws Exception
    {
        String header = "";
        char key = 'A';  // encryption key

        int size = 0; // for white spaces in header
        int i =0, j = 0, k = 0;

        File folderobj = null;
        File fpackobj = null;

        FileInputStream fiobj = null;
        FileOutputStream foobj = null;

        byte Buffer[] = new byte[1024];
        int iRet = 0;

        folderobj = new File(foldername);

        if(folderobj.exists() && folderobj.isDirectory())
        {
            fpackobj = new File(filename);
            fpackobj.createNewFile();

            foobj = new FileOutputStream(fpackobj);

            File fArr[] = folderobj.listFiles();

            for(i = 0; i< fArr.length;i++)
            {
                if(fArr[i].isFile() && ((fArr[i].getName()).endsWith(".txt")
                                     || (fArr[i].getName()).endsWith(".c")
                                     || (fArr[i].getName()).endsWith(".cpp")
                                     || (fArr[i].getName()).endsWith(".java")))
                {
                    fiobj = new FileInputStream(fArr[i]);

                    header = header + fArr[i].getName();
                    header = header + "*";
                    header = header + fArr[i].length();

                    size = 100 - header.length();

                    for(j = 1; j <= size; j++)
                    {
                        header = header +" ";
                    }

                    byte HeaderBuffer[] = header.getBytes();
                    
                    for(k = 0; k < HeaderBuffer.length; k++)
                    {
                        HeaderBuffer[k] = (byte)(HeaderBuffer[k] ^ key);
                    }

                    foobj.write(HeaderBuffer);

                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        for(k = 0; k < iRet; k++)
                        {
                            Buffer[k] = (byte)(Buffer[k] ^ key);
                        }
                        foobj.write(Buffer,0,iRet);
                    }

                    fiobj.close();
                    header = "";

                }
            } // end of for

            foobj.close();
            return true;
        }
        else
        {
            return false;
        }
    }
}
class program734X
{
    public static void main(String[] args)throws Exception
    {
        JFrame frame = new JFrame("Packing Tool");

        JLabel foldername = new JLabel("Folder name : ");
        JLabel filename = new JLabel("Pack File : ");

        JTextField folderField = new JTextField(50);
        JTextField fileField = new JTextField(50);

        JButton packButton = new JButton("PACK");

        foldername.setBounds(30, 30, 100, 30);
        folderField.setBounds(130, 30, 300, 30);

        filename.setBounds(30, 80, 100, 30);
        fileField.setBounds(130, 80, 300, 30);

        packButton.setBounds(190, 140, 100, 40);

        frame.add(foldername);
        frame.add(folderField);

        frame.add(filename);
        frame.add(fileField);

        frame.add(packButton);

        frame.setLayout(null);

        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        packButton.addActionListener(e ->
            {
                String folder = folderField.getText();
                String pfile = fileField.getText();

                if(folder.isEmpty() || pfile.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "Please enter folder name and file name");
                    return;
                }
                try
                {
                    Packing pobj = new Packing();

                    boolean result = pobj.packFiles(folder,pfile);

                    if(result == true)
                    {
                        JOptionPane.showMessageDialog(frame, "Packing Successful");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "Folder does not exist");
                    }

                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(frame, "Packing failed : "+ex.getMessage());
                }
            }

        );
        
    }
    
}
