 .data
array:  .word 10, 20, 30, 40, 50     # Array of 5 integers
size:   .word 5                      # Size of the array
msg:    .asciiz "Array element "      # Message to indicate array element
colon:  .asciiz ": "                 # Colon to separate element number and value
newline: .asciiz "\n"                # Newline for better output formatting
endmsg: .asciiz "\nEnd of array.\n"  # End message

    .text
    .globl main

main:
    # Load base address of the array into $t0
    la   $t0, array           # Load address of array into $t0
    
    # Load array size into $t1
    lw   $t1, size            # $t1 = array size (5)
    
    # Initialize loop counter in $t2
    li   $t2, 0               # $t2 is the index counter
    
loop:
    # Check if the loop counter has reached the size of the array
    bge  $t2, $t1, end_loop   # If $t2 >= $t1, end loop
    
    # Print message "Array element "
    li   $v0, 4               # Syscall code for print_string
    la   $a0, msg             # Load the "Array element" message
    syscall                   # Print "Array element "
    
    # Print the array index (element number)
    li   $v0, 1               # Syscall code for print_int
    move $a0, $t2             # Move the index value to $a0 for printing
    syscall                   # Print the index
    
    # Print colon ": "
    li   $v0, 4               # Syscall code for print_string
    la   $a0, colon           # Load colon ": " message
    syscall                   # Print ": "
    
    # Load current array element into $t3
    lw   $t3, 0($t0)          # Load value at address ($t0) into $t3
    
    # Print current array element (value)
    li   $v0, 1               # Syscall code for print_int
    move $a0, $t3             # Move array element to $a0 for printing
    syscall                   # Print the array element
    
    # Print newline
    li   $v0, 4               # Syscall code for print_string
    la   $a0, newline         # Load the newline message
    syscall                   # Print newline
    
    # Move to the next array element
    addi $t0, $t0, 4          # Move to the next element in the array (4 bytes for each word)
    
    # Increment loop counter
    addi $t2, $t2, 1          # Increment index counter
    
    # Repeat loop
    j    loop                 # Jump back to the start of the loop
    
end_loop:
    # Print end message
    li   $v0, 4               # Syscall code for print_string
