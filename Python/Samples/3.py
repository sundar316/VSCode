n=int(input())
a=0
for i in range(n):
    for j in range(n):
        if(i%2==0):
            a+=1
            if(a>=10):
                print(a,end=" ")
            else:
                print(a,end="  ")
        else:
            if(j==0):
                b=a+n
                a=b
            if(b>=10):
                print(b,end=" ")
            else:
                print(b,end="  ")
            b-=1
    print()