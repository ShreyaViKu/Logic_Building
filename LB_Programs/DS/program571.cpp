/*
specific BST Generic code
*/

#include<iostream> 
using namespace std;

#pragma pack(1)
template <class T>
struct node
{
    T data;
    struct node * lchild;
    struct node * rchild;
};

template <class T>
class BST
{
    private :
        struct node<T> * first;
        int iCount;

        void InorderX(struct node<T> * temp);
        void PreorderX(struct node<T> * temp);
        void PostorderX(struct node<T> * temp);

        int CountLeafX(struct node<T> * temp);
        int CountParentX(struct node<T> * temp);

        bool SearchX(struct node<T> * temp, T iNo);

    public :
        BST();
        ~BST();
        
        void Insert(T iNo);
        void Inorder();
        void Preorder();
        void PostOrder();

        int Count();
        int CountLeaf();
        int Countparent();

        bool Search(T iNo);
};

template <class T>
BST<T> :: BST()
{
    this->first = NULL;
    this->iCount = 0;
}

template <class T>
BST<T> :: ~BST()
{
    delete this->first;
}

template <class T>
void BST<T> :: Insert(T iNo)
{
    struct node<T> * temp = NULL;
    struct node<T> * newn = NULL;
    newn = new struct node<T>;

    newn->data = iNo;
    newn->lchild = NULL;
    newn->rchild = NULL;

    if(first == NULL)
    {
        first = newn;
        this->iCount++;
    }
    else
    {
        temp = this->first;
        while(1)
        {
            if(iNo > temp->data)
            {
                if(temp->rchild == NULL)
                {
                    temp->rchild = newn;
                    this->iCount++;
                    break;
                }
                temp = temp->rchild;
            }
            else if(iNo < temp->data)
            {
                if(temp->lchild == NULL)
                {
                    temp->lchild = newn;
                    this->iCount++;
                    break;
                }
                temp = temp->lchild;
            }
            else
            {
                cout<<"Unable to insert data as its duplicate \n";
                delete newn;
                break;
            }
        }
    }
}

template <class T>
void BST<T> :: InorderX(struct node<T> * temp)
{
    if(temp != NULL)
    {
        InorderX(temp->lchild);
        cout<<temp->data<<endl;
        InorderX(temp->rchild);
    }
}
template <class T>
void BST<T> :: Inorder()
{
    InorderX(this->first);
}

template <class T>
void BST<T> :: PreorderX(struct node<T> *temp)
{
    if(temp != NULL)
    {
        cout<<temp->data<<endl;
        PreorderX(temp->lchild);
        PreorderX(temp->rchild);
    }
}
template <class T>
void BST<T> :: Preorder()
{
    PreorderX(this->first);
}

template <class T>
void BST<T> :: PostorderX(struct node<T> *temp)
{
    if(temp != NULL)
    {
        PostorderX(temp->lchild);
        PostorderX(temp->rchild);
        cout<<temp->data<<endl;
    }
}
template <class T>
void BST<T> :: PostOrder()
{
    PostorderX(this->first);
}

template <class T>
int BST<T> :: Count()
{
    return this->iCount;
}

template <class T>
int BST<T> :: CountLeafX(struct node<T> * temp)
{
    static int count = 0;

    if(temp != NULL)
    {
        if((temp->lchild == NULL) && (temp->rchild == NULL))
        {
            count++;
        }
        CountLeafX(temp->rchild);
        CountLeafX(temp->lchild);
    }
    return count;
}
template <class T>
int BST<T> :: CountLeaf()
{
    return CountLeafX(this->first);
}

template <class T>
int BST<T> :: CountParentX(struct node<T> * temp)
{
    static int count = 0;

    if(temp != NULL)
    {
        if((temp->lchild != NULL) || (temp->rchild != NULL))
        {
            count++;
        }
        CountParentX(temp->rchild);
        CountParentX(temp->lchild);
    }
    return count;
}
template <class T>
int BST<T> :: Countparent()
{
    return CountParentX(this->first);
}

template <class T>
bool BST<T> :: SearchX(struct node<T> * temp, T iNo)
{
    bool bFlag = false;

    while(temp != NULL)
    {
        if(iNo == temp->data)
        {
            bFlag = true;
            break;
        }
        else if(iNo > temp->data)
        {
            temp = temp->rchild;
        }
        else
        {
            temp = temp->lchild;
        }
    }
    return bFlag;
}
template <class T>
bool BST<T> :: Search(T iNo)
{
    return SearchX(this->first,iNo);
}

int main()
{
    BST<int> bobj;
    int iRet = 0;

    bobj.Insert(11);
    bobj.Insert(21);
    bobj.Insert(17);
    bobj.Insert(5);
    bobj.Insert(6);
    bobj.Insert(27);
    bobj.Insert(2);

    cout<<"Inorder Display : \n";
    bobj.Inorder();

    cout<<"Preorder Display : \n";
    bobj.Preorder();

    cout<<"Postorder Display : \n";
    bobj.PostOrder();

    iRet = bobj.Count();
    cout<<"Number of elements are : "<<iRet<<endl;

    if(bobj.Search(55))
    {
        cout<<"Element found\n";
    }
    else
    {
        cout<<"Element not found\n";
    }

    iRet = bobj.CountLeaf();
    cout<<"Number of Leaf nodes are : "<<iRet<<endl;

    iRet = bobj.Countparent();
    cout<<"Number of Parent nodes are : "<<iRet<<endl;

    return 0;
}