
# n=int(input())
# for i in range(n):
#     for j in range(n):
#         if(i==0 or j==0 or i==n-1 or j==n-1):
#             print("*",end="")
#         else:
#             print(end=" ")

#     for j in range(n):
#         if(j==0):
#             print(end="  ")

#     for j in range(n):
#         if(i==0 or j==0 or i==n-1 or j==n-1):
#             print("*",end="")
#         else:
#             print(end=" ")

#     for j in range(n):
#         if(j==0):
#             print(end="  ")
#     for j in range(n):
#         if(j==0 or j==n-1 or (i==j or i+j==n-1) and i<=int(n/2)):
#             print("*",end="")
#         else:
#             print(end=" ")

#     for j in range(n):
#         if(j==0):
#             print(end="  ")

#     for j in range(n):
#         if(i==n-1 or j==n-1 or j==0 or i==0 or i==int(n/2)):
#             print("*",end="")
#         else:
#             print(end=" ")

#     for j in range(n):
#         if(j==0):
#             print(end="  ")

#     for j in range(n):
#         if(i==n-1 or j==n-1 or j==0):
#             print("*",end="")
#         else:
#             print(end=" ")

#     for j in range(n):
#         if(j==0):
#             print(end="  ")

#     for j in range(n):
#         if(i==n-1):
#             print("*",end=" ")
#         else:
#             print(end="  ")

#     for j in range(n):
#         if(j==0):
#             print(end=" ")

#     for j in range(n):
#         if(i<int(n/2)):
#             print(end=" ")
#         elif(i==int(n/2) or j==0 or i==n-1):
#             print("*",end="")
#         else:
#             print(end=" ")
#     for j in range(n):
#         if(i==n-1 or j==n-1 or i==n-1 or i==0 or j==0):
#             print("*",end="")
#         else:
#             print(end=" ")
#     for j in range(1,n):
#         if(i<int(n/2)):
#             print(end=" ")
#         elif(i==int(n/2) or j==n-1 or i==n-1):
#             print("*",end="")
#         else:
#             print(end=" ")
#     for j in range(1,n):
#         if(i<int(n/2)):
#             print(end=" ")
#         elif(i==int(n/2) or j==n-1 or i==n-1):
#             print("*",end="")
#         else:
#             print(end=" ")

#     print()


n=9
for i in range(n):
    for j in range(n):
        if(i==1 or i==int(n/2) or i==0 or i==n-1 or i==n-2):
            print("*",end="")
        else:
            print(end=" ")
    for j in range(n):
        if(j==1 or i==j or i==0 or i==n-1 or j==n-2):
            print("*",end="")
        else:
            print(end=" ")
    for j in range(n):
        if(i+j==n-1 or i==j or i==0 or i==n-1):
            print("*",end="")
        else:
            print(end=" ")
    for j in range(n):
        if(i+j==n-1 or i==j or i==0 or i==n-1):
            print("*",end="")
        else:
            print(end=" ")

    print()