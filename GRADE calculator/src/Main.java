import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GradeCalculator extends JFrame {
    JLabel label;
    JTextField[] textFields;
    JTextField enternum;
    JButton submit;
    JPanel textfieldpanel;
    JPanel inputPanel;
    JPanel buttonPanel;
    JButton addButton;
    JButton perButton,gradeButton;
    int sum;
    int n;
    double per;

    GradeCalculator() {
        super("Dynamic Number of Text Fields");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        label = new JLabel("Enter the number of Text Fields");
        add(label, BorderLayout.NORTH);

        inputPanel = new JPanel(new FlowLayout());
        enternum = new JTextField(10);
        inputPanel.add(enternum);

        submit = new JButton("Create");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numText = enternum.getText().trim();
                try {
                    n = Integer.parseInt(numText);
                    create(n);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
        inputPanel.add(submit);

        add(inputPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void add(int n) {
        sum = 0;
        try {
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(textFields[i].getText().trim());
            }
            JOptionPane.showMessageDialog(null, "The sum is: " + sum);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers in all fields.");
        }
    }

    public void percentage(int sum, int n) {
        try {
            per = (double) sum / n;
            JOptionPane.showMessageDialog(null, "The Average percentage is: " + per);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    public void grade(float per){
        try {
            if (per < 100 && per >= 90) {
                JOptionPane.showMessageDialog(null, "O grade");
            }
            if (per < 90 && per >= 80) {
                JOptionPane.showMessageDialog(null, "E grade");
            }
            if (per < 80 && per >= 70) {
                JOptionPane.showMessageDialog(null, "A+ grade");
            }
            if (per < 70 && per >= 60) {
                JOptionPane.showMessageDialog(null, "A grade");
            }
            if (per < 60 && per >= 50) {
                JOptionPane.showMessageDialog(null, "B+ grade");
            }
            if (per < 50 && per >= 40) {
                JOptionPane.showMessageDialog(null, "B grade");
            }
            if (per < 40 && per >= 30) {
                JOptionPane.showMessageDialog(null, "C grade");
            }
            if (per < 30 && per >= 20) {
                JOptionPane.showMessageDialog(null, "D grade");
            }
            if (per < 20 && per >= 0) {
                JOptionPane.showMessageDialog(null, "F grade");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error 0ccured");
        }
    }

    public void create(int n) {
        textfieldpanel = new JPanel(new GridLayout(n, 2));
        textFields = new JTextField[n];

        for (int i = 0; i < n; i++) {
            JLabel newLabel = new JLabel("Subject " + (i + 1) + ": ");
            JTextField newText = new JTextField(10);
            textFields[i] = newText; // Store the reference to each JTextField
            textfieldpanel.add(newLabel);
            textfieldpanel.add(newText);
        }



        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(n);
            }
        });

        perButton = new JButton("Percentage");
        perButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                percentage(sum, n);
            }
        });

        gradeButton=new JButton("Grade");
        gradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grade((float) per);
            }
        });

        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(perButton);
        buttonPanel.add(gradeButton);

        getContentPane().removeAll(); // Clear previous components
        add(label, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.NORTH);
        add(textfieldpanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        

        revalidate();
        repaint();
        pack();
    }
}

public class Main {
    public static void main(String[] args) {
        new GradeCalculator();
    }
}
