/*
Iteration(while) without i variable
while(iNo != 0)
*/

#include<stdio.h>

void Display(int iNo)
{
    while(iNo != 0)
    {
        printf("Jay Ganesh...\n");
        iNo--;
    }
}
int main()
{
    Display(7);

    return 0;
}