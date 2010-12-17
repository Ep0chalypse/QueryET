package queryet;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileSelectorDialog extends JPanel implements ActionListener {
    JButton go;  
    JFileChooser chooser;
    String choosertitle;
    static JLabel label = new JLabel();
    
   public FileSelectorDialog() {
     setLayout(new FlowLayout(FlowLayout.LEFT));
     go = new JButton("Select et launcher");
     go.setToolTipText("game executable ex: et or et.exe");
     label.setText("Not set ");
     go.addActionListener(this);
     add(go);
     add(label);
    }

   public void actionPerformed(ActionEvent e) {
          
     chooser = new JFileChooser();
     chooser.setCurrentDirectory(new java.io.File("."));
     chooser.setDialogTitle(choosertitle);
     chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
     
     //
     // disable the "All files" option.
     //
     chooser.setAcceptAllFileFilterUsed(false);
     //    
     if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
       System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
       System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
       QueryGUI.setEtBinary(chooser.getSelectedFile().toString());
       label.setText("Selected File: " + QueryGUI.getEtBinary());      
       }
     else {
       System.out.println("No Selection ");
       }
      }
    
   public Dimension getPreferredSize(){
     return new Dimension(500, 300);
     }
 }
