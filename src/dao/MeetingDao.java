package dao;

import java.util.List;
import entity.Meeting;
public interface MeetingDao {
    List<Meeting> getList();
    int insert(String sqr, String order, String time);
}
