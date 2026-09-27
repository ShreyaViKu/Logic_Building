/*
./Myexe 10 11
Addition  error as argv is char array so int not done
*/
#include<stdio.h>

int main(int argc, char *argv[])
{
    int ans = 0;

    if(argc != 3)
    {
        printf("Invalid Number of arguments \n");
        return -1;
    }
    
    ans = argv[1] + argv[2];  Error

    printf("addition is : %d\n"+ans);


    return 0;
}