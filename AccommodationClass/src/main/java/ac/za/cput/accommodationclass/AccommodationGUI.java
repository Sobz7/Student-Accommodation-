
package ac.za.cput.accommodationclass;

import static ac.za.cput.accommodationclass.RoomType.DATABASE_URL;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AccommodationGUI extends JFrame implements ActionListener{
 private JPanel Panel;
   static final String DATABASE_URL = "jdbc:derby://localhost:1527/AccommodationDB";
   private final String username = "Administrator";
   private final String password = "password";
   
    private JPanel Title;
    private JLabel lblTitle;
    private JTextField txtTitle;
    private JLabel lblTitleE;
    /*
    private JLabel lblGender;
    private JPanel panelGender;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private JLabel lblGenderE;
    private ButtonGroup genderButtonGroup; 
       
*/
    private JLabel lblRoomType;
    private JComboBox accType;
    private JLabel lblErrorAccType; 
 
    private JLabel lblAccCost;
    private JComboBox accCost;
    private JLabel lblErrorAccCost;
 
    private JLabel lblAccAddress;
    private JComboBox accAddress;
    private JLabel lblErrorAccAddress;
 /*
    private JLabel lblAccRes;
    private JTextField txtResuls;
    private JLabel lblErrorRes;
 */
    private JButton btnReset;
    private JButton btnSave;
    private JButton btnCancel;
 
 public AccommodationGUI() {
 
    super("Type Of Room");
    Panel = new JPanel ();

    lblTitle = new JLabel ("University:");
    
    txtTitle = new JTextField();
    lblTitleE = new JLabel("*required");
    lblTitleE.setForeground(Color.red);
    lblTitleE.setVisible(false);
   /* 
lblGender = new JLabel("Gender :");
panelGender = new JPanel();
radMale = new JRadioButton("Male");
radMale = new JRadioButton("Female");
genderButtonGroup =new ButtonGroup();
genderButtonGroup.add(radMale);
genderButtonGroup.add(radFemale);
panelGender.setLayout(new GridLayout(1,2));
radFemale.setSelected(true); // make this female Select default
panelGender.add(radMale);
panelGender.add(radFemale);
lblGenderE = new JLabel("*required");
lblGenderE.setForeground(Color.red);
lblGenderE.setVisible(false);
*/
    lblRoomType = new JLabel("Select The Type Of Room: ");
    String typeRoom[] = {"SINGLE","SHARING"};
    accType = new JComboBox(typeRoom);
    lblErrorAccType = new JLabel("*required");
    lblErrorAccType.setForeground(Color.red);
    lblErrorAccType.setVisible(false);
  
  
    lblAccCost = new JLabel("Enter Cost p/m:");
    String listOfRent[] = {"R 4000","R 4500", "R 4800", };
    accCost = new JComboBox(listOfRent);
    lblErrorAccCost = new JLabel("*required");
    lblErrorAccCost.setForeground(Color.red);
    lblErrorAccCost.setVisible(false);
  
    lblAccAddress = new JLabel("Location:");
    String resNames[] = {"Cape Town", "Bellville", "Parow", "Woodstock"};
    accAddress = new JComboBox(resNames);
    lblErrorAccAddress = new JLabel("*required");
    lblErrorAccAddress.setForeground(Color.red);
    lblErrorAccAddress.setVisible(false);
  /*
    lblAccRes = new JLabel("You Have Selected:");
    txtResuls.setEditable(false);
    lblErrorRes = new JLabel("*required"); 
    lblErrorRes.setForeground(Color.red);
    lblErrorRes.setVisible(false);
  */
    btnReset = new JButton ("Reset");
    btnSave = new JButton ("Save");
    btnCancel = new JButton ("Cancel");
 }


public void setGUI(){

    this.setLayout(new GridLayout(5,3));

    this.add(lblTitle);
    this.add(txtTitle);
    this.add(lblTitleE);
    /*
    this.add(lblGender);
    this.add(panelGender);
    this.add(lblGenderE);
   */
    this.add(lblRoomType);
    this.add(accType);
    this.add(lblErrorAccType);
 
    this.add(lblAccCost);
    this.add(accCost);
    this.add(lblErrorAccCost);
  
    this.add(lblAccAddress);
    this.add(accAddress);
    this.add(lblErrorAccAddress);
 /* 
    this.add(lblAccRes);
    this.add(txtResuls);
    this.add(lblErrorRes);
  */
 
    this.add(btnSave);
    this.add(btnReset);
    this.add(btnCancel);
  
    btnSave.addActionListener(this);
    btnReset.addActionListener(this);
    btnCancel.addActionListener(this);
    //btnProcess.setEnabled(false);
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setSize(600,300);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);

}
   public boolean isInputValid(){
    boolean valid = true;
    
    if(txtTitle.getText().equals("")){
        valid = false;
        lblTitle.setVisible(true);
    }
    else lblTitleE.setVisible(false);
    return valid ;
    }

 
  public void resetForm(){

     txtTitle.setText(""); 
     accType.setSelectedIndex(0);
     accCost.setSelectedIndex(0);
     accAddress.setSelectedIndex(0);
    // radNo.setSelected(rootPaneCheckingEnabled);
        
    }

 @Override
 public void actionPerformed(ActionEvent e) {
 if (e.getSource()== btnSave){

    String UniName = txtTitle.getText(); 
    String typeOfRoom= accType.getSelectedItem().toString();
    String costPerMonth =  accCost.getSelectedItem().toString(); 
    String locationType = accAddress.getSelectedItem().toString();
    RoomType s = new  RoomType(UniName, typeOfRoom, costPerMonth, locationType);
  
     if (s.save()); 
          JOptionPane.showMessageDialog(null, "The Information is saved Successfully");        
         txtTitle.hasFocus();
     } else {
         JOptionPane.showMessageDialog(null, "The Information is NOT saved Successfully");        
         txtTitle.hasFocus();
        resetForm();
      //  System.exit(0);
     }
     if(e.getSource() == btnReset){
            resetForm();
 }      else if(e.getSource() == btnCancel){
     JOptionPane.showMessageDialog(null, "CANCELLED");
        txtTitle.hasFocus();
            System.exit(0);
    }

  }
   
}
       
    

  
