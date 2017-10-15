package com.pwr.UI;

import com.pwr.dao.carDao;
import com.pwr.domain.Car;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {
    public static void main(String [] args){
        try {
            System.out.println("欢迎进入租车系统");
            System.out.println("请选择车型的编号(1.客车  2.货车  3.皮卡车)");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            String select=br.readLine();
            String type=null;
            if("1".equals(select)){
                type="kc";
            }
            else if("2".equals(select)){
                type="hc";


            }else if("3".equals(select)){
                type="pkc";
            }

            carDao dao=new carDao();
            dao.show(type);
            System.out.println("请选择具体车型的编号:");
            int  id=(Integer.parseInt(br.readLine()));
            System.out.println("请输入租用天数:");
            int  num=(Integer.parseInt(br.readLine()));
            dao.buy(id,num);
            System.out.println("success！");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("出错了");
        }
  }
}
