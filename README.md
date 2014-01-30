##Exercise 9.11 
Assume that you see the following lines of code: 
```java
Device dev = new Printer();
dev.getName();
```
Printer is a subclass of Device. Which of these classes must have a definition of method getName for this code to compile?

**Answer:**
-----------
The Device class must have a definition of getName(). However, the actual implementation can be in the Printer class.

##Exercise 9.12 
In the same situation as in the previous exercise, if both classes have an
implementation of getName, which one will be executed?

**Answer:**
-----------
In that case the Printer class' implementation of getName will be executed because it overrides the Printer class' one.

##Exercise 9.13 
Assume that you write a class Student that does not have a declared superclass. You do not write a toString method. Consider the following lines of code:
```java
Student st = new Student();
String s = st.toString();
```
Will these lines compile? If so, what exactly will happen when you try to execute?

**Answer:**
-----------
The String "s" will contain the string Student@Address where Address is a hexadecimal number containing what address the Student is located at in virtual memory.

##Exercise 9.14 
In the same situation as before (class Student, no toString method), will the following lines compile? Why?
```java
Student st = new Student();
System.out.println(st);
```

**Answer:**
-----------
Yes, the println() method of System.out internally calls the toString() method of the passed object.

##Exercise 9.15 
Assume that your class Student overrides toString so that it returns the student’s name. You now have a list of students. Will the following code compile? If not, why not? If yes, what will it print? Explain in detail what happens.
```java
for(Object st : myList) {
    System.out.println(st);
}
```
**Answer:**
-----------
Yes, it will compile. It will print the names of the students, each name followed by a new line. All classes in Java extend the Object class implicitly so Object is a superclass of Student and Student overrides the toString() method of Object and as such the Student class' toString() method will be called in the println() call.

##Exercise 9.16 
Write a few lines of code that result in a situation where a variable x has the static type T and the dynamic type D.
**Answer:**
-----------
```java
D x = new T();
```
