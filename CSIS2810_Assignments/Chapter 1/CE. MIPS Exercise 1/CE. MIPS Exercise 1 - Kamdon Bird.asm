# Program: CE. MIPS Exercise 1
# Name: Kamdon Bird
# Due Date: September 23rd, 2024
# Course: CSIS 2810
# Last Modified: September 26th, 2024
# Description: Calculate the area and perimeter of a rectangle and prompt user for input
.data 
  width:	.word 
  height:	.word 
  area:		.word 
  perimeter:	.word 
  
  widthPrompt:	.asciiz "Enter width (integer):\n"
  heightPrompt:	.asciiz "Enter height (integer):\n"
  areaIs:	.asciiz "Rectangle's area is "
  perimeterIs:	.asciiz "Rectangle's perimeter is "
  newline:	.asciiz "\n"
.text

main:
  # Print the prompt for width
  addi 	$v0, $0, 4		# system call 4 is for printing a string
  la 	$a0, widthPrompt 	# address of widthPrompt is in $a0
  syscall           		# print the string

  # Read the width
  addi	$v0, $0, 5		# system call 5 is for reading an integer
  syscall 			# integer value read is in $v0
  add	$8, $0, $v0		# copy the width into $8

  # Print the prompt for height
  addi 	$v0, $0, 4  		# system call 4 is for printing a string
  la 	$a0, heightPrompt 	# address of heightPrompt is in $a0
  syscall           		# print the string
  
  # Read the height
  addi	$v0, $0, 5		# system call 5 is for reading an integer
  syscall 			# integer value read is in $v0
  add	$9, $0, $v0		# copy the height into $9
  
  # Calculate area
  mult	$8, $9			# multiply width * height
  mflo	$10			# bring the product into $10 (assume hi not needed)

  # Print "Rectangle's area is "
  addi 	$v0, $0, 4  		# system call 4 is for printing a string
  la 	$a0, areaIs 		# address of areaIs string is in $a0
  syscall           		# print the string

  # Print the calculated area (in $10)
  addi 	$v0, $0, 1  		# system call 1 is for printing an integer
  add 	$a0, $0, $10 		# bring the area value from $10 into $a0
  syscall           		# print the integer
  
  # Print a newline
  addi 	$v0, $0, 4  		# system call 4 is for printing a string
  la 	$a0, newline 		# address of areaIs string is in $a0
  syscall           		# print the string
  
  # Calculate Perimeter
  add	$t0, $8, $9		# add width $8 plus height $9 in $t0
  li 	$t1, 2          	# Load the value 2 into $t1
  mul 	$t2, $t0, $t1  		# Multiply $t0 by $t1 and store in $t2	

  # Print "perimeter is "
  addi 	$v0, $0, 4 		# system call 4 is for printing an string
  la 	$a0, perimeterIs 	# address of perimeterIs string is in $a0
  syscall           		# print the string

  # Print the calculated perimeter (in $t2)
  addi 	$v0, $0, 1  		# system call 1 is for printing an integer
  add 	$a0, $0, $t2 		# bring the area value from $t2 into $a0
  syscall           		# print the integer

  # Exit from the program
exit:
  ori $v0, $0, 10       	# system call code 10 for exit
  syscall               	# exit the program
