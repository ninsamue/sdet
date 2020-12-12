numberList =list(input("Enter the Numbers to be added : ").split(","))


def calcSum(numberList):
    sum=0;
    for num in numberList:
        sum+=int(num)
    return sum


print("The sum of numbers in the list : ",calcSum(numberList))