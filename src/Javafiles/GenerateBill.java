package Naman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;

public class GenerateBill extends JFrame {

	private JPanel contentPane;
	String url="jdbc:mysql://localhost:3306/r";
	String uname="root";
	String pass="naman123";
	 int A[] = {0,0,0,0,0,0,0,0};
	 private JTextField t1;
	 private JTextField t2;
	 private JTextField t3;
	 private JTextField t4;
	 private JTextField t5;
	 private JTextField t6;
	 private JTextField t7;
	 private JTextField t8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateBill frame = new GenerateBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenerateBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Status");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="select TABLE_ID from tables where status = 1;" ;
				try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection(url, uname, pass);
		        Statement st=con.createStatement();
		        ResultSet rs= st.executeQuery(query);
		       
		        while(rs.next()) {
		        	if(rs.getString(1).equalsIgnoreCase("1")) {
		        		t1.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("2")) {
		        		t2.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("3")) {
		        		t3.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("4")) {
		        		t4.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("5")) {
		        		t5.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("6")) {
		        		t6.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("7")) {
		        		t7.setText("Completed!");
		        	}
		        	if(rs.getString(1).equalsIgnoreCase("8")) {
		        		t8.setText("Completed!");
		        	}
//		       System.out.println("dumn");
		        }
//		        
				} catch(Exception e1) {
					e1.printStackTrace();
				}
//			JOptionPane.showMessageDialog(null,"Customer details added Successfully!");
			
	
			}
		});
		btnNewButton.setBounds(17, 243, 101, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Table1");
		lblNewLabel.setBounds(45, 58, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTable = new JLabel("Table2");
		lblTable.setBounds(151, 58, 49, 14);
		contentPane.add(lblTable);
		
		JLabel lblNewLabel_2 = new JLabel("Table3");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(250, 58, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Table 4");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(358, 58, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Table 5");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(470, 58, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Table 6");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(582, 58, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Table 7");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(40, 150, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Table 8");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(122, 150, 49, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton table1 = new JButton("Generate");
		table1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection(url, uname, pass);
//		        String query="call Generate_Bill(?);" ;
		        java.sql.CallableStatement myStat=null;
		        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
		        int id = 1;
		       myStat.setInt(1, id);
//		        System.out.println(rs.getString(1));
		        
		       ResultSet rs = myStat.executeQuery();
//		       int n = st.Update();
		       rs.next();
//		       String name=rs.getString(2);
		       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		table1.setBounds(27, 89, 91, 23);
		contentPane.add(table1);
		
		JButton table2 = new JButton("Generate");
		table2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 2;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		table2.setBounds(133, 89, 101, 23);
		contentPane.add(table2);
		
		JButton table3 = new JButton("Generate");
		table3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 3;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			
			}
		});
		table3.setBounds(244, 89, 91, 23);
		contentPane.add(table3);
		
		JButton table4 = new JButton("Generate");
		table4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 4;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		table4.setBounds(344, 89, 101, 23);
		contentPane.add(table4);
		
		JButton table5 = new JButton("Generate");
		table5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 5;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		table5.setBounds(455, 89, 100, 23);
		contentPane.add(table5);
		
		JButton table6 = new JButton("Generate");
		table6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 6;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		table6.setBounds(565, 89, 91, 23);
		contentPane.add(table6);
		
		JButton table7 = new JButton("Generate");
		table7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 7;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		table7.setBounds(17, 190, 91, 23);
		contentPane.add(table7);
		
		JButton table8 = new JButton("Generate");
		table8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con=DriverManager.getConnection(url, uname, pass);
//			        String query="call Generate_Bill(?);" ;
			        java.sql.CallableStatement myStat=null;
			        myStat = con.prepareCall("{call GENERATE_BILL(?)}");
			        int id = 8;
			       myStat.setInt(1, id);
//			        System.out.println(rs.getString(1));
			        
			       ResultSet rs = myStat.executeQuery();
//			       int n = st.Update();
			       rs.next();
//			       String name=rs.getString(2);
			       System.out.println("Bill Amount of Customer_ID "+ rs.getString(1)+" is "+rs.getString(2) +"rs.");
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				
			}
		});
		table8.setBounds(111, 190, 94, 23);
		contentPane.add(table8);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(27, 70, 79, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(137, 70, 79, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(244, 70, 80, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(344, 70, 79, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(455, 70, 79, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setEditable(false);
		t6.setColumns(10);
		t6.setBounds(565, 70, 79, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setEditable(false);
		t7.setColumns(10);
		t7.setBounds(17, 163, 81, 20);
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setEditable(false);
		t8.setColumns(10);
		t8.setBounds(108, 163, 79, 20);
		contentPane.add(t8);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.RED);
		btnClose.setBounds(17, 305, 101, 42);
		contentPane.add(btnClose);
	
//		if(A[]==1) table2.setSelected(true);
	}
}
