#include<iostream>
using namespace std;

int Summation(int Arr[], int iSize)
{
    int iSum =0, iCnt = 0;

    for(iCnt = 0; iCnt < iSize; iCnt++)
    {
        iSum += Arr[iCnt];
    }
    return iSum;
}

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0, iRet = 0;

    cout << "Enter number of elements : ";
    cin >> iLength;

    // Dynamic memory allocation
    Brr = new int[iLength];

    cout << "Enter elements : \n";
    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        cin >> Brr[iCnt];
    }

    cout << "Elements are : \n";
    for(iCnt = 0; iCnt < iLength; iCnt++)
    {
        cout << Brr[iCnt] << endl;
    }

    iRet = Summation(Brr, iLength);

    cout<<"Summation is : "<<iRet<<endl;

    delete[] Brr;
    Brr = NULL;

    return 0;
}