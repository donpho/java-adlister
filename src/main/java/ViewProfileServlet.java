import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if (request.getSession().getAttribute("isAdmin").equals(false)) {
                response.sendRedirect("/webapp/login");
                return;
            }
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }catch (NullPointerException e){
            response.sendRedirect("/login");
        }

    }


}
