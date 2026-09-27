/*
./Myexe 10 11
Addition  error as argv is chr warning
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
    
    ans = (int)argv[1] + (int)argv[2];  // warning

    printf("addition is : %d\n",ans);


    return 0;
}