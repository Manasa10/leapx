import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.Color;

public class create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create frame = new create();
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
	public create() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertionOfRecord = new JLabel("Insertion of  Record");
		lblInsertionOfRecord.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblInsertionOfRecord.setBounds(143, 23, 276, 32);
		contentPane.add(lblInsertionOfRecord);
		
		JLabel lblTextbookId = new JLabel("TextBook ID :");
		lblTextbookId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTextbookId.setBounds(43, 85, 110, 23);
		contentPane.add(lblTextbookId);
		
		textField = new JTextField();
		textField.setBounds(180, 85, 226, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTextbookName = new JLabel("Name :");
		lblTextbookName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTextbookName.setBounds(43, 128, 127, 23);
		contentPane.add(lblTextbookName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 128, 226, 25);
		contentPane.add(textField_1);
		
		JLabel lblPublication = new JLabel("Publication :");
		lblPublication.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPublication.setBounds(43, 168, 127, 23);
		contentPane.add(lblPublication);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 171, 226, 25);
		contentPane.add(textField_2);
		
		JLabel lblAuthorName = new JLabel("Author Name :");
		lblAuthorName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAuthorName.setBounds(43, 210, 127, 23);
		contentPane.add(lblAuthorName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 213, 226, 25);
		contentPane.add(textField_3);
		
		JLabel lblNoOfCopies = new JLabel("No of Copies :");
		lblNoOfCopies.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNoOfCopies.setBounds(43, 253, 127, 23);
		contentPane.add(lblNoOfCopies);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 254, 226, 25);
		contentPane.add(textField_4);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(220, 220, 220));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Insert all records...");
				}
				else {
					JButtonActionPerformedFixed(e);
					JButtonActionPerformedVariable(e);
					JOptionPane.showMessageDialog(null, "Records Successfully Inserted!!");
				}
			}
				
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSubmit.setBounds(109, 348, 110, 32);
		contentPane.add(btnSubmit);
		
		JLabel lblSemester = new JLabel("Semester :");
		lblSemester.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSemester.setBounds(43, 294, 127, 23);
		contentPane.add(lblSemester);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(180, 297, 226, 25);
		contentPane.add(textField_5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(220, 220, 220));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(251, 348, 110, 32);
		contentPane.add(btnBack);
	}
	private void JButtonActionPerformedFixed(ActionEvent e) {
		/*String id,name,publication,author,copies,sem;
		id=textField.getText();
		name=textField_1.getText();
		publication=textField_2.getText();
		author=textField_3.getText();
		copies=textField_4.getText();
		sem=textField_5.getText();
		*/
		BufferedWriter out = null;
		String str = this.pack(this);
		try{
			FileWriter fstream = new FileWriter("src/Files/textbook_Fixed.txt", true); 
			out = new BufferedWriter(fstream);
			out.write(str);
			out.newLine();
			//out.write("\n");
			out.close();
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
	public String pack(create book){
		String packed = book.textField.getText() +" | "+  book.textField_1.getText() +" | "+ book.textField_2.getText() +" | "+ book.textField_3.getText() +" | "+ book.textField_4.getText() +" | "+ book.textField_5.getText();
		int len = packed.length();
	    if(len<70){
	    	packed = packed + " | ";
	    	while(packed.length()<=69)
	    		packed = packed + "$";
	    }
		return packed;
	}
	private void JButtonActionPerformedVariable(ActionEvent e) {
		/*String id,name,publication,author,copies,sem;
		id=textField.getText();
		name=textField_1.getText();
		publication=textField_2.getText();
		author=textField_3.getText();
		copies=textField_4.getText();
		sem=textField_5.getText();
		*/
		BufferedWriter out = null;
		String str = this.pack1(this);
		try{
			FileWriter fstream = new FileWriter("src/Files/textbook_Variable.txt", true); 
			out = new BufferedWriter(fstream);
			out.write(str);
			out.newLine();
			//out.write("\n");
			out.close();
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
	public String pack1(create book){
		String packed = book.textField.getText() +" | "+  book.textField_1.getText() +" | "+ book.textField_2.getText() +" | "+ book.textField_3.getText() +" | "+ book.textField_4.getText() +" | "+ book.textField_5.getText();
		packed+=" | "+(book.textField.getText().length()+book.textField_1.getText().length()+book.textField_2.getText().length()+book.textField_3.getText().length()+book.textField_4.getText().length()+book.textField_5.getText().length());
		return packed;
	}
	
}
