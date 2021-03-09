import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.util.TimerTask;
import java.util.Timer;

public class calibLeft {

    JFrame frame = new JFrame();             // defines frame field
    JPanel panel = new JPanel();             // defines panel field

    public calibLeft(Session[] session) {

        panel.setLayout(new GridBagLayout());               // sets panel layout

        JLabel label = new JLabel("Point foot to the left and hold");   // creates a label and sets text
        label.setFont(new Font("Verdana", Font.PLAIN, 50));       // sets font and size

        panel.add(label);                               // adds label to panel

        frame.add(panel);                               // adds panel to frame
        frame.setVisible(true);                         // makes frame visible
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);   // sets frame to fit screen

        Timer timer = new Timer();                // creates a timer field

        timer.schedule(new TimerTask(){           // start timer task

            int second = 5;                       // defines start of countdown
            @Override
            public void run() {
                // title of frame will show time
                frame.setTitle("Calibrating... Hold for " + second-- + " seconds.");

                if (second < 0){                            // at time less than 0s
                    calibUp timer4 = new calibUp(session);  // opens next frame
                    try {
                        PrintWriter instruct = new PrintWriter("python", "UTF-8");
                        instruct.println("4");
                        instruct.close();
                    }
                    catch(Exception E){}
                    frame.dispose();                        // this frame will close
                    timer.cancel();                         // this timer will stop
                }
            }
        },0, 1000);     // adds a 1000ms pause between counts
    }
}
