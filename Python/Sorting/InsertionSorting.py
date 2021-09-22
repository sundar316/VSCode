arr=list(map(int,input().split()))
j=0
for i in range(1,len(arr)):
    temp=arr[i]
    for j in range(i-1,j>-1 and temp<arr[j],-1):
        arr[j+1]=arr[j]
    arr[j+1]=temp
print(arr)
