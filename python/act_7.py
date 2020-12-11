numberList=input("Enter the numbers to be added, separate by commas : ").split(',')
sum=0

for number in numberList:
    sum+=int(number)

print(sum)