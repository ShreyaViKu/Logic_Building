/*
write into file
string header file for string length to tell write fun
APPEND ALL mAREVELLOUS iNFOSYSTEM
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   
#include<string.h>

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

        iRet = write(fd,Data,strlen(Data));    

        printf("%d of bytes successfully written\n",iRet);

        close(fd);
    }
    return 0;
}