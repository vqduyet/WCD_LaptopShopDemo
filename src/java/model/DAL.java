/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duyet
 */
public class DAL {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Connection getConn(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=LaptopShop";
            conn = DriverManager.getConnection(url, "sa", "abc123");
        } catch (Exception e) {
        }
        return conn;
    }
    
    public boolean insert(String lapID, String lapName, int price){
        try {
            conn = getConn();
            String sql = "insert into Laptop values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, lapID);
            ps.setString(2, lapName);
            ps.setInt(3, price);
            return ps.executeUpdate()>0;            
        } catch (Exception e) {
        }
        return false;
    }
    public boolean update(String lapID, String lapName, int price){
        try {
            conn = getConn();
            String sql = "UPDATE Laptop SET lapName = ?, price = ? WHERE lapId = ?";
            ps = conn.prepareStatement(sql);            
            ps.setString(1, lapName);
            ps.setInt(2, price);
            ps.setString(3, lapID);
            return ps.executeUpdate()>0;            
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean delete(String lapID){
        try {
            conn = getConn();
            String sql = "delete from Laptop where lapId=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, lapID);            
            return ps.executeUpdate()>0;    
        } catch (Exception e) {
        }
        return false;
    }
    
    public List showAll(){
        List list = new ArrayList();
        try {
            conn = getConn();
            String sql = "select * from Laptop";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Laptop laptop = new Laptop();
                laptop.setLapID(rs.getString(1));
                laptop.setLapName(rs.getString(2));
                laptop.setPrice(rs.getInt(3));
                list.add(laptop);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Laptop getById(String lapId){
        Laptop laptop = new Laptop();
        try {
            conn = getConn();
            String sql = "select * from Laptop where lapId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, lapId);
            rs = ps.executeQuery();
            while(rs.next()){                
                laptop.setLapID(rs.getString(1));
                laptop.setLapName(rs.getString(2));
                laptop.setPrice(rs.getInt(3));                
            }
        } catch (Exception e) {
        }
        return laptop;
    }
    
    public List searchByPrice(int min, int max){
        List list = new ArrayList();
        try {
            conn = getConn();
            String sql = "select * from Laptop where price >= ? and price <= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);
            rs = ps.executeQuery();
            while(rs.next()){
                Laptop laptop = new Laptop();
                laptop.setLapID(rs.getString(1));
                laptop.setLapName(rs.getString(2));
                laptop.setPrice(rs.getInt(3));
                list.add(laptop);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List searchByPriceMin(int min){
        List list = new ArrayList();
        try {
            conn = getConn();
            String sql = "select * from Laptop where price >= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, min);            
            rs = ps.executeQuery();
            while(rs.next()){
                Laptop laptop = new Laptop();
                laptop.setLapID(rs.getString(1));
                laptop.setLapName(rs.getString(2));
                laptop.setPrice(rs.getInt(3));
                list.add(laptop);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List searchByPriceMax(int max){
        List list = new ArrayList();
        try {
            conn = getConn();
            String sql = "select * from Laptop where price <= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, max);            
            rs = ps.executeQuery();
            while(rs.next()){
                Laptop laptop = new Laptop();
                laptop.setLapID(rs.getString(1));
                laptop.setLapName(rs.getString(2));
                laptop.setPrice(rs.getInt(3));
                list.add(laptop);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List searchByName(String lapName){
        List list = new ArrayList();
        try {
            conn = getConn();
            String sql = "select * from Laptop where lapName like concat('%',?,'%')";
            ps = conn.prepareStatement(sql);
            ps.setString(1, lapName);            
            rs = ps.executeQuery();
            while(rs.next()){
                Laptop laptop = new Laptop();
                laptop.setLapID(rs.getString(1));
                laptop.setLapName(rs.getString(2));
                laptop.setPrice(rs.getInt(3));
                list.add(laptop);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
