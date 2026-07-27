/*
specific BST in CPP
*/

#include<iostream> 
using namespace std;

#pragma pack(1)
struct node
{
    int data;
    struct node * lchild;
    struct node * rchild;
};

class BST
{
    private :
        struct node * first;
        int iCount;

        void InorderX(struct node * temp);
        void PreorderX(struct node * temp);
        void PostorderX(struct node * temp);

        int CountLeafX(struct node * temp);
        int CountParentX(struct node * temp);

        bool SearchX(struct node * temp, int iNo);

    public :
        BST();
        ~BST();
        
        void Insert(int iNo);
        void Inorder();
        void Preorder();
        void PostOrder();

        int Count();
        int CountLeaf();
        int Countparent();

        bool Search(int iNo);
};

BST :: BST()
{
    this->first = NULL;
    this->iCount = 0;
}

BST :: ~BST()
{
    delete this->first;
}

void BST :: Insert(int iNo)
{
    struct node * temp = NULL;
    struct node * newn = NULL;
    newn = new struct node;

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

void BST :: InorderX(struct node * temp)
{
    if(temp != NULL)
    {
        InorderX(temp->lchild);
        cout<<temp->data<<endl;
        InorderX(temp->rchild);
    }
}
void BST :: Inorder()
{
    InorderX(this->first);
}

void BST :: PreorderX(struct node *temp)
{
    if(temp != NULL)
    {
        cout<<temp->data<<endl;
        PreorderX(temp->lchild);
        PreorderX(temp->rchild);
    }
}
void BST :: Preorder()
{
    PreorderX(this->first);
}

void BST :: PostorderX(struct node *temp)
{
    if(temp != NULL)
    {
        PostorderX(temp->lchild);
        PostorderX(temp->rchild);
        cout<<temp->data<<endl;
    }
}
void BST :: PostOrder()
{
    PostorderX(this->first);
}

int BST :: Count()
{
    return this->iCount;
}

int BST :: CountLeafX(struct node * temp)
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
int BST :: CountLeaf()
{
    return CountLeafX(this->first);
}

int BST :: CountParentX(struct node * temp)
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
int BST :: Countparent()
{
    return CountParentX(this->first);
}

bool BST :: SearchX(struct node * temp, int iNo)
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
bool BST :: Search(int iNo)
{
    return SearchX(this->first,iNo);
}

int main()
{
    BST bobj;
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

    if(bobj.Search(5))
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