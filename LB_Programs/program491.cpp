/*
ArrayX class generic programming
function outside class
*/

#include<iostream>
using namespace std;

template <class T>
class ArrayX
{
    public :
        T *Arr;
        int size;

        ArrayX(int No);
        void Accept();
        void Display();
        T Summation();
        ~ArrayX();
};

template <class T>
ArrayX<T> :: ArrayX(int No)
{
    this->size = No;
    Arr = new T[size];
}

template <class T>
void ArrayX<T> :: Accept()
{
    int i = 0;

    cout<<"Enter the elements : \n";

    for(i = 0; i<size; i++)
    {
        cin>>Arr[i];
    }
}

template <class T>
void ArrayX<T> :: Display()
{
    int i = 0;

    cout<<"Elements of array are : \n";

    for(i = 0; i<size; i++)
    {
        cout<<Arr[i]<<endl;
    }
}

template <class T>
T ArrayX<T> :: Summation()
{
    int i = 0;
    T sum = 0;

    for(i = 0; i<size; i++)
    {
        sum = sum + Arr[i];
    }
    return sum;
}

template <class T>
ArrayX<T> :: ~ArrayX ()
{
    delete []Arr;
}

int main()
{
    ArrayX <int>aobj(5);

    aobj.Accept();
    aobj.Display();

    cout<<"Summation is : "<<aobj.Summation()<<endl;
    
    return 0;
}