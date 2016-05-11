import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiniCaptstone extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private JFrame frame;
    private JPanel panel;

    private JTextField totalMinutes;
    private JTextField totalDistance;
    private JTextField totalSeconds;
    private JTextField totalHours;
    private JButton calculate;
    private JLabel minuteLabel;
    private JLabel secondLabel;
    private JLabel hourLabel;
    private JLabel distanceLabel;
    private JLabel infoLabel;
    private JLabel infoLabel2;

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
        this.minuteLabel = new JLabel("Minutes");
        this.secondLabel = new JLabel("Seconds");
        this.hourLabel = new JLabel("Hours");
        this.distanceLabel = new JLabel("Distance");
        this.infoLabel = new JLabel("Please place a 0 in any black location.");
        this.infoLabel2 = new JLabel("Any negative numbers will crash the crash the program.");

        this.panel.add(infoLabel);
        this.panel.add(infoLabel2);
        this.panel.add(hourLabel);
        this.panel.add(minuteLabel);
        this.panel.add(secondLabel);
        this.panel.add(distanceLabel);

        this.panel.add(calculate);
        calculate.setLocation(100,50);

        this.panel.add(totalHours);
        totalHours.setLocation(0,0);

        this.panel.add(totalMinutes);
        totalHours.setLocation(0,0);

        this.panel.add(totalSeconds);
        totalSeconds.setLocation(50,300);

        this.panel.add(totalDistance);
        totalDistance.setLocation(90,40);

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
            double minutes = Double.parseDouble(totalMinutes.getText());
            double seconds = Double.parseDouble(totalSeconds.getText());
            double hours = Double.parseDouble(totalHours.getText());
            double distance = Double.parseDouble(totalDistance.getText());

            //math time (minutes) * 60 + seconds / distance / 60 = minutes
            //math time (minutes) * 60 + seconds / distance - minutes = seconds
            if( distance < 0 || hours < 0 || seconds < 0 || minutes <0)
            {
                System.out.println("Please use positive number");
            }
            else
            {
                if ( distanceSystem.getSelectedIndex() == 0 )
                {
                    //Math goes here
                    int mileSplitMinutes = (int)(((hours*60*60 + minutes*60 + seconds)/distance) /60);
                    int mileSplitSeconds = (int) (((hours*60*60 + minutes*60 + seconds)/distance) - (mileSplitMinutes*60));
                    System.out.println( mileSplitMinutes + ":" + mileSplitSeconds);
                }
                else if (distanceSystem.getSelectedIndex() == 1 )
                {
                    //Math goes here
                    int KiloSplitMinutes = (int)(((hours*60*60 + minutes*60 + seconds)/distance) /60);
                    int KiloSplitSeconds = (int) (((hours*60*60 + minutes*60 + seconds)/distance) - (KiloSplitMinutes*60));
                    System.out.println( KiloSplitMinutes + ":" + KiloSplitSeconds);
                }
            }
            

        }

    }

}
