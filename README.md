# Basic Calculator

**Assumptions/Considerations:**
1. Developed the mentioned feature such that it can be used as dependency in any java based application (by including the JAR - artifact generated from this application)
2. It can be modified to expos APIs for different operation or only calculate method (Not doing it since was not mentioned in assignment)


**Design Decisions:**
1. Operation Enum - For defining different supported operation. For supporting more operation or removal of existing operation, this class needs to be modified.
2. Calculator Interface: To define the contract of calculator application. This would be helpful in achieving IoC. 
3. BasicCalculator class - As an implementation of the BasicCalculator interface. It does not Provide Chaining Operation 
4. Chaining of Operation - This is supported with the help of Builder design pattern. Also, BasicCalculator class has been extended to have a new class ChainingCalculator. This new class demonstrate the Open-Closed Principles and Extensibility principle where new functionality can be added to existing Base classes. As a part of IoC, instead of autowiring BasicCalculator, we will need to autowire ChainingCalculator. Reference would still be of Calculator type.
5. Method overloading - For supporting Operation as an instance of defined Enum as well as String (Operation.ADD and "ADD" - Both are treated equivalent)
6. UnsupportedOperationException - Instance of this exception is thrown in case of use of any operation which is not supported. 



**How to Test:**

```
mvn test
```

**How to generate artifact/JAR (to include as dependency in your application):**

```
mvn package
```

**Code samples:**

```java
BasicCalculator calculator = new Calculator();
```

```java
BasicCalculator calculator = new Calculator().withValue(10);
```

```java
BasicCalculator calculator = new Calculator();
Number result = calculator.calculate(Operation.ADD, 1, 2);
```

```java
BasicCalculator calculator = new Calculator();
Number result = calculator.calculate("ADD", 1, 2);
```

```java
Number result = new Calculator().withValue(1)
        .apply("Add", 2)
        .apply(Operation.DIVIDE, 2)
        .apply(Operation.MULTIPLY, 10)
        .apply(Operation.SUBTRACT, 2)
        .evaluate();
```