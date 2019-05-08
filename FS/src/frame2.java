import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextbookObjects = new JLabel("Textbook Objects");
		lblTextbookObjects.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTextbookObjects.setBounds(139, 82, 212, 31);
		contentPane.add(lblTextbookObjects);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBackground(new Color(245, 245, 245));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create frame=new create();
				frame.setVisible(true);
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCreate.setBounds(80, 144, 106, 35);
		contentPane.add(btnCreate);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBackground(new Color(245, 245, 245));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display2 framed=new display2();
				framed.setVisible(true);
			}
		});
		btnDisplay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDisplay.setBounds(277, 144, 112, 35);
		contentPane.add(btnDisplay);
		
		JButton btnModify = new JButton("DELETE");
		btnModify.setBackground(new Color(245, 245, 245));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify framem=new modify();
				framem.setVisible(true);
			}
		});
		btnModify.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnModify.setBounds(80, 219, 106, 35);
		contentPane.add(btnModify);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(245, 245, 245));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search frames=new search();
				frames.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBounds(277, 219, 112, 35);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBackground(new Color(220, 220, 220));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnBack.setBounds(205, 292, 72, 21);
		contentPane.add(btnBack);
		
	}
}

