import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.Color;
import java.io.RandomAccessFile;
import javax.swing.JScrollPane;

public class search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
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
	public search() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSerachingOfRecord = new JLabel("Seraching of Record");
		lblSerachingOfRecord.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblSerachingOfRecord.setBounds(125, 21, 308, 34);
		contentPane.add(lblSerachingOfRecord);
		
		JLabel lblNewLabel = new JLabel("Enter TextBook ID to search :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(27, 79, 233, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(270, 84, 173, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(245, 245, 245));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter TextbookID to search..");
				}
				else {
					SearchActionPerformed(e);
				}
					
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSearch.setBounds(337, 124, 106, 28);
		contentPane.add(btnSearch);
		
		JLabel lblTheRecordDetails = new JLabel("The Record Details ");
		lblTheRecordDetails.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTheRecordDetails.setBounds(58, 175, 173, 28);
		contentPane.add(lblTheRecordDetails);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(183, 323, 97, 28);
		contentPane.add(btnBack);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(1, 1, 1), 1));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TextBookID", "Name", "Publication", "Author", "Copies", "Semester"
			}
		));
		table.setBounds(6, 206, 460, 82);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 206, 460, 82);
		contentPane.add(scrollPane);
	}
	private void SearchActionPerformed(java.awt.event.ActionEvent e) {
		boolean flag=true;
		File file = new File("src/Files/textbook_Variable.txt");
		String s_id = textField.getText();
		try
		{
			FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            //Object[] lines = br.lines().toArray();
            String line = br.readLine();
            while(line!=null) {
            if(line.startsWith(s_id)) {
            	
            	String[] row = line.toString().split(" | ");
            	row[0]=row[0];
                row[1]=row[2];
                row[2]=row[4];
                row[3]=row[6];
                row[4]=row[8];
                row[5]=row[10];
            	model.addRow(row);
            	flag=false;
            }
           
            line = br.readLine();
            }
            br.close();
            if(flag==true) {
            	JOptionPane.showMessageDialog(null, "Record not Found!!");
            }
		}
		catch(Exception eop) {
			
		}
		
	}
}

