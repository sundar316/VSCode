#include<stdio.h>
int main()
{
    int arr[]={1,2,3,4,5};
    int* ptr;
    ptr=arr;
    for(int i=0;i<5;i++)
    {
        printf("%d\t",*ptr);
        ptr++;
    }
    return 0;
}