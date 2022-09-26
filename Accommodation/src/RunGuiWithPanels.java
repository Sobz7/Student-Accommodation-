package za.ac.cput.guiexamples;

import javax.swing.*;
public class RunGuiWithPanels
{
	
    public static void main(String[] args)
    {
        GuiWithPanels myPanelGui = new GuiWithPanels();
        myPanelGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanelGui.setSize(700,500);
        myPanelGui.setVisible(true);
    }
}
