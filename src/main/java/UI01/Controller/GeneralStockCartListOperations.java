package UI01.Controller;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
		dtm.addColumn("Birim");
		dtm.addColumn("Barkod");
		dtm.addColumn("Oluşturma Tarihi");
		dtm.addColumn("Açıklama");
		dtm.addColumn("Stok Tipi Idsi");
		dtm.addColumn("Stok Tipi Kodu");
		dtm.addColumn("Stok Tipi Adı");
		dtm.addColumn("Stok Tipi Oranı");
		dtm.addColumn("KDV Tipi Idsi");
		dtm.addColumn("KDV Tipi Kodu");
		dtm.addColumn("KDV Tipi Adı");
		dtm.addColumn("KDV Tipi Açıklama");
		
		Object[] row = new Object[14];
	
		for(int i = 0; i<stockCartList.size(); i++) {
			
			row[0] = stockCartList.get(i).getStockCode();
			row[1] = stockCartList.get(i).getStockName();
			row[2] = stockCartList.get(i).getUnit();
			row[3] = stockCartList.get(i).getBarcode();
			row[4] = stockCartList.get(i).getCreationDate();
			row[5] = stockCartList.get(i).getDescription();
			row[6] = stockCartList.get(i).getStockType().getId();
			row[7] = stockCartList.get(i).getStockType().getCode();
			row[8] = stockCartList.get(i).getStockType().getName();
			row[9] = stockCartList.get(i).getStockType().getRating();
			row[10] = stockCartList.get(i).getTaxType().getId();
			row[11] = stockCartList.get(i).getTaxType().getCode();
			row[12] = stockCartList.get(i).getTaxType().getName();
			row[13] = stockCartList.get(i).getTaxType().getDescription();
			
			dtm.addRow(row);
		}
		stockCartListFrame.getTblStockCartList().setModel(dtm);
	}
	
	public void openPopUpMenu(MouseEvent e) {
		int row = stockCartListFrame.getTblStockCartList().rowAtPoint( e.getPoint() );
		stockCartListFrame.getTblStockCartList().changeSelection( row, 0, false, false );
		
		StockCart sc = setSelectedStockCart();
		
		stockCartListFrame.getPopupMenu().show(e.getComponent(), e.getX(), e.getY());
	}
	
	public void exportStockCartListToExcel(){
		JFileChooser fchoose = new JFileChooser();
		int option = fchoose.showSaveDialog(stockCartListFrame);
    	if(option == JFileChooser.APPROVE_OPTION){
			String name = fchoose.getSelectedFile().getName(); 
			String path = fchoose.getSelectedFile().getParentFile().getPath();
			String file = path + "\\" + name + ".xls"; 
			export(stockCartListFrame.getTblStockCartList(), new File(file));

	        try {
	        	Desktop.getDesktop().open(new File(file));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
	}
	
	public void export(JTable table, File file){
		try{
			TableModel model = table.getModel();
			FileWriter fw = new FileWriter(file);
			for(int i = 0; i < model.getColumnCount(); i++){
				fw.write(model.getColumnName(i) + "\t");
			}
			fw.write("\n");
			for(int i=0; i < model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					fw.write(model.getValueAt(i,j).toString()+"\t");
				}
				fw.write("\n");
			}
			fw.close();
		}
		catch(IOException e){ 
			System.out.println(e); 
		}
	}
	
	public StockCart setSelectedStockCart() {
		return stockCartService.getByStockCode(stockCartListFrame.getTblStockCartList().getValueAt(stockCartListFrame.getTblStockCartList().getSelectedRow(), 0).toString());
	}
	
}
