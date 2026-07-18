/*
generic programming 
Maximum function float
*/

#include<iostream>
using namespace std;

float Maximum( float No1,float No2)
{
    if(No1 > No2 )
    {
        return No1;
    }
    else
    {
        return No2;
    }
}

int main()
{
    cout<<Maximum(11,10)<<endl;
    cout<<Maximum(11.4f,10.4f)<<endl;

    return 0;
}