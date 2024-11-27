

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class QuizApplication extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton submitButton, nextButton, finishButton;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Database connection
   
    private ArrayList<Question> questions = new ArrayList<>();

    public QuizApplication() {
        setTitle("Quiz Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Load questions from the database
        loadQuestionsFromDatabase();

        // Question Panel
        JPanel questionPanel = new JPanel(new GridLayout(6, 1));
        questionLabel = new JLabel("Question will appear here.");
        questionPanel.add(questionLabel);

        // Options
        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionGroup.add(options[i]);
            questionPanel.add(options[i]);
        }

        add(questionPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        nextButton = new JButton("Next");
        finishButton = new JButton("Finish");

        nextButton.setEnabled(false); // Disabled until the user submits an answer
        finishButton.setVisible(false); // Visible only for the last question

        buttonPanel.add(submitButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(finishButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        submitButton.addActionListener(e -> submitAnswer());
        nextButton.addActionListener(e -> nextQuestion());
        finishButton.addActionListener(e -> finishQuiz());

        // Display the first question
        if (!questions.isEmpty()) {
            displayQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "No questions found in the database!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        setVisible(true);
    }

    // Load Questions from Database
    private void loadQuestionsFromDatabase() {
	
    	
        try (

        		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db","root","Thanuja@2005");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM questions")) {

            while (rs.next()) {
                String question = rs.getString("question");
                String[] options = {
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4")
                };
                int correctOption = rs.getInt("correct_option") - 1; // Adjust for zero-based index
                questions.add(new Question(question, options, correctOption));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // Display the current question
    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText((currentQuestionIndex + 1) + ". " + currentQuestion.getQuestion());

        String[] currentOptions = currentQuestion.getOptions();
        for (int i = 0; i < options.length; i++) {
            options[i].setText(currentOptions[i]);
            options[i].setSelected(false);
        }
    }

    // Submit Answer
    private void submitAnswer() {
        int selectedOption = -1;

        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }

        if (selectedOption == -1) {
            JOptionPane.showMessageDialog(this, "Please select an option.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the answer is correct
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedOption == currentQuestion.getCorrectOption()) {
            score++;
        }

        submitButton.setEnabled(false);
        nextButton.setEnabled(true);

        if (currentQuestionIndex == questions.size() - 1) {
            nextButton.setVisible(false);
            finishButton.setVisible(true);
        }
    }

    // Move to the next question
    private void nextQuestion() {
        currentQuestionIndex++;
        submitButton.setEnabled(true);
        nextButton.setEnabled(false);
        displayQuestion();
    }

    // Finish Quiz
    private void finishQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz Finished! Your Score: " + score + "/" + questions.size());
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApplication::new);
    }
}

// Question Class
class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

