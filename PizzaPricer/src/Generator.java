import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Owner
 *
 */

public class Generator extends JPanel implements ItemListener
{
    
    JCheckBox check1;
    JCheckBox check2;
    JCheckBox check3;
    JCheckBox check4;
    
    JLabel delivery;
    JLabel pickup;
    JLabel small;
    JLabel large;
    JLabel price;
    JLabel priceDollars;
    JLabel instruct;
    JLabel instructSize;
    JLabel instructToppings;
    JLabel instructObtain;
    
    JButton getPrice;
    
    ButtonGroup bg1 = new ButtonGroup();
    ButtonGroup bg2 = new ButtonGroup();
    
    StringBuffer choices;
    
    //pizza size
    JRadioButton smallPie = new JRadioButton("Small Pie");
    JRadioButton largePie = new JRadioButton("Large Pie");

    //method of obtaining
    JRadioButton deliver = new JRadioButton("Delivery");
    JRadioButton pickUp = new JRadioButton("Pick Up");
    
    public Generator()
    {
      super(new BorderLayout());
      
      getPrice = new JButton("Get Pizza Price!");
      ActionListener listener = new ClickListener();
      getPrice.addActionListener(listener);
      
      check1 = new JCheckBox("Pepperoni");
      check1.setSelected(false);
      
      check2 = new JCheckBox("Meatball");
      check2.setSelected(false);
      
      check3 = new JCheckBox("Mushroom");
      check3.setSelected(false);

      check4 = new JCheckBox("Extra Cheese");
      check4.setSelected(false);
      
      check1.addItemListener(this);
      check2.addItemListener(this);
      check3.addItemListener(this);
      check4.addItemListener(this);
      smallPie.addItemListener(this);
      largePie.addItemListener(this);
      deliver.addItemListener(this);
      pickUp.addItemListener(this);
      
      
      choices = new StringBuffer("----");
      
      instruct = new JLabel("This is your pizza order form. Please fill it out, and click \"Get Pizza Price!\"");
      instructSize = new JLabel("Select the size of the pizza.");
      instructToppings = new JLabel("Select the toppings you would like on the pizza.");
      instructObtain = new JLabel("Select the method of getting the pizza.");
      price = new JLabel("");
      
      JPanel instruction = new JPanel(new GridLayout(1, 1));
      JPanel radioPane1 = new JPanel(new GridLayout(3, 1));
      JPanel checkPanel = new JPanel(new GridLayout(3, 2));
      JPanel radioPane2 = new JPanel(new GridLayout(3, 1));
      JPanel buttonAndText = new JPanel(new GridLayout(1, 3));
            
      instruction.add(instruct);
      
      checkPanel.add(instructToppings);
      checkPanel.add(check1);
      checkPanel.add(check2);
      checkPanel.add(check3);
      checkPanel.add(check4);
      
      bg1.add(pickUp);
      bg1.add(deliver);
      
      radioPane2.add(instructObtain);
      radioPane2.add(pickup);
      radioPane2.add(delivery);
      
      bg2.add(smallPie);
      bg2.add(largePie);
      
      radioPane1.add(instructSize);
      radioPane1.add(small);
      radioPane1.add(large);      
      
      buttonAndText.add(getPrice);
      buttonAndText.add(price);
      buttonAndText.add(priceDollars);
      
      add(instruction, BorderLayout.PAGE_START);
      add(radioPane1, BorderLayout.LINE_START);
      add(checkPanel, BorderLayout.CENTER);
      add(radioPane2, BorderLayout.LINE_END);
      add(buttonAndText, BorderLayout.PAGE_END);
      
      setBorder(BorderFactory.createEmptyBorder(0,0,300,570));
    }
    
      public void itemStateChanged(ItemEvent e)
      {
        Object source = e.getItemSelectable();
        
        
        
        //if (source == two)
        {
          check2.setEnabled(false);
         
          
        }
      }
      
      
      public String getBandName()
      {
        return "Your mom!";
      }
      
      
      public class ClickListener implements ActionListener
      {
        public void actionPerformed(ActionEvent evern)
        {
          Enumeration<AbstractButton> allRadioButton = bg1.getElements();
          while(allRadioButton.hasMoreElements())
          {
            JRadioButton temp=(JRadioButton)allRadioButton.nextElement();
            if (temp.isSelected())
            {
              JOptionPane.showMessageDialog(null,
                  "Your Band Name is: " + getBandName());
            }
          }
        }
      }
    
      private static void createAndShowGUI()
      {      
        JFrame frame = new JFrame("Band Name Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new Generator();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        
        frame.pack();
        frame.setVisible(true);
      }
      
      public static void main(String args[])
      {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
          public void run()
          {
            createAndShowGUI();
          }
        }
        );
      }
}
