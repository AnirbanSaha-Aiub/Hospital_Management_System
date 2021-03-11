import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateDoctor extends Frame implements ActionListener{
	private TextField id,name,phn,qualification,password;
	private Button confirmButton,cancelButton,showButton;
	private Label l,l2,l3,l4,l5,msg;
	private Frame parent;
	
	public UpdateDoctor(){
		super("Update Doctor Window");
		
		l=new Label("ID: ");
		id=new TextField(15);
		l2=new Label("Name: ");
		name=new TextField(15);
		l3=new Label("Phone No: ");
		phn=new TextField(15);
		l4=new Label("Qualification: ");
		qualification=new TextField(15);
		l5=new Label("Password: ");
		password=new TextField(15);
		
		showButton=new Button("Show");
		confirmButton=new Button("Confirm");
		cancelButton=new Button("Back");
		msg=new Label("msg box");
		
		add(l);add(id);
		add(l2);add(name);
		add(l3);add(phn);
		add(l4);add(qualification);
		add(l5);add(password);
		
		add(showButton);add(confirmButton);add(cancelButton);
		add(msg);
		
		l.setBounds(10,60,50,30);
		id.setBounds(125,60,200,30);
		
		l2.setBounds(10,95,100,30);
		name.setBounds(125,95,200,30);
		
		l3.setBounds(10,130,90,30);
		phn.setBounds(125,130,200,30);
		
		l4.setBounds(10,165,90,30);
		qualification.setBounds(125,165,200,30);
		
		l5.setBounds(10,200,90,30);
		password.setBounds(125,200,200,30);
		
		showButton.setBounds(10,235,100,30);
		confirmButton.setBounds(115,235,100,30);
		cancelButton.setBounds(220,235,100,30);
		
		msg.setBounds(115,270,200,30);
		
		showButton.addActionListener(this);
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		setLayout(null);
		setLocation(700,250);
		setSize(500,500);
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		//System.out.println(s.getText()+":"+flag);
		return flag;
	}
	public void loadData(){
		String sql="select D_Name from Doctor where D_Id='"+id.getText()+"'";
		System.out.println(sql);
		try{
			DataAccessDoctor da2=new DataAccessDoctor();
			ResultSet rs=da2.getData(sql);
			String data="";
			while(rs.next()){
				//data=data+rs.getString("loc_id")+"-";
				data=data+rs.getString("D_Name")+"\n";
			}
			name.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in Home");
		}
	}
	public void setParent(Frame p){
		parent=p;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Confirm")){
			String m="";
			String sql="update Doctor set D_Name='"+name.getText()+"',Qualification='"+qualification.getText()+"',PhoneNo='"+phn.getText()+"',Password='"+password.getText()+"' where D_Id='"+id.getText()+"'";
			System.out.println(sql);
			DataAccessDoctor da2=new DataAccessDoctor();
			if(isEmpty(name)){
				m="All fields are mandatory";
			}
			else{
				if(da2.updateDB(sql)>0){
					m="Data Updated";
				}
				else{
					m="Update Error!";
				}
			}
			JOptionPane.showMessageDialog(this,m);
		}
		else if(sig.equals("Back")){
			//parent.setVisible(true);
			Navigate.adminHome.setVisible(true);
			this.setVisible(false);
		}
		else if(sig.equals("Show")){
			//parent.setVisible(true);
			//this.setVisible(false);
			loadData();
		}
	}
}