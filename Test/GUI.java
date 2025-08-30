import java.awt.*;
import java.awt.event.*;

public class GUI {
    public static void main(String[] args) {
        Frame frame = new Frame("Simple AWT Example");
        Button button = new Button("Click me");
        Label label = new Label("Number of clicks: 0");
        Panel panel = new Panel();

        // Variable to keep track of the count
        final int[] count = {0}; // Using an array to allow modification inside the ActionListener

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count[0]++; // Increment the count
                label.setText("Number of clicks: " + count[0]); // Update the label
            }
        });

        // Set layout for the panel
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        // Set layout for the frame and add the panel
        frame.setLayout(new FlowLayout());
        frame.add(panel);

        // Set frame properties
        frame.setSize(300, 150);
        frame.setVisible(true);

        // Add window listener to handle window closing
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Exit the application
            }
        });
    }
}



// import java.awt.*;
// import java.awt.event.*;

// public class GUI {
//     public static void main(String[] args) {
//         Frame frame = new Frame("Simple AWT Example");
//         Button button = new Button("Click me");
//         Label label = new Label("Number of clicks: 0");
//         Panel panel = new Panel();
        
//         // Variable to keep track of the count
//         final int[] count = {0}; // Using an array to allow modification inside the ActionListener

//         button.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 count[0]++; // Increment the count
//                 label.setText("Number of clicks: " + count[0]); // Update the label
//             }
//         });

//         panel.setBorder(BorderLayout);
//         panel.setLayout(new GridLayout(0, 1));
//         panel.add(button);
//         panel.add(label);
//         // Set layout and add components
//         frame.setLayout(new FlowLayout());
//         frame.add(button);
//         frame.add(label);

//         // Set frame properties
//         frame.setSize(300, 150);
//         frame.setVisible(true);

//         // Add window listener to handle window closing
//         frame.addWindowListener(new WindowAdapter() {
//             public void windowClosing(WindowEvent e) {
//                 System.exit(0); // Exit the application
//             }
//         });
//     }
// }





// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;


// public class GUI implements ActionListener{
//     public static void main(String[] args) {
//         int count = 0;
//         JLabel label;
//         JFrame frame;
//         JPanel panel;
//         frame = new JFrame();
    
//         JButton button = new JButton("Click me");
//         button.addActionListener();
    
//         label = new JLabel("Number of clicks: 0");
    
//         panel = new JPanel();
//         panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
//         panel.setLayout(new GridLayout(0, 1));
//         panel.add(button);
//         panel.add(label);
    
//         frame.add(panel, BorderLayout.CENTER);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setTitle("OUR GUI");
//         frame.pack();
//         frame.setVisible(true);
     
//     }
        
//     @Override
//     public void actionPerformed(ActionEvent e){
//         count++;
//         label.setText("Number of clicks: " + count); 
//     }
// }
// https://introcs.cs.princeton.edu/java/15inout/GUI.java.html
