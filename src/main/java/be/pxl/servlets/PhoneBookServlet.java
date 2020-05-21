package be.pxl.servlets;

import be.pxl.dao.PhoneBookDao;
import be.pxl.domain.PhoneBookEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPhonebookEntry", value = "/AddPhonebookEntry")
public class PhoneBookServlet extends HttpServlet {
    private PhoneBookDao phoneBookDao;
    private EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        super.init();
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) getServletContext().getAttribute("entityManagerFactory");
        entityManager = entityManagerFactory.createEntityManager();
        phoneBookDao = new PhoneBookDao(entityManager);
    }

    @Override
    public void destroy() {
        super.destroy();
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PhoneBookEntry entry = new PhoneBookEntry();
        entry.setFirstName(req.getParameter("firstName"));
        entry.setFirstName(req.getParameter("lastName"));
        entry.setFirstName(req.getParameter("phoneNumber"));
        phoneBookDao.createEntry(entry);
    }
}
