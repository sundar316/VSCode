a=int(input())
size=a*2-1
start=0
end=size-1
l=[[0 for i in range(size)] for j in range(size)]
while(a!=0):
    for i in range(start, end+1):
        for j in range(start, end+1):
            if(i==start or i==end or j==start or j==end):
                l[i][j]=a
    start+=1
    end-=1
    a-=1

for i in l:
    for j in i:
        print(j,end="")
    print()