package com.cleo.revision.databaseProgramming;

import java.io.FileInputStream;
import java.sql.*;

public class Person {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CleoPortal","deven","728000");
            PreparedStatement pstmt = conn.prepareStatement("insert into User values (?,?,?,?,?)");
            pstmt.setInt(1,1);
            pstmt.setString(2,"Deven");
            pstmt.setString(3,"728000");
            pstmt.setString(4,"25");
            FileInputStream fin = new FileInputStream("src/resources/Deven.JPG");
            pstmt.setBinaryStream(5,fin,fin.available());
            int i = pstmt.executeUpdate();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
