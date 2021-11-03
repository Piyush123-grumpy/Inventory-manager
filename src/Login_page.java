import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.sql.*;
public class Login_page implements ActionListener,Border{
	//compoonents of GUI
	private int radius;
	private JFrame login_frame=new JFrame();
	private JButton login_button=new JButton("Login");
	private JButton reset=new JButton("reset");
	private JButton register=new JButton("Register");
	private JTextField user_id_field=new JTextField();
	private JPasswordField user_password_field=new JPasswordField();
	private JLabel user_id=new JLabel("User_id");
	private JLabel user_password = new JLabel("Password"); 
	private JLabel message=new JLabel();
	private JCheckBox check;
	private JLabel tbc;
	private JLabel Forgot;
	public JComboBox login_as;
	public String users[]= {"Admin","User"};
	//constructor that initializes the page
	Login_page(){
		ImageIcon image2=new ImageIcon("Bl.jpg");
		JLabel bg = new JLabel();
		bg.setIcon(image2);
		bg.setBounds(0,0,350,600);
		
		
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel brownpanel=new JPanel();
		brownpanel.add(bg);
		brownpanel.setLayout(null);
		brownpanel.setBounds(0, 0, 260, 600);
		
		ImageIcon image=new ImageIcon("Dhukuti (2).png");
		JLabel logo = new JLabel();
		logo.setIcon(image);
		logo.setBounds(10,100,250,250);
		brownpanel.add(logo);
		
		JLabel login = new JLabel("Login");
		login.setFont(new Font("Cambria", Font.BOLD, 60));
		login.setBounds(340, 30, 1000, 200);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Helvetica", Font.PLAIN, 26));
		Username.setBounds(290, 150, 1000, 155);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Helvetica", Font.PLAIN, 26));
		Password.setBounds(290,230, 1000, 155);
		
		login_as=new JComboBox(users);
		login_as.setBounds(400, 450, 100, 30);
		
		
		user_id_field.setBounds(295, 250, 300, 30);
		user_password_field.setBounds(295, 330, 300, 30);
		
		check = new JCheckBox();
		check.setText("Show password");
		check.setFocusable(false);
		check.setFont(new Font("Helvetica", Font.PLAIN, 10));
		check.setBounds(300, 370, 110, 15);
		check.setBackground(Color.WHITE);
		check.setOpaque(true);
		check.addActionListener(this);
		
		login_button.setBounds(300, 390, 130, 40);
		login_button.addActionListener(this);
		login_button.setFocusable(false);
		login_button.setFont(new Font("Comic Sans",Font.BOLD,13));
		login_button.setBackground(Color.WHITE);
		login_button.setBorder(new Login_page(40));
		
		register.setBounds(460,390,133,40);
		register.addActionListener(this);
		register.setFocusable(false);
		register.setFont(new Font("Comic Sans",Font.BOLD,13));
		register.setBackground(Color.WHITE);
		register.setBorder(new Login_page(40));
		
		Forgot = new JLabel("Forgot Password?");
		Forgot.setForeground(Color.BLUE.darker());
		Forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Forgot.setBounds(400, 500, 133, 40);
		Forgot.addMouseListener(new MouseAdapter() {
			 
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // the user clicks on the label
		    	forgot f=new forgot();
		    	login_frame.dispose();
		    }
		 
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        // the mouse has entered the label
		    }
		 
		    @Override
		    public void mouseExited(MouseEvent e) {
		        // the mouse has exited the label
		    }
		});
		
		
		login_frame.add(brownpanel);
		login_frame.add(login);
		login_frame.add(Username);
		login_frame.add(user_id_field);
		login_frame.add(user_password_field);
		login_frame.add(Password);
		login_frame.add(login_button);
		login_frame.add(register);
		login_frame.add(check);
		login_frame.add(Forgot);
		login_frame.add(login_as);
		login_frame.setSize(740,610);
		login_frame.setTitle("Dhukuti");
		login_frame.getContentPane().setBackground(Color.WHITE);
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_frame.setLayout(null);
		login_frame.setVisible(true);
	}
	Login_page(int radius) {
        this.radius = radius;
    }
	//MAKES LOGIN BUTTON FUNCTIONABLE
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login_button) {
			//System.out.println("cool");
			if(login_as.getSelectedItem().equals("Admin")) {
				if(user_id_field.getText().equals("Piyush")) {
					if(user_password_field.getText().toString().equals("123")) {
						JOptionPane.showMessageDialog(null,"Login Successful");
						admin ad=new admin();
						login_frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Password wrong");  
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid credentials");  
				}

			}
			
			else {
				Connection myConn;
				try {
					//1.Get a connection to database
					myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					//2.Create a statement
					Statement myState= myConn.createStatement();
					//3.Execute query
					String sql="Select * from registration where user_name='"+user_id_field.getText()+"'and password ='"+user_password_field.getText().toString()+"'";
					ResultSet rs= myState.executeQuery(sql);
					
					
					if(rs.next()) {
						customer page=new customer();
						login_frame.dispose();
					}
					else {
						user_id_field.setText("");
						user_password_field.setText("");
						JOptionPane.showMessageDialog(null,"Invalid credentials");  
					}
				}catch (SQLException b) {
					// TODO Auto-generated catch block
					b.printStackTrace();
				}

			}
		}
			
		
		else if (e.getSource()==register) {
			login_frame.dispose();
			Register R= new Register();
		}
		else if (e.getSource()==check) {
			if (check.isSelected()) {
				user_password_field.setEchoChar((char) 0);
				
				
			}
			else {
				user_password_field.setEchoChar('\u25cf');
			}
				
		}
		}
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	}
	@Override
	public Insets getBorderInsets(Component c) {
		// TODO Auto-generated method stub
		return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	}
	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}
}
	

