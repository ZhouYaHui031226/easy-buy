import dao.MeetingDao;
import dao.impl.MeetingDaoImpl;
import entity.Meeting;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MeetingDao meetingDao=new MeetingDaoImpl();
        List<Meeting> list=meetingDao.getList();
        Meeting meeting=null;
        for (int i = 0; i <list.size() ; i++) {
            meeting=list.get(i);
            System.out.println(meeting.getId()+"\t\t"+meeting.getMeeting_name());
            System.out.println(meeting.getAdvance_name()+meeting.getMeeting_order());
        }
    }
}
