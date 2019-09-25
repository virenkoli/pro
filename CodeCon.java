import javax.swing.*; 
import java.awt.event.*; 
  
public class CodeCon extends JFrame implements ActionListener ,ItemListener
{ 
  String str;
  JCheckBox  c1, c2, c3 , c4 ;
  JLabel  l1, l2, l3, l4, l5, l6, l7 ,l8;
  JTextField  t1;  
  JButton  b1,b2,b3,b4; 
  public static void main(String args[])
  {
	 CodeCon a = new CodeCon() ;
  }

  public CodeCon() 
  {
    super("Code Covertion of Numbers") ;

    l1 = new JLabel("Enter Number to Convert") ;
    l2 = new JLabel("Select the basetype of Entered Number") ;  
    t1 = new JTextField(20) ;       
    b1 = new JButton("BINARY");
    b2 = new JButton("DECIMAL");
    b3 = new JButton("OCTAL");
    b4 = new JButton("HEXADECIMAL");
    l3 = new JLabel() ;
    l4 = new JLabel() ;
    l5 = new JLabel() ;
    l6 = new JLabel() ;
l8 = new JLabel("RESULT") ;

    c1 = new JCheckBox("DECIMAL") ;
    c2 = new JCheckBox("BINARY") ;
    c3 = new JCheckBox("HEXADECIMAL") ;
    c4 = new JCheckBox("OCTAL") ;
    l7 = new JLabel("Select the basetype to Convert") ;  



    setVisible(true) ;
    setSize(600,600) ;
    setLayout(null) ;

    l1.setBounds(20,40,200,30) ;
    l2.setBounds(20,90,300,30) ;
    t1.setBounds(230,40,150,30);
    b1.setBounds(20,140,150,30) ;
    b2.setBounds(20,170,150,30) ;
    b3.setBounds(20,200,150,30) ;
    b4.setBounds(20,230,150,30) ;
    l7.setBounds(20,260,300,30) ;
    c1.setBounds(20,290,150,30) ;
    c2.setBounds(20,320,150,30) ;
    c3.setBounds(20,350,150,30) ;
    c4.setBounds(20,380,150,30) ;
    l8.setBounds(20,420,150,30) ;


    l3.setBounds(20,450,150,30) ;
    l4.setBounds(20,480,150,30) ;
    l5.setBounds(20,510,150,30);
    l6.setBounds(20,540,150,30) ;



     
    add(l8); 
    add(l1); 
    add(t1); 
    add(l2); 
    add(b1); 
    add(b2);
    add(b3);
    add(b4);
    add(l3); 
    add(l4); 
    add(l5); 
    add(l6); 
    add(l7); 
    add(c1); 
    add(c2);
    add(c3);
    add(c4);


    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    c1.addItemListener(this); 
    c2.addItemListener(this);
    c3.addItemListener(this); 
    c4.addItemListener(this);




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }   
   public void actionPerformed(ActionEvent ae) 
  {
	  str = ae.getActionCommand();
     
}
                public void itemStateChanged(ItemEvent ie)
  {	
	
	String s="";
	if(str.equals("DECIMAL"))
          {
int x=Integer.parseInt(t1.getText().trim());
	if (ie.getSource() == c1) 
	   if (ie.getStateChange() == 1)
        {
	s=t1.getText().trim();
		 l3.setText("Decimal="+s);
	    }
	    else
	      l3.setText(" ");
	
	if (ie.getSource() == c2) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toBinaryString(x);
                
		 l4.setText("Binary="+s);
	    }
	    else
		 l4.setText(" ");

	if (ie.getSource() == c3) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toHexString(x);
		l5.setText("Hexadecimal="+s);
	   }
	   else
		l5.setText(" ");

	if (ie.getSource() == c4) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toOctalString(x);
                
		 l6.setText("Octal="+s);
	    }
	    else
		 l6.setText(" ");

}
	      
	else if(str.equals("BINARY"))
		 {
	int x=Integer.parseInt(t1.getText().trim(),2);
	
	if (ie.getSource() == c1) 
	   if (ie.getStateChange() == 1)
        {
	s=Integer.toString(x);
		 l3.setText("Decimal="+s);
	    }
	    else
	      l3.setText(" ");
	
	if (ie.getSource() == c2) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toBinaryString(x);
                
		 l4.setText("Binary="+s);
	    }
	    else
		 l4.setText(" ");

	if (ie.getSource() == c3) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toHexString(x);
		l5.setText("Hexadecimal="+s);
	   }
	   else
		l5.setText(" ");

	if (ie.getSource() == c4) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toOctalString(x);
                
		 l6.setText("Octal="+s);
	    }
	    else
		 l6.setText(" ");


}
	else if(str.equals("OCTAL"))
		{	int x=Integer.parseInt(t1.getText().trim(),8);
	
	if (ie.getSource() == c1) 
	   if (ie.getStateChange() == 1)
        {
	s=Integer.toString(x);
		 l3.setText("Decimal="+s);
	    }
	    else
	      l3.setText(" ");
	
	if (ie.getSource() == c2) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toBinaryString(x);
                
		 l4.setText("Binary="+s);
	    }
	    else
		 l4.setText(" ");

	if (ie.getSource() == c3) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toHexString(x);
		l5.setText("Hexadecimal="+s);
	   }
	   else
		l5.setText(" ");

	if (ie.getSource() == c4) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toOctalString(x);
                
		 l6.setText("Octal="+s);
	    }
	    else
		 l6.setText(" ");


 
 
}  
   else if(str.equals("HEXADECIMAL"))
	{
	int x=Integer.parseInt(t1.getText().trim(),16);
	
	if (ie.getSource() == c1) 
	   if (ie.getStateChange() == 1)
        {
	s=Integer.toString(x);
		 l3.setText("Decimal="+s);
	    }
	    else
	      l3.setText(" ");
	
	if (ie.getSource() == c2) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toBinaryString(x);
                
		 l4.setText("Binary="+s);
	    }
	    else
		 l4.setText(" ");

	if (ie.getSource() == c3) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toHexString(x);
		l5.setText("Hexadecimal="+s);
	   }
	   else
		l5.setText(" ");

	if (ie.getSource() == c4) 
	   if (ie.getStateChange() == 1)
	   {
		 s=Integer.toOctalString(x);
                
		 l6.setText("Octal="+s);
	    }
	    else
		 l4.setText(" ");


}
  }
}
