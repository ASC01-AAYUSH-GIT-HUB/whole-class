package com.demo.jdbc;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.sql.*;
import java.util.Scanner;

public class JDBCSelectStatement {
    public static void main(String[] args) {
        Connection connection=null;
        Scanner s=new Scanner(System.in);
        PreparedStatement preparedStatement=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://localhost:1433;databaseName=MyFriendsDB;user=sa;password=sqlserver;trustServerCertificate=true";
            connection = DriverManager.getConnection(url);
            System.out.println("connection established!");
            String insertquary="insert into Friends(first_name,last_name,friend_no,email) values(?,?,?,?)";
//            String insertquary="insert into Friends(?,?,?,?) values(?,?,?,?)";
//            String val1="first_name";
//            String val2="last_name";
//            String val3="friend_no";
//            String val4="email";
//            preparedStatement.setString(1,val1);
//            preparedStatement.setString(2,val2);
//            preparedStatement.setString(3,val3);
//            preparedStatement.setString(4,val4);
//            preparedStatement.setString(5,fname);
//            preparedStatement.setString(6,lname);
//            preparedStatement.setInt(7,friendno);
//            preparedStatement.setString(8,email);
// above will not work as the values are not set in the query, we need to use placeholders (?) for prepared statements
            // and set the values using preparedStatement.setString() or preparedStatement.setInt() methods

            preparedStatement=connection.prepareStatement(insertquary);
            System.out.println("Write your first name:");
            String fname=s.nextLine();
            System.out.println("Write your last name:");
            String lname=s.nextLine();
            System.out.println("friend number:");
            int friendno= s.nextInt();
            s.nextLine();
            System.out.println("email:");
            String email= s.nextLine();

            preparedStatement.setString(1,fname);
            preparedStatement.setString(2,lname);
            preparedStatement.setInt(3,friendno);
            preparedStatement.setString(4,email);

            int rowUpdate= preparedStatement.executeUpdate();
            System.out.println(rowUpdate+" rows added");


//            Statement statement=connection.createStatement();
//            System.out.println("Statement Created");
//            ResultSet resultSet= statement.executeQuery("select * from Friends where first_name like '%a%y%'");
//            System.out.println("Result set returned");
//            while(resultSet.next()){
//                int friend_no=resultSet.getInt("friend_no");
//                System.out.print(friend_no+"\t");
//                String first_name=resultSet.getString("first_name");
//                System.out.print(first_name+"\t");
//                String last_name=resultSet.getString("last_name");
//                System.out.println(last_name);
//                String email=resultSet.getString("email");
//                System.out.println(email);
//            }
//            resultSet.close();
//            String sql="insert into Friends(friend_no,first_name,last_name,email) values(6,'John','Doe','john.doe@email.com')";
//            int rowsInserted = statement.executeUpdate(sql);
//            System.out.println(rowsInserted + " row(s) inserted.");

        }catch (ClassNotFoundException classNotFoundException) {
            System.err.println(classNotFoundException.getMessage());
//            throw new RuntimeException(e);
            
        }catch (SQLException sqlException){
            System.err.println(sqlException.getMessage());
//            throw new RuntimeException(e);
        }
        finally{
            try {
                if(connection!=null && !connection.isClosed()){
                    connection.close();
                    System.out.println("Connection is closed");
                }
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                // TODO: handle exception
            }
        }
    }
}
