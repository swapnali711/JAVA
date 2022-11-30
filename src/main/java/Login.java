import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        if("abc".equalsIgnoreCase(username) && "abc".equalsIgnoreCase(password)) {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            RequestDispatcher welcome = req.getRequestDispatcher("welcome");
            welcome.forward(req, resp);
        }else {
            resp.getWriter().println("Invalid Credential");
            RequestDispatcher login=req.getRequestDispatcher("login.html");
            login.include(req,resp);
        }
    }
}
