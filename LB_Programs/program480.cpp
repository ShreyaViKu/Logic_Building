/*
Maximum function with 3 variable generic programming
T replaced with X
*/

#include<iostream>
using namespace std;

template <class X>
X Maximum( X No1,X No2, X No3)
{

    if(No1 > No2 && No1 > No3 )
    {
        return No1;
    }
    else if( No2 > No1 && No2 > No3)
    {
        return No2;
    }
    else
    {
        return No3;
    }
}

int main()
{
    cout<<Maximum(11,101,9)<<endl;
    cout<<Maximum(11.4f,10.4f,9.4f)<<endl;
    cout<<Maximum(11.43,101.423,229.43)<<endl;

    return 0;
}