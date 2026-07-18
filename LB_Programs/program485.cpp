/*
ArrayX class with generic programming in OOP
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
        ~ArrayX()
        {
            delete []Arr;
        }
};

int main()
{
    ArrayX aobj(5);

    return 0;
}