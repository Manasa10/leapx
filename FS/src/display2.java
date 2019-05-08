import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

//import display2.book;

//import display.book;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class display2 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display2 frame = new display2();
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
	public display2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 542, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		table.setBounds(10, 79, 507, 160);
		contentPane.add(table);
		
		JLabel lblTextbooksRecord = new JLabel("TextBooks Record");
		lblTextbooksRecord.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblTextbooksRecord.setBounds(162, 27, 210, 28);
		contentPane.add(lblTextbooksRecord);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBackground(new Color(245, 245, 245));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayActionPerformed(e);
			}
		});
		btnDisplay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDisplay.setBounds(110, 270, 95, 28);
		contentPane.add(btnDisplay);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(283, 270, 95, 28);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 506, 160);
		contentPane.add(scrollPane);
	}
	private void DisplayActionPerformed(java.awt.event.ActionEvent e) {
		
		File file = new File("src/Files/textbook_Variable.txt");
        
        try {
        	//int j=0,k=0;
        	//String[] row1 = {"","","","","",""};
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object[] lines = br.lines().toArray();
           // String[] lines = br.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
               String[] row = lines[i].toString().split(" | ");
               row[0]=row[0];
               row[1]=row[2];
               row[2]=row[4];
               row[3]=row[6];
               row[4]=row[8];
               row[5]=row[10];
//               String id = row[0];
//               String name = row[2];
//               String pub = row[4];
//               String auth = row[6];
//               String cop = row[8];
//               String sem = row[10];
         
//               while(j<lines.length) {
//            	   if(row[j]!="|") {
//            		   
//            		    row1[k] = row[j];
//            		    k++;
//            	   }
//            	   else
//            		   break;
//            	   j++;
//               }
                model.addRow(row);
                br.close();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(display2.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException io) {
        	
        }
        
        }
       
	}
		

