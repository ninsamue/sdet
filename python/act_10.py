tupleNumbers=tuple(input("Enter the Numbers : ").split(","))
print(tupleNumbers)

print("Numbers that are divisible by 5:")
for num in tupleNumbers:
    if int(num)%5==0:
        print(num)