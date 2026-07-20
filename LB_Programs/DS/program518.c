/*
recursion in Display without i ISSUE
Display(iNo--);
*/

#include<stdio.h>

void Display(int iNo)
{
    if(iNo != 0)
    {
        printf("Jay Ganesh...%d\n",iNo);
        
        Display(iNo--);     // Issue
    }
}
int main()
{
    int iValue = 0;

    printf("Enter Frequency : \n");
    scanf("%d",&iValue);

    Display(iValue);

    printf("End of main\n");

    return 0;
}