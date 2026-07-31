/*
Display file inforamtion 
*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>
#include<sys/stat.h>   

#define BUFFER_SIZE 1024     

void DisplayFileInformation(char FileName[])
{
    struct stat sobj;     

    stat(FileName,&sobj);   

    printf("File name : %s\n",FileName);
    printf("Inode number : %llu\n",sobj.st_ino);
    printf("File size : %lld\n",(long long)sobj.st_size);   // %d also works 

}

int main()
{
    char Fname[30] = {'\0'};
    printf("enter file name : \n");
    scanf("%[^'\n']s",Fname);

    DisplayFileInformation(Fname);

    return 0;
}