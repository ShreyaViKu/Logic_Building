/*
File open and close header file unistd for linux for close
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   // only linux based os for close

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

        close(fd);
    }
    return 0;
}