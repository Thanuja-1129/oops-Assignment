

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class login {
	
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user_auth";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Thanuja@2005";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("User Authentication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new CardLayout());
        frame.add(panel);

        JPanel loginPanel = createLoginPanel(panel);
        JPanel registerPanel = createRegisterPanel(panel);

        panel.add(loginPanel, "Login");
        panel.add(registerPanel, "Register");

        

        
        frame.setVisible(true);
    }


    
    private JPanel createLoginPanel(JPanel parentPanel) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton goToRegisterButton = new JButton("Register");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        panel.add(new JLabel());
        panel.add(goToRegisterButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticateUser(username, password)) {
                JOptionPane.showMessageDialog(panel, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        goToRegisterButton.addActionListener(e -> {
            CardLayout layout = (CardLayout) parentPanel.getLayout();
            layout.show(parentPanel, "Register");
        });

        return panel;
    }

    private JPanel createRegisterPanel(JPanel parentPanel) {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton registerButton = new JButton("Register");
        JButton goToLoginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel());
        panel.add(registerButton);
        panel.add(new JLabel());
        panel.add(goToLoginButton);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(panel, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (registerUser(username, password, email)) {
                JOptionPane.showMessageDialog(panel, "Registration successful! Please log in.");
                CardLayout layout = (CardLayout) parentPanel.getLayout();
                layout.show(parentPanel, "Login");
            } else {
                JOptionPane.showMessageDialog(panel, "Registration failed. Username may already exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        goToLoginButton.addActionListener(e -> {
            CardLayout layout = (CardLayout) parentPanel.getLayout();
            layout.show(parentPanel, "Login");
        });

        return panel;
    }
    private boolean registerUser(String username, String password, String email)  {
    try {
   	 
   	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_auth","root","Thanuja@2005");
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, username);
           
            stmt.setString(3, email);
            stmt.executeUpdate();
            return true;
        }
       
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) { // Duplicate entry error
            JOptionPane.showMessageDialog(null, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            e.printStackTrace();
        }
        return false;
    }
}

    
      

    private boolean authenticateUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT password FROM users WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String storedHashedPassword = rs.getString("password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return email.matches(emailRegex);
    }
}
