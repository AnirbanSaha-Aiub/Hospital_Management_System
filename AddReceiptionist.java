import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddReceiptionist extends Frame implements ActionListener{
	private TextField id,name,phn,password;
	private Button createButton,backButton;
	private Label l,l2,l3,l4,msg;
	public AddReceiptionist(){
		super("Add Receiptionist");
		l=new Label("ID: ");
		id=new TextField(15);
		l2=new Label("Name: ");
		name=new TextField(15);
		l3=new Label("Phone No: ");
		phn=new TextField(15);
		l4=new Label("Password: ");
		password=new TextField(15);
		
		createButton=new Button("Create");
		backButton=new Button("Back");
		msg=new Label("msg box");
		
		add(l);add(id);
		add(l2);add(name);
		add(l3);add(phn);
		add(l4);add(password);
		add(createButton);add(backButton);
		add(msg);
		
		l.setBounds(10,60,50,30);
		id.setBounds(125,60,200,30);
		
		l2.setBounds(10,95,100,30);
		name.setBounds(125,95,200,30);
		
		l3.setBounds(10,130,90,30);
		phn.setBounds(125,130,200,30);
		
		l4.setBounds(10,165,90,30);
		password.setBounds(125,165,200,30);
				
		createButton.setBounds(125,200,100,30);
		backButton.setBounds(230,200,100,30);
		
		msg.setBounds(215,270,200,30);
		
		createButton.addActionListener(this);
		backButton.addActionListener(this);
		
		setLocation(700,250);
		setSize(500,500);
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		System.out.println(s.getText()+":"+flag);
		return flag;
	}
	
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		
		if(sig.equals("Create")){
			if(isEmpty(id) || isEmpty(name) || isEmpty(phn) || isEmpty(password)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				DataAccessReceiptionist da=new DataAccessReceiptionist();
				String sql="insert into receptionist values('"+id.getText()+"','"+name.getText()+"','"+phn.getText()+"','"+password.getText()+"')";
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Create Receiptionist Complete!");
				}
				System.out.println(sql);
			}
		}
		else 
			if(sig.equals("Back")){
			this.setVisible(false);
			Navigate.adminHome.setVisible(true);
			
		}
	}
}