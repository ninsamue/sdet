fruitDict={
    "Mango" : 23,
    "Pineappple" : 30,
    "Apple" : 50
}

item=input("Enter the Fruit Item : ")
if item in fruitDict:
   print(item," is present")
else:
    print(item," is not present")