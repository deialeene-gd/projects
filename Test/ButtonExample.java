import java.awt.*;
import java.awt.event.*;

public class ButtonExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Button Example");
        Button button = new Button("Click Me");
        button.setBounds(50, 100, 80, 30);
        
        // Add action listener to the button (optional)
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        frame.add(button);
        frame.setSize(200, 200);
        frame.setLayout(null);
        
        // Add window listener to handle window closing
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}