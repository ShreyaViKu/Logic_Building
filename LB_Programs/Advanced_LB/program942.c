/*
Command line arguments 
int main(int argc, char *argv[]) by default exe name considered
*/
#include<stdio.h>

int main(int argc, char *argv[])
{
    printf("%s\n",argv[0]);

    printf("Number of arguments are : %d\n",argc);

    return 0;
}