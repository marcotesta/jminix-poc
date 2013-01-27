package it.mondogrua.p2p.jminix_test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class DataView extends JFrame  {
    
    JLabel lable;
    
    JButton button;
    
    public DataView(final JMiniXPOC controller) {
        super("JMiniX Proof Of Concept");
        setLayout(new FlowLayout());
        this.lable = new JLabel(DataModel.textA);
        add(lable);
        button = new JButton("Pigia");
        button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                controller.changeLable();
            }
        });
        add(button);
    }

    public String getText() {
        return this.lable.getText();
    }

    public void setText(final String currentText) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                lable.setText(currentText); 
            }
        });
        
    }
    
    public void run(final JMiniXPOC controller) {
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(new Dimension(300,100));
                setVisible(true);
            }
        });

    }

}
