/*
File open code with fd 3
*/

#include<stdio.h>
#include<fcntl.h>   // file control .h

int main()
{
    int fd = 0;    // file descriptor

    fd = open("Marvellous.txt",O_RDONLY); 

    if(fd == -1)
    {
        printf("Unalble to Open file with \n");
    }
    else
    {
        printf("File gets succssfully opened with %d\n",fd);
    }
    return 0;
}