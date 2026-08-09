/*
unpacking encrypted files 
and white spaces hadler code with GUI
*/

import java.io.*;
import javax.swing.*;

class unpacking
{
    public boolean unpackfile(String filename)throws Exception
    {
        char key = 'A';
        int iRet = 0, i =0;

        String strHeader = null;

        byte header[] = new byte[100];
        String Tokens[] = null;
        byte Buffer[] = null;
        
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;

        File fileobj = new File(filename);
        File NewFile = null;

        if(fileobj.exists() && fileobj.isFile())
        {
            fiobj = new FileInputStream(fileobj);

            while((iRet = fiobj.read(header,0,100)) != -1)
            {
                // Decrypt the header
                for(i =0; i< header.length; i++)
                {
                    header[i] = (byte)(header[i] ^ key);
                }
                strHeader = new String(header);

                strHeader = strHeader.trim();
                Tokens = strHeader.split("\\*");

                NewFile = new File(Tokens[0]);
                NewFile.createNewFile();

                foobj = new FileOutputStream(NewFile);

                Buffer = new byte[(Integer.parseInt(Tokens[1]))];

                fiobj.read(Buffer,0,Integer.parseInt(Tokens[1]));

                // Decrypt the data
                for( i=0; i < Buffer.length; i++)
                {
                    Buffer[i] = (byte)(Buffer[i] ^ key);
                }

                foobj.write(Buffer,0,Integer.parseInt(Tokens[1]));

                foobj.close();
                
            }
            fiobj.close();
            return true;
        }
        else
        {
            return false;
        }
    }
}
class program735X
{
    public static void main(String[] a)
    {
        JFrame frame = new JFrame("Unpacking Tool");

        JLabel filename = new JLabel("Packed File : ");

        JTextField fileField = new JTextField(50);

        JButton unpackButton = new JButton("UNPACK");

        filename.setBounds(30, 80, 100, 30);
        fileField.setBounds(130, 80, 300, 30);

        unpackButton.setBounds(190, 140, 100, 40);

        frame.add(filename);
        frame.add(fileField);

        frame.add(unpackButton);

        frame.setLayout(null);

        frame.setSize(500,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        unpackButton.addActionListener(e ->
            {
                String pfile = fileField.getText();

                if(pfile.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "Please enter packed file name");
                    return;
                }
                try
                {
                    unpacking uobj = new unpacking();

                    boolean result = uobj.unpackfile(pfile);

                    if(result == true)
                    {
                        JOptionPane.showMessageDialog(frame, "Unpacking Successful");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "File does not exist");
                    }

                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(frame, "Unpacking failed : "+ex.getMessage());
                }
            }

        );
        
    }
    
}
