package servlet;

import dao.MeetingDao;
import dao.impl.MeetingDaoImpl;
import entity.Meeting;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "indexServlet" ,urlPatterns = "/select")
public class indexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        MeetingDao dao=new MeetingDaoImpl();
        List<Meeting> list=dao.getList();
        request.getSession().setAttribute("mettingList",list);
        response.sendRedirect("Test.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request,response);
    }
}
