import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private AuthService authService = new AuthService();

    public LoginFrame() {
        setTitle("Connexion");
        setSize(350, 170);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Ajoute du padding dans le panel
        panel.setLayout(box);
        
        JLabel userLabel = new JLabel("Identifiant");
        userLabel.setSize(150, 20);
        userLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(userLabel);
    
        usernameField = new JTextField(20);
        usernameField.setSize(300, 20);
        usernameField.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(usernameField);
    
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        passwordLabel.setSize(150, 20);
        panel.add(passwordLabel);
    
        passwordField = new JPasswordField(20);
        passwordField.setAlignmentX(CENTER_ALIGNMENT);
        passwordField.setSize(300, 20);
        panel.add(passwordField);

        panel.add(Box.createVerticalStrut(10));
    
        JButton loginButton = new JButton("Se connecter");
        loginButton.setAlignmentX(CENTER_ALIGNMENT);
        loginButton.setSize(150, 20);
        panel.add(loginButton);
    
        loginButton.addActionListener(e -> {
            try {
                User user = authService.login(usernameField.getText(), new String(passwordField.getPassword()));
    
                if (user != null) {
                    JOptionPane.showMessageDialog(this, "Connexion réussie !");
                    new MainFrame(user);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Identifiant ou mot de passe incorrect.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(panel);
        
        setVisible(true);
    }
}
