/*
unlink delete file with just name
*/

#include<stdio.h>
#include<fcntl.h>   
#include<unistd.h>   
#include<string.h>

#define BUFFER_SIZE 100

int main()
{
    unlink("Marvellous.txt");

    return 0;
}