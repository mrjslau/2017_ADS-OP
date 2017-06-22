import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormPanel extends JPanel{

  private JLabel plNameLabel;
  private JTextField plTextField;
  private JButton okBtn;
  private FormListener formListener;

  public FormPanel(){
    Dimension dim = getPreferredSize();
    dim.width = 250;
    setPreferredSize(dim);

    plNameLabel = new JLabel("Enter ID:");
    plTextField = new JTextField(10);
    okBtn = new JButton("Search");
    
    okBtn.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			String name = plTextField.getText();
			
			FormEvent ev = new FormEvent(this, name);
			
			if(formListener != null){
				formListener.formEventOccured(ev);
			}
		}
    });
    
    

    Border innerBorder = BorderFactory.createTitledBorder("Add Player");
    Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));

    setLayout(new GridBagLayout());
    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = 0;
    gc.gridy = 0;
    gc.weightx = 1;
    gc.weighty = 0.1;
    gc.insets = new Insets(0, 0, 0, 10);
    gc.anchor = GridBagConstraints.LINE_END;
    gc.fill = GridBagConstraints.NONE;

    add(plNameLabel, gc);

    gc.gridx++;
    gc.insets = new Insets(0, 0, 0, 0);
    gc.anchor = GridBagConstraints.LINE_START;

    add(plTextField, gc);

    gc.weighty = 20;
    gc.gridy++;
    gc.anchor = GridBagConstraints.FIRST_LINE_START;

    add(okBtn, gc);
  }

  public void setFormListener(FormListener fl){
	  this.formListener = fl;
  }
}
