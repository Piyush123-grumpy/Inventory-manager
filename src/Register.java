import java.awt.Color;  

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class Register implements ActionListener {
	//components of GUi
	JFrame register=new JFrame();
	JLabel R;
	JTextField username_Field;
	JTextField First_name_field;
	JTextField last_name_field;
	JTextField recovery_field;
	JPasswordField password_field;
	JPasswordField con_password_field;
	JTextField Contact_field;
	JTextField email_field;
	
	//INITIALIZES THE WINDOW
	Register(){
		R=new JLabel("Register");
		R.setFont(new Font("Cambria",Font.BOLD,36));
		R.setBounds(530,30, 300, 36);
		
		
		JPanel trans=new JPanel();
		trans.setSize(900,350);
		trans.setBackground(new Color(0,0,0,60));
		trans.setBounds(0, 0, 300, 560);
		trans.setLayout(null);

		ImageIcon image=new ImageIcon("Bl.jpg");
		JLabel bg = new JLabel();
		bg.setIcon(image);
		bg.setBounds(0,0,350,560);
		trans.add(bg);
		
		JLabel username=new JLabel("Username:");
		username.setFont(new Font("Cambria",Font.BOLD,14));
		username.setForeground(Color.BLACK);
		username.setBounds(350,150, 300, 19);
		
		username_Field=new JTextField();
		username_Field.setBackground(Color.WHITE);
		username_Field.setBounds(350,180, 200, 25);
		
		JLabel Firstname=new JLabel("First name:");
		Firstname.setFont(new Font("Cambria",Font.BOLD,14));
		Firstname.setForeground(Color.BLACK);
		Firstname.setBounds(350,220, 300, 19);
		
		First_name_field=new JTextField();
		First_name_field.setBackground(Color.WHITE);
		First_name_field.setBounds(350,250, 200, 25);
		
		JLabel Lastname=new JLabel("Last name:");
		Lastname.setFont(new Font("Cambria",Font.BOLD,14));
		Lastname.setForeground(Color.BLACK);
		Lastname.setBounds(680,220, 300, 19);
		
		last_name_field=new JTextField();
		last_name_field.setBackground(Color.WHITE);
		last_name_field.setBounds(680,250, 200, 25);
		
		//JLabel Recovery=new JLabel("Recovery code:");
		//Recovery.setFont(new Font("Cambria",Font.BOLD,12));
		//Recovery.setForeground(Color.BLACK);
		//Recovery.setBounds(350,290, 300, 19);
		
		//recovery_field=new JTextField();
		//recovery_field.setBackground(Color.WHITE);
		//recovery_field.setBounds(350,320, 200, 25);
		
		JLabel password=new JLabel("Password:");
		password.setFont(new Font("Cambria",Font.BOLD,14));
		password.setForeground(Color.BLACK);
		password.setBounds(680,290, 300, 19);
		
		password_field=new JPasswordField();
		password_field.setBackground(Color.WHITE);
		password_field.setBounds(680,320, 200, 25);
		
		JLabel con_password=new JLabel("Confirm Password:");
		con_password.setFont(new Font("Cambria",Font.BOLD,12));
		con_password.setForeground(Color.BLACK);
		con_password.setBounds(350,350, 300, 19);
		
		con_password_field=new JPasswordField();
		con_password_field.setBackground(Color.WHITE);
		con_password_field.setBounds(350,380, 200, 25);
		
		JLabel Contact=new JLabel("Contact:");
		Contact.setFont(new Font("Cambria",Font.BOLD,14));
		Contact.setForeground(Color.BLACK);
		Contact.setBounds(680,150, 300, 19);
		
		Contact_field=new JTextField();
		Contact_field.setBackground(Color.WHITE);
		Contact_field.setBounds(680,180, 200, 25);
		
		JButton Register = new JButton("Register");
		Register.setBounds(530, 420, 100, 30);
		Register.setFocusable(false);
		Register.addActionListener(this);
		Register.setBackground(Color.WHITE);
		
		email_field=new JTextField();
		email_field.setFont(new Font("Cambria",Font.BOLD,14));
		email_field.setForeground(Color.BLACK);
		email_field.setBounds(680,380, 200, 25);
		
		JLabel email=new JLabel("Email");
		email.setFont(new Font("Cambria",Font.BOLD,12));
		email.setForeground(Color.BLACK);
		email.setBounds(680,350, 200, 25);
		
		
		
		
		
		
		
		
		register.add(R);
		register.add(username);
		register.add(username_Field);
		register.add(Firstname);
		register.add(First_name_field);
		register.add(Lastname);
		register.add(last_name_field);
		//register.add(Recovery);
		//register.add(recovery_field);
		register.add(password);
		register.add(password_field);
		register.add(con_password);
		register.add(con_password_field);
		register.add(Contact);
		register.add(Contact_field);
		register.add(Register);
		register.add(email_field);
		register.add(email);
		
		register.setSize(930,600);
		register.setTitle("Dhukuti");
		register.add(trans);
		register.getContentPane().setBackground(Color.WHITE);
		register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		register.setLayout(null);
		register.setVisible(true);
		
	}
	public static void resizeImage(File originalImage,File resizedImage,int width,int height,String format) {
		try {
		BufferedImage original=ImageIO.read(originalImage);
		BufferedImage resized=new BufferedImage(width,height,original.getType());
		Graphics g2=resized.createGraphics();
		g2.drawImage(original,0,0, width, height, null);
		g2.dispose();
		ImageIO.write(resized, format, resizedImage);
	}
		catch(IOException ex) {
			ex.printStackTrace();
			
		}
	}
	@Override
	//makes register button functionable
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection myConn;
		if (username_Field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else if (First_name_field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else if (last_name_field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else if (password_field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else if (con_password_field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else if (email_field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else if (Contact_field.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Could not sign in due to empty field .");
		}
		else {
			if(password_field.getText().equalsIgnoreCase(con_password_field.getText()))
            {
                //Executing query
				try {
					//1.Get a connection to database
					myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					//2.Create a statement
					Statement myState= myConn.createStatement();
					//3.Execute query
					String sql="insert into registration"+"(user_name,first_name,last_name,password,confirm_password,Email,contact)"+"values('"+username_Field.getText()+"','"+First_name_field.getText()+"','"+last_name_field.getText()+"','"+password_field.getText().toString()+"','"+con_password_field.getText().toString()+"','"+email_field.getText()+"','"+Contact_field.getText()+"')";
					int x= myState.executeUpdate(sql);
					if (x==0) {
						JOptionPane.showMessageDialog(null,"Account already exists");
					}
					else {
						JOptionPane.showMessageDialog(null,"Data Registered Successfully");
						register.dispose();
						Login_page l=new Login_page();
					}
					
				}catch (SQLIntegrityConstraintViolationException b) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Your Username or Email has already been taken.");
				}
				catch (SQLException b) {
					// TODO Auto-generated catch block
					b.printStackTrace();
				}
            }
            else
            {
                JOptionPane.showMessageDialog(null,"password did not match");
            }
		
		}
		
	}
}
