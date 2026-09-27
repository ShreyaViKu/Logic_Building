/*
./Myexe 10 11
Addition ans = atoi(argv[1]) + atoi(argv[2]);
atoi included in stdlib
*/
#include<stdio.h>
#include<stdlib.h>

int main(int argc, char *argv[])
{
    int ans = 0;

    if(argc != 3)
    {
        printf("Invalid Number of arguments \n");
        return -1;
    }
    
    ans = atoi(argv[1]) + atoi(argv[2]); 

    printf("addition is : %d\n",ans);


    return 0;
}