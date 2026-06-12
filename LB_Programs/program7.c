#include<stdio.h>

int main()
{
    float i = 0.0f;
    // To store first input

    float j = 0.0f;
    // To store secont input

    float k=0.0f;
    // To store result

    printf("Enter first number : \n");
    scanf("%f",&i);

    printf("Enter second number : \n");
    scanf("%f",&j);

    k=i+j;
    // Perform the Addition

    printf("Addition is : %f\n",k);
    return 0;
}