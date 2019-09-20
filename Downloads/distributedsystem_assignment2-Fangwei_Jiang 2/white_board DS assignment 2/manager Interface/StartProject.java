import javax.swing.*;
public class StartProject
{
  public static void main(String[] args)
  {
    try 
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  // the GUI layput depends on the system(mac, win, linux)
      SwingUtilities.updateComponentTreeUI(new MyFrame("WhiteBoard for Manager"));  
    } 
    catch (Exception e)
    {	
      e.printStackTrace();
    }
  }
}
