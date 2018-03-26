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

public class UserEditServlet extends HttpServlet{
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> paramMap = new HashMap<>();
        PageGenerator pageGenerator = PageGenerator.instance();
        long id = Long.valueOf(req.getParameter("id"));
        User user = userService.getOneUser(id);
        paramMap.put("user", user);
        String page = pageGenerator.getPage("user_edit.ftl", paramMap);
        resp.getWriter().write(page);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.valueOf(req.getParameter("age"));
        User user = new User(id, firstName, lastName, age);
        userService.updateUser(user);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.sendRedirect("user_list");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
