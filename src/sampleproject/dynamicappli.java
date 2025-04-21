package sampleproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class dynamicappli {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "Bh@rgav441";
    private static Connection conn;
    private static PreparedStatement pmst;
	public static void main(String[] args) {
		int choice;
		do {
			Scanner src = new Scanner(System.in);
			System.out.println("choose your choice");
			DisplayMenu();
			choice = Integer.parseInt(src.next());
			switch(choice) {
			case 1:
				createdatabase ();
				break;
			case 2:
			    dropDatabase();
			    break;
			case 3:
				dataInsertion();
				break;
			case 4:
				deleteByEmail();
				break;
			case 5:
				updateData();
				break;
			case 6:
				getById();
				break;
			case 7:
				getAll();
				break;
			case 8 :	
			    exit();
			    break;
			case 9:
				login();
				break;
				
			}
		}while(choice > 0);
		

	}

	private static void login() {
	    try {
	        Scanner src = new Scanner(System.in);
	        Class.forName(driver);  
	        String url = "jdbc:mysql://localhost:3306/list";  
	        conn = DriverManager.getConnection(url, username, password);  
	        String logins = "SELECT order_address FROM orders WHERE order_id = 101 AND order_name = 'chittipickels'"; 
	        pmst = conn.prepareStatement(logins);
	        ResultSet rs = pmst.executeQuery();  
	        if (rs.next()) { 
	            System.out.println("Login successful! Order Address: " + rs.getString("order_address"));
	        } else {
	            System.out.println("Login failed");
	        }
	        rs.close();
	        pmst.close();
	        conn.close();
	        src.close();  
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	private static void getById() {
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name :");
			String url  = "jdbc:mysql://localhost:3306/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter tablename :");
			String sql = "slect * from "+src.next()+" where order_id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter order id :");
			pmst.setInt(1, src.nextInt());
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("Order id :"+rs.getInt("order_id"));
				System.out.println("Order name : "+rs.getString("order_name"));
				System.out.println("Order pincode : "+rs.getInt("order_pincode"));
				System.out.println("Order address : "+rs.getString("order_address"));
			}
			pmst.executeQuery();
			pmst.close();
			conn.close();
		} catch (Exception e) {
		     e.printStackTrace();
		}
		
	}

	private static void exit() {
		// TODO Auto-generated method stub
		
	}

	private static void getAll() {
	    try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name :");
			String url = "jdbc:mysql://localhost:3306/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Enter table name :");
			String sql = "select * from "+src.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("Order id :"+rs.getInt("order_id"));
				System.out.println("Order name : "+rs.getString("order_name"));
				System.out.println("Order pincode : "+rs.getInt("order_pincode"));
				System.out.println("Order address : "+rs.getString("order_address"));
			}
			pmst.executeQuery();
			pmst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private static void updateData() {
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name to insert data");
			String url = "jdbc:mysql://localhost:3306/"+src.next();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database tablename");
			String sql = "update "+src.next() + "set order_name = ?,order_pincode=?,order_address=? where order_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter order name :");
			pmst.setString(1, src.next());
			System.out.println("Enter order pincode :");
			pmst.setInt(2,src.nextInt());
			System.out.println("Enter address :");
			pmst.setString(3,src.next());
			System.out.println("Enter id");
			pmst.setInt(4,src.nextInt());
			int i = pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Data base created successfully");
			}else {
				System.out.println("Database not created");
			}
			conn.close();
			pmst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void deleteByEmail() {
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name to insert data");
			String url = "jdbc:mysql://localhost:3306/"+src.next();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database tablename");
			String sql = "insert into database"+src.next() + "where order_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter order id :");
			pmst.setInt(1, src.nextInt());
			int i = pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Data base deleted successfully");
			}else {
				System.out.println("Database not created");
			}
			conn.close();
			pmst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void dropDatabase() {
		// TODO Auto-generated method stub
		
	}

	private static void dataInsertion() {
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name to insert data");
			String url = "jdbc:mysql://localhost:3306/	"+src.next();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database tablename");
			String sql = "insert into "+src.next() + "(order_id,order_name,order_pincode,order_address) values(?,?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter order id :");
			pmst.setInt(1, src.nextInt());
			System.out.println("Enter order name :");
			pmst.setString(2,src.next());
			System.out.println("Enter pincode :");
			pmst.setInt(3,src.nextInt());
			src.nextLine();
			System.out.println("Enter address: ");
			pmst.setString(4,src.next());
			int i = pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Data base added successfully");
			}else {
				System.out.println("Database not added");
			}
			conn.close();
			pmst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void dropdatabase() {
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database name");
			Scanner src = new Scanner(System.in);
			String sql = "drop database"+src.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i == 0) {
				System.out.println("Data base deleted successfully");
			}else {
				System.out.println("Database not deleted");
			}
			conn.close();
			pmst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void createdatabase() {
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database name");
			Scanner src = new Scanner(System.in);
			String sql = "create database "+src.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Data base created successfully");
			}else {
				System.out.println("Database not created");
			}
			conn.close();
			pmst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void base() {
		// TODO Auto-generated method stub
		
	}

	private static void DisplayMenu() {
		System.out.println("\t1.create database");
		System.out.println("\t2.drop database");
		System.out.println("\t3.data insertion");
		System.out.println("\t4.delete by email");
		System.out.println("\t5.update data");
		System.out.println("\t6.get by id");
		System.out.println("\t7.get all");
		System.out.println("\t8.exit");
		System.out.println("\t9.login");
	}

}
