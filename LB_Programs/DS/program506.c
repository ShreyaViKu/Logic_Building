/*
Display call infinitely time in Display fun with auto i
*/

#include<stdio.h>

void Display()
{
    static int i = 1;

    printf("Jay Ganesh...%d\n",i);

    i++;

    Display();
}
int main()
{
    Display();

    return 0;
}