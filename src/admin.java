import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class admin implements ActionListener,MouseListener{
	
	//CREATION OF JFRAME JPANEL JBUTTON JLABEL JTEXT FIELD JSCROLLPANE
	JFrame f;
	JPanel p1,p2,b_Users,b_Warehouse,b_Brands,b_Category,b_Stores,b_Vehicles,b_Products;
	JPanel b_Feedback,b_logout,panel_Users,panel_Warehouse,panel_Brands,panel_Category,panel_Stores,panel_Vehicles;
	JPanel panel_Products,panel_Feedback,panel_logout;
	JButton user_button_add,user_button_refresh,user_button_update,user_button_delete;

	JLabel l1,l2,label_Users,label_Warehouse,label_Brands,label_Category;
	JLabel label_Stores,label_Vehicles,label_Products,label_Feedback,label_logout;
	JLayeredPane jp;
	JTable table;
	JScrollPane pane,Pane2,Pane3,Pane4,Pane5,Pane6;
	Font fon_dispaly,btn_font;
	JPanel table_panel,table_of_warehouse,table_of_brand,table_of_category,table_of_vehicle,table_of_product;
	JLabel user_label_firstname,user_label_lastname,user_label_email,user_label_username,user_label_password,
	user_label_confirm_password,user_label_contact;
	JTextField user_jtext_field_username,user_jtext_field_lastname,user_jtext_field_firstname,user_jtext_field_email,user_jtext_field_contact,user_jtext_field_password,
	user_jtext_field_confirm_password;
	Border blackline = BorderFactory.createLineBorder(Color.black);
	JLabel search,search_ware,search_brand,search_category,search_vehicle,search_product;
	JTextField search_field,search_field_ware,search_field_brand,search_field_category,search_field_vehicle,search_field_product;
	JTable table_ware,table_brand,table_category,table_vehicle,table_product;
	JTextField warehouse_jtext_field_ware_no,warehouse_jtext_field_name,warehouse_jtext_field_address,warehouse_jtext_field_contact,warehouse_jtext_field_incharge,warehouse_jtext_field_totalproduct;
	JLabel warehouse_label_ware_no,warehouse_label_address,warehouse_label_contact,warehouse_label_name,warehouse_label_incharge,warehouse_label_totalproduct;
	JButton	warehouse_button_add,warehouse_button_refresh,warehouse_button_update,warehouse_button_delete;
	JButton	brand_button_add,brand_button_refresh,brand_button_update,brand_button_delete;
	JLabel Brand_label_id,Brand_label_name,Brand_label_status;
	JTextField Brand_jtext_id,Brand_jtext_name,Brand_jtext_satus;
	JLabel Category_label_id,Category_label_name,Category_label_quantity;
	JButton	category_button_add,category_button_refresh,category_button_update,category_button_delete;
	JTextField Category_jtext_id,Category_jtext_name,Category_jtext_quantity;
	JButton	vehicle_button_add,vehicle_button_refresh,vehicle_button_update,vehicle_button_delete;
	JTextField Vehicle_jtext_no,Vehicle_jtext_name,Vehicle_jtext_status,Vehicle_jtext_Driver;
	JLabel Vehicle_label_no,Vehicle_label_name,Vehicle_label_status,Vehicle_label_Driver;
	JButton product_button_add,product_button_refresh,product_button_update,product_button_delete;
	JTextField Product_jtext_id,Product_jtext_name,Product_jtext_price;
	JLabel Product_label_id,Product_label_name,Product_label_price;
	public admin() {
		fon_dispaly=new Font("arial",Font.BOLD,24);
	    btn_font=new Font("arial",Font.BOLD,16);
	    
	    
	        
		//creates frame
		f = new JFrame();
		//--------------------------------------------------------------------------------	
		p1=new JPanel();
		p1.setBounds(0,0,1080,50);
		p1.setLayout(null);
		p1.setOpaque(true);
		p1.setBackground(new Color(44, 57, 75));
		//rgb(44, 57, 75)
		p2=new JPanel();
		p2.setBounds(0,50,200,670);
		//p2.setOpaque(true);
		p2.setLayout(null);
		p2.setBackground(Color.GRAY);
		
		//---------------------------panels-----------------------------------------------------
		
		b_Users=new JPanel();
		b_Users.setBounds(0,0, 200, 50);
		b_Users.setOpaque(true);
		b_Users.setLayout((null));
		b_Users.setBackground(Color.gray);
		b_Users.setBorder(blackline);
		b_Users.addMouseListener(this);
		
		
		label_Users=new JLabel("Users");
		label_Users.setBounds(45,13, 100, 25);
		label_Users.setForeground(Color.white);
		label_Users.setFont(btn_font);
		b_Users.add(label_Users);
		
		p2.add(b_Users);
		
		//------------------------------------------------------------------------
		b_Warehouse=new JPanel();
		b_Warehouse.setBounds(0,50, 200, 50);
		b_Warehouse.setOpaque(true);
		b_Warehouse.setLayout((null));
		b_Warehouse.setBackground(Color.gray);
		b_Warehouse.setBorder(blackline);
		b_Warehouse.addMouseListener(this);
		
		label_Warehouse=new JLabel("Warehouse");
		label_Warehouse.setBounds(45,13, 100, 25);
		label_Warehouse.setForeground(Color.white);
		label_Warehouse.setFont(btn_font);
		b_Warehouse.add(label_Warehouse);
		
		p2.add(b_Warehouse);
		
		//------------------------------------------------------------------------------
		b_Brands=new JPanel();
		b_Brands.setBounds(0,100,200,50);
		b_Brands.setOpaque(true);
		b_Brands.setLayout((null));
		b_Brands.setBackground(Color.gray);
		b_Brands.setBorder(blackline);
		b_Brands.addMouseListener(this);
		
		
		label_Brands=new JLabel("Brands");
		label_Brands.setBounds(45,13, 100, 25);
		label_Brands.setForeground(Color.white);
		label_Brands.setFont(btn_font);
		b_Brands.add(label_Brands);
		
		p2.add(b_Brands);
		
		//------------------------------------------------------------------------------
		b_Category=new JPanel();
		b_Category.setBounds(0,150,200,50);
		b_Category.setOpaque(true);
		b_Category.setLayout((null));
		b_Category.setBackground(Color.gray);
		b_Category.setBorder(blackline);
		b_Category.addMouseListener(this);
		
		label_Category=new JLabel("Category");
		label_Category.setBounds(45,13, 100, 25);
		label_Category.setForeground(Color.white);
		label_Category.setFont(btn_font);
		b_Category.add(label_Category);
		
		p2.add(b_Category);
		
		
		//------------------------------------------------------------------------------
		b_Vehicles=new JPanel();
		b_Vehicles.setOpaque(true);
		b_Vehicles.setBounds(0, 200, 200, 50);
		b_Vehicles.setBackground(Color.GRAY);
		b_Vehicles.setLayout((null));
		b_Vehicles.setBackground(Color.gray);
		b_Vehicles.setBorder(blackline);
		b_Vehicles.addMouseListener(this);
		
		label_Vehicles=new JLabel("Vehicles");
		label_Vehicles.setBounds(45,13, 100, 25);
		label_Vehicles.setForeground(Color.white);
		label_Vehicles.setFont(btn_font);
		b_Vehicles.add(label_Vehicles);
		
		p2.add(b_Vehicles);
		
		//------------------------------------------------------------------------------
		b_Products=new JPanel();
		b_Products.setOpaque(true);
		b_Products.setBounds(0, 250, 200, 50);
		b_Products.setLayout((null));
		b_Products.setBackground(Color.gray);
		b_Products.setBorder(blackline);
		b_Products.addMouseListener(this);
		
		label_Products=new JLabel("Products");
		label_Products.setBounds(45,13, 100, 25);
		label_Products.setForeground(Color.white);
		label_Products.setFont(btn_font);
		b_Products.add(label_Products);
		
		p2.add(b_Products);
		
		
		//-----------------------------------------------------------------------------------------	
		b_logout=new JPanel();
		b_logout.setOpaque(true);
		b_logout.setBounds(0,581, 200, 50);
		b_logout.setLayout((null));
		b_logout.setBackground(Color.gray);
		b_logout.setBorder(blackline);
		b_logout.addMouseListener(this);
		
		label_logout=new JLabel("Logout");
		label_logout.setBounds(45,13, 100, 25);
		label_logout.setForeground(Color.white);
		label_logout.setFont(btn_font);
		b_logout.add(label_logout);
		
		p2.add(b_logout);
		
		//------------------------------------------------------------------------------
		panel_Users=new JPanel();
		panel_Users.setBounds(200,50, 880, 670);
		panel_Users.setOpaque(true);
		panel_Users.setBackground(Color.WHITE);
		panel_Users.setLayout(null);
		
		table_panel=new JPanel();
		table_panel.setLayout(new BorderLayout());
		table_panel.setBounds(50, 350, 800, 100);
		panel_Users.add(table_panel);
		
		//------------------------------------------------------------------------------
		panel_Warehouse=new JPanel();
		panel_Warehouse.setBounds(200,50,880,670);
		panel_Warehouse.setOpaque(true);
		panel_Warehouse.setBackground(Color.WHITE);
		panel_Warehouse.setLayout(null);
		
		table_of_warehouse=new JPanel();
		table_of_warehouse.setLayout(new BorderLayout());
		table_of_warehouse.setBounds(50, 350, 800, 100);
		panel_Warehouse.add(table_of_warehouse);
		
		//------------------------------------------------------------------------------
		panel_Brands=new JPanel();
		panel_Brands.setBounds(200,50,880,670);
		panel_Brands.setOpaque(true);
		panel_Brands.setBackground(Color.WHITE);
		panel_Brands.setLayout(null);
		
		table_of_brand=new JPanel();
		table_of_brand.setLayout(new BorderLayout());
		table_of_brand.setBounds(50, 350, 800, 100);
		panel_Brands.add(table_of_brand);
		
		
		panel_Category=new JPanel();
		panel_Category.setBounds(200,50,880,670);
		panel_Category.setOpaque(true);
		panel_Category.setBackground(Color.white);
		panel_Category.setLayout(null);
		
		table_of_category=new JPanel();
		table_of_category.setLayout(new BorderLayout());
		table_of_category.setBounds(50, 350, 800, 100);
		panel_Category.add(table_of_category);
		
		panel_Stores=new JPanel();
		panel_Stores.setBounds(200,50,880,670);
		panel_Stores.setOpaque(true);
		panel_Stores.setBackground(Color.green);
		panel_Stores.setLayout(null);
		
		panel_Vehicles=new JPanel();
		panel_Vehicles.setBounds(200,50,880,670);
		panel_Vehicles.setOpaque(true);
		panel_Vehicles.setBackground(Color.WHITE);
		panel_Vehicles.setLayout(null);
		
		table_of_vehicle=new JPanel();
		table_of_vehicle.setLayout(new BorderLayout());
		table_of_vehicle.setBounds(50, 350, 800, 100);
		panel_Vehicles.add(table_of_vehicle);
		
		panel_Products=new JPanel();
		panel_Products.setBounds(200,50,880,670);
		panel_Products.setOpaque(true);
		panel_Products.setBackground(Color.WHITE);
		panel_Products.setLayout(null);
		
		table_of_product=new JPanel();
		table_of_product.setLayout(new BorderLayout());
		table_of_product.setBounds(50, 350, 800, 100);
		panel_Products.add(table_of_product);
		
		panel_Feedback=new JPanel();
		panel_Feedback.setBounds(200,50,880,670);
		panel_Feedback.setOpaque(true);
		panel_Feedback.setBackground(Color.magenta);
		panel_Feedback.setLayout(null);
		
		panel_logout=new JPanel();
		panel_logout.setBounds(200,50,880,670);
		panel_logout.setOpaque(true);
		panel_logout.setBackground(Color.DARK_GRAY);
		panel_logout.setLayout(null);
		

		//------------------------------label-----------------------------------------------
		
		l1=new JLabel("DASHBOARD");
		l1.setBounds(18,15, 200,20);
		l1.setForeground(Color.white);
		l1.setFont(fon_dispaly);
		p1.add(l1);
		
		l2=new JLabel("Hello,Admin");///
		l2.setBounds(940,15, 70,20);
		l2.setForeground(Color.white);
		//l2.setFont(fon_dispaly);
		p1.add(l2);
		
		user_label_username=new JLabel("User name :");
		user_label_username.setBounds(50, 10, 100, 100);
		panel_Users.add(user_label_username);
		
		user_label_firstname=new JLabel("First name :");
		user_label_firstname.setBounds(50, 40, 100, 100);
		panel_Users.add(user_label_firstname);
		
		user_label_lastname=new JLabel("Last name :");
		user_label_lastname.setBounds(50, 70, 100, 100);
		panel_Users.add(user_label_lastname);
		
		user_label_password=new JLabel("Password :");
		user_label_password.setBounds(50, 100, 100, 100);
		panel_Users.add(user_label_password);

		user_label_confirm_password=new JLabel("Confirm password :");
		user_label_confirm_password.setBounds(430, 10, 200, 100);
		panel_Users.add(user_label_confirm_password);
		
		user_label_email=new JLabel("Email :");
		user_label_email.setBounds(500, 40, 100, 100);
		panel_Users.add(user_label_email);
		
		user_label_contact=new JLabel("Contact :");
		user_label_contact.setBounds(495, 70, 100, 100);
		panel_Users.add(user_label_contact);
		
		
		//JTEXT FIELD......................------
		user_jtext_field_username=new JTextField();
		user_jtext_field_username.setBounds(130, 50, 200, 25);
		panel_Users.add(user_jtext_field_username);
		
		user_jtext_field_firstname=new JTextField();
		user_jtext_field_firstname.setBounds(130, 80, 200, 25);
		panel_Users.add(user_jtext_field_firstname);
		
		user_jtext_field_lastname=new JTextField();
		user_jtext_field_lastname.setBounds(130, 110, 200, 25);
		panel_Users.add(user_jtext_field_lastname);
		
		user_jtext_field_password=new JTextField();
		user_jtext_field_password.setBounds(130, 140, 200, 25);
		panel_Users.add(user_jtext_field_password);
		
		user_jtext_field_confirm_password=new JTextField();
		user_jtext_field_confirm_password.setBounds(550, 50, 200, 25);
		panel_Users.add(user_jtext_field_confirm_password);
		
		user_jtext_field_email=new JTextField();
		user_jtext_field_email.setBounds(550, 80, 200, 25);
		panel_Users.add(user_jtext_field_email);
		
		user_jtext_field_contact=new JTextField();
		user_jtext_field_contact.setBounds(550, 110, 200, 25);
		panel_Users.add(user_jtext_field_contact);

	
		
		//--------------------------------try--------------------------------------------
		f.add(p1);
		f.add(p2);
		
		//-------------------------------------------------------------------------------- 
		jp = new JLayeredPane();
		jp.setBounds(0, 0, 1080, 720);
		
		f.add(jp);
		jp.add(panel_Users);
		//----------------------------------user button----------------------------------------------
		
		user_button_add=new JButton("Add");
		user_button_add.setBounds(100,300, 100, 30);
		user_button_add.setBackground(Color.gray);
		user_button_add.setForeground(new Color(255,255,255));
		user_button_add.setFocusable(false);
		user_button_add.addActionListener(this);
		panel_Users.add(user_button_add); 
		
		user_button_refresh=new JButton("Refresh");
		user_button_refresh.setBounds(300,300, 100, 30);
		user_button_refresh.setBackground(Color.gray);
		user_button_refresh.setForeground(new Color(255,255,255));
		user_button_refresh.setFocusable(false);
		user_button_refresh.addActionListener(this);
		panel_Users.add(user_button_refresh); 
		
		
		user_button_update=new JButton("Update");
		user_button_update.setBounds(500,300, 100, 30);
		user_button_update.setBackground(Color.gray);
		user_button_update.setForeground(new Color(255,255,255));
		user_button_update.setFocusable(false);
		user_button_update.addActionListener(this);
		panel_Users.add(user_button_update); 
		
		
		user_button_delete=new JButton("Delete");
		user_button_delete.setBounds(700,300, 100, 30);
		user_button_delete.setBackground(Color.gray);
		user_button_delete.setForeground(new Color(255,255,255));
		user_button_delete.setFocusable(false);
		user_button_delete.addActionListener(this);
		panel_Users.add(user_button_delete); 
		
		////...............................warehouse text field ...............................................
		
		warehouse_jtext_field_ware_no = new JTextField();
		warehouse_jtext_field_ware_no.setBounds(130, 50, 200, 25);
		panel_Warehouse.add(warehouse_jtext_field_ware_no);
		
		warehouse_jtext_field_name=new JTextField();
		warehouse_jtext_field_name.setBounds(130, 80, 200, 25);
		panel_Warehouse.add(warehouse_jtext_field_name);
		
		warehouse_jtext_field_address=new JTextField();
		warehouse_jtext_field_address.setBounds(130, 110, 200, 25);
		panel_Warehouse.add(warehouse_jtext_field_address);
		
		warehouse_jtext_field_contact=new JTextField();
		warehouse_jtext_field_contact.setBounds(130, 140, 200, 25);
		panel_Warehouse.add(warehouse_jtext_field_contact);
		
		warehouse_jtext_field_incharge=new JTextField();
		warehouse_jtext_field_incharge.setBounds(550, 50, 200, 25);
		panel_Warehouse.add(warehouse_jtext_field_incharge);
		
		warehouse_jtext_field_totalproduct=new JTextField();
		warehouse_jtext_field_totalproduct.setBounds(550, 80, 200, 25);
		panel_Warehouse.add(warehouse_jtext_field_totalproduct);


		//----------------------------warehouse--------------------------------------------------------
		
		warehouse_label_ware_no = new JLabel("Warehouse no :");
		warehouse_label_ware_no.setBounds(20, 10, 100, 100);
		panel_Warehouse.add(warehouse_label_ware_no);
		
		warehouse_label_name=new JLabel("Name :");
		warehouse_label_name.setBounds(20, 40, 100, 100);
		panel_Warehouse.add(warehouse_label_name);
		
		warehouse_label_address=new JLabel("Address :");
		warehouse_label_address.setBounds(20, 70, 100, 100);
		panel_Warehouse.add(warehouse_label_address);
		
		warehouse_label_contact=new JLabel("Contact :");
		warehouse_label_contact.setBounds(20, 100, 100, 100);
		panel_Warehouse.add(warehouse_label_contact);

		warehouse_label_incharge=new JLabel("Incharge :");
		warehouse_label_incharge.setBounds(430, 10, 200, 100);
		panel_Warehouse.add(warehouse_label_incharge);
		
		warehouse_label_totalproduct=new JLabel("Total product :");
		warehouse_label_totalproduct.setBounds(430, 40, 100, 100);
		panel_Warehouse.add(warehouse_label_totalproduct);
		
		//...............................warehouse button.................................
		
		warehouse_button_add=new JButton("Add");
		warehouse_button_add.setBounds(100,300, 100, 30);
		warehouse_button_add.setBackground(Color.gray);
		warehouse_button_add.setForeground(new Color(255,255,255));
		warehouse_button_add.setFocusable(false);
		warehouse_button_add.addActionListener(this);
		panel_Warehouse.add(warehouse_button_add); 
		
		warehouse_button_refresh=new JButton("Refresh");
		warehouse_button_refresh.setBounds(300,300, 100, 30);
		warehouse_button_refresh.setBackground(Color.gray);
		warehouse_button_refresh.setForeground(new Color(255,255,255));
		warehouse_button_refresh.setFocusable(false);
		warehouse_button_refresh.addActionListener(this);
		panel_Warehouse.add(warehouse_button_refresh); 
		
		
		warehouse_button_update=new JButton("Update");
		warehouse_button_update.setBounds(500,300, 100, 30);
		warehouse_button_update.setBackground(Color.gray);
		warehouse_button_update.setForeground(new Color(255,255,255));
		warehouse_button_update.setFocusable(false);
		warehouse_button_update.addActionListener(this);
		panel_Warehouse.add(warehouse_button_update); 
		
		
		warehouse_button_delete=new JButton("Delete");
		warehouse_button_delete.setBounds(700,300, 100, 30);
		warehouse_button_delete.setBackground(Color.gray);
		warehouse_button_delete.setForeground(new Color(255,255,255));
		warehouse_button_delete.setFocusable(false);
		warehouse_button_delete.addActionListener(this);
		panel_Warehouse.add(warehouse_button_delete); 
		//------------------------Brand button-----------------------------
		brand_button_add=new JButton("Add");
		brand_button_add.setBounds(100,300, 100, 30);
		brand_button_add.setBackground(Color.gray);
		brand_button_add.setForeground(new Color(255,255,255));
		brand_button_add.setFocusable(false);
		brand_button_add.addActionListener(this);
		panel_Brands.add(brand_button_add); 
		
		brand_button_refresh=new JButton("Refresh");
		brand_button_refresh.setBounds(300,300, 100, 30);
		brand_button_refresh.setBackground(Color.gray);
		brand_button_refresh.setForeground(new Color(255,255,255));
		brand_button_refresh.setFocusable(false);
		brand_button_refresh.addActionListener(this);
		panel_Brands.add(brand_button_refresh); 
		
		
		brand_button_update=new JButton("Update");
		brand_button_update.setBounds(500,300, 100, 30);
		brand_button_update.setBackground(Color.gray);
		brand_button_update.setForeground(new Color(255,255,255));
		brand_button_update.setFocusable(false);
		brand_button_update.addActionListener(this);
		panel_Brands.add(brand_button_update); 

		brand_button_delete=new JButton("Delete");
		brand_button_delete.setBounds(700,300, 100, 30);
		brand_button_delete.setBackground(Color.gray);
		brand_button_delete.setForeground(new Color(255,255,255));
		brand_button_delete.setFocusable(false);
		brand_button_delete.addActionListener(this);
		panel_Brands.add(brand_button_delete);
		//JTEXT FIELD.Brand.....................------
		Brand_jtext_id=new JTextField();
		Brand_jtext_id.setBounds(130, 50, 200, 25);
		panel_Brands.add(Brand_jtext_id);
		
		Brand_jtext_name = new JTextField();
		Brand_jtext_name.setBounds(130, 80, 200, 25);
		panel_Brands.add(Brand_jtext_name);
		
		Brand_jtext_satus=new JTextField();
		Brand_jtext_satus.setBounds(130, 110, 200, 25);
		panel_Brands.add(Brand_jtext_satus);
		
		
		

		//----------------------------Brand label--------------------------------------------------------
		Brand_label_id = new JLabel("Brand id :");
		Brand_label_id.setBounds(60, 10, 100, 100);
		panel_Brands.add(Brand_label_id);
		
		Brand_label_name = new JLabel("Brand :");
		Brand_label_name.setBounds(60, 40, 100, 100);
		panel_Brands.add(Brand_label_name);
		
		Brand_label_status=new JLabel("Status :");
		Brand_label_status.setBounds(60, 70, 100, 100);
		panel_Brands.add(Brand_label_status);
		
		search= new JLabel("Search");
		search.setBounds(325, 250, 80, 30);
		search.setForeground(new Color(51,153,255));
		search.setFont(new Font("Cambria", Font.BOLD, 18));
		panel_Users.add(search);
		
		//----------------------------Category buttons--------------------------------------------------------
		category_button_add=new JButton("Add");
		category_button_add.setBounds(100,300, 100, 30);
		category_button_add.setBackground(Color.gray);
		category_button_add.setForeground(new Color(255,255,255));
		category_button_add.setFocusable(false);
		category_button_add.addActionListener(this);
		panel_Category.add(category_button_add); 
		
		category_button_refresh=new JButton("Refresh");
		category_button_refresh.setBounds(300,300, 100, 30);
		category_button_refresh.setBackground(Color.gray);
		category_button_refresh.setForeground(new Color(255,255,255));
		category_button_refresh.setFocusable(false);
		category_button_refresh.addActionListener(this);
		panel_Category.add(category_button_refresh); 
		
		
		category_button_update=new JButton("Update");
		category_button_update.setBounds(500,300, 100, 30);
		category_button_update.setBackground(Color.gray);
		category_button_update.setForeground(new Color(255,255,255));
		category_button_update.setFocusable(false);
		category_button_update.addActionListener(this);
		panel_Category.add(category_button_update); 
		
		
		category_button_delete=new JButton("Delete");
		category_button_delete.setBounds(700,300, 100, 30);
		category_button_delete.setBackground(Color.gray);
		category_button_delete.setForeground(new Color(255,255,255));
		category_button_delete.setFocusable(false);
		category_button_delete.addActionListener(this);
		panel_Category.add(category_button_delete);
		
		//----------------------------Category label--------------------------------------------------------
		Category_label_id = new JLabel("Category id :");
		Category_label_id.setBounds(60, 10, 100, 100);
		panel_Category.add(Category_label_id);
		
		Category_label_name = new JLabel("Category name :");
		Category_label_name.setBounds(60, 40, 100, 100);
		panel_Category.add(Category_label_name);
		
		Category_label_quantity=new JLabel("Category quantity :");
		Category_label_quantity.setBounds(60, 70, 150, 100);
		panel_Category.add(Category_label_quantity);
		
		//----------------------------Category jtext--------------------------------------------------------
		Category_jtext_id=new JTextField();
		Category_jtext_id.setBounds(200, 50, 200, 25);
		panel_Category.add(Category_jtext_id);
		
		Category_jtext_name = new JTextField();
		Category_jtext_name.setBounds(200, 80, 200, 25);
		panel_Category.add(Category_jtext_name);
		
		Category_jtext_quantity=new JTextField();
		Category_jtext_quantity.setBounds(200, 110, 200, 25);
		panel_Category.add(Category_jtext_quantity);
		
		//----------------------------vehicle buttons--------------------------------------------------------
		vehicle_button_add=new JButton("Add");
		vehicle_button_add.setBounds(100,300, 100, 30);
		vehicle_button_add.setBackground(Color.gray);
		vehicle_button_add.setForeground(new Color(255,255,255));
		vehicle_button_add.setFocusable(false);
		vehicle_button_add.addActionListener(this);
		panel_Vehicles.add(vehicle_button_add); 
		
		vehicle_button_refresh=new JButton("Refresh");
		vehicle_button_refresh.setBounds(300,300, 100, 30);
		vehicle_button_refresh.setBackground(Color.gray);
		vehicle_button_refresh.setForeground(new Color(255,255,255));
		vehicle_button_refresh.setFocusable(false);
		vehicle_button_refresh.addActionListener(this);
		panel_Vehicles.add(vehicle_button_refresh); 
		
		
		vehicle_button_update=new JButton("Update");
		vehicle_button_update.setBounds(500,300, 100, 30);
		vehicle_button_update.setBackground(Color.gray);
		vehicle_button_update.setForeground(new Color(255,255,255));
		vehicle_button_update.setFocusable(false);
		vehicle_button_update.addActionListener(this);
		panel_Vehicles.add(vehicle_button_update); 
		
		
		vehicle_button_delete=new JButton("Delete");
		vehicle_button_delete.setBounds(700,300, 100, 30);
		vehicle_button_delete.setBackground(Color.gray);
		vehicle_button_delete.setForeground(new Color(255,255,255));
		vehicle_button_delete.setFocusable(false);
		vehicle_button_delete.addActionListener(this);
		panel_Vehicles.add(vehicle_button_delete);
		
		//----------------------------Vehicle label--------------------------------------------------------
		Vehicle_label_no = new JLabel("Vehicle id :");
		Vehicle_label_no.setBounds(60, 10, 100, 100);
		panel_Vehicles.add(Vehicle_label_no);
		
		Vehicle_label_name = new JLabel("Vehicle name :");
		Vehicle_label_name.setBounds(60, 40, 100, 100);
		panel_Vehicles.add(Vehicle_label_name);
		
		Vehicle_label_status=new JLabel("Vehicle status :");
		Vehicle_label_status.setBounds(60, 70, 150, 100);
		panel_Vehicles.add(Vehicle_label_status);
		
		Vehicle_label_Driver=new JLabel("Vehicle Driver :");
		Vehicle_label_Driver.setBounds(60, 100, 150, 100);
		panel_Vehicles.add(Vehicle_label_Driver);
		
		//----------------------------Vehicle jtext--------------------------------------------------------
		Vehicle_jtext_no=new JTextField();
		Vehicle_jtext_no.setBounds(200, 50, 200, 25);
		panel_Vehicles.add(Vehicle_jtext_no);
		
		Vehicle_jtext_name = new JTextField();
		Vehicle_jtext_name.setBounds(200, 80, 200, 25);
		panel_Vehicles.add(Vehicle_jtext_name);
		
		Vehicle_jtext_status = new JTextField();
		Vehicle_jtext_status.setBounds(200, 110, 200, 25);
		panel_Vehicles.add(Vehicle_jtext_status);
		
		Vehicle_jtext_Driver=new JTextField();
		Vehicle_jtext_Driver.setBounds(200, 140, 200, 25);
		panel_Vehicles.add(Vehicle_jtext_Driver);
		//----------------------------product buttons--------------------------------------------------------
		product_button_add=new JButton("Add");
		product_button_add.setBounds(100,300, 100, 30);
		product_button_add.setBackground(Color.gray);
		product_button_add.setForeground(new Color(255,255,255));
		product_button_add.setFocusable(false);
		product_button_add.addActionListener(this);
		panel_Products.add(product_button_add); 
		
		product_button_refresh=new JButton("Refresh");
		product_button_refresh.setBounds(300,300, 100, 30);
		product_button_refresh.setBackground(Color.gray);
		product_button_refresh.setForeground(new Color(255,255,255));
		product_button_refresh.setFocusable(false);
		product_button_refresh.addActionListener(this);
		panel_Products.add(product_button_refresh); 
		
		
		product_button_update=new JButton("Update");
		product_button_update.setBounds(500,300, 100, 30);
		product_button_update.setBackground(Color.gray);
		product_button_update.setForeground(new Color(255,255,255));
		product_button_update.setFocusable(false);
		product_button_update.addActionListener(this);
		panel_Products.add(product_button_update); 
		
		
		product_button_delete=new JButton("Delete");
		product_button_delete.setBounds(700,300, 100, 30);
		product_button_delete.setBackground(Color.gray);
		product_button_delete.setForeground(new Color(255,255,255));
		product_button_delete.setFocusable(false);
		product_button_delete.addActionListener(this);
		panel_Products.add(product_button_delete);
		
		//----------------------------product label--------------------------------------------------------
		Product_label_id = new JLabel("Product id :");
		Product_label_id.setBounds(60, 10, 100, 100);
		panel_Products.add(Product_label_id);
				
		Product_label_name = new JLabel("Product name :");
		Product_label_name.setBounds(60, 40, 100, 100);
		panel_Products.add(Product_label_name);
				
		Product_label_price=new JLabel("Product price :");
		Product_label_price.setBounds(60, 70, 150, 100);
		panel_Products.add(Product_label_price);
		//----------------------------Vehicle jtext--------------------------------------------------------
		Product_jtext_id=new JTextField();
		Product_jtext_id.setBounds(200, 50, 200, 25);
		panel_Products.add(Product_jtext_id);
				
		Product_jtext_name = new JTextField();
		Product_jtext_name.setBounds(200, 80, 200, 25);
		panel_Products.add(Product_jtext_name);
				
		Product_jtext_price = new JTextField();
		Product_jtext_price.setBounds(200, 110, 200, 25);
		panel_Products.add(Product_jtext_price);
		
		
		
		//creates a search field FOR USE
		search_field=new JTextField();
		search_field.setBounds(400, 250, 200, 25);
		panel_Users.add(search_field);
		search_field.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field.getText();
            	search_user(searchString);
            }
        });
		
		//creates a search field FOR WAREHOUSE
		search_ware= new JLabel("Search");
		search_ware.setBounds(325, 250, 80, 30);
		search_ware.setForeground(new Color(51,153,255));
		search_ware.setFont(new Font("Cambria", Font.BOLD, 18));
		panel_Warehouse.add(search_ware);
		
		search_field_ware=new JTextField();
		search_field_ware.setBounds(400, 250, 200, 25);
		panel_Warehouse.add(search_field_ware);
		search_field_ware.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field_ware.getText();
            	search_ware(searchString);
            }
        });
		//creates a search field FOR BRAN
		search_brand= new JLabel("Search");
		search_brand.setBounds(325, 250, 80, 30);
		search_brand.setForeground(new Color(51,153,255));
		search_brand.setFont(new Font("Cambria", Font.BOLD, 18));
		panel_Brands.add(search_brand);
		
		search_field_brand=new JTextField();
		search_field_brand.setBounds(400, 250, 200, 25);
		panel_Brands.add(search_field_brand);
		search_field_brand.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field_brand.getText();
            	search_brand(searchString);
            }
        });
		//creates a search field FOR CATEGORY
		search_category= new JLabel("Search");
		search_category.setBounds(325, 250, 80, 30);
		search_category.setForeground(new Color(51,153,255));
		search_category.setFont(new Font("Cambria", Font.BOLD, 18));
		panel_Category.add(search_category);
		
		search_field_category=new JTextField();
		search_field_category.setBounds(400, 250, 200, 25);
		panel_Category.add(search_field_category);
		search_field_category.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field_category.getText();
            	search_category(searchString);
            }
        });
		//creates a search field FOR VEHICLE
		search_vehicle= new JLabel("Search");
		search_vehicle.setBounds(325, 250, 80, 30);
		search_vehicle.setForeground(new Color(51,153,255));
		search_vehicle.setFont(new Font("Cambria", Font.BOLD, 18));
		panel_Vehicles.add(search_vehicle);
		
		search_field_vehicle=new JTextField();
		search_field_vehicle.setBounds(400, 250, 200, 25);
		panel_Vehicles.add(search_field_vehicle);
		search_field_vehicle.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field_vehicle.getText();
            	search_vehicle(searchString);
            }
        });
		//creates a search field FOR PRODUCT
		search_product= new JLabel("Search");
		search_product.setBounds(325, 250, 80, 30);
		search_product.setForeground(new Color(51,153,255));
		search_product.setFont(new Font("Cambria", Font.BOLD, 18));
		panel_Products.add(search_product);
		
		search_field_product=new JTextField();
		search_field_product.setBounds(400, 250, 200, 25);
		panel_Products.add(search_field_product);
		search_field_product.addKeyListener(new KeyAdapter() {
            // override keyReleased listener on the Email TextField
            @Override
            public void keyReleased(KeyEvent e) {
            	String searchString = search_field_product.getText();
            	search_product(searchString);
            }
        });
		
		
		
		show_user();
		show_warehouse();
		show_brand();
		show_category();
		show_vehicle();
		show_product();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1080,720);
		f.setTitle("Dashboard");
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);	
	}
	//STORING THE DATA OF USERS IN ARRAY LIST
	public ArrayList<registration> userlist(){
		ArrayList<registration> userlist=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
			String query="Select * from registration";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			registration user;
			while(rs.next()) {
				user=new registration(rs.getInt("sn"),rs.getString("user_name"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("password"),rs.getString("confirm_password"),rs.getString("Email"),rs.getString("contact"));
				//using the user object to store into the user list
				userlist.add(user);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return userlist;
	}
	//STORING THE DATA OF WAREHOUSE IN ARRAY LIST
	public ArrayList<warehouse> warehousedetail(){
		ArrayList<warehouse> warehousedetail=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
			String query="Select * from warehouse";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			warehouse user;
			while(rs.next()) {
				user=new warehouse(rs.getInt("sn"),rs.getString("ware_id"),rs.getString("ware_name"),rs.getString("location"),rs.getString("contact"),rs.getString("incharge"),rs.getString("total_products"));
				//using the user object to store into the user list
				warehousedetail.add(user);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return warehousedetail;
		
	}
	//STORING THE DATA OF BRAND  IN ARRAY LIST
	public ArrayList<brand> branddetail(){
		ArrayList<brand> branddetail=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
			String query="Select * from brand";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			brand user;
			while(rs.next()) {
				user=new brand(rs.getInt("sn"),rs.getString("brand_id"),rs.getString("brand_name"),rs.getString("brand_status"));
				//using the user object to store into the user list
				branddetail.add(user);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return branddetail;
	}
	//STORING THE DATA OF CATEGORY IN ARRAY LIST
	public ArrayList<category> categorydetail(){
		ArrayList<category> categorydetail=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
			String query="Select * from category";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			category details;
			while(rs.next()) {
				details=new category(rs.getInt("sn"),rs.getString("category_id"),rs.getString("category"),rs.getString("quantity"));
				//using the user object to store into the user list
				categorydetail.add(details);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return categorydetail;
	}
	//STORING THE DATA OF VEHICLE IN ARRAY LIST
	public ArrayList<vehicle> vehicledetail(){
		ArrayList<vehicle> vehicledetail=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
			String query="Select * from vehicle";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			vehicle gadi;
			while(rs.next()) {
				gadi=new vehicle(rs.getInt("sn"),rs.getString("vehicle_id"),rs.getString("vehicle_name"),rs.getString("vehicle_status"),rs.getString("vehicle_driver"));
				//using the user object to store into the user list
				vehicledetail.add(gadi);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return vehicledetail;
	}
	//STORING THE DATA OF PRODUCT IN ARRAY LIST
	public ArrayList<product> productdetail(){
		ArrayList<product> productdetail=new ArrayList<>();
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
			String query="Select * from product";
			Statement st=myConn.createStatement();
			ResultSet rs=st.executeQuery(query);
			//creating a user class
			product PRODUCT;
			while(rs.next()) {
				PRODUCT=new product(rs.getInt("sn"),rs.getString("product_id"),rs.getString("product_name"),rs.getString("product_price"));
				//using the user object to store into the user list
				productdetail.add(PRODUCT);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return productdetail;
	}
	//SHOWS DATA OF USERS INTO TABLE
	public void show_user() throws ArrayIndexOutOfBoundsException{
		ArrayList<registration>list=userlist();
		table=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[8];
		columnNames[0]="Sn";
		columnNames[1]="User name";
		columnNames[2]="First Name";
		columnNames[3]="Last Name";
		columnNames[4]="Password";
		columnNames[5]="Confirm Password";
		columnNames[6]="Email Address";
		columnNames[7]="Contact";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[8];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getUser_name();
			row[2]=list.get(i).getFirst_name();
			row[3]=list.get(i).getLast_name();
			row[4]=list.get(i).getPassword();
			row[5]=list.get(i).getConfirm_password();
			row[6]=list.get(i).getEmail();
			row[7]=list.get(i).getContact();
			model.addRow(row);
			}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setLayout(null);
		table.setBounds(200, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int i = table.getSelectedRow();
		        TableModel model=table.getModel();
		        try {
		        user_jtext_field_username.setText(model.getValueAt(i, 1).toString());
		        user_jtext_field_firstname.setText(model.getValueAt(i, 2).toString());
		        user_jtext_field_lastname.setText(model.getValueAt(i, 3).toString());
		        user_jtext_field_password.setText(model.getValueAt(i, 4).toString());
		        user_jtext_field_confirm_password.setText(model.getValueAt(i, 5).toString());
		        user_jtext_field_email.setText(model.getValueAt(i, 6).toString());
		        user_jtext_field_contact.setText(model.getValueAt(i, 7).toString());
		        }
		        catch(ArrayIndexOutOfBoundsException e) {
		            // Print message when any exception occurs
					JOptionPane.showMessageDialog(null,"Table is empty");  
		        }
		        
		        
		    }
		});
		//Jtable added to the scrollpane
		pane=new JScrollPane(table);
		table_panel.add(pane);
		
	}
	//SHOWS DATA OF WAREHOUSE INTO TABLE
	public void show_warehouse()throws ArrayIndexOutOfBoundsException{ 
		
		ArrayList<warehouse>list=warehousedetail();
		table_ware=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[7];
		columnNames[0]="Sn";
		columnNames[1]="Ware id";
		columnNames[2]="Ware_name";
		columnNames[3]="Location";
		columnNames[4]="Contact";
		columnNames[5]="Incharge";
		columnNames[6]="Total products";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[7];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getWare_id();
			row[2]=list.get(i).getWare_name();
			row[3]=list.get(i).getLocation();
			row[4]=list.get(i).getContact();
			row[5]=list.get(i).getIncharge();
			row[6]=list.get(i).getTotal_products();
			model.addRow(row);
			}
		table_ware.setModel(model);
		table_ware.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_ware.setFillsViewportHeight(true);
		table_ware.setLayout(null);
		table_ware.setBounds(200, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows
		
		table_ware.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt)  {
		        int i = table_ware.getSelectedRow();
		        TableModel model=table_ware.getModel();
		        try {
		        warehouse_jtext_field_ware_no.setText(model.getValueAt(i, 1).toString());
		        warehouse_jtext_field_name.setText(model.getValueAt(i, 2).toString());
		        warehouse_jtext_field_address.setText(model.getValueAt(i, 3).toString());
		        warehouse_jtext_field_contact.setText(model.getValueAt(i, 4).toString());
		        warehouse_jtext_field_incharge.setText(model.getValueAt(i, 5).toString());
		        warehouse_jtext_field_totalproduct.setText(model.getValueAt(i, 6).toString());
		        }
		        catch(ArrayIndexOutOfBoundsException e) {
		            // Print message when any exception occurs
					JOptionPane.showMessageDialog(null,"Table is empty");  
		        }
		        
		        
		    }
		});
		//Jtable added to the scrollpane
		Pane2=new JScrollPane(table_ware);
		table_of_warehouse.add(Pane2);
		}
	//SHOWS DATA OF BRANDS INTO TABLE	
	public void show_brand() throws ArrayIndexOutOfBoundsException {
		ArrayList<brand>list=branddetail();
		table_brand=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[4];
		columnNames[0]="Sn";
		columnNames[1]="Brand id";
		columnNames[2]="Brand_name";
		columnNames[3]="Brand status";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getBrand_id();
			row[2]=list.get(i).getBrand_name();
			row[3]=list.get(i).getBrand_status();
			model.addRow(row);
			}
		table_brand.setModel(model);
		table_brand.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_brand.setFillsViewportHeight(true);
		table_brand.setLayout(null);
		table_brand.setBounds(200, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows

		table_brand.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int i = table_brand.getSelectedRow();
		        TableModel model=table_brand.getModel();
		        try {
		        Brand_jtext_id.setText(model.getValueAt(i, 1).toString());
		        Brand_jtext_name.setText(model.getValueAt(i, 2).toString());
		        Brand_jtext_satus.setText(model.getValueAt(i, 3).toString());
		  
		        
		        
			}
		       catch(ArrayIndexOutOfBoundsException e) {
		            // Print message when any exception occurs
					JOptionPane.showMessageDialog(null,"Table is empty");  
		        }
		
		}
		});
		//Jtable added to the scrollpane
		Pane3=new JScrollPane(table_brand);
		table_of_brand.add(Pane3);
		
	}
	//SHOWS DATA OF CATEGORY INTO TABLE
	public void show_category() throws ArrayIndexOutOfBoundsException {
		ArrayList<category>list=categorydetail();
		table_category=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[4];
		columnNames[0]="Sn";
		columnNames[1]="Category id";
		columnNames[2]="Category";
		columnNames[3]="Quantity";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getsn();
			row[1]=list.get(i).getCategory_id();
			row[2]=list.get(i).getCategory();
			row[3]=list.get(i).getquantity();
			model.addRow(row);
			}
		table_category.setModel(model);
		table_category.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_category.setFillsViewportHeight(true);
		table_category.setLayout(null);
		table_category.setBounds(200, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows
		
		table_category.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int i = table_category.getSelectedRow();
		        try {
		        TableModel model=table_category.getModel();
		        Category_jtext_id.setText(model.getValueAt(i, 1).toString());
		        Category_jtext_name.setText(model.getValueAt(i, 2).toString());
		        Category_jtext_quantity.setText(model.getValueAt(i, 3).toString());
		        }
		        catch(ArrayIndexOutOfBoundsException e) {
		            // Print message when any exception occurs
					JOptionPane.showMessageDialog(null,"Table is empty");  
		        }
		        
		        
			}
		});
		//Jtable added to the scrollpane/*
		Pane4=new JScrollPane(table_category);
		table_of_category.add(Pane4);
		
	}
	//SHOWS DATA OF VEHICLE INTO TABLE
	public void show_vehicle()throws ArrayIndexOutOfBoundsException {
		ArrayList<vehicle>list=vehicledetail();
		table_vehicle=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[5];
		columnNames[0]="Sn";
		columnNames[1]="Vehicle ID";
		columnNames[2]="Vehicle Name";
		columnNames[3]="Vehicle Status";
		columnNames[4]="Vehicle Driver";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[5];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getsn();
			row[1]=list.get(i).getVehicle_id();
			row[2]=list.get(i).getVehicle_name();
			row[3]=list.get(i).getVehicle_status();
			row[4]=list.get(i).getVehicle_driver();
			
			model.addRow(row);
			}
		table_vehicle.setModel(model);
		table_vehicle.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_vehicle.setFillsViewportHeight(true);
		table_vehicle.setLayout(null);
		table_vehicle.setBounds(200, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows
		
		table_vehicle.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int i = table_vehicle.getSelectedRow();
		        TableModel model=table_vehicle.getModel();
		        try {
		        Vehicle_jtext_no.setText(model.getValueAt(i, 1).toString());
		        Vehicle_jtext_name.setText(model.getValueAt(i, 2).toString());
		        Vehicle_jtext_status.setText(model.getValueAt(i, 3).toString());
		        Vehicle_jtext_Driver.setText(model.getValueAt(i, 4).toString());
		        }
		        catch(ArrayIndexOutOfBoundsException e) {
		            // Print message when any exception occurs
					JOptionPane.showMessageDialog(null,"Table is empty");  
		        }

		        
		        
		        
			}
		});
		//Jtable added to the scrollpane/*
		Pane5=new JScrollPane(table_vehicle);
		table_of_vehicle.add(Pane5);
		
	}
	//SHOWS DATA OF PRODUCT INTO TABLE
	public void show_product() throws ArrayIndexOutOfBoundsException{
		ArrayList<product>list=productdetail();
		table_product=new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnNames= new Object[4];
		columnNames[0]="Sn";
		columnNames[1]="Product id";
		columnNames[2]="Product name";
		columnNames[3]="Product price";
		model.setColumnIdentifiers(columnNames);
	
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getsn();
			row[1]=list.get(i).getProduct_id();
			row[2]=list.get(i).getProduct_name();
			row[3]=list.get(i).getProduct_price();
			model.addRow(row);
			}
		table_product.setModel(model);
		table_product.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_product.setFillsViewportHeight(true);
		table_product.setLayout(null);
		table_product.setBounds(200, 100, 400, 50);
		//displays the data into jtext field and radio buttosn after selection of the rows
		
		table_product.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int i = table_product.getSelectedRow();
		        try {
		        TableModel model=table_product.getModel();
		        Product_jtext_id.setText(model.getValueAt(i, 1).toString());
		        Product_jtext_name.setText(model.getValueAt(i, 2).toString());
		        Product_jtext_price .setText(model.getValueAt(i, 3).toString());
		        }
		        catch(ArrayIndexOutOfBoundsException e) {
		            // Print message when any exception occurs
					JOptionPane.showMessageDialog(null,"Table is empty");  
		        }
		        
		        
			}
		});
		//Jtable added to the scrollpane
		Pane6=new JScrollPane(table_product);
		table_of_product.add(Pane6);
		
	}
	//REFRESHES DATA OF USERS INTO TABLE
	public void update_user() {
		// TODO Auto-generated method stub
		ArrayList<registration>list=userlist();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row=new Object[8];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getUser_name();
			row[2]=list.get(i).getFirst_name();
			row[3]=list.get(i).getLast_name();
			row[4]=list.get(i).getPassword();
			row[5]=list.get(i).getConfirm_password();
			row[6]=list.get(i).getEmail();
			row[7]=list.get(i).getContact();
			model.addRow(row);
			}
	}
	//REFRESHES DATA OF WAREHOUSE INTO TABLE
	public void update_warehouse() {
		// TODO Auto-generated method stub
		ArrayList<warehouse>list=warehousedetail();
		DefaultTableModel model = (DefaultTableModel) table_ware.getModel();
		Object[] row=new Object[7];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getWare_id();
			row[2]=list.get(i).getWare_name();
			row[3]=list.get(i).getLocation();
			row[4]=list.get(i).getContact();
			row[5]=list.get(i).getIncharge();
			row[6]=list.get(i).getTotal_products();
			model.addRow(row);
			}
	}
	//REFRESHES DATA OF BRAND INTO TABLE
	public void update_brand() {
		// TODO Auto-generated method stub
		ArrayList<brand>list=branddetail();
		DefaultTableModel model = (DefaultTableModel) table_brand.getModel();
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getSn();
			row[1]=list.get(i).getBrand_id();
			row[2]=list.get(i).getBrand_name();
			row[3]=list.get(i).getBrand_status();
			model.addRow(row);
			}
	}
	//REFRESHES DATA OF CATEGORY INTO TABLE
	public void update_category() {
		// TODO Auto-generated method stub
		ArrayList<category>list=categorydetail();
		DefaultTableModel model = (DefaultTableModel) table_category.getModel();
		Object[] row=new Object[4];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getsn();
			row[1]=list.get(i).getCategory_id();
			row[2]=list.get(i).getCategory();
			row[3]=list.get(i).getquantity();
			model.addRow(row);
			}
	}
	//REFRESHES DATA OF VEHICLE INTO TABLE
	public void update_vehicle() {
		// TODO Auto-generated method stub
		ArrayList<vehicle>list=vehicledetail();
		DefaultTableModel model = (DefaultTableModel) table_vehicle.getModel();
		Object[] row=new Object[5];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getsn();
			row[1]=list.get(i).getVehicle_id();
			row[2]=list.get(i).getVehicle_name();
			row[3]=list.get(i).getVehicle_status();
			row[4]=list.get(i).getVehicle_driver();
			
			model.addRow(row);
			}
	}
	//REFRESHES DATA OF PRODUCT INTO TABLE
	public void update_product() {
		// TODO Auto-generated method stub
		ArrayList<product>list=productdetail();
		DefaultTableModel model = (DefaultTableModel) table_product.getModel();
		Object[] row=new Object[5];
		

		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getsn();
			row[1]=list.get(i).getProduct_id();
			row[2]=list.get(i).getProduct_name();
			row[3]=list.get(i).getProduct_price();
			model.addRow(row);
			}
	}
	//RESETS USER
	public void reset_user() {
		user_jtext_field_username.setText("");
		user_jtext_field_firstname.setText("");
		user_jtext_field_lastname.setText("");
		user_jtext_field_password.setText("");
		user_jtext_field_confirm_password.setText("");
		user_jtext_field_email.setText("");
		user_jtext_field_contact.setText("");
	}
	//RESETS WAREHOUSE
	public void reset_warehouse() {
		warehouse_jtext_field_ware_no.setText("");
		warehouse_jtext_field_name.setText("");
		warehouse_jtext_field_address.setText("");
		warehouse_jtext_field_contact.setText("");
		warehouse_jtext_field_incharge.setText("");
		warehouse_jtext_field_totalproduct.setText("");
	}
	//RESETS BRAND
	public void reset_brand() {
		Brand_jtext_id.setText("");
		Brand_jtext_name.setText("");
		Brand_jtext_satus.setText("");
	}
	//RESETS BRAND
	public void reset_category() {
		Category_jtext_id.setText("");
		Category_jtext_name.setText("");
		Category_jtext_quantity.setText("");
	}
	//RESETS VEHICLE
	public void reset_vehicle() {
		Vehicle_jtext_no.setText("");
		Vehicle_jtext_name.setText("");
		Vehicle_jtext_status.setText("");
		Vehicle_jtext_Driver.setText("");
	}
	//RESETS VEHICLE
	public void reset_product() {
		Product_jtext_id.setText("");
		Product_jtext_name.setText("");
		Product_jtext_price.setText("");
	}
	//MAKES THE BUTTONS FUNCTIONAL
	@Override
	public void actionPerformed(ActionEvent e) {
		//ADD BUTTON OF USERS
		 if(e.getSource()==user_button_add) {
				try {
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					PreparedStatement myState= myConn.prepareStatement("insert into registration"+"(user_name,first_name,last_name,password,confirm_password,Email,contact)"+"values(?,?,?,?,?,?,?)");
					Statement stmt = myConn.createStatement();
					stmt.execute("Set @autoid:=0");
					Statement stmt2 = myConn.createStatement();
					stmt.execute("Update registration set sn=@autoid:=(@autoid+1)");
					Statement stmt3 = myConn.createStatement();
					stmt.execute("alter table registration Auto_increment=1");
					
					myState.setString(1, user_jtext_field_username.getText() );
					myState.setString(2, user_jtext_field_firstname.getText());
					myState.setString(3, user_jtext_field_lastname.getText());
					myState.setString(4, user_jtext_field_password.getText());
					myState.setString(5, user_jtext_field_confirm_password.getText());
					myState.setString(6, user_jtext_field_email.getText());
					myState.setString(7, user_jtext_field_contact.getText());
					
					myState.executeUpdate();
					JOptionPane.showMessageDialog(null,"Inserted successfully");  
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//resets the row to 0
					model.setRowCount(0);
					//empties the jtex feild and unselects the radio buttons
					reset_user();
					//refreshes the jtable
					update_user();
					
					
					

				}catch (SQLIntegrityConstraintViolationException b) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Your Username or Email has already been taken.");
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		 //UPDATE BUTTON OF USER
			 else if(e.getSource()==user_button_update) {
				 try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
						int row = table.getSelectedRow();
						String value=(table.getModel().getValueAt(row, 0).toString());
						if (user_jtext_field_password.getText().equals(user_jtext_field_confirm_password.getText())) {
							String query="UPDATE registration SET user_name=?,first_name=?,last_name=?,password=?,confirm_password=?,Email=?,contact=? where sn="+value;
							PreparedStatement myState= myConn.prepareStatement(query);
							myState.setString(1, user_jtext_field_username.getText() );
							myState.setString(2, user_jtext_field_firstname.getText());
							myState.setString(3, user_jtext_field_lastname.getText());
							myState.setString(4, user_jtext_field_password.getText());
							myState.setString(5, user_jtext_field_confirm_password.getText());
							myState.setString(6, user_jtext_field_email.getText());
							myState.setString(7, user_jtext_field_contact.getText());
							
							myState.executeUpdate();
							
							JOptionPane.showMessageDialog(null,"Updated successfully");
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							//resets the row to 0
							model.setRowCount(0);
							//empties the jtex feild and unselects the radio buttons
							reset_user();
							//refreshes the jtable
							update_user();
						}
						else {
							JOptionPane.showMessageDialog(null,"passwords are not same");
						}
						//PreparedStatement myState= myConn.prepareStatement(query);
						//3.Execute sql query
			

		  
						
				 }
				 catch (java.lang.ArrayIndexOutOfBoundsException exc) {
					 JOptionPane.showMessageDialog(null,"Select a row first"); 
				 }
				 catch (Exception exc) {
						exc.printStackTrace();
					}
			 }
			 //delete BUTTON OF USER
			 else if(e.getSource()==user_button_delete) {
				 try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
						int row = table.getSelectedRow();
						String value=(table.getModel().getValueAt(row, 0).toString());
						Statement stmt = myConn.createStatement();
						stmt.execute("DELETE FROM registration WHERE sn="+value);
						JOptionPane.showMessageDialog(null,"Deleted successfully");  
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						//resets the row to 0
						model.setRowCount(0);
						//empties the jtex feild and unselects the radio buttons
						reset_user();
						//refreshes the jtable
						update_user();
				 
				 }
				 catch (java.lang.ArrayIndexOutOfBoundsException exc) {
					 JOptionPane.showMessageDialog(null,"Select a row first"); 
				 }
				 catch (Exception exc) {
						exc.printStackTrace();
				 }
			 }
		
			 //refreshes THE TABLE
			 else if (e.getSource()==user_button_refresh) {
				 try {
					 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					 Statement stmt = myConn.createStatement();
					stmt.execute("Set @autoid:=0");
					Statement stmt2 = myConn.createStatement();
					stmt.execute("Update registration set sn=@autoid:=(@autoid+1)");
					Statement stmt3 = myConn.createStatement();
					stmt.execute("alter table registration Auto_increment=1");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//resets the row to 0
					model.setRowCount(0);
					//empties the jtex feild and unselects the radio buttons
					reset_user();
					//refreshes the jtable
					update_user();
					
				 }
			catch (Exception exc) {
				exc.printStackTrace();
				 }
			 }
		 //add button of ware house
		else if(e.getSource()==warehouse_button_add) {
				try {
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					PreparedStatement myState= myConn.prepareStatement("insert into warehouse"+"(ware_id,ware_name,location,contact,incharge,total_products)"+"values(?,?,?,?,?,?)");
					Statement stmt = myConn.createStatement();
					stmt.execute("Set @autoid:=0");
					Statement stmt2 = myConn.createStatement();
					stmt.execute("Update registration set sn=@autoid:=(@autoid+1)");
					Statement stmt3 = myConn.createStatement();
					stmt.execute("alter table registration Auto_increment=1");
					
					myState.setString(1, warehouse_jtext_field_ware_no.getText());
					myState.setString(2, warehouse_jtext_field_name.getText());
					myState.setString(3, warehouse_jtext_field_address.getText());
					myState.setString(4, warehouse_jtext_field_contact.getText());
					myState.setString(5, warehouse_jtext_field_incharge.getText());
					myState.setString(6, warehouse_jtext_field_totalproduct.getText());
					
					myState.executeUpdate();
					JOptionPane.showMessageDialog(null,"Inserted successfully");  
					DefaultTableModel model = (DefaultTableModel) table_ware.getModel();
					//resets the row to 0
					model.setRowCount(0);
					//empties the jtex feild and unselects the radio buttons
					//reset_user();
					//refreshes the jtable
					reset_warehouse();
					update_warehouse();
					
					
					

				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		 //refresh button of ware house
		else if (e.getSource()==warehouse_button_refresh) {
			try {
				 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				 Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update warehouse set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table warehouse Auto_increment=1");
				DefaultTableModel model = (DefaultTableModel) table_ware.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_warehouse();
				//refreshes the jtable
				update_warehouse();
				
			 }
		catch (Exception exc) {
			exc.printStackTrace();
			 }
		 }
		 //update button of ware house
		else if (e.getSource()==warehouse_button_update) {
			 try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
					int row = table_ware.getSelectedRow();
					String value=(table_ware.getModel().getValueAt(row, 0).toString());
					String query="UPDATE warehouse SET ware_id=?,ware_name=?,location=?,contact=?,incharge=?,total_products=? where sn="+value;
					PreparedStatement myState= myConn.prepareStatement(query);
					//3.Execute sql query
					myState.setInt(1, Integer.parseInt(warehouse_jtext_field_ware_no.getText()));
					myState.setString(2, warehouse_jtext_field_name.getText());
					myState.setString(3, warehouse_jtext_field_address.getText());
					myState.setString(4, warehouse_jtext_field_contact.getText());
					myState.setString(5, warehouse_jtext_field_incharge.getText());
					myState.setInt(6,Integer.parseInt (warehouse_jtext_field_totalproduct.getText()));
					myState.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Updated successfully");
					DefaultTableModel model = (DefaultTableModel) table_ware.getModel();
					//resets the row to 0
					model.setRowCount(0);
					//empties the jtex feild and unselects the radio buttons
					reset_warehouse();
					//refreshes the jtable
					update_warehouse();
					
			 }
			 catch (Exception exc) {
					exc.printStackTrace();
				}
			
		}
		 //delete button of ware house
		else if (e.getSource()==warehouse_button_delete) { 
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_ware.getSelectedRow();
				String value=(table_ware.getModel().getValueAt(row, 0).toString());
				Statement stmt = myConn.createStatement();
				stmt.execute("DELETE FROM warehouse WHERE sn="+value);
				JOptionPane.showMessageDialog(null,"Deleted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_ware.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_warehouse();
				//refreshes the jtable
				update_warehouse();
		 
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
		 }
			
		}
		 //add button of brand
		else if (e.getSource()==brand_button_add) {
			try {
				
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				PreparedStatement myState= myConn.prepareStatement("insert into brand"+"(brand_id,brand_name,brand_status)"+"values(?,?,?)");
				Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update brand set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table brand Auto_increment=1");
				
				myState.setString(1, Brand_jtext_id.getText());
				myState.setString(2, Brand_jtext_name.getText());
				myState.setString(3, Brand_jtext_satus.getText());
				
				
				myState.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_brand.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				//reset_user();
				//refreshes the jtable
				reset_brand();
				update_brand();
				
				
				

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		 //refresh button of brand
		else if (e.getSource()==brand_button_refresh) {
			try {
				 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				 Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update brand set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table brand Auto_increment=1");
				DefaultTableModel model = (DefaultTableModel) table_brand.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_brand();
				//refreshes the jtable
				update_brand();
				
			 }
		catch (Exception exc) {
			exc.printStackTrace();
			 }
			
		}
		//update button of brand
		else if (e.getSource()==brand_button_update) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_brand.getSelectedRow();
				String value=(table_brand.getModel().getValueAt(row, 0).toString());
				String query="UPDATE brand SET brand_id=?,brand_name=?,brand_status=? where sn="+value;
				PreparedStatement myState= myConn.prepareStatement(query);
				//3.Execute sql query
				myState.setString(1, Brand_jtext_id.getText());
				myState.setString(2, Brand_jtext_name.getText());
				myState.setString(3, Brand_jtext_satus.getText());
				
				myState.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Updated successfully");
				DefaultTableModel model = (DefaultTableModel) table_brand.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_brand();
				//refreshes the jtable
				update_brand();
				
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
			}
		
			
		}
		 //delete button of brand
		else if (e.getSource()==brand_button_delete) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_brand.getSelectedRow();
				String value=(table_brand.getModel().getValueAt(row, 0).toString());
				Statement stmt = myConn.createStatement();
				stmt.execute("DELETE FROM brand WHERE sn="+value);
				JOptionPane.showMessageDialog(null,"Deleted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_brand.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_brand();
				//refreshes the jtable
				update_brand();
		 
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
		 }
			
		}
		 //add button of category
		else if(e.getSource()==category_button_add) {
			try {
				
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				PreparedStatement myState= myConn.prepareStatement("insert into category"+"(category_id,category,quantity)"+"values(?,?,?)");
				Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update category set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table category Auto_increment=1");
				
				myState.setString(1, Category_jtext_id.getText());
				myState.setString(2, Category_jtext_name.getText());
				myState.setString(3, Category_jtext_quantity.getText());
				myState.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_category.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				//reset_user();
				//refreshes the jtable
				reset_category();
				update_category();
				
				
				

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		 //refresh button of category
		else if (e.getSource()==category_button_refresh) {
			try {
				 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				 Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update category set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table category Auto_increment=1");
				DefaultTableModel model = (DefaultTableModel) table_category.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_category();
				//refreshes the jtable
				update_category();
				
			 }
			catch (Exception exc) {
				exc.printStackTrace();
			}
		 
		 
		}
		 //update button of category
		else if (e.getSource()==category_button_update) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_category.getSelectedRow();
				String value=(table_category.getModel().getValueAt(row, 0).toString());
				String query="UPDATE category SET category_id=?,category=?,quantity=? where sn="+value;
				PreparedStatement myState= myConn.prepareStatement(query);
				//3.Execute sql query
				myState.setString(1,Category_jtext_id.getText());
				myState.setString(2, Category_jtext_name.getText());
				myState.setString(3, Category_jtext_quantity.getText());
				
				myState.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Updated successfully");
				DefaultTableModel model = (DefaultTableModel) table_category.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_category();
				//refreshes the jtable
				update_category();
				
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
			}
		
			
		}
		 //delete button of category
		else if (e.getSource()==category_button_delete) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_category.getSelectedRow();
				String value=(table_category.getModel().getValueAt(row, 0).toString());
				Statement stmt = myConn.createStatement();
				stmt.execute("DELETE FROM category WHERE sn="+value);
				JOptionPane.showMessageDialog(null,"Deleted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_category.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_category();
				//refreshes the jtable
				update_category();
		 
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
		 }
	}
		 //add button of vehicle
		else if (e.getSource()==vehicle_button_add) {
			try {
				
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				PreparedStatement myState= myConn.prepareStatement("insert into vehicle"+"(vehicle_id,vehicle_name,vehicle_status,vehicle_driver)"+"values(?,?,?,?)");
				Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update vehicle set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table vehicle Auto_increment=1");
				
				myState.setString(1, Vehicle_jtext_no.getText());
				myState.setString(2,Vehicle_jtext_name.getText());
				myState.setString(3, Vehicle_jtext_status.getText());
				myState.setString(4, Vehicle_jtext_Driver.getText());
				myState.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_vehicle.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				//reset_user();
				//refreshes the jtable
				reset_vehicle();
				update_vehicle();
				
				
				

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		 //refresh button of vehicle
		else if (e.getSource()==vehicle_button_refresh) {
			try {
				 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				 Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update vehicle set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table vehicle Auto_increment=1");
				DefaultTableModel model = (DefaultTableModel) table_vehicle.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_vehicle();
				//refreshes the jtable
				update_vehicle();
				
			 }
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		 //update button of vehicle
		else if (e.getSource()==vehicle_button_update) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_vehicle.getSelectedRow();
				String value=(table_vehicle.getModel().getValueAt(row, 0).toString());
				String query="UPDATE vehicle SET vehicle_id=?,vehicle_name=?,vehicle_status=?,vehicle_driver=? where sn="+value;
				PreparedStatement myState= myConn.prepareStatement(query);
				//3.Execute sql query
				myState.setString(1,Vehicle_jtext_no.getText());
				myState.setString(2, Vehicle_jtext_name.getText());
				myState.setString(3,Vehicle_jtext_status.getText());
				myState.setString(4,Vehicle_jtext_Driver.getText());
				
				myState.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Updated successfully");
				DefaultTableModel model = (DefaultTableModel) table_vehicle.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_vehicle();
				//refreshes the jtable
				update_vehicle();
				
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		 //delete button of vehicle
		else if (e.getSource()==vehicle_button_delete) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_vehicle.getSelectedRow();
				String value=(table_vehicle.getModel().getValueAt(row, 0).toString());
				Statement stmt = myConn.createStatement();
				stmt.execute("DELETE FROM vehicle WHERE sn="+value);
				JOptionPane.showMessageDialog(null,"Deleted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_vehicle.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_vehicle();
				//refreshes the jtable
				update_vehicle();
		 
		 }
			 catch (Exception exc) {
					exc.printStackTrace();
				}
			
		}
		 //add button of product
		else if (e.getSource()==product_button_add) {
			try {
				
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				PreparedStatement myState= myConn.prepareStatement("insert into product"+"(product_id,product_name,product_price)"+"values(?,?,?)");
				Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update product set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table product Auto_increment=1");
				
				myState.setString(1, Product_jtext_id.getText());
				myState.setString(2, Product_jtext_name.getText());
				myState.setString(3, Product_jtext_price.getText());
				
				
				myState.executeUpdate();
				JOptionPane.showMessageDialog(null,"Inserted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_product.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				//reset_user();
				//refreshes the jtable
				reset_product();
				update_product();
				
				
				

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		 //refresh button of product 
		else if (e.getSource()==product_button_refresh) {
			try {
				 Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				 Statement stmt = myConn.createStatement();
				stmt.execute("Set @autoid:=0");
				Statement stmt2 = myConn.createStatement();
				stmt.execute("Update product set sn=@autoid:=(@autoid+1)");
				Statement stmt3 = myConn.createStatement();
				stmt.execute("alter table product Auto_increment=1");
				DefaultTableModel model = (DefaultTableModel) table_product.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_product();
				//refreshes the jtable
				update_product();
				
			 }
		catch (Exception exc) {
			exc.printStackTrace();
			 }
			
		}
		 //update button of product
		else if (e.getSource()==product_button_update) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_product.getSelectedRow();
				String value=(table_product.getModel().getValueAt(row, 0).toString());
				String query="UPDATE product SET product_id=?,product_name=?,product_price=? where sn="+value;
				PreparedStatement myState= myConn.prepareStatement(query);
				//3.Execute sql query
				myState.setString(1, Product_jtext_id.getText());
				myState.setString(2, Product_jtext_name.getText());
				myState.setString(3, Product_jtext_price.getText());
				
				myState.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Updated successfully");
				DefaultTableModel model = (DefaultTableModel) table_product.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_product();
				//refreshes the jtable
				update_product();
				
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
			}
		
			
		}//delete button of product
		else if (e.getSource()==product_button_delete) {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","123456abc");
				int row = table_product.getSelectedRow();
				String value=(table_product.getModel().getValueAt(row, 0).toString());
				Statement stmt = myConn.createStatement();
				stmt.execute("DELETE FROM product WHERE sn="+value);
				JOptionPane.showMessageDialog(null,"Deleted successfully");  
				DefaultTableModel model = (DefaultTableModel) table_product.getModel();
				//resets the row to 0
				model.setRowCount(0);
				//empties the jtex feild and unselects the radio buttons
				reset_product();
				//refreshes the jtable
				update_product();
		 
		 }
		 catch (Exception exc) {
				exc.printStackTrace();
		 }
			
		}
		 
	}
		
	//SEARCH FUNCTIONALIT
	public void search_user(String str) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	public void search_ware(String str) {
		DefaultTableModel model=(DefaultTableModel) table_ware.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_ware.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	public void search_brand(String str) {
		DefaultTableModel model=(DefaultTableModel) table_brand.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_brand.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	public void search_category(String str) {
		DefaultTableModel model=(DefaultTableModel) table_category.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_category.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	public void search_vehicle(String str) {
		DefaultTableModel model=(DefaultTableModel) table_vehicle.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_vehicle.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	public void search_product(String str) {
		DefaultTableModel model=(DefaultTableModel) table_product.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_product.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	@Override
	//swithces panel 
	public void mouseClicked(MouseEvent e) {
		
		//System.out.println("its working" );
		//b_Stores.setBackground(Color.BLACK);
		if(e.getSource()==b_Users) {
			//p1.setVisible(true);
			jp.removeAll();
			jp.add(panel_Users);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Warehouse) {
			jp.removeAll();
			jp.add(panel_Warehouse);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Brands) {
			jp.removeAll();
			jp.add(panel_Brands);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Category) {
			//p1.setVisible(true);
			jp.removeAll();
			jp.add(panel_Category);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Stores) {
			jp.removeAll();
			jp.add(panel_Stores);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Vehicles) {
			jp.removeAll();
			jp.add(panel_Vehicles);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Products) {
			jp.removeAll();
			jp.add(panel_Products);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_Feedback) {
			jp.removeAll();
			jp.add(panel_Feedback);
			jp.repaint();
			jp.revalidate();
		}
		if(e.getSource()==b_logout) {
			f.dispose();
			Login_page l=new Login_page();
		}
		
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

