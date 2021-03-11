import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginAsAdmin extends Frame implements ActionListener{
	private TextField id,pass;
	private Button b,b2;
	private Label l,l2;
	private Frame parent;
	public LoginAsAdmin(){
		super("Admin Login Window");
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
		
		/*l.setBounds(80,60,50,30);
		id.setBounds(150,60,200,30);
		
		l2.setBounds(80,100,50,30);
		pass.setBounds(150,100,200,30);
		
		b.setBounds(125,185,80,30);
		b.setBounds(125,185,80,30);
		b2.setBounds(230,185,90,30);*/
		
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
		String sql="select * from admin where A_Id='"+n+"' and Password='"+p+"'";
		System.out.println(sql);
		try{
			DataAccessAdmin daa=new DataAccessAdmin();
			ResultSet rs=daa.getData(sql);
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
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Login")){
			if(checkAuth()){
				System.out.println("Success");
				Navigate.adminHome.setVisible(true);
				Navigate.adminHome.setParent(this);
				//Navigate.adminHome.loadData();
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