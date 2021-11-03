
import java.awt.Color;  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class forgot implements ActionListener,MouseListener{
	//Components of forgot password
	JPanel reset_panel;
	JButton test;
	JFrame forgot_frame;
	JLayeredPane layeredpane;
	JPanel forgot_panel;
	JPanel verification_panel;
	JTextField email_field;
	JPanel change_password_panel;
	JButton verify_button;
	JButton change_password_button;
	int randomCode;
	JTextField verify_field;
	JTextField change_password_field;
	JTextField confirm_password_field;
	//initialzes the components of Gui
	forgot(){
		
		forgot_frame=new JFrame();
		
		JLabel Reset=new JLabel();
		
		layeredpane=new JLayeredPane();
		layeredpane.setBounds(0, 0, 800, 700);
		reset_panel=new JPanel();
		reset_panel.setLayout(null);
		reset_panel.setBackground(new Color(255,255,255));
		reset_panel.setBounds(200, 150, 390, 390);
	
		verification_panel=new JPanel();
		verification_panel.setLayout(null);
		verification_panel.setBackground(new Color(255,255,255));
		verification_panel.setBounds(200, 150, 390, 390);
		verification_panel.add(reset_panel);
		
		JLabel verify=new JLabel("Verification");
		verify.setFont(new Font("Cambria",Font.BOLD,36));
		verify.setBounds(100,60,1000,50);
		verify.setForeground(new Color(51,153,255));
		verification_panel.add(verify);
		
		JLabel Verify=new JLabel("Verify:");
		Verify.setFont(new Font("Comic Sans",Font.BOLD,13));
		Verify.setBounds(20,190,100,50);
		verification_panel.add(Verify);
		
		verify_field=new JTextField("");
		verify_field.setBounds(70,200,300,30);
		verify_field.setForeground(new Color(153,153,153));
		verification_panel.add(verify_field);
		verify_field.addMouseListener(this);
		
		JLabel verify_text=new JLabel("Enter your verification code");
		verify_text.setFont(new Font("Cambria",Font.PLAIN,16));
		verify_text.setBounds(100,110,1000,50);
		verification_panel.add(verify_text);
		
		JLabel below=new JLabel("Below!!");
		below.setFont(new Font("Cambria",Font.PLAIN,16));
		below.setBounds(180,140,1000,50);
		verification_panel.add(below);
		
		
		forgot_panel=new JPanel();
		forgot_panel.setLayout(null);
		forgot_panel.setBackground(new Color(0,0,0,60));
		forgot_panel.setBounds(200, 150, 400, 400);
		forgot_panel.add(reset_panel);
		
		change_password_panel=new JPanel();
		change_password_panel.setLayout(null);
		change_password_panel.setBackground(new Color(255,255,255));
		change_password_panel.setBounds(200, 150, 390, 390);
		
		JLabel change_password=new JLabel("New password:");
		change_password.setFont(new Font("Comic Sans",Font.BOLD,13));
		change_password.setBounds(20,140,100,50);
		change_password_panel.add(change_password);
		
		change_password_field=new JTextField("");
		change_password_field.setBounds(120,150,230,30);
		change_password_field.setForeground(new Color(153,153,153));
		change_password_panel.add(change_password_field);
		
		JLabel confirm_password=new JLabel("Confirm:");
		confirm_password.setFont(new Font("Comic Sans",Font.BOLD,13));
		confirm_password.setBounds(20,180,100,50);
		change_password_panel.add(confirm_password);
		
		confirm_password_field=new JTextField("");
		confirm_password_field.setBounds(120,190,230,30);
		confirm_password_field.setForeground(new Color(153,153,153));
		change_password_panel.add(confirm_password_field);
		
		JLabel Change=new JLabel("Change Password!!");
		Change.setFont(new Font("Cambria",Font.PLAIN,26));
		Change.setForeground(new Color(51,153,255));
		Change.setBounds(100,70,1000,50);
		change_password_panel.add(Change);
		
		
		
		layeredpane.add(forgot_panel, Integer.valueOf(0));
		layeredpane.add(reset_panel, Integer.valueOf(3));
		layeredpane.add(verification_panel, Integer.valueOf(2));
		layeredpane.add(change_password_panel, Integer.valueOf(1));


		
		JLabel email=new JLabel("Email:");
		email.setFont(new Font("Comic Sans",Font.BOLD,13));
		email.setBounds(20,190,100,50);
		reset_panel.add(email);
		
		JLabel forgot_password=new JLabel("Forgot password?");
		forgot_password.setFont(new Font("Cambria",Font.BOLD,36));
		forgot_password.setBounds(50,60,1000,50);
		forgot_password.setForeground(new Color(51,153,255));
		reset_panel.add(forgot_password);
		
		JLabel okay=new JLabel("It's okay");
		okay.setFont(new Font("Cambria",Font.PLAIN,16));
		okay.setBounds(160,110,1000,50);
		reset_panel.add(okay);
		
		JLabel okay2=new JLabel("Enter your email below for the verification code");
		okay2.setFont(new Font("Cambria",Font.PLAIN,16));
		okay2.setBounds(30,130,1000,50);
		reset_panel.add(okay2);
		
		
		email_field=new JTextField("");
		email_field.setBounds(70,200,300,30);
		email_field.setForeground(new Color(153,153,153));
		reset_panel.add(email_field);
		email_field.addMouseListener(this);
		
		
		test=new JButton("Submit");
		test.setBounds(140, 240, 100, 40);
		test.addActionListener(this);
		test.setFocusable(false);
		reset_panel.add(test);
		
		verify_button=new JButton("Submit");
		verify_button.setBounds(140, 240, 100, 40);
		verify_button.setFocusable(false);
		verify_button.addActionListener(this);
		verification_panel.add(verify_button);
		
		change_password_button=new JButton("Submit");
		change_password_button.setBounds(140, 240, 100, 40);
		change_password_button.setFocusable(false);
		change_password_button.addActionListener(this);
		change_password_panel.add(change_password_button);

		 
		
		
		ImageIcon image2=new ImageIcon("Bl.jpg");
		JLabel bg = new JLabel();
		bg.setIcon(image2);
		bg.setBounds(0,0,800,700);
		forgot_frame.setSize(800,700);
		forgot_frame.setTitle("Forgot");
		forgot_frame.add(layeredpane);
		forgot_frame.add(bg);
		forgot_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forgot_frame.setLayout(null);
		forgot_frame.setVisible(true);
		
	}
	//makes the buttons functional
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==test) {
			try {
			Random rand=new Random();
			randomCode=rand.nextInt(999999);
			String host="smtp.gmail.com";
			String user="piyush.ratna.66@gmail.com";
			String password="9841415229";
			if (email_field.getText().equals("")) {
				System.out.println("Error");
			}
			else {
			try {
				//1.Get a connection to database
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				//2.Create a statement
				Statement myState= myConn.createStatement();
				//3.Execute query
				String sql="Select * from registration where Email='"+email_field.getText()+"'";
				ResultSet rs= myState.executeQuery(sql);
				if(rs.next()) {
					String to=email_field.getText();
					String subject="Reseting code";
					String message="Your reset code is :"+randomCode;
					boolean sessionDebug=false;
					Properties pros= System.getProperties();
					pros.put("mail.smtp.host", "host");
					pros.put("mail.smtp.port", "587");
					pros.put("mail.debug", "true");
					pros.put("mail.smtp.auth", "true");
					pros.put("mail.smtp.starttls.required", "true");
					pros.put("mail.smtp.starttls.enable", "true");
					pros.put(" mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
					java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
					Session mailSession=Session.getInstance(pros,null);
					mailSession.setDebug(sessionDebug);
					Message msg =new MimeMessage(mailSession);
					msg.setFrom(new InternetAddress(user));
					InternetAddress []address= {new InternetAddress(to)};
					msg.setRecipients(Message.RecipientType.TO,address);
					msg.setSubject(subject);
					msg.setText(message);
					Transport transport =mailSession.getTransport("smtp");
					transport.connect(host, user, password);
					transport.sendMessage(msg, msg.getAllRecipients());
					transport.close();
					JOptionPane.showMessageDialog(null, "Verification Code has been sent");
					switchpanel(verification_panel);
				}
				else {
					JOptionPane.showMessageDialog(null, "None of the emails match with your email");
				}
			}catch (SQLException b) {
				// TODO Auto-generated catch block
				b.printStackTrace();
			}
			}
			
				}
			
		catch(Exception ex) {
			JOptionPane.showMessageDialog(layeredpane, ex);
		}
		}
		else if (e.getSource()==verify_button) {
			try {
			if(Integer.valueOf(verify_field.getText())==randomCode){
				switchpanel(change_password_panel);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Code do not match");
			}
			}
			catch( java.lang.NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Field cant be empty");
				
			}
		}
		else if (e.getSource()==change_password_button) {
			if(change_password_field.getText().equalsIgnoreCase(confirm_password_field.getText())) {
				try {
					//1.Get a connection to database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					//2.Create a statement
					Statement myState= myConn.createStatement();
					//3.Execute query
					String sql="UPDATE registration set password='"+change_password_field.getText()+"',confirm_password='"+confirm_password_field.getText()+"' where Email='"+email_field.getText()+"' "; 
					myState.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Reset successfully");
					forgot_frame.dispose();					
					Login_page login=new Login_page();
					
				}catch (SQLException b) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, b);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Passwords do not match :(");
			}
		
		}
	}
	public void switchpanel(JPanel panel) {
		layeredpane.removeAll();
		layeredpane.add(forgot_panel);
		layeredpane.add(panel);
		layeredpane.repaint();
		layeredpane.revalidate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		email_field.setText(" ");
		email_field.setForeground(Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
