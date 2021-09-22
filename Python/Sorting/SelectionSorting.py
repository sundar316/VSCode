arr=list(map(int,input().split()))
for i in range(0,len(arr)-1):
    min=i
    for j in range(i+1,len(arr)):
        if(arr[min]>arr[j]):
            min=j
    if(min!=i):
        arr[i],arr[min]=arr[min],arr[i]
print(arr)