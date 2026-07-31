#include<stdio.h>

int main()
{
    char str[80] = {'\0'};

    //char Command1[20] = {'\0'};
    //char Command2[20] = {'\0'};
    //char Command3[20] = {'\0'};

    char Command[4][20] = {{'\0'}};

    printf("Enter command : \n");
    fgets(str,sizeof(str),stdin);

    printf("Entered command is : %s \n",str);

    sscanf(str,"%s %s %s",Command[0],Command[1],Command[2]);

    printf("first token : %s\n",Command[0]);
    printf("second token : %s\n",Command[1]);
    printf("third token : %s\n",Command[2]);

    return 0;
}