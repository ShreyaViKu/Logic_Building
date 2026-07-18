/*
ArrayX class Summation function not generic
*/

#include<iostream>
using namespace std;

class ArrayX
{
    public :
        int *Arr;
        int size;

        ArrayX(int No)
        {
            this->size = No;
            Arr = new int[size];
        }
        void Accept()
        {
            int i = 0;

            cout<<"Enter the elements : \n";

            for(i = 0; i<size; i++)
            {
                cin>>Arr[i];
            }
        }
        void Display()
        {
            int i = 0;

            cout<<"Elements of array are : \n";

            for(i = 0; i<size; i++)
            {
                cout<<Arr[i]<<endl;
            }
        }
        int Summation()
        {
            int i = 0;
            int sum = 0;

            for(i = 0; i<size; i++)
            {
                sum = sum + Arr[i];
            }
            return sum;
        }
        ~ArrayX()
        {
            delete []Arr;
        }
};

int main()
{
    ArrayX aobj(5);

    aobj.Accept();
    aobj.Display();

    cout<<"Summation is : "<<aobj.Summation()<<endl;
    
    return 0;
}