# init memory
lui $t0, 4097
ori $t0, $t0, 4
addi $t1, $zero, 10
sw $t1, 0($t0)
addi $t0, $zero, 0
addi $t1, $zero, 0
# init register
addi $s1, $zero, 5
# init stack
add $sp, $sp, -16
addi $t0, $zero, 1
sw $t0, 12($sp)
addi $t0, $zero, 2
sw $t0, 8($sp)
addi $t0, $zero, 3
sw $t0, 4($sp)
addi $t0, $zero, 4
sw $t0, 0($sp)
addi $t0, $zero, 0
# initial operation completed
addi $t0, $zero, 2
addi $t1, $zero, 3
lui $t3, 4097
ori $t3, $t3, 4
addi $t4, $zero, 20
sw $t4, 0($t3)
