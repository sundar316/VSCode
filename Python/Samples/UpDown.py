a=int(input())
c=0
if(a%2==0):
    c=a//2
else:
    c=a//2+1
start=0
end=a-1
n=1
li=[[0 for i in range(a)]for j in range(a)]
while(c!=0):
    for i in range(start,a):
        for j in range(a):
            if(i==start or i==end):
                li[i][j]=n
                n+=1
    start+=1
    end-=1
    c-=1

for i in  li:
    for j in i:
        print(j,end=" ")
    print()
