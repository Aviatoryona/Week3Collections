
   A sample project showing implementation of collections, derived data types and other OOP concepts.
   
   The project is a console application to read student scores for different subjects and tutor who teaches the subject.
   
   Student class
		- A class defining student attributes ie name and admission number
		
   Teacher class
		- A class defining teacher attribute(s) ie  name
   
   Subject class
		- Defines subject attributes ie title, score and Teacher
   
   ResultI interface
		- An interface defining methods that can be used to manipulate the objects of the named above stated classes to produce the expected output.
		
   Result class
		- Implements the above named interface.
		- Has student object and a collection of Subject object(s).
		

	Pseudocode:
	
		1. Capture subject(s) and respective teacher and put in a collection
	       eg Title-Eng ,Teacher- Brian T

	    2. Loop n times, capture student name and admission number, and prompt for scores of each subject as provide in (1) above.
	       This info store in a Result object. Push the result object in a collection.

	    3. For collection result in (2) above, print the output. Eg
	           Student: Yona K
	           Admission Number: 900/567/2020
	           Eng-40 Teacher- Brian T
	           Kis-78 Teacher- Mariam M
	           Total- 118
	           Avg- 59
	           Remarks- Passed
	           ...
			 
	Structure:
		-src
			-main
				-java - sources folder
				-test - tests folder