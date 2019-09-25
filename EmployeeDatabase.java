import javax.swing.*; 
import java.awt.event.*;
import java.sql.*; 

public class EmployeeDatabase extends JFrame implements ActionListener 
{
  JLabel  l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16,l17, l18, l19 ;
  JTextField  t1, t2, t3, t4, t5, t6, t7 ;
  JButton  b1, b2, b3, b4, b5, b6 ; 
  
  Connection  con ;
  Statement  stmt ;
  ResultSet  rs ;

  int  affectedRecords ;
  String  s="", str="" , s1="" ;

  EmployeeDatabase()
  {
	super("Employee Management System") ;
	
    setLayout(null) ;
    setSize(700,700);
    setVisible(true);

    l1 = new JLabel("CREATE TABLE") ;
    l2 = new JLabel("Table Name:") ;
    t1 = new JTextField() ;
    b1 = new JButton("Create Table");
    l1.setBounds(20,30,100,30) ;
    l2.setBounds(20,70,100,30) ;
    t1.setBounds(130,70,100,30) ;
    b1.setBounds(240,70,130,30) ;
    add(l1); 
    add(l2); 
    add(t1); 
    add(b1); 
    b1.addActionListener(this);    

    l3 = new JLabel("INSERT EMPLOYEE RECORD") ;
    l4 = new JLabel("Id:") ;
    t2 = new JTextField() ;
    l5 = new JLabel("Name:") ;
    t3 = new JTextField() ;
    l6 = new JLabel("Salary:") ;
    t4 = new JTextField() ;
    b2 = new JButton("Insert Record");
    l3.setBounds(20,120,300,30) ;
    l4.setBounds(20,170,20,30) ;
    t2.setBounds(50,170,60,30) ;
    l5.setBounds(120,170,50,30) ;
    t3.setBounds(180,170,150,30) ;
    l6.setBounds(340,170,50,30) ;
    t4.setBounds(400,170,70,30) ;
    b2.setBounds(480,170,150,30) ;
    add(l3); 
    add(l4); 
    add(t2); 
    add(l5);
    add(t3); 
    add(l6); 
    add(t4); 
    add(b2);
    b2.addActionListener(this); 

    l7 = new JLabel("UPDATE EMPLOYEE RECORD") ;
    l8 = new JLabel("Id:") ;
    t5 = new JTextField() ;
    l9 = new JLabel("New Salary:") ;
    t6 = new JTextField() ;
    b3 = new JButton("Update Salary");
    l7.setBounds(20,220,300,30) ;
    l8.setBounds(20,270,20,30) ;
    t5.setBounds(50,270,60,30) ;
    l9.setBounds(120,270,80,30) ;
    t6.setBounds(210,270,150,30) ;
    b3.setBounds(370,270,150,30) ;
    add(l7); 
    add(l8); 
    add(t5); 
    add(l9); 
    add(t6); 
    add(b3);
    b3.addActionListener(this); 

    l10 = new JLabel("DELETE RECORD") ;
    l11 = new JLabel("Id") ;
    t7 = new JTextField() ;
    b4 = new JButton("Delete Employee");
    l10.setBounds(20,320,150,30) ;
    l11.setBounds(20,370,20,30) ;
    t7.setBounds(40,370,60,30) ;
    b4.setBounds(100,370,130,30) ;
    add(l10); 
    add(l11); 
    add(t7); 
    add(b4); 
    b4.addActionListener(this);

    l12 = new JLabel("DROP TABLE") ;
    b5 = new JButton("Submit");
    l12.setBounds(20,420,80,30) ;
    b5.setBounds(110,420,100,30) ;
    add(l12); 
    add(b5); 
    b5.addActionListener(this);
	
	l13 = new JLabel("SHOW TABLE") ;
    b6 = new JButton("Show");
    l13.setBounds(20,550,80,30) ;
    b6.setBounds(110,550,80,30) ;
    add(l13); 
    add(b6); 
    b6.addActionListener(this);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
  } 
 
  public void actionPerformed(ActionEvent ae) 
  {
	s1 = ae.getActionCommand();
	
	try
	{   
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopm","sandeep","studycircle");
		stmt=con.createStatement();		
		
		switch(s1)
		{
		  case "Create Table":		  
		  s = t1.getText();
		  stmt.executeUpdate("CREATE TABLE "+s+"(id  char(3), name varchar(20), salary varchar(10))");
		  
		  l14 = new JLabel("Table Created") ;
		  add(l14);
		  l14.setBounds(20,460,100,20) ;
		  
		  break;
		  
		  case "Insert Record":
		  int j = stmt.executeUpdate("INSERT INTO  "+s+" VALUES("+t2.getText()+ ", '"+t3.getText()+"',"+t4.getText()+")");
		  break;
		  
		  case "Update Salary":
		  affectedRecords = stmt.executeUpdate("UPDATE  "+s+" SET salary="+	t6.getText() + "WHERE id=" + t5.getText());
		  if(affectedRecords==0)
			str="Record with ID "+t5.getText() + " not found";
		  else
			str="Number of records updated: " + affectedRecords;
		
		  l15 = new JLabel(str) ;
		  add(l15);
		  l15.setBounds(20,480,400,20) ;
		  break;
		  
		  case "Delete Employee":
		  affectedRecords = stmt.executeUpdate("DELETE FROM "+s+" WHERE id=" + t7.getText());
		  if(affectedRecords==0)
			str="Record with ID "+t7.getText() + " not found";
		  else
			str="Number of records deleted: " + affectedRecords;
		
		  l16 = new JLabel(str) ;
		  add(l16);
		  l16.setBounds(20,500,400,20) ;
		  break;
		  
		  case "Submit":
		  stmt.executeUpdate("DROP TABLE  "+s);
		  
		  l18 = new JLabel("Table dropped") ;
		  add(l18);
		  l18.setBounds(20,520,100,20) ;
		  break;
		  
		  case "Show":
		  int x=0;
		  rs=stmt.executeQuery("select * from  "+s); 
		  while(rs.next())
		  {
			l19 = new JLabel(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			add(l19);
			l19.setBounds(20,600+x,600,20) ;
			x=x+20;
		  }
		  break;
		}		
		con.close();
	  }
	  catch(Exception e) 
	  {}
  }

  public static void main(String[] args)
  {
	EmployeeDatabase frm = new EmployeeDatabase();
  }
}
