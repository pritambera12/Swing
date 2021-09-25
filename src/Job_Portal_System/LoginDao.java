/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Job_Portal_System;

/**
 *
 * @author Biswajit Samanta
 */
import java.sql.*;
public class LoginDao {
    Connection cn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    Statement st=null;
   public boolean checkLogin(String uname,String pass)
   {
        boolean flag=false;
         try{
         //String select_sql="select Username, Password from registration where Username=? and Password=?";
         String select_sql="select Username, Password from registration where Username='"+uname+"' and Password='"+pass+"'";
         ConnectionFactory con=new ConnectionFactory();
         cn=con.getConn();
         st=cn.createStatement();
        rs=st.executeQuery(select_sql);
        if(rs.next()){
            flag=true;
        }
         }
        
            
       catch(SQLException se){  
        se.printStackTrace();   
       }
         return flag;
    
}
}
