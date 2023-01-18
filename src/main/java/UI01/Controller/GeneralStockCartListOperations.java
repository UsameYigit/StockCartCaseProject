package UI01.Controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Business.Abstract.IStockCartService;
import Entity.StockCart;
import UI01.View.StockCartListFrame;

public class GeneralStockCartListOperations {
	private StockCartListFrame stockCartListFrame;
	private IStockCartService stockCartService;
	
	public GeneralStockCartListOperations(StockCartListFrame stockCartListFrame, IStockCartService stockCartService) {
		this.stockCartListFrame = stockCartListFrame;
		this.stockCartService = stockCartService;
	}
	
	public void getAllStockCartsToTable() {
		ArrayList<StockCart> stockCartList = stockCartService.getAll();
		DefaultTableModel dtm = new DefaultTableModel();
		
		dtm.addColumn("Stok Kartı");
		dtm.addColumn("Stok Adı");
		dtm.addColumn("Barkod");
		dtm.addColumn("KDV Tipi");
		
		Object[] row = new Object[4];
	
		for(int i = 0; i<stockCartList.size(); i++) {
			row[0] = stockCartList.get(i).getStockCode();
			row[1] = stockCartList.get(i).getStockName();
			row[2] = stockCartList.get(i).getBarcode();
			row[3] = stockCartList.get(i).getTaxType();
			dtm.addRow(row);
		}
		stockCartListFrame.getTblStockCartList().setModel(dtm);
	}
	
	public void getAllStockCartsToTable1() {
		ArrayList<StockCart> stockCartList = stockCartService.getAll();
		DefaultTableModel dtm = (DefaultTableModel) stockCartListFrame.getTblStockCartList().getModel();
		
		dtm.addColumn("Stok Kartı");
		dtm.addColumn("Stok Adı");
		dtm.addColumn("Barkod");
		dtm.addColumn("KDV Tipi");
		
		Object[] row = new Object[4];
	
		for(int i = 0; i<stockCartList.size(); i++) {
			row[0] = stockCartList.get(i).getStockCode();
			row[1] = stockCartList.get(i).getStockName();
			row[2] = stockCartList.get(i).getBarcode();
			row[3] = stockCartList.get(i).getTaxType();
			dtm.addRow(row);
		}
		stockCartListFrame.getTblStockCartList().setModel(dtm);
	}
	
}
