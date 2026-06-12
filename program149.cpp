#include<iostream>
using namespace std;

int main()
{
    int *Brr = NULL;
    int iLength = 0, iCnt = 0;

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

    delete[] Brr;
    Brr = NULL;

    return 0;
}