/*
write into file
write(fd,"Jay Ganesh...",13);
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   // only linux based os for close

int main()
{
    int fd = 0;  

    fd = open("Marvellous.txt",O_RDWR); 

    if(fd == -1)
    {
        printf("Unalble to Open file \n");
    }
    else
    {
        printf("File gets succssfully opened with %d\n",fd);

        write(fd,"Jay Ganesh...",13);

        close(fd);
    }
    return 0;
}