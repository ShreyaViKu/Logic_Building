/*
function to calculate size with stat library
*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>
#include<sys/stat.h>    // for size calculation mam page paha

#define BUFFER_SIZE 1024     

int CalculateFileSize(char FileName[])
{
    struct stat sobj;     // structure object of stat its inbuild

    stat(FileName,&sobj);   

    return sobj.st_size;

}

int main()
{
    char Fname[30] = {'\0'};
    int iRet =  0;

    printf("enter file name : \n");
    scanf("%[^'\n']s",Fname);

    iRet = CalculateFileSize(Fname);

    printf("Size of file is %d bytes\n",iRet);
    return 0;
}