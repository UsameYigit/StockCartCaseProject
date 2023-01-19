package UI01.View;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class StockCartListFrame extends JInternalFrame {
	private JTable tblStockCartList;
	
	private JMenuItem miStockCart;
	private JMenuItem miExcell;
	private JMenuItem miShow;
	private JMenuItem miEmail;
	private JPopupMenu popupMenu;

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
		setResizable(true);
		setTitle("Stok Kartı Listesi");
		setClosable(true);
		setBounds(100, 100, 990, 420);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 954, 366);
		getContentPane().add(scrollPane);
		
		tblStockCartList = new JTable();
		scrollPane.setViewportView(tblStockCartList);
		
		//Popup Menu
		miStockCart = new JMenuItem();
		miStockCart.setText("Stok Kartı");
		miExcell = new JMenuItem();
		miExcell.setText("Excell");
		miShow = new JMenuItem();
		miShow.setText("Önizleme");
		miEmail = new JMenuItem();
		miEmail.setText("e-Mail");
		
		popupMenu = new JPopupMenu();
		popupMenu.add(miStockCart);
		popupMenu.add(miExcell);
		popupMenu.add(miShow);
		popupMenu.add(miEmail);
		
	}
	
	public JMenuItem getMiStockCart() {
		return miStockCart;
	}

	public JMenuItem getMiExcell() {
		return miExcell;
	}

	public JMenuItem getMiShow() {
		return miShow;
	}

	public JMenuItem getMiEmail() {
		return miEmail;
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}



	public JTable getTblStockCartList() {
		return tblStockCartList;
	}

	public void setTblStockCartList(JTable tblStockCartList) {
		this.tblStockCartList = tblStockCartList;
	}
}
