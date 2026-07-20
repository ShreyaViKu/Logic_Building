/*
Iteration(while) for with parameter in Display and frequency from user
*/

#include<stdio.h>

void Display(int iNo)
{
    auto int i = 0;
    i =1;
    while(i <= iNo)
    {
        printf("Jay Ganesh...\n");
        i++;
    }
}
int main()
{
    int iValue = 0;

    printf("Enter Frequency : \n");
    scanf("%d",&iValue);

    Display(iValue);

    return 0;
}