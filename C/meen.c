#include<stdio.h>
int main(){
    int a,i,j;
    scanf("%d",&a);
    for(i=0;i<a;i++){
        for(j=0;j<a;j++){
            if(i>=j)
                printf("* ");
            else
                printf("  ");
        }
        for(j=1;j<a;j++){
            if(i+j>=a-1)
                printf("* ");
            else
                printf("  ");
        }
        for(j=1;j<a;j++){
            if(i>=j)
                printf("* ");
            else
                printf("  ");
        }
    printf("\n");
    }
    for(i=1;i<a;i++){
        for(j=0;j<a;j++){
            if(i+j<=a-1)
                printf("* ");
            else
                printf("  ");
        }
        for(j=1;j<a;j++){
            if(i<=j)
                printf("* ");
            else
                printf("  ");
        }
        for(j=1;j<a;j++){
            if(i+j<=a-1)
                printf("* ");
            else
                printf("  ");
        }
    printf("\n");
    }
    
}