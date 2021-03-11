import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AccountantHome extends Frame implements ActionListener{
	private Button viewPatientButton;
	private Button logoutButton,exitButton;

	private Frame parent;
	

	public AccountantHome(){
		super("Accountant Home");
		viewPatientButton=new Button("View Patient");
		logoutButton=new Button("Logout");
		exitButton=new Button("Exit");
		add(viewPatientButton);add(logoutButton);add(exitButton);
		
		viewPatientButton.addActionListener(this);
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
		if(sig.equals("View Patient")){
			this.setVisible(false);
			//receiptionistHome.viewPatient.setVisible(true);
			//s1.setParent(this);
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