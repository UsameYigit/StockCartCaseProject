package UI01.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JButton;

public class StockCartListFrame extends JInternalFrame {
	private JTable tblStockCartList;
	private JButton btnSearch;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockCartListFrame frame = new StockCartListFrame();
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
	public StockCartListFrame() {
		setTitle("Stok Kartı Listesi");
		setClosable(true);
		setBounds(100, 100, 575, 300);
		getContentPane().setLayout(null);
		
		tblStockCartList = new JTable();
		tblStockCartList.setBounds(10, 11, 375, 248);
		getContentPane().add(tblStockCartList);
		
		btnSearch = new JButton("Ara");
		btnSearch.setBounds(440, 7, 89, 23);
		getContentPane().add(btnSearch);

	}
	
	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JTable getTblStockCartList() {
		return tblStockCartList;
	}

	public void setTblStockCartList(JTable tblStockCartList) {
		this.tblStockCartList = tblStockCartList;
	}
}
