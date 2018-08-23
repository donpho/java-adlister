import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if (request.getSession().getAttribute("isLoggedIn").equals(true)) {
                response.sendRedirect("/profile");
                return;
            }
        }catch (NullPointerException e){
            request.getSession().setAttribute("isLoggedIn", false);
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute("isAdmin",true);
            request.getSession().setAttribute("isLoggedIn", true);
            request.getSession().setAttribute("username",username);
            response.sendRedirect("/profile");
        } else {
            request.getSession().setAttribute("isAdmin",false);
            response.sendRedirect("/login");
        }
    }
}
