# Jasper

기존 코드는 write()함수를 이용해서 html을 그대로 박아 넣었다.

이를 개선하고자 나온게 Jasper.

Jasper는 자동으로 코드들을 write()함수를 사용하여 html로 띄워준다.
즉 자바코드이다. 어떻게 적용할 수 있을까?

html문법을 사용한 코드에 확장자를 .jsp로 해주면 알아서 적용해준다.

```jsp
<%
int x = 3;
int y = 4;
%>
```

란 코드블록을 jsp를 사용한 코드내에 박아주면 Jasper가 자바코드로 변수선언을 하게 된다.

# 코드블록

기본적으로 jsp는 override한 service()함수와 그 함수를 감싸고 있는 '작성한 이름_jsp'함수가 있다.

그렇기에 초기설정이나 함수를 선언할 때 각각 구분을 해줘야하므로 코드블록을 다르게 작성하여 구분해준다.

## 1. 출력 코드

```
x = 3;
```

이렇게 작성하면 jsp에서는 

```java
out.write("x=3");
```
이렇게 인식하여 그대로 출력된다.

## 2. 코드 블록

```jsp
<%
int x = 10;
%>
```

이렇게 작성하면 jsp에서는

```java
int x = 10;
```

그대로 들어간다.

## 3. 응용

```jsp
y의 값은 <% out.print(y)%>
```
이렇게 작성하면

```java
out.write("y의 값은");
out.print(y);
```
이렇게 인식한다.

## 4. 선언부

```jsp
<%!

public int sum(int a,int b){
    return a + b;
}

%>
```
이렇게 작성해야 override된 service()함수 내에서 선언되지 않는다. 그 윗단에 선언된다.

## 5. 초기 설정을 위한 Page지시자

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```

이렇게 '@'를 달아주면 가장 먼저 읽어들인다. 설정할 때 사용.
