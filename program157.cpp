#include<iostream>
using namespace std;

#pragma pack(1)
class ArrayX
{
    public:
        int *Arr;
        int iSize;

        // Default constructor
        ArrayX()
        {

        }

        // Parametrized constuctor
        ArrayX(int X)
        {

        }

};

int main()
{
    ArrayX aobj1;       // default
    ArrayX aobj2(5);        // parameterized

    cout<<sizeof(aobj2)<<endl;    

    return 0;
}