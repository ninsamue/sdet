list1=[1,4,8,3,0,4]
list2=[34.59,60,63,71,76]

list3=[]

for num in list1:
    if num%2==1:
        list3.append(num)

for num in list2:
    if num%2==0:
        list3.append(num)    

print("List 1 : ",list1)
print("List 2 : ",list2)
print("Odd Number from List 1 and Even Number from List2 : ",list3)  
