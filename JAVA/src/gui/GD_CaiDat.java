package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_CaiDat extends JFrame {

	private JPanel contentPane;
	private JTextField txtF;
	private JTextField txtEnter;
	private JTextField txtDelete;
	private JTextField txtEsc;
	private JTextField txtCrtls;
	private JTextField txtF_1;
	private JTextField txtF_2;
	private JTextField txtHome;

	/**
	 * Launch the application.
	 */
	public static void CDScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 GD_CaiDat window = new  GD_CaiDat();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GD_CaiDat() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 553);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(10, 10, 777, 496);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thanh to\u00E1n");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 77, 179, 74);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 151, 179, 74);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("X\u00F3a");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 232, 179, 74);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tho\u00E1t");
		lblNewLabel_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 308, 179, 74);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Trang ch\u1EE7");
		lblNewLabel_1_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(374, 308, 179, 74);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("L\u00E0m m\u1EDBi");
		lblNewLabel_1_1_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(374, 232, 179, 74);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Th\u00EAm");
		lblNewLabel_1_1_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1.setBounds(374, 151, 179, 74);
		panel.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("L\u01B0u");
		lblNewLabel_1_1_1_2_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1_1.setBounds(374, 77, 179, 74);
		panel.add(lblNewLabel_1_1_1_2_1_1);
		
		txtF = new JTextField();
		txtF.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtF.setForeground(new Color(255, 255, 255));
		txtF.setText("F9");
		txtF.setHorizontalAlignment(SwingConstants.CENTER);
		txtF.setBackground(new Color(0, 0, 0));
		txtF.setBounds(178, 93, 186, 42);
		panel.add(txtF);
		txtF.setColumns(10);
		
		txtEnter = new JTextField();
		txtEnter.setText("ENTER");
		txtEnter.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnter.setForeground(Color.WHITE);
		txtEnter.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEnter.setColumns(10);
		txtEnter.setBackground(Color.BLACK);
		txtEnter.setBounds(178, 161, 186, 42);
		panel.add(txtEnter);
		
		txtDelete = new JTextField();
		txtDelete.setText("F3");
		txtDelete.setHorizontalAlignment(SwingConstants.CENTER);
		txtDelete.setForeground(Color.WHITE);
		txtDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDelete.setColumns(10);
		txtDelete.setBackground(Color.BLACK);
		txtDelete.setBounds(178, 244, 186, 42);
		panel.add(txtDelete);
		
		txtEsc = new JTextField();
		txtEsc.setText("Esc");
		txtEsc.setHorizontalAlignment(SwingConstants.CENTER);
		txtEsc.setForeground(Color.WHITE);
		txtEsc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEsc.setColumns(10);
		txtEsc.setBackground(Color.BLACK);
		txtEsc.setBounds(178, 316, 186, 42);
		panel.add(txtEsc);
		
		txtCrtls = new JTextField();
		txtCrtls.setText("F4");
		txtCrtls.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrtls.setForeground(Color.WHITE);
		txtCrtls.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCrtls.setColumns(10);
		txtCrtls.setBackground(Color.BLACK);
		txtCrtls.setBounds(540, 93, 186, 42);
		panel.add(txtCrtls);
		
		txtF_1 = new JTextField();
		txtF_1.setText("F5");
		txtF_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtF_1.setForeground(Color.WHITE);
		txtF_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtF_1.setColumns(10);
		txtF_1.setBackground(Color.BLACK);
		txtF_1.setBounds(540, 170, 186, 42);
		panel.add(txtF_1);
		
		txtF_2 = new JTextField();
		txtF_2.setText("F6");
		txtF_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtF_2.setForeground(Color.WHITE);
		txtF_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtF_2.setColumns(10);
		txtF_2.setBackground(Color.BLACK);
		txtF_2.setBounds(540, 244, 186, 42);
		panel.add(txtF_2);
		
		txtHome = new JTextField();
		txtHome.setText("Home");
		txtHome.setHorizontalAlignment(SwingConstants.CENTER);
		txtHome.setForeground(Color.WHITE);
		txtHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtHome.setColumns(10);
		txtHome.setBackground(Color.BLACK);
		txtHome.setBounds(540, 316, 186, 42);
		panel.add(txtHome);
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Lưu cài đặt thành công!!");
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(SystemColor.controlLtHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(301, 424, 166, 42);
		panel.add(btnNewButton);
	}
}
