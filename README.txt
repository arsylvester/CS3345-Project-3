Name: Andrew Sylvester
NetID: ars170007
Class: CS 3345
Section: 001
Semester: Fall 2019

This is Project 2 with the following files:
	MyItem.java
	IDedObject.java
	IDedLinkedList.java
	P2Driver.java

The code was developed in eclispe IDE. The code also can be compiled and ran in eclispe. 

Steps for compilation and running if needed (eclipse):
First, set up a java project with the 4 java files in the src folder (default package).
Next, add the desired input files to the project folder (above src). 
Next go to Run -> Run Configurations -> Argument. Under "Program Arguments" add <inputfilename> <outputfilenname>.
Apply these changes. 
Now P2Driver.java should be able to run and compile via the eclispe run button.

Steps for compilation and running if needed (Command Line):
CD to the folder with all the java files and input files in it. Enter the command javac P2Driver.java to compile.
Now run the program with java P2Driver <inputFileName> <outputFileName>.


Sample: java P2Driver t1.txt o1

t1.txt (Input):
Insert 22 19 475 1238 9742 0
# New item with id=22, price="$19", description="475 1238 9742"
# Return: True
#
Insert 12 96 44 109 0
# Second item with id=12, price="96", description="44 109"
# Return: True
#
Insert 37 47 109 475 694 88 0
# Another item with id=37, price="47", description="109 475 694 88"
# Return: True
#
DeleteID 37
# Return: 37 47 109 475 694 88(in a single line)
#
FindID 22
#Return 22 19 475 1238 9742
#
PrintTotal		
# Return: 22+12 = 34
#
Insert 22 100 75 128 742 0
# Same item with id=22, not included in the list
# Return: False
#
Insert 45 100 75 128 742 0
# New item with id=45, price="$100", description="75 128 742"
# Return: True
#
PrintTotal		
# Return: 22+12+45 = 79
#
DeleteID 111
#Id=111 is not in the list so print Null
#
Sadsad
#This is an error in line print error message in the output file
Insert 56
End
{Even if there are line after this the program will not read them.}

cxzCzxc
asdasdas

o1 (output):
True
True
True
37 47 109 475 694 88
22 19 475 1238 9742
34
False
True
79
Null
ERROR
ERROR
