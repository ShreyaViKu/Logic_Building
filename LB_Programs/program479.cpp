/*
Maximum function generic programming
T replaced with X
*/

#include<iostream>
using namespace std;

template <class X>
X Maximum( X No1,X No2)
{
    X Ans;

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