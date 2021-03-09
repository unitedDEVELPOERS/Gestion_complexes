/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fachr
 */
public class DataSource {
    private static DataSource data;
  private Connection con;
  private static String url="jdbc:mysql://localhost:3306/complexes_sportifs";
  private static String login="root";
  private static String pwd="";
  private DataSource() {
      try {
          con=DriverManager.getConnection(url,login,pwd);
          System.out.println("connection valide");
      } catch (SQLException ex) {
         System.out.print(ex);
      }
      
  }
  public Connection getConnection(){
      return con;
  }
  public static DataSource getInstances(){
      if(data==null)
          data=new DataSource();
    return data;  
  }
}
