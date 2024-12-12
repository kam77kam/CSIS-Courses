############################################################################
#  Program #4 : Bank Balance	Programmer: Bob Britton
#  Due Date: Oct.22, 2006	Course: CSCI 320
#  Last Modified: Oct. 21, 2006	
#############################################################################
#					
# Overall Program Functional Description:
#  A new INPUT function is used to read in decimal values, which returns
#  status in register v1. User is prompted to try again if input is in error
#  Each input value (positive or negative) is added to an accumulating sum.	
#  The sum is printed in decimal (right justified) using the new output function.
#  The program terminates when a value of zero is read in.	
############################################################################
#  Cross reference table showing Register use in main-line program:
#	$s0 = Sum of the Balance column items	
#	$s1 = Running Balance
#	$s2 = Average Balance rounded to nearest penny
#	$s4 = Interest rounded to nearest penny
#	$s7 = Count of valid transactions
#############################################################################
#  Pseudo Code Description:
#		out  << "header"
#		out  << '		    Balance '
#		s1=0;
#	loop:
#		out << "Enter a Value "
#		New input from keyboard >> v0;
#		if (v1!=0) {out << "Error try again"; go to loop}
#		if (v0 == 0) go to quit;
#		s1 = s1 + v0;
#		out << tabs;
#		out << s1;
#		out << tab;
#		a0 = s1;
#		goto loop;
#	quit:
#		out << ' Thank You ';
############################################################################
		.data
tab:		.asciiz	"\t"
tabs:		.asciiz	"\t\t\t\t\t\t"
welcome:	.ascii	"\n\n\t\t   Welcome to  First National Bank"	
		.asciiz "\n\t\t\t\t\t\t\t Balance"
prompt:		.asciiz "\nTransaction: "
again:		.asciiz "\n**Try Again: "
bye:		.asciiz	"\nThank You for banking at First National Bank"
		.text
main:	
		li	$v0,	4	
		la	$a0, 	welcome
		syscall
		move	$s0,	$0		# Used to compute Average
		move	$s1,	$0		# Clear accumulator register s1
		move	$s7	$0		# Init. count transactions 
loop:
		li	$v0,	4
		la	$a0, 	prompt
		syscall
indata:
		jal 	input			# get a decimal value
		beqz	$v1, 	ok
		li	$v0,	4
		la	$a0, 	again
		syscall
		b	indata
ok:
		beqz	$v0,	quit		# If (v0 == 0) go to quit
		addu	$s1,	$s1, $v0		# Add to balance
		addu	$s0,	$s0, $s1		# sum of balance column
		addi	$s7,	$s7, 1		# Count transactions 

		li	$v0,	4
		la	$a0, 	tabs		# tab over 4
		syscall
	
		move	$a0, 	$s1
		jal	out			# print total

		li	$v0,	4		
		la	$a0,	tab
		syscall				# One tab
		b	loop
quit:
		li	$v0,	4
		la	$a0, 	bye
		syscall

		li	$v0,	10	
		syscall


################################################################
# Procedure hexout
#
# Functional Description:
#  Takes a 32 bit binary value passed in register $a0, and prints 
#  it out as a  hexadecimal number
################################################################
# Register Usage:
#		$a0 value passed to procedure
#		$a1 buffer address initialized to end of buffer
#		$t0 working register used to extract 4-bit values
#		$t2 loop counter
################################################################
# Algorithmic Description:
# a1 = &buffer + 10;
# for (t2=7; t2 >= 0: t2=t2-1)
#     	{t0 = (a0 AND 0xf);
#	shift a0 right 4 bits;
#	if (t0 >= 10) t0 = t0 + 55
#		else  t0 = to +48;
#	mem(a1) = t0;
#	a1 = a1 -1;
#	}
# out << buffer
# return
#
################################################################

		.globl		hexout
		.data
buffer:		.asciiz	" 0x        "
		.text
hexout:
		la	$a1, 	buffer
		addi	$a1,	$a1,	10	# Set pointer to end of buffer
		li	$t1,	10		# A Test value
		li	$t2,	7		# Loop counter = 8
forloop:
		andi	$t0,	$a0, 0x000F	#Extract lower 4 bits
		srl	$a0,	$a0, 4		# Shift right 4 bits
		bge	$t0,	10,	big	# If a0 >= 10 branch to big
		addi	$t0,	$t0,	0x30	# Add ASCII bias of 0x30
		b	insert
big:		
		addi	$t0,	$t0,	0x37	# Add ASCII bias of 0x37
insert:
		sb	$t0,	0($a1)		# Put ASCII char in buffer
		addi	$a1,	$a1,	-1	
		addi	$t2,	$t2,	-1	# Dec. loop count
		bgez	$t2,	forloop

		li	$v0,	4
		la	$a0, 	buffer		# Print the hexadecimal Num
		syscall

		jr	$ra

##############################################################
# Functional Description: Procedure OUT
# Receives a binary value in a0
# Converts a 32 bit 2's complement binary integer to an ASCII 
# decimal string and prints it out  
##############################################################
#
# Algorithmic Description:
# t3=a0
# t9=0
# t8=10
# if (t3 < 0 ) {t9=1; t3=-t3;}
# a0 =&buff
# a1=a0 + 12
# mem(a1)= 0
# do{
#	High,Low = t3/t8
#	t0=High
#	t3=Low
#	a1=a1-1
#	t0=t0+48
#	mem(a1)=t0
#   }
# while(t3 > 0)
# if (t9==1) {a1=a1-1; mem(a1) = "-"
# while (a1 > a0)
# 	{a1=a1-1
# 	mem(a1)= " "
#	}
# out << buff
# return
###############################################################
# Register Usage:
#		a0
#		a1
#		t0
#		t3
#		t8
#		t9
#
###############################################################
	.globl	out
	.data
