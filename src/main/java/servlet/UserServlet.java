package servlet;

import entity.User;
import service.UserService;
import tamplater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map <String, Object> paramMap = new HashMap<>();
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("add_user.ftl", paramMap);
        resp.getWriter().write(page);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
