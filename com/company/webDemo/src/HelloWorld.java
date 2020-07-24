import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloWorld extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    // d:\项目\java
    // ..\..\jdk1.8.0_261\bin\javac -cp "d:\Software\apache-tomcat-9.0.37\lib\servlet-api.jar" -d .\WebDemo1\WEB-INF\classes .\WebDemo1\src\HelloWorld.java
}