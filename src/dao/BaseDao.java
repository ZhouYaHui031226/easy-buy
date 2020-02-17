package dao;

import java.sql.*;

public class BaseDao {
    private final String URL = "jdbc:mysql://localhost:3306/huiyishidb?useUnicode=true&amp&characterEncoding=utf-8";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected PreparedStatement pstmt = null;
    protected ResultSet rs=null;


    /**
     * 获取数据库连接
     *
     * @return
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            if (conn == null) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int MyExecute(String sql, Object... params) {
        Connection conn = null;
        int num = 0;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject((i + 1), params[i]);
                }
            }
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(null,pstmt,conn);
        }
        return num;
    }

    /**
     * 释放资源
     *
     * @param rs
     * @param pstmt
     * @param conn
     */
    public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
