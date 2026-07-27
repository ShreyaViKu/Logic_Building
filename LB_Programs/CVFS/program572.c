/*
File Creation
*/

#include<stdio.h>
#include<fcntl.h>   // file control .h

int main()
{
    int fd = 0;    // file descriptor

    fd = creat("Marvellous.txt",0777);  // 0777 permission for owner reader

    if(fd == -1)
    {
        printf("Unalble to create file \n");
    }
    else
    {
        printf("File gets succssfully created\n");
    }
    return 0;
}