package com.pwr.Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DButils {
    private static Connection ct = null;
    public static Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ct = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc", "root", "peng");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    public static void   closeAll(Connection ct, PreparedStatement ps)throws SQLException{
        if(ct!=null){
            ct.close();
        }
        if (ps != null) {
            ps.close();
        }
    }
}
