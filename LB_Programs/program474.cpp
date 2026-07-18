/*
generic programming 
Maximum function int
*/

#include<iostream>
using namespace std;

int Maximum( int No1, int No2)
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

    return 0;
}