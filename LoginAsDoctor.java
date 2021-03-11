import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginAsDoctor extends Frame implements ActionListener{
	private TextField id,pass;
	private Button b,b2;
	private Label l,l2;
	private Frame parent;
	public static DoctorHome doctorHome;
	public LoginAsDoctor(){
		super("Doctor Login Window");
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
		String i=id.getText();
		String p=pass.getText();
		String sql="select * from doctor where D_Id='"+i+"' and Password='"+p+"'";
		System.out.println(sql);
		try{
			DataAccessDoctor da2=new DataAccessDoctor();
			ResultSet rs=da2.getData(sql);
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
				Navigate.doctorHome.setVisible(true);
				Navigate.doctorHome.setParent(this);
				//Navigate.doctorHome.loadData();
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