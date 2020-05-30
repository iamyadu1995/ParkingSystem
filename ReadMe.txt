1) To execute the file in CMD
	> javac ParkingSystem.java
	> java ParkingSystem

We can also execute by running this file in any IDE.


2) It is a console based java application where you can write the command (specified in problem statement) and application will operate that command and show you the result..

Testing by unit cases is optional in problem statement so i have not used that approach to test the application, if needed/want, i can write the code for that also.

3) I have commented the package import as my package name can create conflicts and also that you can directly run the program through cmd and if you are executing it through any IDE and moved this program inside your package, then uncomment the first line and write your package name.

4) System will ask to the user for the commands if he/she wants to enter more commands and it will operate the user commands until user ask the system to stop.	

5) We can enter the commands and and system will operate it.Commands are same as mentioned in the problem statement.

create_parking_lot [no of parking lot]
park [regNo] [colour]
leave [slot no of that vehicle]
status
registration_numbers_for_cars_with_colour [colour of vehicle]
slot_numbers_for_cars_with_colour [colour of vehicle]
slot_number_for_registration_number [regNo of vehicle]


Example as in Problem Statement:
 * create_parking_lot 6
 * park KA-01-HH-1234 white
 * park KA-01-HH-9999 white
 * park KA-01-BB-0001 black
 * park KA-01-HH-7777 red
 * park KA-01-HH -2701 blue
 * park KA-01-HH-3141 black
 * leave 4
 * status
 * park KA-01-p-333 white
 * park DL-12-AA-9999 white
 * registration_numbers_for_cars_with_colour white
 * slot_numbers_for_cars_with_colour white
 * slot_number_for_registration_number KA-01-HH-3141
 * slot_number_for_registration_number MH-04-AY-1111


