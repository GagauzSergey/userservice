import dao.jdbc.JdbcUserDao;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.UserService;
import servlet.AllUsersServlet;
import servlet.UserEditServlet;
import servlet.UserServlet;

public class AppStarter {
    public static void main(String[] args) throws Exception {

        //config DAO
        JdbcUserDao jdbcUserDao = new JdbcUserDao();

        //config services
        UserService userService = new UserService();
        userService.setJdbcUserDao(jdbcUserDao);

        //servlet services
        UserServlet userServlet = new UserServlet();
        userServlet.setUserService(userService);

        AllUsersServlet allUsersServlet = new AllUsersServlet();
        allUsersServlet.setUserService(userService);

        UserEditServlet userEditServlet = new UserEditServlet();
        userEditServlet.setUserService(userService);

        ServletContextHandler userContextHandler = new ServletContextHandler();
        ServletHolder userServletHolder = new ServletHolder(userServlet);
        ServletHolder allUserServletHolder = new ServletHolder(allUsersServlet);
        ServletHolder userEditServletHolder = new ServletHolder(userEditServlet);


        userContextHandler.addServlet(userServletHolder, "/add_user");
        userContextHandler.addServlet(allUserServletHolder, "/user_list");
        userContextHandler.addServlet(userEditServletHolder, "/*");

        //server config
        Server server = new Server(8080);
        server.setHandler(userContextHandler);
        server.start();
        server.join();
        System.out.println("Server Successfully Started");
    }
}
