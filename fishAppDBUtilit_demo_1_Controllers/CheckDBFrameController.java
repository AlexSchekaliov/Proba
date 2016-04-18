package fishAppDBUtilit_demo_1_Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import fishAppDBUtilit_demo_1_Models.CheckDBFrameModel;
import fishAppSql.SqlConnectSingleton;
import fishAppUtilitMVC_demo_1_Viewes.CheckDBFrameView;

public class CheckDBFrameController {

	private CheckDBFrameView view;
	private CheckDBFrameModel model;
	private final static Connection connection = SqlConnectSingleton.getInstance().getConnection();

	public CheckDBFrameController(CheckDBFrameView view, CheckDBFrameModel model) {
		this.view = view;
		this.model = model;
		view.addConnectDBListener(new ConnectListener());

	}

	class ConnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				connection.setCatalog((String) view.getCombobox().getSelectedItem());
			} catch (SQLException e1) {

				System.out.println("Не завелось!!!");
			}
			try (ResultSet resultSet = connection.prepareStatement("Select r.Название from dbo.Рыбы r")
					.executeQuery()) {

				while (resultSet.next()) {
					System.out.println(resultSet.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}

}
