#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int weight(char* a)
{
    int w=0;
    int i=0;
    char *A;
    A=a;
    char letter;
    for(i=0;i<strlen(A);i++){
        letter=A[i];
        if(letter>=65 && letter<=90)
        {
            w+=letter-64;
        }
        else if(letter>=97 && letter<=122)
        {
            w+=letter-96;
        }
        return w;
    }
}

int main(){
    char str[100];
    int x;
    scanf("%[^\n]%*c", str);
    x=weight(str);
    if(x%5==0){
        printf("TRUE");
    }
    else{
        printf("FALSE");
    }

    return 0;
}