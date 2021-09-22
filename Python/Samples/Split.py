myDict ='name John country Norway'
mySeparator='TEST'
for i in myDict.split():
    print(i)
    a=myDict.split()
    x = mySeparator.join(a)
print(x.split("TEST"))