package UI01.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class StockCartFrame extends JInternalFrame {
	private JTextField txtStockCode;
	private JTextField txtStockName;
	private JTextField txtBarcode;
	private JTextField txtCreationDate;
	private JComboBox cmbStockType;
	private JComboBox cmbUnit;
	private JComboBox cmbTaxType;
	private JTextArea txtaDescription;
	private JButton btnFirst;	
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnCopy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockCartFrame frame = new StockCartFrame();
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
	public StockCartFrame() {
		setTitle("Stok Kartı");
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 570, 300);
		getContentPane().setLayout(null);
		
		btnFirst = new JButton("|<");
		btnFirst.setBounds(10, 11, 66, 23);
		getContentPane().add(btnFirst);
		
		btnPrevious = new JButton("<");
		btnPrevious.setBounds(86, 11, 66, 23);
		getContentPane().add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.setBounds(162, 11, 66, 23);
		getContentPane().add(btnNext);
		
		btnLast = new JButton(">|");
		btnLast.setBounds(238, 11, 66, 23);
		getContentPane().add(btnLast);
		
		btnSave = new JButton("Kaydet");
		btnSave.setBounds(317, 11, 66, 23);
		getContentPane().add(btnSave);
		
		btnDelete = new JButton("Sil");
		btnDelete.setBounds(395, 11, 66, 23);
		getContentPane().add(btnDelete);
		
		btnCopy = new JButton("Kopyala");
		btnCopy.setBounds(471, 11, 66, 23);
		getContentPane().add(btnCopy);
		
		txtStockCode = new JTextField();
		txtStockCode.setBounds(86, 65, 175, 20);
		getContentPane().add(txtStockCode);
		txtStockCode.setColumns(10);
		
		txtStockName = new JTextField();
		txtStockName.setColumns(10);
		txtStockName.setBounds(86, 90, 175, 20);
		getContentPane().add(txtStockName);
		
		txtBarcode = new JTextField();
		txtBarcode.setColumns(10);
		txtBarcode.setBounds(349, 65, 175, 20);
		getContentPane().add(txtBarcode);
		
		txtCreationDate = new JTextField();
		txtCreationDate.setColumns(10);
		txtCreationDate.setBounds(349, 117, 175, 20);
		getContentPane().add(txtCreationDate);
		
		cmbStockType = new JComboBox();
		cmbStockType.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cmbStockType.setBounds(86, 114, 175, 22);
		getContentPane().add(cmbStockType);
		
		cmbUnit = new JComboBox();
		cmbUnit.setModel(new DefaultComboBoxModel(new String[] {"İç", "Dış"}));
		cmbUnit.setBounds(86, 141, 175, 22);
		getContentPane().add(cmbUnit);
		
		cmbTaxType = new JComboBox();
		cmbTaxType.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cmbTaxType.setBounds(349, 91, 175, 22);
		getContentPane().add(cmbTaxType);
		
		txtaDescription = new JTextArea();
		txtaDescription.setBounds(349, 145, 175, 95);
		getContentPane().add(txtaDescription);

		JLabel lblStockCode = new JLabel("Stok Kodu");
		lblStockCode.setBounds(31, 68, 46, 14);
		getContentPane().add(lblStockCode);
		
		JLabel lblStockName = new JLabel("Stok Adı");
		lblStockName.setBounds(30, 93, 46, 14);
		getContentPane().add(lblStockName);
		
		JLabel lblStockType = new JLabel("Stok Tipi");
		lblStockType.setBounds(30, 118, 46, 14);
		getContentPane().add(lblStockType);
		
		JLabel lblUnit = new JLabel("Birimi");
		lblUnit.setBounds(30, 145, 46, 14);
		getContentPane().add(lblUnit);
		
		JLabel lblBarcode = new JLabel("Barkod");
		lblBarcode.setBounds(290, 68, 46, 14);
		getContentPane().add(lblBarcode);
		
		JLabel lblTaxType = new JLabel("Vergi Tipi");
		lblTaxType.setBounds(290, 93, 46, 14);
		getContentPane().add(lblTaxType);
		
		JLabel lblCreationDate = new JLabel("Oluşturulma Tarihi");
		lblCreationDate.setBounds(290, 118, 46, 14);
		getContentPane().add(lblCreationDate);
		
		JLabel lblDescription = new JLabel("Açıklama");
		lblDescription.setBounds(290, 145, 46, 14);
		getContentPane().add(lblDescription);
		
	}
	
	public JTextField getTxtStockCode() {
		return txtStockCode;
	}

	public void setTxtStockCode(JTextField txtStockCode) {
		this.txtStockCode = txtStockCode;
	}

	public JTextField getTxtStockName() {
		return txtStockName;
	}

	public void setTxtStockName(JTextField txtStockName) {
		this.txtStockName = txtStockName;
	}

	public JTextField getTxtBarcode() {
		return txtBarcode;
	}

	public void setTxtBarcode(JTextField txtBarcode) {
		this.txtBarcode = txtBarcode;
	}

	public JTextField getTxtCreationDate() {
		return txtCreationDate;
	}

	public void setTxtCreationDate(JTextField txtCreationDate) {
		this.txtCreationDate = txtCreationDate;
	}

	public JComboBox getCmbStockType() {
		return cmbStockType;
	}

	public void setCmbStockType(JComboBox cmbStockType) {
		this.cmbStockType = cmbStockType;
	}

	public JComboBox getCmbUnit() {
		return cmbUnit;
	}

	public void setCmbUnit(JComboBox cmbUnit) {
		this.cmbUnit = cmbUnit;
	}

	public JComboBox getCmbTaxType() {
		return cmbTaxType;
	}

	public void setCmbTaxType(JComboBox cmbTaxType) {
		this.cmbTaxType = cmbTaxType;
	}

	public JTextArea getTxtaDescription() {
		return txtaDescription;
	}

	public void setTxtaDescription(JTextArea txtaDescription) {
		this.txtaDescription = txtaDescription;
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}
	
	public JButton getBtnCopy() {
		return btnCopy;
	}
}
