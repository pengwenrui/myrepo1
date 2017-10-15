package com.pwr.test;


import com.pwr.dao.*;
import com.pwr.domain.Car;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {
    public static void main(String [] args)throws SQLException{
        carDao carDao = new carDao();
//        ArrayList al = carDao.getAll();
//        for(int i=0;i<al.size();i++){
//                System.out.println(al.get(i).toString());
//
//           }
       // System.out.println(carDao.buy(1).toString());
        carDao.show("hc");
        
    }
}
