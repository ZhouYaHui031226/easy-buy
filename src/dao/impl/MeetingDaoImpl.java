package dao.impl;

import dao.BaseDao;
import dao.MeetingDao;
import entity.Meeting;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingDaoImpl extends BaseDao implements MeetingDao {
    @Override
    public List<Meeting> getList() {
        List<Meeting> meetingList=new ArrayList<Meeting>();
        Meeting meeting=null;
        String sql="SELECT * FROM `meetingroom`";
        Connection connection = this.getConn();
        try {
            this.pstmt=connection.prepareStatement(sql);
            this.rs = this.pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String meeting_name=rs.getString("meeting_name");
                Date meeting_order=rs.getDate("meeting_order");
                String advance_name=rs.getString("advance_name");

                meeting=new Meeting(id,meeting_name,meeting_order,advance_name);
                meetingList.add(meeting);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meetingList;
    }

    @Override
    public int insert(String room, String name, String time) {
        String sql="INSERT INTO `meetingroom`(`meeting_name`,`meeting_order`,`advance_name`) VALUES(?,?,?)";
        Object[] params={room,time,name};
        int result=this.MyExecute(sql,params);

        return result;
    }
}

