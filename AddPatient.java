import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddPatient extends Frame implements ActionListener{
	private TextField id,name,phn,dob,blood,record;
	private Button createButton,backButton;
	private Label l,l2,l3,l4,l5,l6,msg;
	public AddPatient(){
		super("Add Patient");
		l=new Label("ID: ");
		id=new TextField(15);
		l2=new Label("Name: ");
		name=new TextField(15);
		l3=new Label("Phone No: ");
		phn=new TextField(15);
		l4=new Label("DOB: ");
		dob=new TextField(15);
		l5=new Label("Blood Group: ");
		blood=new TextField(15);
		l6=new Label("Record: ");
		record=new TextField(15);
		
		createButton=new Button("Create");
		backButton=new Button("Back");
		msg=new Label("msg box");
		
		add(l);add(id);
		add(l2);add(name);
		add(l3);add(phn);
		add(l4);add(dob);
		add(l5);add(blood);
		add(l6);add(record);
		add(createButton);add(backButton);
		add(msg);
		
		l.setBounds(10,60,50,30);
		id.setBounds(125,60,200,30);
		
		l2.setBounds(10,95,100,30);
		name.setBounds(125,95,200,30);
		
		l3.setBounds(10,130,90,30);
		phn.setBounds(125,130,200,30);
		
		l4.setBounds(10,165,90,30);
		dob.setBounds(125,165,200,30);
		
		l5.setBounds(10,200,90,30);
		blood.setBounds(125,200,200,30);
		
		l6.setBounds(10,235,90,30);
		record.setBounds(125,235,200,30);
		
		createButton.setBounds(125,275,100,30);
		backButton.setBounds(230,275,100,30);
		
		msg.setBounds(235,320,90,30);
		
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
			if(isEmpty(id) || isEmpty(name) || isEmpty(phn) || isEmpty(dob) || isEmpty(blood) || isEmpty(record)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				DataAccessReceiptionist da=new DataAccessReceiptionist();
				String sql="insert into patient values('"+id.getText()+"','"+name.getText()+"','"+dob.getText()+"','"+blood.getText()+"','"+phn.getText()+"','"+record.getText()+"')";
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Create Patient Complete!");
				}
				System.out.println(sql);
			}
		}
		else 
			if(sig.equals("Back")){
			this.setVisible(false);
			Navigate.receiptionistHome.setVisible(true);
		}
	}
}