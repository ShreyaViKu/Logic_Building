/////////////////////////////////////////////////////////////////////////
//
// Header Files Inclusion
//
/////////////////////////////////////////////////////////////////////////

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include<stdbool.h>

/////////////////////////////////////////////////////////////////////////
//
// User defined Macros
//
/////////////////////////////////////////////////////////////////////////

#define MAXINODE 5
#define MAXFILESIZE 50
#define MAXOPENFILES 5

#define READ 1
#define WRITE 2
#define EXECUTE 4

#define START 0
#define CURRENT 1
#define END 2 

#define EXECUTE_SUCCESS 0

#define REGULARFILE 1
#define SPECIALFILE 2

/////////////////////////////////////////////////////////////////////////
//
// User defined Macros FOR ERROR HANDLING
//
/////////////////////////////////////////////////////////////////////////

#define ERR_INVALID_PARAMETER -1

#define ERR_NO_INODES -2

#define ERR_FILE_ALREADY_EXIST -3
#define ERR_FILE_NOT_EXIST -4

#define ERR_PERMISSION_DENIED -5

#define ERR_INSUFFICIENT_SPACE -6
#define ERR_INSUFFICIENT_DATA -7

#define ERR_MAX_FILES_OPEN -8

/////////////////////////////////////////////////////////////////////////
//
// Structure Name :  BootBlock
// Description :     it holds the information to 
//                   boot the Operating system
//
/////////////////////////////////////////////////////////////////////////

struct BootBlock
{
    char Information[100];
};

/////////////////////////////////////////////////////////////////////////
//
// Structure Name :  SuperBlock
// Description :     it holds the information of complete file system
//
/////////////////////////////////////////////////////////////////////////

struct SuperBlock 
{
    int TotalInodes;
    int FreeInodes;
};

/////////////////////////////////////////////////////////////////////////
//
// Structure Name :  Inode
// Description :     it holds information of file
//
/////////////////////////////////////////////////////////////////////////

#pragma pack(1)
struct Inode
{
    char FileName[20];
    int InodeNumber;
    int FileSize;
    int ActualFileSize;
    int FileType;
    int ReferenceCount;
    int Premission;
    char * Buffer;
    struct Inode * next;

};

typedef struct Inode INODE;
typedef struct Inode * PINODE;
typedef struct Inode ** PPINODE;

/////////////////////////////////////////////////////////////////////////
//
// Structure Name :  FileTable
// Description :     it holds information of opened files
//
/////////////////////////////////////////////////////////////////////////

#pragma pack(1)
struct FileTable
{
    int ReadOffset;
    int WriteOffset;
    int Mode;
    PINODE ptrinode;
};

typedef struct FileTable FILETABLE;
typedef struct FileTable * PFILETABLE;

/////////////////////////////////////////////////////////////////////////
//
// Structure Name :  UAREA
// Description :     it holds information of Process
//
/////////////////////////////////////////////////////////////////////////

struct UAREA
{
   char ProcessName[20];
   PFILETABLE UFDT[MAXOPENFILES]; 
};

/////////////////////////////////////////////////////////////////////////
//
// Global variables used in the project
//
/////////////////////////////////////////////////////////////////////////

struct BootBlock bootobj;
struct SuperBlock superobj;
struct UAREA uareaobj;

PINODE head = NULL;

/////////////////////////////////////////////////////////////////////////
//
// Function Name : InitialiseUAREA
// Description :   it is used to initialise UAREA
// Author :        Shreya Vilas Kulkarni
// Date:           31/07/2026
//
/////////////////////////////////////////////////////////////////////////

