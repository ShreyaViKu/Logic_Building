/*
Maximum function generic programming
*/

#include<iostream>
using namespace std;

template <class T>
T Maximum( T No1,T No2)
{
    T Ans;

    if(No1 > No2 )
    {
        Ans = No1;
    }
    else
    {
        Ans = No2;
    }
    return Ans;
}

int main()
{
    cout<<Maximum(11,10)<<endl;
    cout<<Maximum(11.4f,10.4f)<<endl;
    cout<<Maximum(11.43,10.423)<<endl;

    return 0;
}