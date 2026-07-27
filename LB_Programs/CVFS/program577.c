/*
write into file
write returns no of bytes successfully written 
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   // only linux based os for close

int main()
{
    int fd = 0;  
    int iRet = 0;

    fd = open("Marvellous.txt",O_RDWR); 

    if(fd == -1)
    {
        printf("Unalble to Open file \n");
    }
    else
    {
        printf("File gets succssfully opened with %d\n",fd);

        iRet = write(fd,"Jay Ganesh...",13);   // write returns no of bytes successfully written 

        printf("%d of bytes successfully written\n",iRet);

        close(fd);
    }
    return 0;
}