void InitialiseUAREA()
{
    int i = 0;

    strcpy(uareaobj.ProcessName,"Myexe");

    for(i = 0; i < MAXOPENFILES ; i++)
    {
        uareaobj.UFDT[i] = NULL;
    }

    printf("Marvellous CVFS : UAREA gets initialised successfully\n");
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : InitialiseSuperBlock
// Description :   it is used to initialise SuperBlock
// Author :        Shreya Vilas Kulkarni
// Date:           31/07/2026
//
/////////////////////////////////////////////////////////////////////////

void InitialiseSuperBlock()
{
    superobj.TotalInodes = MAXINODE;
    superobj.FreeInodes = MAXINODE;

    printf("Marvellous CVFS : Super Block gets initialised successfully\n");
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : CreateDILB
// Description :   it is used to Create linked List of Inodes
// Author :        Shreya Vilas Kulkarni
// Date:           31/07/2026
//
/////////////////////////////////////////////////////////////////////////

void CreateDILB()
{
    int i = 0;
    PINODE temp = NULL;
    PINODE newn = NULL;

    temp = head;

    for(i= 1; i<= MAXINODE; i++)
    {
        newn = (PINODE)malloc(sizeof(INODE));

        newn->InodeNumber = i;
        strcpy(newn->FileName,"\0");
        newn->ActualFileSize = 0;
        newn->FileSize = 0;
        newn->ReferenceCount = 0;
        newn->Buffer = NULL;
        newn->FileType = 0;
        newn->Premission = 0;
        newn->next = NULL;

        if(temp == NULL)
        {
            head = newn;
            temp = head;
        }
        else
        {
            temp->next = newn;
            temp = temp->next;
        }

    }
    printf("Marvellous CVFS : DILB gets created successfully\n");
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : StartAuxillaryDataInitialisation
// Description :   it is used to Call all such functions which are used
//                 to initialise auxillary data
// Author :        Shreya Vilas Kulkarni
// Date:           31/07/2026
//
/////////////////////////////////////////////////////////////////////////

void StartAuxillaryDataInitialisation()
{
    strcpy(bootobj.Information,"Booting process of Marvellous CVFS is completed\n");

    printf("%s",bootobj.Information);
    
    InitialiseUAREA();

    InitialiseSuperBlock();

    CreateDILB();
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : DisplayHelp
// Description :   it is used to Display help
//                 to the user of project
// Author :        Shreya Vilas Kulkarni
// Date:           01/08/2026
//
/////////////////////////////////////////////////////////////////////////

void DisplayHelp()
{
    printf("-----------------------------------------------------------------\n");
    printf("-------------------Marvellous CVFS Help Page---------------------\n");
    printf("-----------------------------------------------------------------\n");

    printf("man : It is used to Display manual page \n");
    printf("clear : It is used to clear display screen \n");
    printf("creat : It is used to Create new regular file \n");
    printf("open : It is used to Open regular file \n");
    printf("close : It is used to Close the regular file \n");
    printf("write : It is used to write the data into the file \n");
    printf("read : It is used to read the data from file \n");
    printf("stat : It is used to Display statistical information of file \n");
    printf("unlink : It is used to delete the file \n");
    printf("exit : It is used to terminate Marvellous CVFS \n");

    printf("-----------------------------------------------------------------\n");

}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : ManPageDisplay
// Description :   it is used to Display man page
//                 of specific command to the user of project
// Input :         Name of command
// Author :        Shreya Vilas Kulkarni
// Date:           01/08/2026
//
/////////////////////////////////////////////////////////////////////////

void ManPageDisplay(char Name[])
{
    if(strcmp(Name,"exit") == 0 )
    {
        printf("About : It is used to terminate the project \n");
        printf("Usage : exit \n");
    }
    else if(strcmp(Name,"ls") == 0 )
    {
        printf("About : It is used to list all files from current Directory \n");
        printf("Usage : ls \n");
    }
    else if(strcmp(Name,"clear") == 0 )
    {
        printf("About : It is used to clear the terminal \n");
        printf("Usage : clear \n");
    }
    else
    {
        printf("No manual entry found for %s\n",Name);
    }
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : IsFileExist
// Description :   it is used to Check whether the 
//                 file is present or not
// Input :         Name of file
// Output :        true if present
//                 false if not present
// Author :        Shreya Vilas Kulkarni
// Date:           01/08/2026
//
/////////////////////////////////////////////////////////////////////////

bool IsFileExist(
                       char name[]  // name of file
                  )
{
    bool bFlag = false;
    PINODE temp = head;

    while(temp != NULL)
    {
        if(strcmp(temp->FileName,name) == 0)
        {
            bFlag = true;
            break;
        }
        temp = temp->next;
    }
    return bFlag;
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : CreateFile
// Description :   it is used to Create file
// Input :         Name of file and permossions
// Output :        File descriptor
// Author :        Shreya Vilas Kulkarni
// Date:           01/08/2026
//
/////////////////////////////////////////////////////////////////////////

int CreateFile(
                  char name[],     // Name of file
                  int permission   // File Permission
              )
{
    PINODE temp = head ;
    int i = 0;

    if(superobj.FreeInodes == 0)
    {
        return ERR_NO_INODES;
    }

    // if permission value is wrong 
    // permission = 1 -> READ
    // permission = 2 -> WRITE
    // permission = 3 -> READ + WRITE

    if(permission < 1 || permission > 3)
    {
        return ERR_INVALID_PARAMETER;
    }
    if(IsFileExist(name) == true)
    {
        return ERR_FILE_ALREADY_EXIST;
    }
    // Search for empty inode
    while(temp != NULL)
    {
        if(temp->FileType == 0)    // empty inode
        {
            break;
        }
        temp = temp->next;
    }

    // rare case
    if(temp == NULL)
    {
        return ERR_NO_INODES;
    }

    // search empty UFDT entry
    // reserve first 3 fd
    for(i = 3; i < MAXINODE ; i++)
    {
        if(uareaobj.UFDT[i] == NULL)
        {
            break;
        }
    }
    if(i == MAXOPENFILES)
    {
        return ERR_MAX_FILES_OPEN;
    }

    // Allocate memory fro file table

    uareaobj.UFDT[i] = (PFILETABLE)malloc(sizeof(FILETABLE));

    // initialise filetable

    uareaobj.UFDT[i]->ReadOffset = 0;
    uareaobj.UFDT[i]->WriteOffset = 0;
    uareaobj.UFDT[i]->Mode = permission;
    
    // Connect file table with inode

    uareaobj.UFDT[i]->ptrinode = temp;

    //initialise all members of inode

    strcpy(uareaobj.UFDT[i]->ptrinode->FileName,name);

    uareaobj.UFDT[i]->ptrinode->FileSize = MAXFILESIZE;

    uareaobj.UFDT[i]->ptrinode->ActualFileSize = 0;

    uareaobj.UFDT[i]->ptrinode->FileType = REGULARFILE;

    uareaobj.UFDT[i]->ptrinode->ReferenceCount = 1;

    uareaobj.UFDT[i]->ptrinode->Premission = permission;
    
    // allocate memoty for file's data (Data Block)

    uareaobj.UFDT[i]->ptrinode->Buffer = (char *)malloc(MAXFILESIZE);

    // Free Inode decrease
    superobj.FreeInodes--;

    return i;
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : LsFile
// Description :   it is used to Display names of all files
// Output :        None
// Author :        Shreya Vilas Kulkarni
// Date:           01/08/2026
//
/////////////////////////////////////////////////////////////////////////

void LsFile()
{
    PINODE temp = head;

    printf("-----------------------------------------------------------------\n");
    printf("----------------Marvellous CVFS Files Information----------------\n");
    printf("-----------------------------------------------------------------\n");

    while (temp != NULL)
    {
        if(temp->FileType != 0)
        {
            printf("%s\n",temp->FileName);
        }
        temp = temp->next;
    }
    
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : LsFile_All
// Description :   it is used to Display all details of all files
// Output :        None
// Author :        Shreya Vilas Kulkarni
// Date:           02/08/2026
//
/////////////////////////////////////////////////////////////////////////

void LsFile_All()
{
    PINODE temp = head;

    printf("-----------------------------------------------------------------\n");
    printf("----------------Marvellous CVFS Files Information----------------\n");
    printf("-----------------------------------------------------------------\n");

    while (temp != NULL)
    {
        if(temp->FileType != 0)
        {
            printf("%s %d %d \n",temp->FileName,temp->InodeNumber,temp->ActualFileSize);
        }
        temp = temp->next;
    }
    
}

/////////////////////////////////////////////////////////////////////////
//
// Function Name : stat_file
// Description :   it is used to Display all details of specific file
// Input :         File name
// Output :        exit status of function
// Author :        Shreya Vilas Kulkarni
// Date:           02/08/2026
//
/////////////////////////////////////////////////////////////////////////

int stat_file(char name[])
{
    PINODE temp = NULL;
    int permission = 0;
    int Type = 0;

    if(IsFileExist(name) == false)
    {
        return ERR_FILE_NOT_EXIST;
    }

    temp = head;

    while(temp != NULL)
    {
        if(strcmp(temp->FileName,name) == 0)
        {
            printf("-----------------------------------------------------------------\n");
            printf("-----------------Statistical Information of file-----------------\n");
            printf("-----------------------------------------------------------------\n");

            printf("File name : %s\n",temp->FileName);

            printf("Inode number : %d\n",temp->InodeNumber);

            printf("File size : %d\n",temp->FileSize);

            printf("Actual file size : %d\n",temp->ActualFileSize);

            printf("Reference count : %d\n",temp->ReferenceCount);

            permission = temp->Premission;

            if(permission == READ)
            {
                printf("File Permission : Read Only\n");
            }
            else if(permission == WRITE)
            {
                printf("File Permission : Write\n");
            }
            else if(permission == READ + WRITE)
            {
                printf("File Permission : Read + Write\n");
            }

            Type = temp->FileType;

            if(Type == REGULARFILE)
            {
                printf("File Type : Regular File \n");
            }
            else if(Type == SPECIALFILE)
            {
                printf("File Type : Special File \n");
            }

            printf("-----------------------------------------------------------------\n");

            break;
        }
        temp = temp->next;
    }

    return EXECUTE_SUCCESS;
}

/////////////////////////////////////////////////////////////////////////
//
// Entry point function of CVFS project
//
/////////////////////////////////////////////////////////////////////////

int main()
{
    char str[80] = {'\0'};
    char Command[5][20] = {{'\0'}};
    int iRet = 0, iCount = 0;

    StartAuxillaryDataInitialisation();

    printf("-----------------------------------------------------------------\n");
    printf("--------------Marvellous CVFS started Successfully---------------\n");
    printf("-----------------------------------------------------------------\n");

    // infinite listening Shell

    while(1)
    {
        fflush(stdin);
        strcpy(str,"");

        printf("\nMarvellous CVFS : > ");
        fgets(str,sizeof(str),stdin);

        iCount = sscanf(str,"%s %s %s %s %s",Command[0],Command[1],Command[2],Command[3],Command[4]);

        fflush(stdin);

        if(iCount == 1)
        {
            // Marvellous CVFS : > exit
            if(strcmp(Command[0],"exit") == 0)
            {
                printf("Thank you for using Marvellous CVFS\n");
                printf("Deallocating all resources of Marvellous CVFS\n");
                break;
            }
            // Marvellous CVFS : > help
            else if(strcmp(Command[0],"help") == 0 )
            {
                DisplayHelp();
            }
            // Marvellous CVFS : > clear
            else if(strcmp(Command[0],"clear") == 0 )
            {
                #ifdef _WIN32   
                    system("cls");
                #else   
                     system("clear");
                #endif 
            }
            // Marvellous CVFS : > ls
            else if(strcmp(Command[0],"ls") == 0 )
            {
                LsFile();
            }
            else
            {
                printf("Command not found\n");
                printf("Please refer help option to get more information\n");
                printf("Please refer manual page of command using man\n");
            }
        }
        else if(iCount == 2)
        {
            // Marvellous CVFS : > man open
            if(strcmp(Command[0],"man") == 0)
            {
                ManPageDisplay(Command[1]);
            }
            // Marvellous CVFS : > ls -a
            else if((strcmp(Command[0],"ls") == 0) && (strcmp(Command[1],"-a") == 0))
            {
                LsFile_All();
            }
            // Marvellous CVFS : > stat Ganesh.txt
            else if(strcmp(Command[0],"stat") == 0)
            {
                iRet = stat_file(Command[1]);

                if(iRet == ERR_FILE_NOT_EXIST)
                {
                    printf("Error : File not exists\n");
                }
            }
            else
            {
                printf("Command not found\n");
                printf("Please refer help option to get more information\n");
                printf("Please refer manual page of command using man\n");
            }
        }
        else if(iCount == 3)
        {
            // Marvellous CVFS : > creat Ganesh.txt 3
            if(strcmp(Command[0],"creat") == 0)
            {
                iRet = CreateFile(Command[1],atoi(Command[2]));

                if(iRet == ERR_NO_INODES)
                {
                    printf("Error : Unable to create new file\n");
                    printf("Because there is no free inode\n");
                }
                else if(iRet == ERR_INVALID_PARAMETER)
                {
                    printf("Error : Unable to create new file\n");
                    printf("Because parameters of command are Invalid\n");
                    printf("Please use manpage to get actual parameters\n");
                }
                else if(iRet == ERR_FILE_ALREADY_EXIST)
                {
                    printf("Error : Unable to create new file\n");
                    printf("Because File name is already present\n");
                    printf("Please use ls command to check names of all files\n");
                }
                else if(iRet == ERR_MAX_FILES_OPEN)
                {
                    printf("Error : Unable to create new file\n");
                    printf("Because UFDT is full\n");
                    printf("Please close some opened files\n");
                }
                else
                {
                    printf("File successfully created with FD : %d\n",iRet);
                }
            }
        }
        else if(iCount == 4)
        {
            
        }
        else
        {
            printf("Command not found\n");
            printf("Please refer help option to get more information\n");
            printf("Please refer manual page of command using man\n");
        }
        
    } // end of while
    
    return 0;
} // end of main