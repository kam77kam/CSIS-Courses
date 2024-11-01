# Program: First Assembly Program
# Name: Kamdon Bird
# Due Date: October 7th, 2024
# Course: CSIS 2810
# Last Modified: October 22, 2024
# Description: Displays the largest, smallest, and sum of three numbers.

.data
    newLine:    .asciiz "\n"  # String for newline output

.text
main:
    addi    $s0, $zero, 10	     # Initialize $s0 with value 10
    jal     increaseMyRegister       # Call function to modify $s0

    # Output a newline for formatting
    li      $v0, 4                   # Set syscall code for printing a string
    la      $a0, newLine             # Load address of newLine string
    syscall                          # Make the syscall to print

    # Output the value in $s0
    li      $v0, 1                   # Set syscall code for printing an integer
    move    $a0, $s0                 # Move the value of $s0 to $a0 for printing
    syscall                          # Make the syscall to print

    # Exit the program
    li      $v0, 10                  # Set syscall code for program exit
    syscall                          # Make the syscall to terminate the program

increaseMyRegister:
    addi    $sp, $sp, -4             # Allocate 4 bytes on the stack to save $s0
    sw      $s0, 0($sp)              # Save the current value of $s0 onto the stack

    addi    $s0, $s0, 30             # Increase $s0 by 30

    # Output the modified value in $s0
    li      $v0, 1                   # Set syscall code for printing an integer
    move    $a0, $s0                 # Move the modified value of $s0 to $a0 for printing
    syscall                          # Make the syscall to print

    lw      $s0, 0($sp)              # Restore the original value of $s0 from the stack
    addi    $sp, $sp, 4              # Deallocate the stack space used

    jr      $ra                      # Return to main
