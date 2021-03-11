import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminHome extends Frame implements ActionListener{
	private Button addDoctorButton,addReceiptionistButton,addAccountantButton,deleteDoctorButton,deleteReceiptionistButton,deleteAccountantButton,updateDoctorButton,updateReceiptionistButton,updateAccountantButton;
	private Button logoutButton,exitButton;
	
	public static AddDoctor addDoctor;
	public static AddAccountant addAccountant;
	public static AddReceiptionist addReceiptionist;
	
	public static UpdateDoctor updateDoctor;
	public static UpdateAccountant updateAccountant;
	public static UpdateReceiptionist updateReceiptionist;
	
	public static DeleteDoctor deleteDoctor;
	public static DeleteAccountant deleteAccountant;
	public static DeleteReceiptionist deleteReceiptionist;
	
	private Frame parent;
	
	
	public AdminHome(){
		super("Admin Home");
		
		addDoctor=new AddDoctor();
		addReceiptionist=new AddReceiptionist();
		addAccountant=new AddAccountant();
		
		updateDoctor=new UpdateDoctor();
		updateAccountant=new UpdateAccountant();
		updateReceiptionist=new UpdateReceiptionist();
		
		deleteDoctor=new DeleteDoctor();
		deleteAccountant=new DeleteAccountant();
		deleteReceiptionist=new DeleteReceiptionist();
		
		addDoctorButton=new Button("Add Doctor");
		addReceiptionistButton=new Button("Add Receiptionist");
		addAccountantButton=new Button("Add Accountant");
		
		deleteDoctorButton=new Button("Delete Doctor");
		deleteReceiptionistButton=new Button("Delete Receiptionist");
		deleteAccountantButton=new Button("Delete Accountant");
		
		updateDoctorButton=new Button("Update Doctor");
		updateReceiptionistButton=new Button("Update Receiptionist");
		updateAccountantButton=new Button("Update Accountant");
		
		logoutButton=new Button("Logout");
		exitButton=new Button("Exit");
		
		add(addDoctorButton);add(addReceiptionistButton); add(addAccountantButton);
		add(deleteDoctorButton);add(deleteReceiptionistButton);add(deleteAccountantButton);
		add(updateDoctorButton);add(updateReceiptionistButton);add(updateAccountantButton);
		
		addDoctorButton.addActionListener(this);
		addReceiptionistButton.addActionListener(this);
		addAccountantButton.addActionListener(this);
		
		deleteDoctorButton.addActionListener(this);
		deleteReceiptionistButton.addActionListener(this);
		deleteAccountantButton.addActionListener(this);
		
		updateDoctorButton.addActionListener(this);
		updateReceiptionistButton.addActionListener(this);
		updateAccountantButton.addActionListener(this);
		
		add(logoutButton);add(exitButton);
		logoutButton.addActionListener(this);
		
		exitButton.addActionListener(this);
		
		setLayout(new FlowLayout());
		setLocation(700,250);
		setSize(500,500);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Add Doctor")){
			this.setVisible(false);
			addDoctor.setVisible(true);
			//addDoctor.setParent(this);
		}
		else if(sig.equals("Add Receiptionist")){
			this.setVisible(false);
			addReceiptionist.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Add Accountant")){
			this.setVisible(false);
			addAccountant.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Delete Doctor")){
			this.setVisible(false);
			deleteDoctor.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Delete Receiptionist")){
			this.setVisible(false);
			deleteReceiptionist.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Delete Accountant")){
			this.setVisible(false);
			deleteAccountant.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Update Doctor")){
			this.setVisible(false);
			updateDoctor.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Update Receiptionist")){
			this.setVisible(false);
			updateReceiptionist.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Update Accountant")){
			this.setVisible(false);
			updateAccountant.setVisible(true);
			//s2.setParent(this);
		}
		else if(e.getSource()==logoutButton){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(e.getSource()==exitButton){
			System.exit(0);
		}
	}
}