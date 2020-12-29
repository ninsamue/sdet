package API_Activity

class Activity_1b {
	
	static void main(def args) {
		
		//To create a file using Groovy
		File file=new File("./resources/input.txt")
		file.createNewFile()
		
		//After the file is created, add the following text to it using the write()/append() method
		file.write("A quick brown Fox jumped over the lazy Cow")
		file.append("\nJohn Jimbo jingeled happily ever after")
		file.append("\nTh1\$ 1\$ v3ry c0nfus1ng")
		
			
		file.eachLine{line ->
			
			println "------------------------------------"
			println line
			println "------------------------------------"	
			println "--------- Lines Matched ---------"
			
			//the line that has Cow at the end of the line
			if(line ==~ /.*Cow$/) {
				println "Line Ending with Cow"
			}
			//the line that start with capital letter 'J'
			if(line ==~ /^J.*/) {
				println "Line that start with capital letter 'J'"
			}
			//line that has two numbers one after the other
			if(line ==~ /.*\d.*\d.*/) {
				println "Line that has two numbers one after the other"
			}
		
		}
		
		//the string(s) that match the pattern '\S+er'
		def match1 = file.getText() =~ /\S+er/ 
		println "String(s) that match the pattern \\S+er : ${match1.findAll()}"
		
		//the string(s) that match the pattern '\S*\d\W'
		def match2 = file.getText() =~ /\S*\d\W/ 
		println "String(s) that match the pattern '\\S*\\d\\W' : ${match2.findAll()}"
	}
		
}

