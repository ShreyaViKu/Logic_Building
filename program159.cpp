#include<iostream>
using namespace std;

#pragma pack(1)
class ArrayX
{
    public:
        int *Arr;
        int iSize;

        // Parametrized constuctor
        ArrayX(int x)
        {
            cout<<"Inside constructor \n";

            iSize= x;               // Characteristics initialization

            Arr = new int[iSize];   // Resource allocation in constructor
        }

        // Destructor
        ~ArrayX()
        {
            cout<<"Inside destructor \n";
            
            delete []Arr;           // Resource deallocation
        }
};

int main()
{ 
    // Ststic memory allocation for object :
    //ArrayX aobj1(5); 

    ArrayX *aobj1 = new ArrayX(5);
    return 0;
}