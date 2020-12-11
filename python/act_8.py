numberList=input("Enter the numbers to be compared, separate by commas : ").split(',')

print("First Number : ", numberList.pop(0))

print("Last Number : ", numberList.pop())

if numberList.pop(0) == numberList.pop():
    print(True)
else:
    print(False)
 

