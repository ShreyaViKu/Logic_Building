/*
ArrayX class generic class 
tested with float
*/

#include<iostream>
using namespace std;

template <class T>
class ArrayX
{
    public :
        T *Arr;
        int size;

        ArrayX(int No)
        {
            this->size = No;
            Arr = new T[size];
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
        T Summation()
        {
            int i = 0;
            T sum = 0;

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
    ArrayX <float>aobj(5);

    aobj.Accept();
    aobj.Display();

    cout<<"Summation is : "<<aobj.Summation()<<endl;
    
    return 0;
}