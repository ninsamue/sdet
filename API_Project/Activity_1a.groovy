package API_Activity


class Activity_1a {
	
	static void main(def args) {
		def mainList = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		def intList =[]
		def strList = []
		
		//separate out the integers and the string into two different lists, intList and strList.
		mainList.each { item ->
			if(item instanceof Integer)
				intList.add(item)
			else if(item instanceof String)
				strList.add(item)
		}
		
		print("Initial List : ")
		println(mainList)
		
		//print the sorted version of both the intList and strList
		print("Integer Type Sorted List : ")
		println(intList.sort())
		
		print("String Type Sorted List : ")
		println(strList.sort())
		
	}
	
	
}
