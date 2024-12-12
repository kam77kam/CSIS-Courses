# Program: Procedures
# Name: Kamdon Bird
# Due Date: October 2th, 2024
# Course: CSIS 2810
# Last Modified: November 11, 2024
# Description: Calculates and displays the result of a mathematical functions based on four user-input integers
    
.data
   prompt_g: .asciiz "Enter g = "
   prompt_h: .asciiz "Enter h = "
   prompt_i: .asciiz "Enter i = "
   prompt_j: .asciiz "Enter j = "
   output_msg: .asciiz "f = "

.text
main:
    # Prompt and read g
    li $v0, 4                  # syscall for print string
    la $a0, prompt_g           # load address of prompt_g
    syscall                    # print prompt_g
    li $v0, 5                  # syscall for reading integer
    syscall                    # read integer into $v0
    move $t0, $v0              # store g in $t0

    # Prompt and read h
    li $v0, 4                  # syscall for print string
    la $a0, prompt_h           # load address of prompt_h
    syscall                    # print prompt_h
    li $v0, 5                  # syscall for reading integer
    syscall                    # read integer into $v0
    move $t1, $v0              # store h in $t1

    # Prompt and read i
    li $v0, 4                  # syscall for print string
    la $a0, prompt_i           # load address of prompt_i
    syscall                    # print prompt_i
    li $v0, 5                  # syscall for reading integer
    syscall                    # read integer into $v0
    move $t2, $v0              # store i in $t2

    # Prompt and read j
    li $v0, 4                  # syscall for print string
    la $a0, prompt_j           # load address of prompt_j
    syscall                    # print prompt_j
    li $v0, 5                  # syscall for reading integer
    syscall                    # read integer into $v0
    move $t3, $v0              # store j in $t3

    # Call leaf_example function
    jal leaf_example

    # Print output message
    li $v0, 4                  # syscall for print string
    la $a0, output_msg         # load address of output_msg
    syscall                    # print output_msg

    # Print the value of f
    move $a0, $s0              # move result (f) into $s0 for printing
    li $v0, 1                  # syscall for printing integer
    syscall                    # print integer

    # Exit
    li $v0, 10                 # syscall for exit
    syscall

leaf_example:
    # Calculate f = (g + h) - (i + j)
    add $t4, $t0, $t1          # $t4 = g + h
    add $t5, $t2, $t3          # $t5 = i + j
    sub $s0, $t4, $t5          # f = (g + h) - (i + j), store in $v0

    # Return from function
    jr $ra                      # return to caller
