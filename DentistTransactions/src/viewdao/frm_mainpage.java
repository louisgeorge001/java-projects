package viewdao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllerdao.dentist_informationcontroller;
import modeldao.dentist_information;
import modeldao.user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frm_mainpage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JTextField textField_2;
	private JLabel lblRubberColor;
	public JLabel lblHello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_mainpage frame = new frm_mainpage();
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
	public frm_mainpage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				retrievedata();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHello = new JLabel("Hello");
		lblHello.setBounds(918, 33, 70, 15);
		contentPane.add(lblHello);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 245, 706, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(162, 52, 128, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(109, 59, 70, 15);
		contentPane.add(lblDate);
		
		JLabel lblAmountpaid = new JLabel("Amountpaid");
		lblAmountpaid.setBounds(55, 100, 109, 15);
		contentPane.add(lblAmountpaid);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 93, 128, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 135, 128, 29);
		contentPane.add(textField_2);
		
		lblRubberColor = new JLabel("Rubber Color");
		lblRubberColor.setBounds(55, 142, 109, 15);
		contentPane.add(lblRubberColor);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adddentistinfo();
			}
		});
		btnAdd.setBounds(162, 176, 128, 39);
		contentPane.add(btnAdd);
		setLocationRelativeTo(null);
	}
	public void retrievedata()
	{
		dentist_informationcontroller d = new dentist_informationcontroller();
		dentist_information obj_dd = new dentist_information();
		boolean res = d.retrievedentist_information(obj_dd,table);
		if(res)
		{
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "FAIL");
		}
		
	}
	public void adddentistinfo()
	{
		String p_date = this.textField.getText();
		String p_ampaid = this.textField_1.getText();
		String p_rubcolor = this.textField_2.getText();
		
		dentist_informationcontroller d = new dentist_informationcontroller();
		dentist_information dd = new dentist_information();
		dd.setDate(p_date);
		dd.setAmpaid(p_ampaid);
		dd.setRubbercolor(p_rubcolor);
		
		int res = d.add_dentist_information(dd);
		if(res>0)
			JOptionPane.showMessageDialog(null, "Dentist information is successfully added!");
		else
			JOptionPane.showMessageDialog(null, "Insert error!");
	}
	public void viewdentistinfo()
	{
		
	}
}
