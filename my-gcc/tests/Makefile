test1.s: test1.c
	gcc -S test1.c

a.out: test1.s test1.h tester.c
	gcc test1.s tester.c 

run_test: a.out
	./a.out

test.y :