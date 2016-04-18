package fishAppUtilitMVC_demo_1_Viewes;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fishAppDBUtilit_demo_1_Models.CheckDBFrameModel;

public class CheckDBFrameView extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox<String> comboBox;
	private JLabel lblNewLabel;
	private CheckDBFrameModel model;
	

	public CheckDBFrameView(CheckDBFrameModel model) {
		
		this.model= model;
		initialize();
		addListDBtoForm();
			
	}


	private void initialize() {
		setBounds(100, 100, 450, 212);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel(
				"<html>\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0438\u0437 \u0441\u043F\u0438\u0441\u043A\u0430<br> \u0431\u0430\u0437\u0443 \u0434\u043B\u044F \u043F\u043E\u0434\u043A\u043B\u044E\u0447\u0435\u043D\u0438\u044F</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(25, 32, 222, 40);
		getContentPane().add(lblNewLabel);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(315, 35, 93, 20);
		getContentPane().add(comboBox);

		btnNewButton = new JButton("\u041F\u043E\u0434\u043A\u043B\u044E\u0447\u0438\u0442\u044C\u0441\u044F");
		btnNewButton.setBounds(161, 140, 135, 23);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\u0412\u044B\u0439\u0442\u0438");
		btnNewButton_1.setBounds(319, 140, 89, 23);
		getContentPane().add(btnNewButton_1);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void addListDBtoForm(){
		
		for (String item : model.getListDB()) {	
			comboBox.addItem(item);
		}
	}
	
	public JComboBox<String> getCombobox(){
		
		return comboBox;
	}
	
	public void addConnectDBListener(ActionListener listenForConnectButton){
		
		btnNewButton.addActionListener(listenForConnectButton);
	}
}