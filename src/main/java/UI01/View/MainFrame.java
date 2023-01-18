package UI01.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JInternalFrame jif;
	private JMenuItem stockCart;
	private JMenuItem stockCartList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu stock = new JMenu("Stok");
		menuBar.add(stock);
		
		stockCart = new JMenuItem("Stok Kartı");
		stock.add(stockCart);
		
		stockCartList = new JMenuItem("Stok Kartı Listesi");
		stock.add(stockCartList);	

	}
	
	public void setInternalFrame(JInternalFrame jif) {
		this.jif = jif;
	}
	
	public JInternalFrame getInternalFrame() {
		return this.jif;
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public JMenuItem getStockCart() {
		return this.stockCart;
	}
	
	public JMenuItem getStockCartList() {
		return this.stockCartList;
	}
	
}
