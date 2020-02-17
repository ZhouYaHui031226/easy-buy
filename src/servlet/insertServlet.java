package servlet;

import dao.MeetingDao;
import dao.impl.MeetingDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "insertServlet",urlPatterns = {"/insert"})
public class insertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("name");
        String room=request.getParameter("se");
        String time=request.getParameter("time");
        MeetingDao dao=new MeetingDaoImpl();
        int result=dao.insert(room,name,time);
        if (result>0){
           response.getWriter().print("<script>alert('添加成功');window.location.href=\"select\";</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        this.doPost(request,response);
    }
}
