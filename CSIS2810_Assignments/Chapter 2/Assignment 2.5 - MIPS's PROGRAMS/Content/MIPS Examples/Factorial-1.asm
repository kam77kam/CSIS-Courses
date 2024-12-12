#This program calculate the factorial. Maximum 13!
.data
saludo: .asciiz "\n Factorial"
saludo1: .asciiz "\n Introduce the number: "
saludo2: .asciiz "\n Factorial is ="

.text
main:	# Intro
	la $a0 saludo
	li $v0 4
	syscall
	# Input the number
	la $a0 saludo1
	syscall
	li $v0 5 # ask the input number
	syscall
	move $t0 $v0 # Storage the number in $t0
	beqz  $t0 factorial_zero
	addi $t1 $t0-1 # $t1 - 1 to calculate the factorial
	
loop:	beqz $t1 fact # until  $t1= 0
	mul $t0 $t0 $t1 # t0 = $t0 * $t1
	addi $t1 $t1-1 # t1 -= 1 
	b loop

fact:	la $a0 saludo2
	li $v0 4
	syscall
	move $a0 $t0
	li $v0 1
	syscall
	b exit
	
factorial_zero:
	li $t0 1
	b fact
	
exit:	li $v0 10
	syscall