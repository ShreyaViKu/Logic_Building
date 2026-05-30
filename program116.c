#include<stdio.h>

void Display(int Arr[], int iSize)
{
    int iCnt = 0;

    for(iCnt = 0; iCnt < iSize; iCnt ++)
    {
        printf("%d \n",Arr[iCnt]);
    }

}

int main()
{
    int iLength = 4;
    int Brr[iLength];  // for this we have to do member by member intialization

    Brr[0] = 10;
    Brr[1] = 20;
    Brr[2] = 30;
    Brr[3] = 40;
    Brr[4] = 50;

    Display(Brr, iLength);

    return 0;
}