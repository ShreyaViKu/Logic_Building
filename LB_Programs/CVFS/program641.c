#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include<stdbool.h>

int main()
{
    #ifdef _WIN32   // macro for windows
        system("dir");
    #else   
        system("ls");
    #endif    // Preprocessor la sanga kam sampl

    return 0;
}