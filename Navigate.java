import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Navigate extends JFrame implements ActionListener{
	
	private Button loginAsAdminButton,loginAsDoctorButton,loginAsReceiptionistButton,loginAsAccountantButton;
	
	public static LoginAsAdmin log1;
	public static LoginAsDoctor log2;
	public static LoginAsReceiptionist log3;
	public static LoginAsAccountant log4;
	
	public static AdminHome adminHome;
	public static DoctorHome doctorHome;
	public static ReceiptionistHome receiptionistHome;
	public static AccountantHome accountantHome;
	
	public Navigate(){
		super("Login As");
		log1=new LoginAsAdmin();
		log2=new LoginAsDoctor();
		log3=new LoginAsReceiptionist();
		log4=new LoginAsAccountant();
		
		
		adminHome=new AdminHome();
		doctorHome=new DoctorHome();
		receiptionistHome=new ReceiptionistHome();
		accountantHome=new AccountantHome();
		
		loginAsAdminButton=new Button("Admin");
		loginAsDoctorButton=new Button("Doctor");
		loginAsReceiptionistButton=new Button("Receiptionist");
		loginAsAccountantButton=new Button("Accountant");
		
		add(loginAsAdminButton);add(loginAsDoctorButton);
		add(loginAsReceiptionistButton);add(loginAsAccountantButton);
		
		loginAsAdminButton.addActionListener(this);
		loginAsDoctorButton.addActionListener(this);
		loginAsReceiptionistButton.addActionListener(this);
		loginAsAccountantButton.addActionListener(this);
		
		//loginAsAdminButton.setBounds			(100,100,100,50);
		//loginAsDoctorButton.setBounds			(300,100,100,50);
		//loginAsAccountantButton.setBounds		(100,200,100,50);
		//loginAsReceiptionistButton.setBounds	(300,200,100,50);

		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(700,250);
		setSize(500,500);
	}
	
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Admin")){
			this.setVisible(false);
			log1.setVisible(true);
			log1.setParent(this);
		}
		else if(sig.equals("Doctor")){
			this.setVisible(false);
			log2.setVisible(true);
			log2.setParent(this);
		}
		else if(sig.equals("Receiptionist")){
			this.setVisible(false);
			log3.setVisible(true);
			log3.setParent(this);
		}
		else if(sig.equals("Accountant")){
			this.setVisible(false);
			log4.setVisible(true);
			log4.setParent(this);
		}
		else if(sig.equals("Cancel")){
			System.exit(0);
		}
	}
}