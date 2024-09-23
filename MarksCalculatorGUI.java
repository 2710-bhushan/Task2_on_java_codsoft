import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarksCalculatorGUI extends JFrame {

    // GUI Components
    private JTextField[] markFields;
    private JLabel totalLabel, averageLabel, gradeLabel;
    private JButton calculateButton;

    public MarksCalculatorGUI() {
        // Set up the JFrame
        setTitle("Marks Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Number of subjects
        int numSubjects = 5;

        // Array for text fields to input marks
        markFields = new JTextField[numSubjects];

        // Create labels and text fields for each subject
        for (int i = 0; i < numSubjects; i++) {
            add(new JLabel("Enter marks for subject " + (i + 1) + ":"));
            markFields[i] = new JTextField();
            add(markFields[i]);
        }

        // Create button to calculate total, average, and grade
        calculateButton = new JButton("Calculate");
        add(calculateButton);

        // Create labels to display total marks, average percentage, and grade
        totalLabel = new JLabel("Total Marks: ");
        averageLabel = new JLabel("Average Percentage: ");
        gradeLabel = new JLabel("Grade: ");

        // Add these labels to the JFrame
        add(totalLabel);
        add(averageLabel);
        add(gradeLabel);

        // Add ActionListener to the button to handle calculations when clicked
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });

        setVisible(true); // Set the JFrame visible
    }

    // Method to calculate total marks, average percentage, and grade
    private void calculateResults() {
        try {
            int numSubjects = markFields.length;
            int totalMarks = 0;

            // Calculate total marks by summing all the inputs
            for (JTextField markField : markFields) {
                int marks = Integer.parseInt(markField.getText());
                totalMarks += marks;
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Calculate grade based on the average percentage
            String grade;
            if (averagePercentage >= 90) {
                grade = "A+";
            } else if (averagePercentage >= 80) {
                grade = "A";
            } else if (averagePercentage >= 70) {
                grade = "B";
            } else if (averagePercentage >= 60) {
                grade = "C";
            } else if (averagePercentage >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display total marks, average percentage, and grade
            totalLabel.setText("Total Marks: " + totalMarks);
            averageLabel.setText("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
            gradeLabel.setText("Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
        }
    }

    public static void main(String[] args) {
        new MarksCalculatorGUI();
    }
}
