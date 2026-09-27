import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;


// ==========================================================
// Interface for FTP operations
// ==========================================================

interface FTPTask
{
    void run() throws Exception;
}


// ==========================================================
// FTP CLIENT
// ==========================================================

class program935 extends JFrame
{
    // ======================================================
    // GUI Components
    // ======================================================

    JTextField ipField;
    JTextField portField;

    JTextField fileField;
    JTextField newNameField;

    JButton connectButton;

    JButton listButton;
    JButton infoButton;
    JButton sizeButton;
    JButton existsButton;

    JButton getButton;
    JButton putButton;
    JButton deleteButton;
    JButton renameButton;

    JButton quitButton;

    JTextArea outputArea;


    // ======================================================
    // Networking
    // ======================================================

    Socket socket;

    DataInputStream dis;
    DataOutputStream dos;

    boolean connected = false;


    // ======================================================
    // Constructor
    // ======================================================

    public program935()
    {
        setTitle("Marvellous FTP Client");

        setSize(700, 600);

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createGUI();
    }


    // ======================================================
    // CREATE GUI
    // ======================================================

    public void createGUI()
    {
        // ==================================================
        // Connection Panel
        // ==================================================

        JPanel connectionPanel =
            new JPanel(new FlowLayout());

        connectionPanel.add(
            new JLabel("IP Address:")
        );

        ipField =
            new JTextField("127.0.0.1", 12);

        connectionPanel.add(ipField);


        connectionPanel.add(
            new JLabel("Port:")
        );

        portField =
            new JTextField("9000", 6);

        connectionPanel.add(portField);


        connectButton =
            new JButton("CONNECT");

        connectionPanel.add(connectButton);


        add(
            connectionPanel,
            BorderLayout.NORTH
        );


        // ==================================================
        // Main Panel
        // ==================================================

        JPanel mainPanel =
            new JPanel(new BorderLayout());


        // ==================================================
        // File Name Panel
        // ==================================================

        JPanel filePanel =
            new JPanel(
                new GridLayout(2, 2, 5, 5)
            );

        filePanel.setBorder(
            BorderFactory.createEmptyBorder(
                10,
                20,
                10,
                20
            )
        );


        filePanel.add(
            new JLabel("File Name:")
        );

        fileField =
            new JTextField();

        filePanel.add(fileField);


        filePanel.add(
            new JLabel("New Name:")
        );

        newNameField =
            new JTextField();

        filePanel.add(newNameField);


        mainPanel.add(
            filePanel,
            BorderLayout.NORTH
        );


        // ==================================================
        // Button Panel
        // ==================================================

        JPanel buttonPanel =
            new JPanel(
                new GridLayout(
                    3,
                    4,
                    10,
                    10
                )
            );

        buttonPanel.setBorder(
            BorderFactory.createEmptyBorder(
                10,
                20,
                10,
                20
            )
        );


        listButton =
            new JButton("LIST");

        infoButton =
            new JButton("INFO");

        sizeButton =
            new JButton("SIZE");

        existsButton =
            new JButton("EXISTS");

        getButton =
            new JButton("GET");

        putButton =
            new JButton("PUT");

        deleteButton =
            new JButton("DELETE");

        renameButton =
            new JButton("RENAME");

        quitButton =
            new JButton("QUIT");


        buttonPanel.add(listButton);
        buttonPanel.add(infoButton);
        buttonPanel.add(sizeButton);
        buttonPanel.add(existsButton);

        buttonPanel.add(getButton);
        buttonPanel.add(putButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(renameButton);

        buttonPanel.add(quitButton);


        mainPanel.add(
            buttonPanel,
            BorderLayout.CENTER
        );


        // ==================================================
        // Output Area
        // ==================================================

        outputArea =
            new JTextArea();

        outputArea.setEditable(false);

        outputArea.setFont(
            new Font(
                "Monospaced",
                Font.PLAIN,
                14
            )
        );


        JScrollPane scrollPane =
            new JScrollPane(outputArea);


        mainPanel.add(
            scrollPane,
            BorderLayout.SOUTH
        );


        add(
            mainPanel,
            BorderLayout.CENTER
        );


        // ==================================================
        // Button Actions
        // ==================================================

        connectButton.addActionListener(
            e -> connectToServer()
        );

        listButton.addActionListener(
            e -> listFiles()
        );

        infoButton.addActionListener(
            e -> infoFile()
        );

        sizeButton.addActionListener(
            e -> sizeFile()
        );

        existsButton.addActionListener(
            e -> existsFile()
        );

        getButton.addActionListener(
            e -> getFile()
        );

        putButton.addActionListener(
            e -> putFile()
        );

        deleteButton.addActionListener(
            e -> deleteFile()
        );

        renameButton.addActionListener(
            e -> renameFile()
        );

        quitButton.addActionListener(
            e -> quitServer()
        );


        // Initially commands are disabled

        enableCommands(false);
    }


    // ======================================================
    // CONNECT TO SERVER
    // ======================================================

    public void connectToServer()
    {
        try
        {
            String ip =
                ipField.getText().trim();

            int port =
                Integer.parseInt(
                    portField.getText().trim()
                );


            outputArea.append(
                "Connecting to server...\n"
            );


            socket =
                new Socket(ip, port);


            dis =
                new DataInputStream(
                    socket.getInputStream()
                );


            dos =
                new DataOutputStream(
                    socket.getOutputStream()
                );


            // Receive server welcome message

            String response =
                dis.readUTF();


            outputArea.append(
                response + "\n"
            );


            connected = true;


            connectButton.setEnabled(false);

            ipField.setEnabled(false);

            portField.setEnabled(false);


            enableCommands(true);


            outputArea.append(
                "Connection successful.\n\n"
            );
        }
        catch(Exception e)
        {
            outputArea.append(
                "Connection failed: " +
                e.getMessage() +
                "\n"
            );
        }
    }


    // ======================================================
    // LIST
    // ======================================================

    public void listFiles()
    {
        runCommand(() ->
        {
            dos.writeUTF("LIST");

            String response =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\n---------- FILES ----------\n"
                );

                outputArea.append(response);

                outputArea.append(
                    "---------------------------\n"
                );
            });
        });
    }


    // ======================================================
    // INFO
    // ======================================================

    public void infoFile()
    {
        String filename =
            getFileName();

        if(filename == null)
        {
            return;
        }


        runCommand(() ->
        {
            dos.writeUTF(
                "INFO " + filename
            );


            String response =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\n---------- FILE INFO ----------\n"
                );

                outputArea.append(response);

                outputArea.append(
                    "--------------------------------\n"
                );
            });
        });
    }


    // ======================================================
    // SIZE
    // ======================================================

    public void sizeFile()
    {
        String filename =
            getFileName();

        if(filename == null)
        {
            return;
        }


        runCommand(() ->
        {
            dos.writeUTF(
                "SIZE " + filename
            );


            String response =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\n" + response + "\n"
                );
            });
        });
    }


    // ======================================================
    // EXISTS
    // ======================================================

    public void existsFile()
    {
        String filename =
            getFileName();

        if(filename == null)
        {
            return;
        }


        runCommand(() ->
        {
            dos.writeUTF(
                "EXISTS " + filename
            );


            String response =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\n" + response + "\n"
                );
            });
        });
    }


    // ======================================================
    // GET
    // ======================================================

    public void getFile()
    {
        String filename =
            getFileName();

        if(filename == null)
        {
            return;
        }


        runCommand(() ->
        {
            // Send GET command

            dos.writeUTF(
                "GET " + filename
            );


            // Receive server response

            String response =
                dis.readUTF();


            if(response.equals(
                "FILE_NOT_FOUND"
            ))
            {
                SwingUtilities.invokeLater(() ->
                {
                    outputArea.append(
                        "\nFile not found on server.\n"
                    );
                });

                return;
            }


            // Receive file size

            long filesize =
                dis.readLong();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\nDownloading: " +
                    filename +
                    "\n"
                );

                outputArea.append(
                    "File size: " +
                    filesize +
                    " bytes\n"
                );
            });


            // Create local file

            String newFileName =
                "Download_" + filename;


            FileOutputStream fos =
                new FileOutputStream(
                    newFileName
                );


            byte buffer[] =
                new byte[1024];


            long received = 0;


            // Receive file

            while(received < filesize)
            {
                long remaining =
                    filesize - received;


                int toread;


                if(remaining > buffer.length)
                {
                    toread =
                        buffer.length;
                }
                else
                {
                    toread =
                        (int)remaining;
                }


                int bytesread =
                    dis.read(
                        buffer,
                        0,
                        toread
                    );


                if(bytesread == -1)
                {
                    break;
                }


                fos.write(
                    buffer,
                    0,
                    bytesread
                );


                received =
                    received + bytesread;
            }


            fos.close();


            if(received == filesize)
            {
                SwingUtilities.invokeLater(() ->
                {
                    outputArea.append(
                        "Download completed successfully.\n"
                    );
                });
            }
            else
            {
                SwingUtilities.invokeLater(() ->
                {
                    outputArea.append(
                        "Download failed.\n"
                    );
                });
            }
        });
    }


    // ======================================================
    // PUT
    // ======================================================

    public void putFile()
    {
        String filename =
            getFileName();

        if(filename == null)
        {
            return;
        }


        // File on client computer

        File file =
            new File(filename);


        if(!file.exists() ||
           !file.isFile())
        {
            outputArea.append(
                "\nFile does not exist "
                + "on client.\n"
            );

            return;
        }


        runCommand(() ->
        {
            // Send PUT command

            dos.writeUTF(
                "PUT " + filename
            );


            // Wait for READY

            String response =
                dis.readUTF();


            if(!response.equals("READY"))
            {
                SwingUtilities.invokeLater(() ->
                {
                    outputArea.append(
                        "Server is not ready.\n"
                    );
                });

                return;
            }


            // Get file size

            long filesize =
                file.length();


            // Send file size

            dos.writeLong(filesize);


            // Open file

            FileInputStream fis =
                new FileInputStream(file);


            byte buffer[] =
                new byte[1024];


            int bytesread;

            long sent = 0;


            // Read and send file

            while(
                (bytesread =
                    fis.read(buffer))
                != -1
            )
            {
                dos.write(
                    buffer,
                    0,
                    bytesread
                );


                sent =
                    sent + bytesread;
            }


            // Make sure all data
            // is sent

            dos.flush();


            fis.close();


            // Receive server response

            String serverResponse =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\nUploading: " +
                    filename +
                    "\n"
                );

                outputArea.append(
                    "File size: " +
                    filesize +
                    " bytes\n"
                );

                outputArea.append(
                    serverResponse +
                    "\n"
                );
            });
        });
    }


    // ======================================================
    // DELETE
    // ======================================================

    public void deleteFile()
    {
        String filename =
            getFileName();

        if(filename == null)
        {
            return;
        }


        int choice =
            JOptionPane.showConfirmDialog(
                this,
                "Delete " +
                filename +
                "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
            );


        if(choice !=
           JOptionPane.YES_OPTION)
        {
            return;
        }


        runCommand(() ->
        {
            dos.writeUTF(
                "DELETE " + filename
            );


            String response =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\n" +
                    response +
                    "\n"
                );
            });
        });
    }


    // ======================================================
    // RENAME
    // ======================================================

    public void renameFile()
    {
        String oldName =
            fileField.getText().trim();


        String newName =
            newNameField.getText().trim();


        if(oldName.isEmpty())
        {
            JOptionPane.showMessageDialog(
                this,
                "Enter old file name."
            );

            return;
        }


        if(newName.isEmpty())
        {
            JOptionPane.showMessageDialog(
                this,
                "Enter new file name."
            );

            return;
        }


        runCommand(() ->
        {
            dos.writeUTF(
                "RENAME " +
                oldName +
                " " +
                newName
            );


            String response =
                dis.readUTF();


            SwingUtilities.invokeLater(() ->
            {
                outputArea.append(
                    "\n" +
                    response +
                    "\n"
                );
            });
        });
    }


    // ======================================================
    // QUIT
    // ======================================================

    public void quitServer()
    {
        if(!connected)
        {
            dispose();

            return;
        }


        try
        {
            dos.writeUTF("QUIT");


            String response =
                dis.readUTF();


            outputArea.append(
                "\n" +
                response +
                "\n"
            );


            socket.close();


            connected = false;


            enableCommands(false);


            connectButton.setEnabled(true);

            ipField.setEnabled(true);

            portField.setEnabled(true);
        }
        catch(Exception e)
        {
            outputArea.append(
                "Error: " +
                e.getMessage() +
                "\n"
            );
        }
    }


    // ======================================================
    // GET FILE NAME
    // ======================================================

    public String getFileName()
    {
        String filename =
            fileField.getText().trim();


        if(filename.isEmpty())
        {
            JOptionPane.showMessageDialog(
                this,
                "Enter file name."
            );

            return null;
        }


        return filename;
    }


    // ======================================================
    // ENABLE / DISABLE COMMAND BUTTONS
    // ======================================================

    public void enableCommands(
        boolean value)
    {
        listButton.setEnabled(value);

        infoButton.setEnabled(value);

        sizeButton.setEnabled(value);

        existsButton.setEnabled(value);

        getButton.setEnabled(value);

        putButton.setEnabled(value);

        deleteButton.setEnabled(value);

        renameButton.setEnabled(value);

        quitButton.setEnabled(value);
    }


    // ======================================================
    // RUN NETWORK OPERATION
    // ======================================================

    public void runCommand(
        FTPTask operation)
    {
        if(!connected)
        {
            JOptionPane.showMessageDialog(
                this,
                "Connect to server first."
            );

            return;
        }


        Thread t =
            new Thread(() ->
            {
                try
                {
                    operation.run();
                }
                catch(Exception e)
                {
                    SwingUtilities.invokeLater(() ->
                    {
                        outputArea.append(
                            "Error: " +
                            e.getMessage() +
                            "\n"
                        );
                    });
                }
            });


        t.start();
    }


    // ======================================================
    // MAIN
    // ======================================================

    public static void main(
        String args[])
    {
        SwingUtilities.invokeLater(
            () ->
            {
                program935 obj =
                    new program935();

                obj.setVisible(true);
            }
        );
    }
}