/*
File Creation fd display as 3 as 0 1 2 are occupied
*/

#include<stdio.h>
#include<fcntl.h>   // file control .h

int main()
{
    int fd = 0;    // file descriptor

    fd = creat("Marvellous.txt",0777);  // 0777 permission for owner reader

    if(fd == -1)
    {
        printf("Unalble to create file with fd \n");
    }
    else
    {
        printf("File gets succssfully created with %d\n",fd);
    }
    return 0;
}