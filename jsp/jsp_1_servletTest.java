import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class jsp_1_servletTest extends HttpServlet
{
    public void service(HttpServletRequest request, HttpServletResponse response)
     throws IOException,ServletException{
        System.out.println("hello Servlet");        
    }
}