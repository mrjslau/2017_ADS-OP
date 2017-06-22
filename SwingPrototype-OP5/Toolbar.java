import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;


public class Toolbar extends JPanel implements ActionListener{

  private JButton playersBtn;
  private JButton teamsBtn;
  private TextPanel textPanel;
  private StringListener strListener;

  public Toolbar(){
    playersBtn = new JButton("Players");
    teamsBtn = new JButton("Teams");

    playersBtn.addActionListener(this);
    teamsBtn.addActionListener(this);

    setLayout(new FlowLayout(FlowLayout.LEFT));

    add(playersBtn);
    add(teamsBtn);
  }

  public void addTextPanel(TextPanel txtP){
    this.textPanel = txtP;
  }
  public void setStringListener(StringListener strListener){
    this.strListener = strListener;
  }

  public void actionPerformed(ActionEvent e){
    JButton btn = (JButton)e.getSource();
    if(btn == playersBtn){
      if(strListener != null){
        strListener.stringEmitted("Player");
      }
    }
    else{
      if(strListener != null){
        strListener.stringEmitted("Team");
      }
    }
  }

}
