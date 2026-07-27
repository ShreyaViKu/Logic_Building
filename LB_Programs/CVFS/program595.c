/*
printf internally calls write system call
0 - stdin keyboard
1 - stdout console
2 - stderr error for console

*/

#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<string.h>

#define BUFFER_SIZE 1024     // Macro

int main()
{
    write(1,"Jay Ganesh...",13);

    return 0;
}