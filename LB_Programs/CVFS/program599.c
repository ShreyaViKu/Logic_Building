/*
function parameter chsr array with * 
*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024     

// change in parameter 

void Display(char * FileName)
{
    char Bufffer[BUFFER_SIZE] = {'\0'};
    int iRet = 0, fd = 0;

    fd = open(FileName,O_RDONLY);
    if(fd == -1)
    {
        printf("Unable to open file\n");
        return;
    }

    while((iRet = read(fd,Bufffer,sizeof(Bufffer))) != 0)
    {
        write(1,Bufffer,iRet);
        memset(Bufffer,'\0',sizeof(Bufffer));
    }

    close(fd);

}

int main()
{
    char Fname[30] = {'\0'};

    printf("enter file name : \n");
    scanf("%[^'\n']s",Fname);

    Display(Fname);

    return 0;
}