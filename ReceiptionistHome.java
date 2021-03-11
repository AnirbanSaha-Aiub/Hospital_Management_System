import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ReceiptionistHome extends Frame implements ActionListener{
	
	private Button addPatientButton,viewPatientButton,deletePatientButton, updatePatientButton;
	private Button logoutButton,exitButton;
	public static AddPatient addPatient;
	//public static ViewPatient viewPatient;
	public static DeletePatient deletePatient;
	public static UpdatePatient updatePatient;

	private Frame parent;
	
	
	public ReceiptionistHome(){
		super("Receiptionist Home");
		
		addPatient=new AddPatient();
		//viewPatient=new ViewPatient();
		deletePatient=new DeletePatient();
		updatePatient=new UpdatePatient();
		
		addPatientButton=new Button("Add Patient");
		viewPatientButton=new Button("View Patient");
		deletePatientButton=new Button("Delete Patient");
		updatePatientButton=new Button("Update Patient");
		logoutButton=new Button("Logout");
		exitButton=new Button("Exit");
		add(addPatientButton);add(viewPatientButton);
		add(deletePatientButton);add(updatePatientButton);
		add(logoutButton);add(exitButton);
		
		addPatientButton.addActionListener(this);
		viewPatientButton.addActionListener(this);
		deletePatientButton.addActionListener(this);
		updatePatientButton.addActionListener(this);
		
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
		if(sig.equals("Add Patient")){
			this.setVisible(false);
			addPatient.setVisible(true);
			//addPatient.setParent(this);
		}
		else if(sig.equals("View Patient")){
			this.setVisible(false);
			//viewPatientButton.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Delete Patient")){
			this.setVisible(false);
			deletePatient.setVisible(true);
			//s2.setParent(this);
		}
		else if(sig.equals("Update Patient")){
			this.setVisible(false);
			updatePatient.setVisible(true);
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