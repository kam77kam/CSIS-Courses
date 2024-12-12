# Improved routine to demonstrate functions and the use of the stack
# This program calculates y = 3*x + 5, where x is initially 5.
# The program calls a function (fun) to compute the result
# and demonstrates how to use the stack to preserve register values.

# ------------------------------------------------------------------
	.data  # Data segment
x:	.word 5       # Initial value of x
y:	.word 0       # Initial value of y (result will be stored here)
msg1:	.asciiz "y="  # Message to print before displaying the result
lf:     .asciiz "\n"  # Newline character

	.text
	.globl main

main:
	# Initialize registers
	lw	$s0, x         # Load x (5) into register $s0
	lw	$s1, y         # Load y (0) into register $s1

	# Call the function `fun` to compute y = 3*x + 5
	move	$a0, $s0      # Move x ($s0) into argument register $a0
	jal	fun           # Call function `fun`, save return address in $ra
	move	$s1, $v0      # Store the returned value (y) into $s1

	# Output the result
	li	$v0, 4         # System call code for printing a string (print_string)
	la	$a0, msg1      # Load address of the message "y="
	syscall

	li	$v0, 1         # System call code for printing an integer (print_int)
	move	$a0, $s1      # Move the result (y) into $a0 for printing
	syscall

	# Print a newline for formatting
	li	$v0, 4         # System call code for printing a string (print_string)
	la	$a0, lf        # Load address of the newline character
	syscall

	# Exit the program
	li	$v0, 10        # System call code for program exit (exit)
	syscall

# ------------------------------------------------------------------
# FUNCTION: fun(int a)
# Calculates: y = 3*a + 5
# Arguments: $a0 = input parameter a (in this case, x)
# Return: The result is stored in $v0
# The function uses the stack to save/restore registers $s0 and $s1

fun:
	# Save the current values of $s0 and $s1 onto the stack (PUSH)
	addi $sp, $sp, -8   # Allocate space on the stack (2 words)
	sw $s0, 4($sp)      # Save $s0 to the stack
	sw $s1, 0($sp)      # Save $s1 to the stack

	# Perform the calculation: y = 3*a + 5
	li	$s0, 3           # Load constant 3 into $s0
	mul	$s1, $s0, $a0    # $s1 = 3 * $a0 (3 * a)
	addi $s1, $s1, 5    # $s1 = 3*a + 5

	# Store the result in the return register $v0
	move	$v0, $s1       # Move the result into $v0

	# Restore the saved values of $s0 and $s1 from the stack (POP)
	lw	$s1, 0($sp)      # Restore $s1
	lw	$s0, 4($sp)      # Restore $s0
	addi $sp, $sp, 8    # Deallocate space on the stack

	# Return to the caller (jump to the address in $ra)
	jr	$ra             # Return from function

# ------------------------------------------------------------------
