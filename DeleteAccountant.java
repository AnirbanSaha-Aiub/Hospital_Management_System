import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DeleteAccountant extends Frame implements ActionListener{
	private TextField Id;
	private Button confirmButton,cancelButton;
	private Label l,msg;
	private Frame parent;
	public DeleteAccountant(){
		super("Delete Accountant Window");
		l=new Label("ID: ");
		Id=new TextField(10);
		confirmButton=new Button("Confirm");
		cancelButton=new Button("Back");
		msg=new Label("msg box");
		add(l);add(Id);
		add(confirmButton);add(cancelButton);
		add(msg);
		
		l.setBounds(10,60,50,30);
		Id.setBounds(115,60,200,30);
		confirmButton.setBounds(120,130,100,30);
		cancelButton.setBounds(220,130,100,30);
		msg.setBounds(115,170,200,30);
		
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
	public void setParent(Frame p){
		parent=p;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		String m="";
		if(sig.equals("Confirm")){
			String sql="delete from accountant where AC_Id='"+Id.getText()+"'";
			m=sql;
			DataAccessDoctor da2=new DataAccessDoctor();
			if(isEmpty(Id)){
				m="All fields are mandatory";
			}
			else{
				if(da2.updateDB(sql)>0){
					m="Data Deleted";
				}
				else{
					m="Delete Error!";
				}
			}
		}
		else if(sig.equals("Back")){
			//parent.setVisible(true);
			Navigate.adminHome.setVisible(true);
			this.setVisible(false);
		}
		if(m.length()>0){
			msg.setText(m);
			JOptionPane.showMessageDialog(this,m);
		}
	}
}