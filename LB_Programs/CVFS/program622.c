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
        newn->FileName[0] = '\0';
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
// Entry point function of CVFS project
//
/////////////////////////////////////////////////////////////////////////

int main()
{
    StartAuxillaryDataInitialisation();

    return 0;
}