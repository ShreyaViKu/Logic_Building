/*
read from file to empty 2 buffer data and datax
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   
#include<string.h>

int main()
{
    int fd = 0;  
    int iRet = 0;
    char Data[100] = {'\0'};   
    char DataX[100] = {'\0'};

    fd = open("Marvellous.txt",O_RDONLY); 

    if(fd == -1)
    {
        printf("Unalble to Read file \n");
    }
    else
    {
        printf("File gets succssfully opened with %d\n",fd);

        iRet = read(fd,Data,13);    

        printf("%d of bytes successfully read\n",iRet);

        printf("data from file is %s\n",Data);

        iRet = read(fd,DataX,3);    

        printf("%d of bytes successfully read\n",iRet);

        printf("data from file is %s\n",DataX); 

        close(fd);
    }
    return 0;
}