package com.shadab.dao;

import com.shadab.model.Student;
import com.shadab.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

	//registerStudent method to insert student details into the database
    public static boolean registerStudent(Student student) {
        boolean status = false;

        
        try (Connection con = DBConnection.getConnection()) {
        	String sql = "INSERT INTO student_info (id, name, email, course) VALUES (student_seq.NEXTVAL, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());

            int rows = ps.executeUpdate();
            System.out.println(rows);
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