buff:  	.space	13
	.text
out:	
	move	$t3, $a0		# put 32 bit integer into t3
	li	$t9, 0		# clear neg flag
	li	$t8, 10		# Constant 10
	bgez	$t3, pos		# If negative complement & set flag
	subu	$t3, $0, $t3	# negate t3
	li	$t9, 1		# set neg flag
pos:
	la	$a0, buff		# a0 points to first byte in buffer
	addi	$a1, $a0, 12	# a1 points to last byte in buffer		 
	sb	$0, 0($a1)		# put null char at end of buffer
lpxx:
	divu	$t3, $t8		# divide number by 10
	mfhi	$t0		# t0 get remainder
	mflo	$t3		# t3 gets quotient (new number)
	addi	$a1, $a1, -1	# adjust pointer
	addi	$t0, $t0, 48	# add in ASCII bias of 48
	sb	$t0, 0($a1)		# put ASCII char in buffer
	bgtz	$t3, lpxx		# go to loop if not done
	beqz	$t9, spxx		# If neg flag is set then
	li	$t8, 45		# put minus char in front
	addi	$a1, $a1, -1	# adjust pointer
	sb	$t8, 0($a1)
spxx:	
	li	$t8, 32		# else put spaces char in front
store:
	addi	$a1, $a1, -1	# adjust pointer
	sb	$t8, 0($a1)
	bne	$a0, $a1, store	# If a0 != a1 then more spaces
			
fini:	li	$v0, 4		# system call code for print_str
	syscall			# print the string of decimal digits.

	jr	$ra		# return

############################################################################
# Function Name: input
# Last Modified: Oct. 21, 2006
############################################################################
# Functional Description:
# Reads a string of decimal digits from the keyboard and returns the 32-bit 
# binary equivalent in register $v0. If the string does not correctly
# represent a decimal number then error status 1 is returned in register $v1
# otherwise the status value returned is 0 for a valid decimal number.
############################################################################
# Example Calling Sequence:
# indata:
#		jal 	input			# get a value
#		beqz	$v1, 	ok
#		li	$v0,	4
#		la	$a0, 	again
#		syscall
#		b	indata
# ok:
#
############################################################################
# Algorithmic Description:
# Input an ascii string into the buffer
# Initialize registers  
# get:	t2 = get character from buffer
# increment buffer pointer t1
# If t2 = blank go to get
# If t2 = minus set flag
# loop:
# If t2 is not a decimal digit go to done
# t2 =t2 - 48
# t0 = 10 * t0 + t2
# get next character from buffer
# go to loop
# done:
# If not a space print error msg and try again
# if minus flag is set then complement t0
# return
# labels to avoid: get, done
############################################################################
# Register Usage:
# $t0: accumulating binary value
# $t1: string pointer
# $t2: gets ascii codes
# $t3:
# $t4: ascii code for 0 (48)
# $t5: ascii code for 9 (57)
# $t7: holds space character (32)
# $t8: ascii code for newline (10)
# $t9: minus sign flag	
	.data
bufin:	.space	60
	.text
input:
	la	$a0, 	bufin
	li	$a1,	60
	li	$v0,	8
	syscall				# Input an  character string
	li	$t4,	48		# ascii 0
	li	$t5,	57		# ascii 9
	li	$t7,	32		# ascii space	
	li	$t0,	0		# t0 used to accumulate binary value
	li	$t8,	10		# ascii code for newline
	li	$t9,	0		# clear t9 minus flag
	li	$v1,	0		# clear status register
	la	$t1, 	bufin		# use t1 as a string pointer
getchar:
	lbu	$t2 	0($t1)		# put character in t2 - not sign extended
	addi	$t1, 	$t1, 1		# increment string pointer
	beq	$t2, 	$t7, getchar	# If space get next character
	beq	$t2,	$t8, err		# error if no digits in string
	bne	$t2, 	45, loopin		# skip to loop if not a minus
	li	$t9,	1		# set minus flag
	lbu	$t2 	0($t1)		# put character in t2 - not sign extended
	addi	$t1, 	$t1, 1		# increment string pointer
	beq	$t2,	10, err		# minus nl is an error							 
loopin:
	blt	$t2,	$t4, err		# if char. less than zero go to quit
	bgt	$t2,	$t5, err		# if char greater than 9 go to quit
	addi	$t2,	$t2,-48		# subtract out ascii bias
	mult	$t0,	$t8		# multiply by 10

	mfhi	$t3
	bnez	$t3,	err		# overflow error
	mflo	$t0
	addu	$t0,	$t0,$t2		# add in value of digit				
	bltz	$t0,	special		# need to check for overflow
more:
	lbu	$t2,	0($t1)		# get next char. from buffer-not extended
	addi	$t1, 	$t1,1		# increment string pointer
	beq	$t2,	$t8, ck		# if newline check for minus
	beq	$t2,	$t7, qt		# Branch if a space
	b    	loopin			# branch to loop
qt:
	beq	$t2,	$t8,ck		# go to ck if a line feed. 
	bne	$t2,	$t7,err		# if not LF or space we have an error
	lbu	$t2,	0($t1)		# get next character from buffer - not extended
	addi	$t1, 	$t1,1		# increment string pointer
	b    	qt			#  branch to loop
ck:
	beqz	$t9, 	posin		# if minus flag not set skip next inst.
	subu	$t0, 	$0, $t0		# complement accumulated value
posin:	move	$v0,	$t0		# return value in v0
	jr	$ra			# return
special:
	beqz	$t9,	err
	beq	$t0,	0x80000000,more
err:
	li	$v1,	1 		# return error flag
	jr	$ra

  
