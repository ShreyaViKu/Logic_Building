/*
Array LinearSearch
*/

#include<iostream>
using namespace std;

class Searching
{
    private :
        int * Arr;
        int iSize;

    public :
        Searching(int iNo);
        ~Searching();

        void Accept();
        void Display();

        bool LinearSearch(int iNo);
};

Searching :: Searching(int iNo)
{
    this->iSize = iNo;

    Arr = new int[iSize];
}

Searching :: ~Searching()
{
    delete []Arr;
}

void Searching :: Accept()
{
    int i = 0;

    cout<<"Enter the elements : \n";

    for(i = 0; i < iSize; i++)
    {
        cin>>Arr[i];
    }
}

void Searching :: Display()
{
    int i = 0;

    cout<<"Elements of Array are  : \n";

    for(i = 0; i < iSize; i++)
    {
        cout<<Arr[i]<<endl;
    }
}

bool Searching :: LinearSearch(int iNo)
{ 
    bool bFlag = false;
    int i = 0;

    for(i = 0; i< iSize; i++)
    {
        if(iNo == Arr[i])
        {
            bFlag = true;
            break;
        }
    }
    return bFlag;
}

int main()
{
    Searching sobj(5);

    sobj.Accept();
    sobj.Display();

    if(sobj.LinearSearch(30))
    {
        cout<<"element is present\n";
    }
    else
    {
        cout<<"There is no such element\n";
    }
    
    return 0;
}
