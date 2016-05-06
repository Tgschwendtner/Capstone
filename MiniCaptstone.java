import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
//https://docs.oracle.com/javase/7/docs/api/java/awt/GridLayout.html#GridLayout(int,%20int)
public class MiniCaptstone extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private int hgap = 10;
    private int vgap = 10;
    private int rows = 3;
    private int cols = 3;
    
    private JFrame frame;
    private JPanel panel;
    private JTextField totalMinutes;
    private JTextField totalDistance;
    private JTextField totalSeconds;
    private JTextField totalHours;
    private JButton calculate;
    private String[] description = { "Miles", "Kilometers" };
    private JComboBox <String> distanceSystem;
    public MiniCaptstone()
    {
        this.frame = new JFrame();
        this.panel = new JPanel();

        this.totalMinutes = new JTextField(15);
        this.totalSeconds = new JTextField(15);
        this.totalDistance = new JTextField(15);
        this.totalHours = new JTextField(15);
        this.calculate = new JButton ( "Calculate Split" );
        this.distanceSystem = new JComboBox <String>();
        this.panel.add( this.calculate );
        this.panel.add(totalMinutes);
        this.panel.add(totalSeconds);
        this.panel.add(totalDistance);
        this.panel.add(totalHours);
        
        GridLayout layout = new GridLayout( rows, cols, hgap, vgap);
        
        
        for (int i = 0; i < description.length;i++)
        {
           this.distanceSystem.addItem(description[i]);
        }
        
        this.panel.add(distanceSystem);
        ClickListener listener = new ClickListener();
        this.calculate.addActionListener( listener );
        
        this.frame.add( this.panel );
        this.frame.setSize( FRAME_WIDTH , FRAME_HEIGHT );
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.setVisible( true );
    }

    public static void main ( String[] args )
    {
        MiniCaptstone view = new MiniCaptstone();
    }

    public class ClickListener implements ActionListener
    {

        public void actionPerformed( ActionEvent event )
        {
            String minutes = totalMinutes.getText();
            String seconds = totalSeconds.getText();
            String hours = totalHours.getText();
            String distance = totalDistance.getText();
            //math time (minutes) * 60 + seconds / distance / 60 = minutes
            //math time (minutes) * 60 + seconds / distance - minutes = seconds
            if ( distanceSystem.getSelectedIndex() == 0 )
            {
                //Math goes here
                System.out.println("Minutes "+ minutes);
                System.out.println("Seconds "+ seconds);
                System.out.println("Hours "+ hours);
                System.out.println("Distance "+ distance);
                System.out.println("Miles");
            }
            else if (distanceSystem.getSelectedIndex() == 1 )
            {
                //Math goes here
                
                System.out.println("Kilometers");
            }
            
        }

    }

}
