# Program: First Assembly Program
# Name: Kamdon Bird
# Due Date: October 7th, 2024
# Course: CSIS 2810
# Last Modified: October 31, 2024
# Description: Input three integers from keyboard & perform calculations & display results

.data
     promptFirstinput:	.asciiz "Enter the first number: "  	 	# Prompt for the first number
     promptSecondinput: .asciiz "Enter the second number: "   		# Prompt for the second number
     promptThirdinput: 	.asciiz "Enter the third number: "    		# Prompt for the third number
     promptSumOut:	.asciiz "The sum of the entered numbers is: " 	# Prompt for displaying the sum
     promptSmallestOut:	.asciiz "The smallest number is: " 		# Prompt for displaying the smallest number
     promptLargestOut:	.asciiz "The largest number is: " 		# Prompt for displaying the largest number
     promptRestartOut:	.asciiz "Try again? (0 for Yes, 1 for No): "	# Prompt for restarting the program
     promptThankYouOut: .asciiz "Thank you for using the program!!!\n"	# Prompt for ending the program

.text
main:
    # Enter 3 integers from keyboard
    jal	inputFirstInteger				# First integer function
    jal	inputSecondInteger				# Second integer function
    jal	inputThirdInteger				# Third integer function
    jal printNewLine    				# Print a new line function
    
    # Calculate and display the sum of the numbers.
    jal displayCalculatedSum				# Calculate and display function
    jal printNewLine    				# Print a new line function
    
    # Select and display the smallest of the numbers
    jal displaySmallestNum				# Select and display function
    jal printNewLine    				# Print a new line function
    
    # Select and display the largest of the numbers
    jal displayLargestNum				# Select and display function
    jal printNewLine    				# Print a new line function
    
    # Allow multiple iterations
    jal restartIteration				# Program iteration function
    jal printNewLine    				# Print a new line function
###################################################################################################################
# Print a new line
printNewLine:
    li      $v0, 11         				# Load character
    li      $a0, 10         				# Load the line feed
    syscall                  				# Syscall to print
    jr      $ra              				# Return to main
###################################################################################################################
# Read first integer from the keyboard
inputFirstInteger:

    # Prompt user for first number
    li	    $v0, 4					# Load print string
    la      $a0, promptFirstinput			# Load promptFirstinput string
    syscall						# Syscall to print
    
    # Save input from user for first number
    li      $v0, 5					# Load read-an-int
    syscall						# Syscall to read
    move    $s0, $v0					# Save first number
    jr	    $ra						# Return to main
###################################################################################################################
# Read second integer from the keyboard
inputSecondInteger:

    # Prompt user for second number
    li	    $v0, 4					# Load print string
    la      $a0, promptSecondinput			# Load promptSecondinput string
    syscall						# Syscall to print
    
    # Save input from user for second number
    li      $v0, 5					# Load read-an-int
    syscall						# Syscall to read
    move    $s1, $v0					# Save second number
    jr	    $ra						# Return to main
###################################################################################################################
# Read third integer from the keyboard
inputThirdInteger:

    # Prompt user for third number
    li	    $v0, 4					# Load print string
    la      $a0, promptThirdinput			# Load promptThirdinput string
    syscall						# Syscall to print
    
    # Save input from user for third number
    li      $v0, 5					# Load read-an-int
    syscall						# Syscall to read
    move    $s2, $v0					# Save third number
    jr	    $ra						# Return to main
###################################################################################################################
# Calculate and display the sum of the numbers
displayCalculatedSum:

    # Sums up the three values
    add     $s3, $s0, $s1    				# Add first & second input and store the result
    add     $s3, $s3, $s2    				# Add third input and store the result of sum
    
    # Print the sum of entered numbers prompt
    li      $v0, 4            				# Load print a string
    la      $a0, promptSumOut  				# Load promptSumOut string
    syscall                    				# Syscall to print
    
    # Print the final result
    move    $a0, $s3           				# Move the result to be printed
    li      $v0, 1             				# Load print integer
    syscall                     			# Syscall to print
    jr	    $ra						# Return to main
###################################################################################################################
# Select and display the smallest of the numbers
displaySmallestNum:

    # Compare first input with second input
    move    $t0, $s0          				# Assume first input is the smallest
    ble     $t0, $s1, checkSmallThirdNum 		# If first input <= second input, skip updating
    move    $t0, $s1    				# If first input >= second input, update smallest
    
checkSmallThirdNum:

    # Compare result with third input
    ble     $t0, $s2, endDisplaySmallest		# If second input <= third input, skip updating
    move    $t0, $s2     				# If second input >= third input, update smallest
    
endDisplaySmallest:

    # Print the smallest numbers prompt
    li      $v0, 4            				# Load print string
    la      $a0, promptSmallestOut  			# Load promptSmallestOut string
    syscall                    				# Syscall to print
    
    # Print the smallest result
    move    $a0, $t0           				# Move the result to be printed
    li      $v0, 1             				# Load print integer
    syscall                     			# Syscall to print
    jr	    $ra						# Return to main
###################################################################################################################
# Select and display the largest of the numbers
displayLargestNum:

    # Compare first input with second input
    move    $t0, $s0          				# Assume first input is the largest
    bge     $t0, $s1, checkLargeThirdNum 		# If first input >= second input, skip updating
    move    $t0, $s1    				# If first input <= second input, update largest
    
checkLargeThirdNum:

    # Compare result with third input
    bge     $t0, $s2, endDisplayLargest			# If second input >= third input, skip updating
    move    $t0, $s2     				# If second input <= third input, update largest
    
endDisplayLargest:

    # Print the largest numbers prompt
    li      $v0, 4            				# Load print string
    la      $a0, promptLargestOut  			# Load promptLargestOut string
    syscall                    				# Syscall to print
    
    # Print the largest result
    move    $a0, $t0           				# Move the result to be printed
    li      $v0, 1             				# Load print integer
    syscall                     			# Syscall to print
    jr	    $ra						# Return to main
###################################################################################################################
# Restart the program iteration
restartIteration:

    # Prompt to restart the program
    jal printNewLine    				# Print a new line function
    li      $v0, 4                  			# Load print string
    la      $a0, promptRestartOut       		# Load promptRestartOut string
    syscall                          			# Syscall to print
    
    # Select input from user for restart
    li      $v0, 5                  			# Load read-an-int
    syscall                          			# Syscall to read
    bgt     $v0, $zero, endProgram     			# If input > 0, endProgram
    j       main                    			# Jump to main to restart the program
    
endProgram:

    # Thank user and end program iteration
    li      $v0, 4                  			# Load print string
    la      $a0, promptThankYouOut       		# Load promptThankYouOut string
    syscall                          			# Syscall to print
    
    # Exit the program
    li	    $v0, 10					# Load the syscall code for program exit
    syscall						# Syscall to terminate the program
###################################################################################################################
