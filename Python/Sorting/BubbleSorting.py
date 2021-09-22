arr=list(map(int,input().split())) #[:5]
flag=True
for i in arr:
    for j in range(0,len(arr)-1):
        if(arr[j]>arr[j+1]):
            arr[j],arr[j+1]=arr[j+1],arr[j]
            flag=False
        if(flag):
            break
print(arr)