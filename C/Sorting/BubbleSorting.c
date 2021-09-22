#include<stdio.h>
void main()
{
    int arr[5],flag=0;
    for(int i=0;i<5;i++)
        scanf("%d",&arr);
    for(int i=0;i<5;i++)
    {
        for(int j=0;j<4;j++)
        {
            if(arr[j]>arr[j+1])
            {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                flag=1;
            }
            if(flag==0)
                break;
        }
    }
    for(int i=0;i<5;i++)
        printf("%d",arr[i]);
}