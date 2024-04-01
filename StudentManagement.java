import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentManagement {
    private static int rollNo = 1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> ShowGUI());    //to ensure contents are displayed properly
    }

    private static void ShowGUI() {
		JFrame frame = new JFrame("Student Management System");
		frame.setSize(700,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		//For name
		JLabel lname = new JLabel("Name : ");
		lname.setBounds(50, 10, 80, 25);
		frame.add(lname);
		JTextField tname = new JTextField();
		tname.setBounds(50, 40, 100, 25);
		frame.add(tname);
		
		//For Roll no
		JLabel lroll = new JLabel("Roll No. : ");
		lroll.setBounds(50, 70, 80, 25);
		frame.add(lroll);
		JTextField troll = new JTextField();
		troll.setBounds(50, 100, 100, 25);
		troll.setEditable(false);
		frame.add(troll);
		
		//For Gender
		JLabel lgender = new JLabel("Gender : ");
		lgender.setBounds(50, 150, 80, 25);
		frame.add(lgender);
		
		JRadioButton rmale = new JRadioButton("Male");
        JRadioButton rfemale = new JRadioButton("Female");
        JRadioButton rothers = new JRadioButton("Others");
        
        rmale.setBounds(50,180,80,25);
        rfemale.setBounds(130,180,80,25);
        rothers.setBounds(210,180,80,25);
        
        
        frame.add(rmale);
        frame.add(rfemale);
        frame.add(rothers);

        // Grouping the radio buttons to ensure only one can be selected
        ButtonGroup rgroup = new ButtonGroup();
        rgroup.add(rmale);
        rgroup.add(rfemale);
        rgroup.add(rothers);
        
        //For Favorite foods
        JLabel lfood = new JLabel("Favourite Foods : ");
		lfood.setBounds(50, 230, 100, 25);
		frame.add(lfood);
		
		JCheckBox cchowmin = new JCheckBox("Chowmin");
        JCheckBox csamosa = new JCheckBox("Samosa");
        JCheckBox cparothaa = new JCheckBox("Parothaa");
        
        cchowmin.setBounds(50, 260, 100, 25);
        csamosa.setBounds(50, 280, 100, 25);
        cparothaa.setBounds(50, 300, 100, 25);
        
        frame.add(cchowmin);
        frame.add(csamosa);
        frame.add(cparothaa);
        

        
        //For Submit
        
        JButton bsubmit = new JButton("Submit");
        bsubmit.setBounds(50, 350, 100, 25);
        frame.add(bsubmit);

        
        
        //Output Section
        
        //output name
        JLabel lstudent = new JLabel("Students Record");
        lstudent.setBounds(400, 10, 200, 25);
        frame.add(lstudent);
        
        //output display area
        JTextArea displayStudent = new JTextArea();
        displayStudent.setBounds(300,40,320,400);
        frame.add(displayStudent);
        
        //scroll option
        JScrollPane scroll = new JScrollPane(displayStudent);
        scroll.setBounds(300,40,320,400);
        frame.add(scroll);
      
        
        
        //for roll number assignment
        troll.setText(String.valueOf(rollNo));
        
        
        
        
        //Logic Section
       bsubmit.addActionListener(new ActionListener(){
    	   @Override
    	   public void actionPerformed(ActionEvent e)
    	   {
    		   
    		   String gender="";
    		   String foodChoice ="";
    		 //radio logic 
    		   if(rmale.isSelected())
    			   gender = "Male";
    		   else if(rfemale.isSelected())
    			   gender = "Female";
    		   else if(rothers.isSelected())
    			   gender = "Others";
    		   else
    			   gender = "Not Selected";
    		   
    		   //checkbox logic
    		   if(cchowmin.isSelected())
    			   foodChoice += "Chowmin ";
    		   if(csamosa.isSelected())
    			   foodChoice += "Samosa ";
    		   if(cparothaa.isSelected())
    			   foodChoice += "parothaa ";
    			   
    			   
    			   
    		   //displaying logic
    		  
    		   displayStudent.setText(displayStudent.getText()+"Roll no : "+String.valueOf(rollNo)+"\n"+"Name : "+tname.getText() +"\n"+"Gender : "+gender+"\n"+"Favourite Foods : "+foodChoice+"\n\n");
    		  
    		   rollNo++;
    		   troll.setText(String.valueOf(rollNo));
    		   tname.setText(null);
    		   rgroup.clearSelection();
    		   cchowmin.setSelected(false);
    		   csamosa.setSelected(false);
    		   cparothaa.setSelected(false);
    		   
    		   
    		  
    		   frame.revalidate();
    		   frame.repaint();
    	    }
       });

	}
}
        