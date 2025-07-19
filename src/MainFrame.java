import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class MainFrame extends JFrame {

    public MainFrame(User user) {
        setTitle("Application de gestion de factures");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel();
        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu prestationsMenu = new JMenu("Prestations");
        JMenuItem prestationsListItem = new JMenuItem("Liste des prestations");
        JMenuItem addPrestationItem = new JMenuItem("Ajouter une prestation");
        prestationsMenu.add(prestationsListItem);
        prestationsMenu.add(addPrestationItem);
        
        prestationsListItem.addActionListener((e) -> displayPrestationsList(panel));
        addPrestationItem.addActionListener((e) -> createPrestation(user));
        
        JMenuItem bilanMenu = new JMenu("Bilan");
        JMenuItem bilanItem = new JMenuItem("Consulter le bilan");
        bilanMenu.add(bilanItem);
        
        menuBar.add(prestationsMenu);
        menuBar.add(bilanMenu);
        setJMenuBar(menuBar);
        
        add(panel);
        panel.setLayout(null);
        
        homePage(user);

        setVisible(true);
    }

    private void homePage(User user) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Bienvenue sur l'application de gestion de facturation " + user.getUsername() + " !");
        label.setBounds(10, 20, 400, 25);
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);

        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void displayPrestationsList(JPanel panel) {
        System.out.println("Liste des prestations");
    }

    public void createPrestation(User user) {
        int userId = user.getId();

        // Panel principal du formulaire
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // espace avant le titre
        formPanel.add(javax.swing.Box.createVerticalStrut(20));

        // Titre centré en haut
        JLabel title = new JLabel("Création d'une nouvelle prestation");
        title.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(title);
        
        // Espacement après le titre
        formPanel.add(javax.swing.Box.createVerticalStrut(20));
        
        // Panel pour les champs communs avec layout en grille
        JPanel commonFieldsPanel = new JPanel();
        commonFieldsPanel.setLayout(new java.awt.GridBagLayout());
        commonFieldsPanel.setPreferredSize(new Dimension(400, 120));
        commonFieldsPanel.setMaximumSize(new Dimension(400, 120));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Champs communs
        JTextField dateField = new JTextField(20);
        JTextField clientField = new JTextField(20);
        String[] types = {"Consultation", "Cours"};
        JComboBox<String> typeCombo = new JComboBox<>(types);
        
        // Date
        gbc.gridx = 0; gbc.gridy = 0;
        commonFieldsPanel.add(new JLabel("Date :"), gbc);
        gbc.gridx = 1;
        commonFieldsPanel.add(dateField, gbc);
        
        // Client
        gbc.gridx = 0; gbc.gridy = 1;
        commonFieldsPanel.add(new JLabel("Client / Etablissement :"), gbc);
        gbc.gridx = 1;
        commonFieldsPanel.add(clientField, gbc);
        
        // Type
        gbc.gridx = 0; gbc.gridy = 2;
        commonFieldsPanel.add(new JLabel("Type de prestation :"), gbc);
        gbc.gridx = 1;
        commonFieldsPanel.add(typeCombo, gbc);
        
        formPanel.add(commonFieldsPanel);
        
        // Espacement avant les champs spécifiques
        formPanel.add(Box.createVerticalStrut(20));
        
        // Panel pour les champs spécifiques (dynamique)
        JPanel specificPanel = new JPanel();
        specificPanel.setLayout(new GridBagLayout());
        specificPanel.setPreferredSize(new Dimension(400, 80));
        specificPanel.setMaximumSize(new Dimension(400, 80));
        formPanel.add(specificPanel);

        // Champs spécifiques pour Consultation
        JTextField descriptionField = new JTextField(20);
        JTextField rateField = new JTextField(20);

        // Champs spécifiques pour Cours
        JTextField startHourField = new JTextField(20);
        JTextField endHourField = new JTextField(20);
        JTextField moduleField = new JTextField(20);
        JTextField classLevelField = new JTextField(20);

        // Méthode pour mettre à jour les champs spécifiques
        Runnable updateSpecificFields = () -> {
            specificPanel.removeAll();
            GridBagConstraints gbcSpecific = new GridBagConstraints();
            gbcSpecific.insets = new Insets(5, 5, 5, 5);
            gbcSpecific.anchor = GridBagConstraints.WEST;
           
            // Rend les champs spécifiques en fonction du type de prestation
            if (typeCombo.getSelectedItem().equals("Consultation")) {
                // Description
                gbcSpecific.gridx = 0; gbcSpecific.gridy = 0;
                specificPanel.add(new JLabel("Description :"), gbcSpecific);
                gbcSpecific.gridx = 1;
                specificPanel.add(descriptionField, gbcSpecific);
                
                // Tarif
                gbcSpecific.gridx = 0; gbcSpecific.gridy = 1;
                specificPanel.add(new JLabel("Tarif :"), gbcSpecific);
                gbcSpecific.gridx = 1;
                specificPanel.add(rateField, gbcSpecific);
                
                // Ajuster la hauteur pour Consultation (2 champs)
                specificPanel.setPreferredSize(new Dimension(400, 80));
                specificPanel.setMaximumSize(new Dimension(400, 80));
            } else {
                // Heure de début
                gbcSpecific.gridx = 0; gbcSpecific.gridy = 0;
                specificPanel.add(new JLabel("Heure de début :"), gbcSpecific);
                gbcSpecific.gridx = 1;
                specificPanel.add(startHourField, gbcSpecific);
                
                // Heure de fin
                gbcSpecific.gridx = 0; gbcSpecific.gridy = 1;
                specificPanel.add(new JLabel("Heure de fin :"), gbcSpecific);
                gbcSpecific.gridx = 1;
                specificPanel.add(endHourField, gbcSpecific);
                
                // Module
                gbcSpecific.gridx = 0; gbcSpecific.gridy = 2;
                specificPanel.add(new JLabel("Module :"), gbcSpecific);
                gbcSpecific.gridx = 1;
                specificPanel.add(moduleField, gbcSpecific);
                
                // Niveau de classe
                gbcSpecific.gridx = 0; gbcSpecific.gridy = 3;
                specificPanel.add(new JLabel("Niveau de classe :"), gbcSpecific);
                gbcSpecific.gridx = 1;
                specificPanel.add(classLevelField, gbcSpecific);
                
                // Ajuster la hauteur pour Cours (4 champs)
                specificPanel.setPreferredSize(new Dimension(400, 140));
                specificPanel.setMaximumSize(new Dimension(400, 140));
            }
            specificPanel.revalidate();
            specificPanel.repaint();
        };

        // Listener pour le menu déroulant
        typeCombo.addActionListener(e -> updateSpecificFields.run());

        // Initialisation des champs spécifiques
        updateSpecificFields.run();

        // Espacement avant le bouton
        formPanel.add(Box.createVerticalStrut(20));
        
        // Bouton de validation centré
        JButton submitButton = new JButton("Valider");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(submitButton);

        // Espacement après le bouton
        formPanel.add(Box.createVerticalStrut(10));

        // Panel conteneur pour centrer le formulaire
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(formPanel, BorderLayout.CENTER);

        // Affichage du formulaire dans la fenêtre principale
        getContentPane().removeAll();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();

        // Soumission du formulaire
        submitButton.addActionListener(e -> {
            String date = dateField.getText();
            String client = clientField.getText();
            String type = (String) typeCombo.getSelectedItem();

            if (type.equals("Consultation")) {
                String description = descriptionField.getText();
                int rate = Integer.parseInt(rateField.getText());

                // Crée et enregistre une Consultation en base
                try {
                    Consultation consultation = new Consultation(date, client, type, description, rate, userId);

                    // l'id est initialisé à 0 (je ne sais pas pourquoi), je set à nouveau avec la bonne valeur.
                    consultation.setUserId(userId);

                    ConsultationDAO consultationDAO = new ConsultationDAO();
                    consultationDAO.save(consultation);

                    // affiche un message de succès
                    JOptionPane.showMessageDialog(formPanel, "Consultation enregistrée avec succès");
                    homePage(user);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(formPanel, "Erreur lors de l'enregistrement de la consultation");
                }
            } else {
                String startHour = startHourField.getText();
                String endHour = endHourField.getText();
                String module = moduleField.getText();
                String classLevel = classLevelField.getText();

                // Crée et enregistre un Cours
                try {
                    Course course = new Course(date, client, type, startHour, endHour, module, classLevel, userId);
                    course.setUserId(userId);

                    CourseDAO courseDAO = new CourseDAO();
                    courseDAO.save(course);

                    // affiche un message de succès
                    JOptionPane.showMessageDialog(formPanel, "Cours enregistré avec succès");
                    homePage(user);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(formPanel, "Erreur lors de l'enregistrement du cours");
                }
            }
        });
    }
}
