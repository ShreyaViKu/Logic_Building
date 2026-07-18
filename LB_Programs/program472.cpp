/*
generic programming teach
Addition function Double Float Int
Not implemented
*/

#include<iostream>
using namespace std;

double AdditionD(double No1, double No2)
{
    double Ans;

    Ans = No1+No2;

    return Ans;
}
float AdditionF(float No1, float No2)
{
    float Ans;

    Ans = No1+No2;

    return Ans;
}
int AdditionI(int No1, int No2)
{
    int Ans;

    Ans = No1+No2;

    return Ans;
}

int main()
{
    cout<<AdditionI(11,10)<<endl;
    cout<<AdditionF(11.5f,10.2f)<<endl;
    cout<<AdditionD(11.2,10.5)<<endl;

    return 0;
}