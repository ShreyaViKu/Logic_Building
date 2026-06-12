#include<iostream>
using namespace std;

#pragma pack(1)
class ArrayX
{
    private:
        int *Arr;
        int iSize;

    public:
        // parametrized constructor with default argument
        ArrayX(int x = 5)
        {
            iSize= x;               

            Arr = new int[iSize];  
        }

        ~ArrayX()
        {
            delete []Arr;           
        }

        void Accept()
        {
            int iCnt = 0;

            cout<<"Enter the elements : \n";

            for(iCnt = 0; iCnt < iSize; iCnt++ )
            {
                cin>>Arr[iCnt];
            }
        }

        void Display()
        {
            int iCnt = 0;

            cout<<"elements of the array are : \n";

            for(iCnt = 0; iCnt < iSize; iCnt++ )
            {
                cout<<Arr[iCnt]<<endl;
            }
        }

        int Summation()
        {
            int iSum = 0, iCnt = 0;

            for(iCnt = 0; iCnt < iSize; iCnt++ )
            {
                iSum += Arr[iCnt];
            }

            return iSum;
        }
};

int main()
{ 
    ArrayX *aobj = NULL;
    int iLength = 0, iRet = 0;

    cout<<"Enter the number of elements : \n";
    cin>>iLength;

    aobj = new ArrayX(iLength);

    aobj->Accept();

    aobj->Display();

    iRet = aobj->Summation();

    cout<<"Summation is : "<<iRet<<endl;

    delete aobj;
    
    return 0;
}