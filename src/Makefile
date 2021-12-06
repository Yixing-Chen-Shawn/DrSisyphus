#Makefile
JAVAC=javac
JAVAC_FLAGS= -d ../bin
JAVAC_TEST_FLAFS=-cp ../bin
JAVA=java
JAVA_FLAGS=-cp ../bin
JAVA_TEST_FLAGS=-cp .:../bin:../test:../lib/hamcrest-core-1.3.jar:../lib/hamcrest-library-1.3.jar:../lib/junit-4.13.2.jar

all: http

http: http/server/*/*.java
	$(JAVAC) $(JAVAC_FLAGS) http/server/*/*.java

clean: 
	rm -rf ../bin/*/*/*/*.java
	rm -rf ../bin/*

run: all
	$(JAVA) $(JAVA_FLAGS) http.server.main.Main

test: ../test/http/server/*/*.java
	$(JAVAC) $(JAVAC_TEST_FLAGS) ../test/http/server/*/*.java

