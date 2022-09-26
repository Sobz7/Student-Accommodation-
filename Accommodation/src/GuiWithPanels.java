package za.ac.cput.guiexamples;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GuiWithPanels extends JFrame implements ActionListener, ItemListener
{
    /**declare variables for panels*/ 
    private JPanel radioPanel = new JPanel(new GridLayout(1,3));
    private JPanel textPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel centerPanel1 = new JPanel();
    private JPanel centerPanel2 = new JPanel();
    private JPanel centerPanel3 = new JPanel();
    
    /**declare textfield and label*/
    private JTextField nameTxt = new JTextField("");
    private JLabel nameLbl = new JLabel("Enter your name");
    
    /**declare radio buttons*/
    private JRadioButton SingleRadio = new JRadioButton("Single");
    private JRadioButton DoubleRadio = new JRadioButton("Double");
    private JRadioButton TripleRadio = new JRadioButton("Triple");
    /**group for radio buttons*/
    private ButtonGroup group = new ButtonGroup();        
    
    /**declare text area*/
    private JTextArea msgTxtArea1 = new JTextArea(10,20);
    private JTextArea msgTxtArea2 = new JTextArea(10,20);

    /**declare Jbuttons*/
    private JButton addBtn = new JButton("Add student");
    private JButton typBtn = new JButton("Student Account Type");
    private JButton cosBtn = new JButton("Student Cost");
    private JButton locBtn = new JButton("Location");
    
    /**declare JCheckBoxess*/
    private JCheckBox maleChk = new JCheckBox("Male");
    private JCheckBox femaleChk = new JCheckBox("Female");
    /**
     * Constructor for objects of class GuiWithPanels
     */
    public GuiWithPanels() 
    {
        /**call parent class constructor
        super("Frame dealing with panels");
        
        /**layout of the frame */
        setLayout(new BorderLayout());
        
        /** layout of panels*/
        //radioPanel.setLayout(new GridLayout(3,1));
        textPanel.setLayout(new FlowLayout());
        leftPanel.setLayout(new GridLayout(2,2));
        rightPanel.setLayout(new FlowLayout());
        centerPanel1.setLayout(new FlowLayout());
        centerPanel2.setLayout(new FlowLayout());
        centerPanel3.setLayout(new GridLayout(2,1));
        
        /**adding radio buttons to panel and group*/
        group.add(SingleRadio);
        group.add(DoubleRadio);
        group.add(TripleRadio);
        radioPanel.add(SingleRadio);
        radioPanel.add(DoubleRadio);
        radioPanel.add(TripleRadio);
        
        /**adding textfield and label to panel*/
        textPanel.add(nameLbl);
        nameTxt.setColumns(25);
        textPanel.add(nameTxt);

        /**adding buttons to panel*/
        leftPanel.add(addBtn);
        leftPanel.add(typBtn);
        leftPanel.add(cosBtn);
        leftPanel.add(locBtn);
        
        /**adding checkboxes to panel*/
        rightPanel.add(maleChk);
        rightPanel.add(femaleChk);

        /**adding textareas to center panels*/
        centerPanel1.add(msgTxtArea1);
        centerPanel2.add(msgTxtArea2);

        /**adding center panels to third center panel*/
        centerPanel3.add(centerPanel1);
        centerPanel3.add(centerPanel2);

        /**adding panels and textarea to frame*/
        add(textPanel,BorderLayout.NORTH);
        add(centerPanel3,BorderLayout.CENTER);
        add(radioPanel,BorderLayout.SOUTH);
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.EAST);
        
        /**register components with Listeners */
        nameTxt.addActionListener(this);
        SingleRadio.addItemListener(this);
        DoubleRadio.addItemListener(this);
        TripleRadio.addItemListener(this);
    }
    
      public void actionPerformed(ActionEvent action)
      {
         if (action.getSource() == nameTxt)
         {
            msgTxtArea1.setText("Welcome " + nameTxt.getText());
         }
      }
      
      public void itemStateChanged(ItemEvent e)
      {  
                     if (e.getSource() == SingleRadio)
                        msgTxtArea1.setBackground(Color.RED);
                     else if (e.getSource() == DoubleRadio)
                        msgTxtArea1.setBackground(Color.GREEN);
                     else if (e.getSource() == TripleRadio)
                        msgTxtArea1.setBackground(Color.BLUE);


      }
}//end class
