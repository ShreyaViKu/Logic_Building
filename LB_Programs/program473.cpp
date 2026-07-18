/*
generic programming 
Addition function 
*/

#include<iostream>
using namespace std;

template <class T>
T Addition(T No1, T No2)
{
    T Ans;

    Ans = No1+No2;

    return Ans;
}

int main()
{
    cout<<Addition(11,10)<<endl;
    cout<<Addition(11.5f,10.2f)<<endl;
    cout<<Addition(11.2,10.5)<<endl;

    return 0;
}