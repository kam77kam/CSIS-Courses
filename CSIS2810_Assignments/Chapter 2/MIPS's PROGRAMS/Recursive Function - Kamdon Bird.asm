# Program: Recursive Function 
# Name: Kamdon Bird
# Due Date: October 2th, 2024
# Course: CSIS 2810
# Last Modified: November 16, 2024
# Description: Recursively reverses an array of integers and prints both the original and reversed arrays

.data
array:    .word  1,2,3,4,5,6		# Example array with 6 elements
length:	  .word  6 			# Length of the array
original: .asciiz "Original Array: "	# Original array message
reversed: .asciiz "Reversed Array: "	# Reversed array message

.text
main:

    # Print Original Array String
    li   $v0, 4		# String syscall
    la   $a0, original	# Load original string
    syscall		# Print original string message

    # Print Original Array
    la   $t0, array	# Load base address of array
    lw   $t1, length	# Load array length
    move $t2, $t1	# Copy array length (loop counter)
    jal  printArray	# Jump to print array

    # Print Reversed Array String 
    li   $v0, 4		# Print string syscall
    la   $a0, reversed	# Load address of "Reversed Array: "
    syscall		# Print reversed string

    # Reverse Array
    la   $t0, array	# Load base address of array
    lw   $t1, length	# Load array length
    move $t2, $t1	# Copy array length (loop counter)
    jal  reverseArray	# Reverse array in-place

    # Print Reversed Array
    lw   $t1, length	# Load array length
    move $t2, $t1	# Copy array length (loop counter)
    jal  printArray	# Print reversed array

    # Exit the program    
    li   $v0, 10	# Syscall to exit program
    syscall		# Exit program

printArray:
    beqz $t2, endPrint	# If counter is 0, end loop
    lw   $t3, 0($t0)	# Load array element
    addi $t0, $t0, 4	# Move to the next array element
    move $a0, $t3	# Pass value to $a0 for printing
    li   $v0, 1		# Print integer syscall
    syscall		# Print integer

    li   $a0, 32	# ASCII value for space
    li   $v0, 11	# Load system call for print character
    syscall		# Print the space

    subi $t2, $t2, 1	# Decrement loop counter
    j    printArray	# Repeat loop

endPrint:
    li   $a0, 10	# Load the ASCII value of newline ('\n') into $a0
    li   $v0, 11	# System call for printing a character
    syscall		# Perform the syscall to print the newline

    jr   $ra		# Return to caller

reverseArray:
    la   $t2, array	# Load base address of array
    mul  $t3, $t1, 4	# Calculate the size of the array in bytes (length * 4)
    add  $t3, $t2, $t3	# Calculate the address of the last element + 4
    subi $t3, $t3, 4	# Point to the last element (n - 1)
   
reverse_loop:
    bge  $t2, $t3, done	# If the start pointer >= end pointer, we’re done

    # Swap values at $t2 and $t3
    lw   $t4, 0($t2)	# Load value at start pointer into $t4
    lw   $t5, 0($t3)	# Load value at end pointer into $t5
    sw   $t5, 0($t2)	# Store value from end pointer into start pointer
    sw   $t4, 0($t3)	# Store value from start pointer into end pointer

    # Move the pointers closer to the center
    addi $t2, $t2, 4	# Increment start pointer by 4 bytes
    subi $t3, $t3, 4	# Decrement end pointer by 4 bytes
    
    j    reverse_loop   # Repeat the process

done:
    jr   $ra		# Return to caller
