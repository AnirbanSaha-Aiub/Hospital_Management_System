import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginAsReceiptionist extends Frame implements ActionListener{
	private TextField id,pass;
	private Button b,b2;
	private Label l,l2;
	private Frame parent;
	public LoginAsReceiptionist(){
		super("Receiptionist Login Window");
		l=new Label("ID: ");
		l2=new Label("Password: ");
		id=new TextField(10);
		pass=new TextField(10);
		pass.setEchoChar('*');
		b=new Button("Login");
		b2=new Button("Back");
		add(l);add(id);
		add(l2);add(pass);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setLocation(700,250);
		setSize(500,500);
	}
	public void setParent(Frame f){
		parent=f;
	}
	private boolean checkAuth(){
		boolean flag=false;
		String n=id.getText();
		String p=pass.getText();
		String sql="select * from receptionist where R_Id='"+n+"' and Password='"+p+"'";
		System.out.println(sql);
		try{
			DataAccessReceiptionist da=new DataAccessReceiptionist();
			ResultSet rs=da.getData(sql);
			while(rs.next()){
					flag=true;
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred");
		}
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Login")){
			if(checkAuth()){
				System.out.println("Success");
				Navigate.receiptionistHome.setVisible(true);
				Navigate.receiptionistHome.setParent(this);
				//Navigate.home.loadData();
				this.setVisible(false);
			}
			else{
				System.out.println("Incorrect");
			}
		}
		else if(sig.equals("Back")){
			parent.setVisible(true);
			this.setVisible(false);
		}
	}
}