#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include<stdbool.h>

int main()
{
    #ifdef _WIN32   
        printf("Project is Running on Windows platform\n");
    #else   
         printf("Project is Running on Linux/MacOs platform\n");
    #endif    

    return 0;
}