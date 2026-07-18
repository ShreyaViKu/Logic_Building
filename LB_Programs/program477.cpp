/*
Maximum float function with ? : function
Ternary operator
*/

#include<iostream>
using namespace std;

float Maximum( float No1,float No2)
{
    float Ans;

    (No1 > No2) ? Ans = No1 : Ans = No2;

    return Ans;
}

int main()
{
    cout<<Maximum(11.4f,10.4f)<<endl;

    return 0;
}