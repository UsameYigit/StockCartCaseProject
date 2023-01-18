package UI01.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

import Business.Abstract.IStockCartService;
import Business.Abstract.IStockTypeService;
import Business.Abstract.ITaxTypeService;
import Entity.StockCart;
import Entity.StockType;
import Entity.TaxType;
import UI01.View.StockCartFrame;

public class GeneralStockCartOperations {
	private StockCartFrame stockCartFrame;
	private IStockCartService stockCartService;
	private IStockTypeService stockTypeService;
	private ITaxTypeService taxTypeService;
	
	public GeneralStockCartOperations(StockCartFrame stockCartFrame, IStockCartService stockCartService, IStockTypeService stockTypeService, ITaxTypeService taxTypeService) {
		this.stockCartFrame = stockCartFrame;
		this.stockCartService = stockCartService;
		this.stockTypeService = stockTypeService;
		this.taxTypeService = taxTypeService;
	}
	
	public void addStockCart() {
		if(stockCartFrame.getTxtStockCode().getText().isEmpty() || 
				stockCartFrame.getTxtStockName().getText().isEmpty() || 
				stockCartFrame.getTxtBarcode().getText().isEmpty() || 
				stockCartFrame.getTxtCreationDate().getText().isEmpty() || 
				stockCartFrame.getTxtaDescription().getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Lütfen bütün alanları doldurunuz.");
		else {
			TaxType tt = taxTypeService.getById(Integer.parseInt(stockCartFrame.getCmbTaxType().getSelectedItem().toString()));
			StockType st = stockTypeService.getById(Integer.parseInt(stockCartFrame.getCmbStockType().getSelectedItem().toString()));
			
			StockCart sc = new StockCart(
					stockCartFrame.getTxtStockCode().getText(),
					stockCartFrame.getTxtStockName().getText(), 
					st,
					stockCartFrame.getCmbUnit().getSelectedItem().toString(),
					stockCartFrame.getTxtBarcode().getText(),
					tt,
					stockCartFrame.getTxtaDescription().getText(),
					LocalDateTime.now());
			
			if(doesExist(sc)) {
				stockCartService.update(sc);
				resetFields();
			}else {
				stockCartService.create(sc);
				resetFields();
			}
		}
			
	}
	
	public boolean doesExist(StockCart sc) {
		ArrayList<StockCart> al = stockCartService.getAll();
		for(int i = 0; i<al.size(); i++)
			if(al.get(i).getStockCode().equals(sc.getStockCode()))
				return true;
		return false;
	}
	
	public void deleteStockCart(){
		if(stockCartFrame.getTxtStockCode() != null) {
			StockCart sc = stockCartService.getByStockCode(stockCartFrame.getTxtStockCode().getText());
			if(sc != null) {
				stockCartService.delete(sc);
				resetFields();
			}else
				JOptionPane.showMessageDialog(null, "Böyle bir stok kartı zaten bulunmamaktadır.");
		}
	}
	
	public void copySelectedItem() {
		if(stockCartFrame.getTxtStockCode() != null) {
			UUID uuid = UUID.randomUUID();
			StockCart sc = stockCartService.getByStockCode(stockCartFrame.getTxtStockCode().getText());
			if(sc != null) {
				sc.setStockCode(uuid.toString().substring(0, 8));
				stockCartService.create(sc);
				resetFields();
			}else
				JOptionPane.showMessageDialog(null, "Böyle bir stok kartı bulunmamaktadır, kopyalanamaz.");
		}else
			JOptionPane.showMessageDialog(null, "Böyle bir stok kartı bulunmamaktadır, kopyalanamaz.");
	}
	
	public void searchStockCart() {
//		if(frame.getSearchPage().getTxtSearch().getText().isEmpty()) 
//			JOptionPane.showMessageDialog(null, "Lütfen arama alanını doldurunuz.");
//		else {
//			DefaultListModel stockCarts = new DefaultListModel();
//			String data = frame.getSearchPage().getTxtSearch().getText();
//			StockCart sc = stockCartService.getByStockCode(data);
//			if(sc != null)
//				stockCarts.addElement(sc.getStockCode());
//			else {
//				ArrayList<StockCart> al = stockCartService.getByBarcode(data);
//				if(!al.isEmpty())
//					for(int i = 0; i<al.size(); i++)
//						stockCarts.addElement(al.get(i).getStockCode());
//				else {
//					al = stockCartService.getByStockName(data);
//					if(!al.isEmpty())
//						for(int i = 0; i<al.size(); i++)
//							stockCarts.addElement(al.get(i).getStockCode());
//				}
//			}
//			
//			frame.getSearchPage().getListStockCarts().setModel(stockCarts);	
//		}
		
	}
	
	public void setSearchFields(){
//		if(frame.getSearchPage().getListStockCarts().getSelectedValue() != null) {
//			StockCart sc = stockCartService.getByStockCode(frame.getSearchPage().getListStockCarts().getSelectedValue().toString());
//			frame.getSearchPage().getTxtStockCode().setText(sc.getStockCode());
//			frame.getSearchPage().getTxtStockName().setText(sc.getStockName());
//			frame.getSearchPage().getTxtStockType().setText(sc.getStockType()+"");
//			frame.getSearchPage().getTxtUnit().setText(sc.getUnit());
//			frame.getSearchPage().getTxtBarcode().setText(sc.getBarcode());
//			frame.getSearchPage().getTxtTaxType().setText(sc.getTaxType()+"");
//			frame.getSearchPage().getFtxtDateCreated().setText(sc.getCreationDate().toString());
//			frame.getSearchPage().getTxtAreaDescription().setText(sc.getDescription());
//		}
	}
	
	public void setDeleteFields() {
//		if(frame.getDeletePage().getListStockCode().getSelectedValue() != null) {
//			StockCart sc = stockCartService.getByStockCode(frame.getDeletePage().getListStockCode().getSelectedValue().toString());
//			frame.getDeletePage().getTxtBarcode().setText(sc.getBarcode());
//			frame.getDeletePage().getTxtAreaDescription().setText(sc.getDescription());
//			frame.getDeletePage().getTxtCreationDate().setText(sc.getCreationDate().toString());
//		}
	}
	
	public void refreshLists() {
//		frame.getSearchPage().getListStockCarts().setModel(getStockCarts());
//		frame.getDeletePage().getListStockCode().setModel(getStockCarts());
//		initializeStockCode();
	}
	
//	private DefaultListModel getStockCarts() {
//		DefaultListModel stockCarts = new DefaultListModel();
//		ArrayList<StockCart> al = stockCartService.getAll();
//		for(int i = 0; i<al.size(); i++)
//			stockCarts.addElement(al.get(i).getStockCode());
//		return stockCarts;
//	}
	
//	private void initializeStockCode() {
//		frame.getUpdatePage().getCmbStockCode().removeAllItems();
//		ArrayList<StockCart> al = stockCartService.getAll();
//		if(al != null)
//			for(int i = 0; i<al.size(); i++)
//				frame.getUpdatePage().getCmbStockCode().addItem(al.get(i).getStockCode());
//	}
	
	private void resetFields() {
		stockCartFrame.getTxtStockCode().setText("");
		stockCartFrame.getTxtStockName().setText("");
		stockCartFrame.getCmbStockType().setSelectedIndex(0);
		stockCartFrame.getCmbUnit().setSelectedIndex(0);
		stockCartFrame.getTxtBarcode().setText("");
		stockCartFrame.getCmbTaxType().setSelectedIndex(0);
		stockCartFrame.getTxtaDescription().setText("");
		stockCartFrame.getTxtCreationDate().setText("");
	}

}
