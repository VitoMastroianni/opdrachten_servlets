package be.pxl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "GreetingServlet", value = "/Greeting")
public class GreetingServlet extends HttpServlet {

    private Random rand;
    private List<String> greetingList;

    @Override
    public void init() throws ServletException {
        super.init();
        rand = new Random();
        greetingList = new ArrayList<>();
        greetingList.add("Put that cookie down!");
        greetingList.add("Hi!");
        greetingList.add("Hey!");
        greetingList.add("Good day to you!");
        greetingList.add("Howdy-doody!");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1><b>" + greetingList.get(rand.nextInt(greetingList.size())) + "</b></h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
