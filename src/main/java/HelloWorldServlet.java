import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = null;
        String name = req.getParameter("name") != null ? req.getParameter("name") : "World";

        System.out.println("Hello there!");
        res.setContentType("text/html");
        PrintWriter output = res.getWriter();
        output.printf("<h1 style=\"color:red;\">Hello %s!</h1>",name);
    }

}