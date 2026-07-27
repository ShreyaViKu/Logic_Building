/*
write into file
write(fd,Data,10);  APPEND ONLY mARVELLOUS
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   // only linux based os for close

int main()
{
    int fd = 0;  
    int iRet = 0;
    char Data[] = "Marvellous Infosystems";

    fd = open("Marvellous.txt",O_RDWR | O_APPEND); 

    if(fd == -1)
    {
        printf("Unalble to Open file \n");
    }
    else
    {
        printf("File gets succssfully opened with %d\n",fd);

        iRet = write(fd,Data,10);    

        printf("%d of bytes successfully written\n",iRet);

        close(fd);
    }
    return 0;
}