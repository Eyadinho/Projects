#Mips program that calculates the areas of Triangle, Square and Parallelogram
# Eyad Kathir 
.data
	msg1: 	.asciiz "Calculate area\n1.Triangle\n2.Square\n3.Parallelogram\n0.Exit\n"
	msg2:	.asciiz "Height: "
	msg3:	.asciiz "Base: "
	msgS:	.asciiz "Side: "
	msg4:	.asciiz "Area = "
	enter:	.asciiz "\n==============\n"
	end:	.asciiz "End"

.text

main:
	#print the menu for the user to choose which figure they want to calculate 
	la $a0, msg1
	li $v0, 4
	syscall
	#read user choice or the input 
	li $v0, 5
	syscall
	#switch
	beq $v0, 1, areaT	# 1 will be for calculating the area of triangle 
	beq $v0, 2, areaS	#  2 will be for calculating the area of square
	beq $v0, 3, areaP	# 3 will be for calculating the area of Parallelogram
	beq $v0, 0, exit	# 0 will end program
	
areaT:	#    area of triangle is base * height / 2
	
	la $a0, msg3  # base
	li $v0, 4
	syscall			#print
	add $v0, $0, 6
	syscall			#receives value of base and stores in f0
	add.s $f1, $f1, $f0	#store f0 in f1
	#print and receive height value
	la $a0, msg2
	li $v0, 4
	syscall			#print
	add $v0, $0, 6
	syscall			# stores height value in f0
	add.s $f2, $f2, $f0	#store f0 in f2 , the add.s is for Single precision for floating point number
	#calculate area of triangle
	mul.s $f0, $f1, $f2	#base x height and save in f0
	#load 2 float
	addi $t0, $0, 2
	mtc1 $t0, $f2		#f2 = 0.0         it is to use the correct registers 
	cvt.s.w $f2, $f2           # convert from word to single percision which means that it will have a better output with easier decimals to read
	div.s $f0, $f0, $f2	#divide by 2 and save in f0 , Single precision
	#reset f1 and f2 for counting the other figure
	addi $t0, $0, 0
	mtc1 $t0, $f4		
	cvt.s.w $f4, $f4
	add.s $f1, $f4, $f4	#reset value of f1
	add.s $f2, $f4, $f4	#reset value of f2
	j printf		#jump to printfinal
	
areaS:	#side * side or aka s^2 but s * s will be easier 
	#print and receive side value
	la $a0, msgS
	li $v0, 4
	syscall			#print
	add $v0, $0, 6
	syscall			#receives value of side and stores in f0
	#calculate area of square
	mul.s $f0, $f0, $f0 	#side x side and save in f0 
	j printf		#jump to printfinal
	
areaP:	#base * height
	#print and receive base value
	la $a0, msg3
	li $v0, 4
	syscall			#print
	add $v0, $0, 6
	syscall			#receives value of base and stores in f0
	add.s $f1, $f1, $f0	#store f0 in f1
	#print and receive height value
	la $a0, msg2
	li $v0, 4
	syscall			#print
	add $v0, $0, 6
	syscall			#receives value of height and stores in f0
	add.s $f2, $f2, $f0	#store f0 in f2
	#calculate area of Parallelogram
	mul.s $f0, $f1, $f2	#base x height and save in f0
	#reset f1 and f2
	addi $t0, $0, 0
	mtc1 $t0, $f4		#f4 will look like 0.0
	cvt.s.w $f4, $f4
	add.s $f1, $f4, $f4	#reset the value of  f1
	add.s $f2, $f4, $f4	#reset the value of  f2
	j printf		#jump to printfinal

printf:	#print final  area result(s)
	la $a0, msg4
	li $v0, 4
	syscall
	li $v0, 2
	mtc1 $0, $f3		#f3 is going to look like 0.0
	add.s $f12, $f3, $f0	#f12 print float
	syscall	
	la $a0, enter		#\n
	li $v0, 4
	syscall
	j main			#jump main to loop

exit:	#end program
	la $a0, end
	li $v0, 4
	syscall
	li $v0, 10
	syscall
