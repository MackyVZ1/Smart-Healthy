import javax.swing.*;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


/**
 * @author 65364565 Veerapat Pitchwannakham
 */
public class App extends JFrame implements ActionListener{
    //JFrame
    private Color c1 = new Color(181, 241, 204);
    private Font fHead = new Font("Agency FB", 1, 22);
    private Font fHead2 = new Font("Agency FB", 1, 18);
    private Font f = new Font("Agency FB", 1, 16);
    private int frameWidth = 600;
    private int frameHeight = 480;
    private JLabel labelWelcome;
    private JLabel labelfill;
    private JLabel labelName;
    private JTextField fillName;
    private JLabel labelAge;
    private JTextField fillAge;
    private JLabel labelWeight;
    private JTextField fillWeight;
    private JLabel labelHeight;
    private JTextField fillHeight;
    private JLabel labelGender;
    private JButton buttonNext;
    private JCheckBox choiceMale;
    private JCheckBox choiceFemale;
    private JButton buttonExit;

    public App(){
        super("Smart Healthy");
        super.setBackground(c1);
        initComponents();
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents(){
        setLayout(null);
        //Label "Welcome"
        labelWelcome = new JLabel("Welcome to Smart Healthy Application");
        labelWelcome.setBounds(170, -200, frameWidth, frameHeight);// set JLabel position
        labelWelcome.setFont(fHead);
        add(labelWelcome);

        labelfill = new JLabel("Please fill your infomations.");
        labelfill.setBounds(215, -160, frameWidth, frameHeight);
        labelfill.setFont(fHead2);
        add(labelfill);

        labelName = new JLabel("Username: ");
        labelName.setBounds(215, -120, frameWidth, frameHeight);
        labelName.setFont(f);
        add(labelName);

        fillName = new JTextField(7);
        fillName.setBounds(280, 110, 100, 20);
        fillName.setFont(f);
        add(fillName);

        labelAge = new JLabel("Age: ");
        labelAge.setBounds(235, -90, frameWidth, frameHeight);
        labelAge.setFont(f);
        add(labelAge);


        fillAge = new JTextField(7);
        fillAge.setBounds(280, 140, 100, 20);
        fillAge.setFont(f);
        add(fillAge);

        labelGender = new JLabel("Gender: ");
        labelGender.setBounds(220, -60, frameWidth, frameHeight);
        labelGender.setFont(f);
        add(labelGender);

        choiceMale = new JCheckBox("Male");
        choiceMale.setBounds(280, 170, 59, 18);
        choiceMale.setFont(f);
        add(choiceMale);

        choiceFemale = new JCheckBox("Female");
        choiceFemale.setBounds(340, 168, 98, 25);
        choiceFemale.setFont(f);
        add(choiceFemale);

        labelWeight = new JLabel("Weight(kg): ");
        labelWeight.setBounds(210, -30, frameWidth, frameHeight);
        labelWeight.setFont(f);
        add(labelWeight);

        fillWeight = new JTextField(7);
        fillWeight.setBounds(280, 200, 100, 20);
        fillWeight.setFont(f);
        add(fillWeight);

        labelHeight = new JLabel("Height(cm): ");
        labelHeight.setBounds(210, 0, frameWidth, frameHeight);
        labelHeight.setFont(f);
        add(labelHeight);

        fillHeight = new JTextField(7);
        fillHeight.setBounds(280, 230, 100, 20);
        fillHeight.setFont(f);
        add(fillHeight);

        buttonNext = new JButton("Next");
        buttonNext.setBounds(220, 270, 60, 20);
        buttonNext.setFont(f);
        add(buttonNext);

        buttonExit = new JButton("Exit");
        buttonExit.setBounds(300, 270, 70, 20);
        buttonExit.setFont(f);
        add(buttonExit);

        buttonNext.addActionListener(this);
        buttonExit.addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("Next")){
            UserInfo u1 = new UserInfo();
            try
            {
                u1.setName(fillName.getText());
                u1.setAge(Integer.parseInt(fillAge.getText()));
                u1.setWeight(Double.parseDouble(fillWeight.getText()));
                u1.setHeight(Double.parseDouble(fillHeight.getText()));
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "The infomation is incorrect, must be a number.");
            }    
            if(choiceMale.isSelected() && choiceFemale.isSelected()){
                JOptionPane.showMessageDialog(null, "Please choose your gender only one.");
            }
            else if(choiceMale.isSelected()){
                u1.setGender("Male");
                if(u1.getAge() != 0 && u1.getWeight() != 0 && u1.getHeight() != 0){
                    if(u1.calculateBMI() < 18.5){
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Underweight.\n\n"+ "Recommend: Doing Weight training to increase mass and consume more proteins.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRmale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                    else if(u1.calculateBMI() >= 18. && u1.calculateBMI() <= 24.9){
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Normal weight.\n\n"+ "Recommend: Doing some Cardio to maintain your body.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRmale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                    else if(u1.calculateBMI() >= 25 && u1.calculateBMI() <= 29.9){
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Overweight.\n\n"+ "Recommend: Doing Cardio and Weigh training to increase mass, avoid high fat dish and consume more proteins.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRmale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Obesity.\n\n"+ "Recommend: Doing Cardio and Weigh training to increase mass, avoid high fat dish and consume more proteins.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRmale())+ "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill your infomation correctly.");
                }
            }
            else if(choiceFemale.isSelected()){
                u1.setGender("Female");
                if(u1.getAge() != 0 && u1.getWeight() != 0 && u1.getHeight() != 0){
                    if(u1.calculateBMI() < 18.5){
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Underweight.\n\n"+ "Recommend: Doing Weight training to increase mass and consume more proteins.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRfemale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                    else if(u1.calculateBMI() >= 18. && u1.calculateBMI() <= 24.9){
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Normal weight.\n\n"+ "Recommend: Doing some Cardio to maintain your body.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRfemale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                    else if(u1.calculateBMI() >= 25 && u1.calculateBMI() <= 29.9){
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Overweight.\n\n"+ "Recommend: Doing Cardio and Weigh training to increase mass, avoid high fat dish and consume more proteins.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRfemale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "The BMI is " + String.format("%.2f", u1.calculateBMI()) + "\n" + "You're Obesity.\n\n"+ "Recommend: Doing Cardio and Weigh training to increase mass, avoid high fat dish and consume more proteins.\n\n" + "The Calories you require per day is " + String.format("%.2f", u1.calculateBMRfemale()) + "\n" + "Amount of water you require per day is " + u1.calculateWater() + " L");
                        
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill the infomation correctly.");
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select a gender.");
            }
        }       
        if(event.getActionCommand().equals("Exit")){
            System.exit(0);
        }        
    }

    public static void main(String[] args) throws Exception {
        new App().setVisible(true);
    }
}
