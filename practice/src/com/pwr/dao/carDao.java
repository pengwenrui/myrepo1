package com.pwr.dao;

import com.pwr.Utils.DButils;
import com.pwr.Utils.XMLDOMUtils;
import com.pwr.Utils.XMLutils;
import com.pwr.domain.Car;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.dom4j.Document;
import org.dom4j.Element;


import java.sql.*;
import java.util.*;
public class carDao {
    public ArrayList getAll() {
        try {
            ArrayList al = new ArrayList();
            Document document = XMLutils.getDocument("practice/car.xml");
            Element rootElement = document.getRootElement();
            List<Element> cars = rootElement.elements();
            for (Element e : cars) {
                Car car = new Car();
                car.setType(e.getName());
                car.setId((Integer.parseInt(e.attributeValue("id"))));
                car.setName(e.element("name").getTextTrim());
                car.setSize(Integer.parseInt(e.element("size").getTextTrim()));
                car.setPrice(Integer.parseInt(e.element("price").getTextTrim()));
                al.add(car);
            }
            return al;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void putInDB() throws SQLException {
        ArrayList al = this.getAll();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        for (int i = 0; i < al.size(); i++) {
            Car car = (Car) al.get(i);
            try {
                con = DButils.getCon();
                con.setAutoCommit(false);
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                String sql = "insert into car(id,name,size,price)values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, car.getId());
                ps.setString(2, car.getName());
                ps.setInt(3, car.getSize());
                ps.setInt(4, car.getPrice());
                ps.executeUpdate();
                sql = "INSERT INTO type(type,id)VALUES (?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, car.getType());
                ps.setInt(2, car.getId());
                ps.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    rs.close();
                }
                DButils.closeAll(con, ps);
            }
        }
    }
    public Car selectById (int id) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DButils.getCon();
            String sql="select * from car where id=?";
            ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            Car car=null;
            while (rs.next()){
                car=new Car();
                car.setId(rs.getInt(1));
                car.setName(rs.getString(2));
                car.setSize(rs.getInt(3));
                car.setPrice(rs.getInt(4));
            }
            sql="select type from type where id=?";
            ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                car.setType(rs.getString(1));
            }
            return car;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            DButils.closeAll(con, ps);
        }
        return null;
    }
    public  void show(String type)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ArrayList<Car> al=null;
        int id=0;
        try {
            con = DButils.getCon();
            String sql="select * from type where type=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,type);
            rs = ps.executeQuery();
            al=new ArrayList();
            Car car=null;
            while (rs.next()){
                car=new Car();
                car.setType(rs.getString(2));
                id=rs.getInt(3);
                sql="select * from car where id=?";
                ps=con.prepareStatement(sql);
                ps.setInt(1,id);
                rs2=ps.executeQuery();
                while(rs2.next()){
                    car.setId(id);
                    car.setName(rs2.getString(2));
                    car.setSize(rs2.getInt(3));
                    car.setPrice(rs2.getInt(4));
                }
                al.add(car);
            }
            for(int i=0;i<al.size();i++){
                System.out.println(al.get(i).toString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            DButils.closeAll(con, ps);
        }
    }
    public void buy(int id,int num){
        try {
            org.w3c.dom.Document document = XMLDOMUtils.getDocument("practice/result.xml");
            Car car = this.selectById(id);
            org.w3c.dom.Element table = document.createElement("table");
            table.setAttribute("id",car.getId()+"");
            org.w3c.dom.Element name =document.createElement("name");
            org.w3c.dom.Element size =document.createElement("size");
            org.w3c.dom.Element price =document.createElement("price");
            org.w3c.dom.Element type=document.createElement("type");
            org.w3c.dom.Element sum=document.createElement("sum");
            name.setTextContent(car.getName());
            size.setTextContent(car.getSize()+"");
            price.setTextContent(car.getPrice()+"");
            type.setTextContent(car.getType());
            int total=car.getPrice()*num;
            sum.setTextContent(total+"");
            table.appendChild(name);
            table.appendChild(size);
            table.appendChild(price);
            table.appendChild(type);
            table.appendChild(sum);
            document.getElementsByTagName("cars").item(0).appendChild(table);
            XMLDOMUtils.write2Xml(document,"practice/result.xml");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
