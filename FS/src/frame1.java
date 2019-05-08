import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frame1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 492, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName : ");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblUsername.setBounds(107, 145, 111, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblPassword.setBounds(107, 190, 111, 21);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(228, 147, 129, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 191, 129, 24);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(245, 245, 245));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value1=textField.getText();
				String value2=passwordField.getText();
				if (value1.equals("Rakshita38") && value2.equals("raku")) {
				frame2 frame=new frame2();
				frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect login or password",
							   "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(180, 236, 105, 35);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblImplementationOfBuffer = new JLabel("Implementation of Buffer Management ");
		lblImplementationOfBuffer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblImplementationOfBuffer.setBounds(68, 40, 365, 58);
		frame.getContentPane().add(lblImplementationOfBuffer);
		
		JLabel lblOnTextbookObjects = new JLabel("on TextBook Objects");
		lblOnTextbookObjects.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblOnTextbookObjects.setBounds(140, 76, 190, 58);
		frame.getContentPane().add(lblOnTextbookObjects);
	
	}
}
