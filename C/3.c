#include<stdio.h>
void pattern(int n) {
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i>=j)
                printf("* ");
        else
            printf("  ");
        }
        for(int j=1;j<n;j++){
            if(i+j>=n-1)
                printf("* ");
        else
            printf("  ");
        }
        for(int j=1;j<n;j++){
            if(i>=j)
                printf("* ");
        else
            printf("  ");
        }
        printf("\n");
        
    }
    for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
            if(i+j<=n-1)
                printf("* ");
        else
            printf("  ");
        }
        for(int j=1;j<n;j++){
            if(i<=j)
                printf("* ");
        else
            printf("  ");
        }
        for(int j=1;j<n;j++){
            if(i+j<=n-1)
                printf("* ");
        else
            printf("  ");
        }
        printf("\n");
        
    }

}
int main(){
    int n;
    scanf("%d",&n);
    pattern(n);
}