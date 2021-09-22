a=int(input())
for i in range(5):
    for i in range(a):
        for j in range(5):
            for j in range(a):
                if(i+j>=a-1):
                    print("*",end="")
                else:
                    print(end=" ")

            for j in range(1,a):
                if(i>=j):
                    print("*",end="")
                else:
                    print(end=" ")

            for j in range(1,a):
                if(i+j>=a-1):
                    print("*",end="")
                else:
                    print(end=" ")

            for j in range(1,a):
                if(i>=j):
                    print("*",end="")
                else:
                    print(end=" ")


        print()

    for i in range(1,a):
        for j in range(5):
            for j in range(a):
                if(i<=j):
                    print("*",end="")
                else:
                    print(end=" ")

            for j in range(1,a):
                if(i+j<=a-1):
                    print("*",end="")
                else:
                    print(end=" ")

            for j in range(1,a):
                if(i<=j):
                    print("*",end="")
                else:
                    print(end=" ")

            for j in range(1,a):
                if(i+j<=a-1):
                    print("*",end="")
                else:
                    print(end=" ")



        print()
