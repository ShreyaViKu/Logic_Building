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

#define MAXINODE 10
#define MAXFILESIZE 50
#define MAXOPENFILES 10

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
    if(strcmp(Name,"exit"))
    {
        printf("About : It is used to terminate the project \n");
        printf("Usage : exit \n");
    }
    else if(strcmp(Name,"ls"))
    {
        printf("About : It is used to list all files from current Directory \n");
        printf("Usage : ls \n");
    }
    else if(strcmp(Name,"clear"))
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
            if(strcmp(Command[0],"exit") == 0)
            {
                printf("Thank you for using Marvellous CVFS\n");
                printf("Deallocating all resources of Marvellous CVFS\n");
                break;
            }
            else if(strcmp(Command[0],"help") == 0 )
            {
                DisplayHelp();
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
            if(strcmp(Command[0],"man") == 0)
            {
                ManPageDisplay(Command[1]);
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