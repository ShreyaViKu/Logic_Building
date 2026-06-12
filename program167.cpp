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
};

int main()
{ 
    ArrayX *aobj1 = new ArrayX();   // parametrized constructor call

    ArrayX *aobj2 = new ArrayX(15);    // parametrized constructor call

    // Function call
    
    // Destructor call
    delete aobj1;
    delete aobj2;
    
    return 0;
}