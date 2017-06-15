package com.hm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Database2
{
	
	public static final String DBDRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/demo";
	public static final String DBUSER="root";
	public static final String DBPWD="root2";

	public static void main(String[] args) throws Exception
	{
		//注册驱动
		Class.forName(DBDRIVER);
		//建立连接
		Connection conn= DriverManager.getConnection(DBURL,DBUSER,DBPWD);
		//创建执行SQL语句
		String sql="insert into cv (id,name,height,city) values(?,?,?,?);";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setInt(1, 2);
		ps.setString(2, "feng");
		ps.setInt(3,190);
		ps.setString(4, "马鞍山");
		
		int i=ps.executeUpdate();
		
		System.out.println("i = " + i);
		System.out.println("执行结束");
		ps.close();
		conn.close();

	}

}
