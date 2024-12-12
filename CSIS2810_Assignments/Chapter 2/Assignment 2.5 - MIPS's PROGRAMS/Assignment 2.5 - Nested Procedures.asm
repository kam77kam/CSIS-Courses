# Program: Nested Procedures 
# Name: Kamdon Bird
# Due Date: October 2th, 2024
# Course: CSIS 2810
# Last Modified: November 15, 2024
# Description: Uses nested procedures to calculate the nth term of a Fibonacci-like sequence. It splits the work 
# into smaller, reusable functions: one to add two numbers and another to generate the sequence step by step.

.data
prompt:	.asciiz "Enter the number of terms (n): "	# Message prompting user to input the number of terms
result:	.asciiz "The nth term is: "			# Message for displaying the nth term result

.text
main:

    # Print the prompt for user input
    li   $v0, 4		# Set code to print a string
    la   $a0, prompt	# Load the prompt message address
    syscall		# Print the prompt message

    # Read input from the user
    li   $v0, 5		# Set code to read an integer
    syscall		# Read the user's input
    move $a0, $v0	# Store input for bonacci

    # Calculate the nth term and store result
    jal  bonacci	# Jump to the bonacci procedure and link return address
    move $t0, $v0	# Store the result (nth term)

    # Print the result message
    li   $v0, 4		# Set code to print a string
    la   $a0, result	# Load the result message address
    syscall		# Print the result message
    
    # Print the result
    li   $v0, 1		# Set code to print an integer
    move $a0, $t0	# Restore the result to print
    syscall		# Print the result (nth term)
    
    # Exit the program
    li   $v0, 10	# Set code to exit program
    syscall		# Exit program

# Bonacci procedure
# Implements a Fibonacci-like sequence. Takes input n in $a0 and calculates
# the nth term. Uses the sum procedure to add the last two terms in the sequence.
bonacci:
    addi $sp, $sp, -8	# Allocates 8 bytes on the stack (for $ra and input $a0)
    sw   $ra, 0($sp)	# Save return address to restore after bonacci ends
    sw   $a0, 4($sp)	# Save the input value n (will be modified in loop)

    li   $a1, 0		# Initialize a = 0
    li   $a2, 1		# Initialize b = 1
    
    beq  $a0, 0, end	# If n == 0, return a (initialized as 0)
    
# Iteratively calculate the nth Fibonacci-like term using $a1 and $a2.
loop:
    jal  sum		# Compute a + b, result returned in $v0

    move $a1, $a2	# Update a to the current b value for the next iteration
    move $a2, $v0	# Update b to the sum (a + b)
    sub  $a0, $a0, 1	# Decrement n

    bnez $a0, loop	# If n != 0, continue the loop
    
# End of bonacci procedure
end:
    move $v0, $a1	# Set $v0 to the final nth term in the sequence
    
    lw   $a0, 4($sp)	# Restore n (input) address
    lw   $ra, 0($sp)	# Restore the return address
    addi $sp, $sp, 8	# Deallocate stack space
    
    jr   $ra		# Jump back to the return address
    
# Sum procedure
# Adds two numbers (a and b) passed in $a1 and $a2, returns the result in $v0.
sum:
    add  $v0, $a1, $a2	# Add a ($a1) and b ($a2), result stored in $v0
    jr   $ra		# Jump back to the return address
