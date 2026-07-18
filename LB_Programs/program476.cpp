/*
Maximum float function with another variable ans
*/

#include<iostream>
using namespace std;

float Maximum( float No1,float No2)
{
    float Ans;

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

    return 0;
}