import java.awt.BorderLayout; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MainFrame extends JFrame{

  private TextPanel textPanel;
  private JButton button;
  private Toolbar toolbar;
  private FormPanel formPanel;

  public MainFrame(){
    super("Football App");

    setLayout(new BorderLayout());

    textPanel = new TextPanel();
    button = new JButton();
    toolbar = new Toolbar();
    formPanel = new FormPanel();

    toolbar.setStringListener(new StringListener(){
        public void stringEmitted(String text){
          textPanel.appendText(text);
        }

    });
    
    formPanel.setFormListener(new FormListener(){
    	public void formEventOccured(FormEvent e){
    		String name = e.getName();
    		
    		textPanel.appendText(name + "\n");
    	}
    });

    add(formPanel, BorderLayout.WEST);
    add(textPanel, BorderLayout.CENTER);
    add(button, BorderLayout.SOUTH);
    add(toolbar, BorderLayout.NORTH);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0){
        textPanel.appendText("OK\n");
      }
    });

    setSize(500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);




  }


}
