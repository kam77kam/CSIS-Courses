
#Program to obtain two different numbers from a user and perform the arithmetic operations of addition, subtraction and multiplication
.data
prompt1: .asciiz "Enter the first number=\n"
prompt2: .asciiz "Enter the second number=\n"
menu: .asciiz " Enter an integer number to display the results of the operations:add, subtract and multiply:\n"
resultTest1: .asciiz "\nYour Add final result is="
resultTest2: .asciiz "\nYour Substract final result is="
resultTest3: .asciiz "\nYour Multiply final result is="

.text
#asking the user to provide the first number
li $v0,4 #command to printing a string
la $a0, prompt1 # loading the string to print into the argument to enable printing
syscall #executing the command

# the next block of code is for reading the first number provided by the user
li $v0,5 # command for reading an integer
syscall # executing the command for reading an integer
move $t0,$v0 # moving the number read from the user input into the temporary register $t0

#asking the user to provide the second number
li $v0,4
la $a0, prompt2
syscall

#reading the second number
li $v0,5
syscall
move $t1,$v0
li $v0,4
la $a0,menu 
syscall 

# read the number provided by the user
li $v0,5
syscall
move $t2,$v0
 
beq $t2,$t3, addProcess # branch to "addProcess' if=$t2=$t3
beq $t2,$t4, subtractProcess  # branch to "subtractProcess' if=$t2=$t4
beq $t2,$t5, multiplyProcess  # branch to "multiplyProcess' if=$t2=$t5

addProcess:
add $t6,$t0,$t1 # this add the values stored in $t0 and $t1 and assigns them to the temporary resgister $t6

# the followwing line of the code is to print the results of the computation above
li,$v0,4
la $a0, resultTest1 # this load the string to print into the argument $a0 for printing
syscall

# the following line of code prints out the result of the addition
li $v0,1
la $a0,($t6)
syscall
li $v0,10 

subtractProcess:
sub $t6,$t0,$t1
li $v0,4
la $a0, resultTest2
syscall

li $v0,1
la $a0,($t6)
syscall
li $v0,10

multiplyProcess:
mul $t6,$t0,$t1
li $v0,4
la $a0, resultTest3
syscall
li $v0,1
la $a0, ($t6)
syscall

li $v0,10










