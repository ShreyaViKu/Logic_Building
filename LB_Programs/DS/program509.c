/*
recursion in Display with if conditions 
but initalization i to 0 so ISSUE
*/

#include<stdio.h>

void Display()
{
    static int i = 0;
     
    i =1;      // ISSUE
    if(i <=4)
    {
        printf("Jay Ganesh...\n");
        i++;
        Display();
    }
}
int main()
{
    Display();

    return 0;
}