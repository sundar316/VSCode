#include<stdio.h>
#include<conio.h>
int Factorial(int n){
    if(n==0)
        return 1;
    else
        return(n*Factorial(n-1));
}
void main(){
    int n;
    scanf("%d",&n);
    printf("%d",Factorial(n));
}