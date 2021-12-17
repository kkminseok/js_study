# Model 1이란?

jsp 코드 2개를 비교하면 쉽다.


```jsp
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  int num = 3;
%>
<head>
    <title>스파게티 코드 예제</title>
</head>
<%
  String getnum = request.getParameter("num");
    PrintWriter writer = response.getWriter();
    if(getnum != null && !getnum.equals(""))
      num = Integer.parseInt(getnum);
%>
<body>
<% writer.print(num); %>
<% if(num %2 != 0){ %>
    홀수입니다.
    <%}
    else
    {%>
    짝수입니다.
<%} %>
</body>
</html>

```

모델1방식을 사용하지 않으면 이처럼 코드가 짬뽕이 되어버리는 일이 발생한다.

코드가 짬뽕이 되지 않게 java코드와 view 코드를 분리하는 것이 필요하다.

분리해보자.


```jsp
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>model_1 Test</title>
</head>
<%
    int num = 3;
    String getnum = request.getParameter("num");
    PrintWriter writer = response.getWriter();
    if(getnum != null && !getnum.equals(""))
        num = Integer.parseInt(getnum);
    String model = "";
    if(num%2 ==1 ){
        model = "홀수";
    }else{
        model = "짝수";
    }
%>
<body>
<%=model%>입니다.
</body>
</html>

```

이렇게 model이라는 변수에 데이터를 담아 view에 출력하는 것을 model1방식이라 한다.
굳이 변수명이 model이 아니여도 된다.
