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
import java.io.File;
import java.awt.Color;


public class modify extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modify frame = new modify();
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
	public modify() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeletionOfRecord = new JLabel("Deletion of Record");
		lblDeletionOfRecord.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblDeletionOfRecord.setBounds(141, 28, 271, 37);
		contentPane.add(lblDeletionOfRecord);
		
		JLabel lblEnterTextbookId = new JLabel("Enter TextBook ID to delete :");
		lblEnterTextbookId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterTextbookId.setBounds(53, 94, 367, 26);
		contentPane.add(lblEnterTextbookId);
		
		textField = new JTextField();
		textField.setBounds(293, 94, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(245, 245, 245));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter textbookID to delete..");
				}
				else {
					SubmitActionPerformed(e);
				}
					
				
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSubmit.setBounds(119, 143, 105, 31);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(272, 143, 96, 31);
		contentPane.add(btnNewButton);
	}
	private void SubmitActionPerformed_F(ActionEvent e) {
		try {
			
			File infile = new File("src/Files/textbook_Fixed.txt");
			File tempfile = new File("src/Files/textbook_Fixed1.txt");
		BufferedReader br = new BufferedReader(new FileReader(infile));
		BufferedWriter wr = new BufferedWriter(new FileWriter(tempfile));
		String toRemove = textField.getText();
		String line = null;
		while((line = br.readLine()) != null) {
			if (line.startsWith(toRemove)) {
					
					continue;
			}
				wr.write(line);
				wr.newLine();
		        wr.flush();
			}
		br.close();
		wr.close();
		if(!infile.delete()) {
			System.out.println("caonnot delete file..");
			return;
		}
		if(!tempfile.renameTo(infile)) {
			System.out.println("cannot rename file..");
			return;
		}
		}
		catch(Exception eop) {
			eop.printStackTrace();
		}

	}
	private void SubmitActionPerformed(ActionEvent e) {
		try {
			boolean flag=false;
			File infile = new File("src/Files/textbook_Variable.txt");
			File tempfile = new File("src/Files/textbook_Variable1.txt");
		BufferedReader br = new BufferedReader(new FileReader(infile));
		BufferedWriter wr = new BufferedWriter(new FileWriter(tempfile));
		String toRemove = textField.getText();
		String line = null;
		while((line = br.readLine()) != null) {
			if (line.startsWith(toRemove)) {
					flag=true;
					continue;
			}
				wr.write(line);
				wr.newLine();
		        wr.flush();
			}
		if(flag==false) {
			JOptionPane.showMessageDialog(null, "Record Not Found!!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!");
			SubmitActionPerformed_F(e);
		}
		
		br.close();
		wr.close();
		if(!infile.delete()) {
			System.out.println("caonnot delete file..");
			return;
		}
		if(!tempfile.renameTo(infile)) {
			System.out.println("cannot rename file..");
			return;
		}
		}
		catch(Exception eop) {
			eop.printStackTrace();
		}

	}
}
