    .data
array:  .word 10, 20, 30, 40, 50  # Array with 5 elements
msg_push: .asciiz "Pushing element onto stack: "
msg_pop:  .asciiz "Popping element from stack: "
newline:  .asciiz "\n"

    .text
    .globl main

main:
    # Load the base address of the array into $t0
    la   $t0, array          # Base address of the array in $t0
    
    # Initialize stack pointer ($sp)
    li   $sp, 0x7fffeffc     # Set the initial stack pointer

    # Push array elements onto the stack
    li   $t1, 5              # Set loop counter for pushing 5 elements

push_loop:
    beq  $t1, $zero, pop_elements  # If counter reaches 0, go to pop section
    
    # Load the current array element into $t2
    lw   $t2, 0($t0)         # Load element from array into $t2
    
    # Print message for pushing
    li   $v0, 4              # Syscall for print_string
    la   $a0, msg_push       # Load message to $a0
    syscall
    
    # Print the element being pushed
    li   $v0, 1              # Syscall for print_int
    move $a0, $t2            # Move the value of $t2 to $a0
    syscall

    # Print newline
    li   $v0, 4              # Syscall for print_string
    la   $a0, newline        # Load newline character
    syscall

    # Push element onto the stack
    addi $sp, $sp, -4        # Decrement stack pointer by 4 bytes
    sw   $t2, 0($sp)         # Store element at the top of the stack
    
    # Move to the next array element
    addi $t0, $t0, 4         # Move to the next array element (4 bytes)
    subi $t1, $t1, 1         # Decrement loop counter
    
    j    push_loop           # Repeat the loop for all elements

pop_elements:
    # Reset loop counter for popping 5 elements
    li   $t1, 5              # Reset loop counter for popping

pop_loop:
    beq  $t1, $zero, end_program  # If counter reaches 0, end program
    
    # Pop element from the stack
    lw   $t3, 0($sp)         # Load the value from the stack into $t3
    addi $sp, $sp, 4         # Increment stack pointer (pop operation)
    
    # Print message for popping
    li   $v0, 4              # Syscall for print_string
    la   $a0, msg_pop        # Load pop message
    syscall
    
    # Print the popped element
    li   $v0, 1              # Syscall for print_int
    move $a0, $t3            # Move popped value to $a0
    syscall

    # Print newline
    li   $v0, 4              # Syscall for print_string
    la   $a0, newline        # Load newline character
    syscall

    # Decrement loop counter
    subi $t1, $t1, 1         # Decrement the loop counter
    
    j    pop_loop            # Repeat the loop to pop all elements

end_program:
    # Exit the program
    li   $v0, 10             # Syscall for exit
    syscall
