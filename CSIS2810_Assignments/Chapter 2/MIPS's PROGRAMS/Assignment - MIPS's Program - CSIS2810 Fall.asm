# ---------------------------------------------------------------------------
# Program: MIPS's Programs
# Name: Kamdon Bird
# Due Date: October 7th, 2024
# Course: CSIS 2810
# Last Modified: October 7th, 2024
# Description: Fibonacci Sequence
# ---------------------------------------------------------------------------

.data
termsPrompt:	.asciiz "\n Enter the number of terms: "


.text

# ---------------------------------------------------------------------------
# 1. Nested Procedures. The following is a pseudo code for 
# performing the Fibonacci seriesup to n terms using nested functions
# ---------------------------------------------------------------------------

# Computes the sum of two integers.
sum:			# FUNCTION sum(a, b):
  add $v0, a, b		# DECLARE s
  			# s = a + b
 			# RETURN s
 			# END FUNCTION
 	
			# FUNCTION bonacci(n):
			# DECLARE a = 0
			# DECLARE b = 1
			# FOR i FROM 0 TO n-1 DO:
			# DECLARE temp
			# temp = sum(a, b)
			# a = b
			# b = temp
			# END FOR
			# RETURN a
			# END FUNCTION
			# MAIN:
			# PROMPT "Enter the number of terms: "
			# READ n
			# DECLARE nth_term = bonacci(n)
			# PRINT "The nth term is: " + nth_term
			# END MAIN
exit:
  ori $v0, $0, 10       	# system call code 10 for exit
  syscall               	# exit the program