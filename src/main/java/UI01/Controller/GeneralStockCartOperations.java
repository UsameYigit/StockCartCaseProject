package UI01.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
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
				resetViewFields();
			}else {
				stockCartService.create(sc);
				resetViewFields();
			}
		}
			
	}
	
	private boolean doesExist(StockCart sc) {
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
				resetViewFields();
			}else
				JOptionPane.showMessageDialog(null, "Böyle bir stok kartı zaten bulunmamaktadır.");
		}
	}
	
	public void copySelectedItem() {
		if(stockCartFrame.getTxtStockCode() != null) {
			String stockCode = JOptionPane.showInputDialog(
                    "What is your name?", null);
			if(stockCode==null)
				JOptionPane.showMessageDialog(null, "Alanı doldurmadığınız için kopyalama işlemi tamamlanamadı.");
			else {
				StockCart sc = stockCartService.getByStockCode(stockCartFrame.getTxtStockCode().getText());
				if(sc != null) {
					if(doesExist(sc)) {
						sc.setStockCode(stockCode);
						stockCartService.create(sc);
						resetViewFields();
					}else 
						JOptionPane.showMessageDialog(null, "Böyle bir stok kartı bulunmamaktadır, kopyalanamaz.");
				}else
					JOptionPane.showMessageDialog(null, "Böyle bir stok kartı bulunmamaktadır, kopyalanamaz.");
			}
			
		}else
			JOptionPane.showMessageDialog(null, "Böyle bir stok kartı bulunmamaktadır, kopyalanamaz.");
	}
	
	
	//Navigators
	public void getPreviousItem() {
		StockCart sc;
		if(stockCartFrame.getTxtStockCode().getText().equals(""))
			sc = stockCartService.getFirstItem();
		else {
			sc = stockCartService.getByStockCode(stockCartFrame.getTxtStockCode().getText());
			if(sc != null)
				sc = stockCartService.getPreviousItem(sc.getStockCode());
			else
				sc = stockCartService.getFirstItem();
		}
		
		setViewFields(sc);
	}
	
	public void getNextItem() {
		StockCart sc;
		if(stockCartFrame.getTxtStockCode().getText().equals(""))
			sc = stockCartService.getFirstItem();
		else {
			sc = stockCartService.getByStockCode(stockCartFrame.getTxtStockCode().getText());
			if(sc != null)
				sc = stockCartService.getNextItem(sc.getStockCode());
			else
				sc = stockCartService.getFirstItem();
		}
		
		setViewFields(sc);
	}
	
	public void getFirstItem() {		
		setViewFields(stockCartService.getFirstItem());
	}
	
	public void getLastItem() {		
		setViewFields(stockCartService.getLastItem());
	}
	
	
	private void setViewFields(StockCart sc) {
		stockCartFrame.getTxtStockCode().setText(sc.getStockCode());
		stockCartFrame.getTxtStockName().setText(sc.getStockName());
		stockCartFrame.getTxtBarcode().setText(sc.getBarcode());
		stockCartFrame.getTxtCreationDate().setText(sc.getCreationDate().toString());
		stockCartFrame.getTxtaDescription().setText(sc.getDescription());
		stockCartFrame.getCmbStockType().setSelectedItem(sc.getStockType().getId()+"");
		stockCartFrame.getCmbTaxType().setSelectedItem(sc.getTaxType().getId()+"");
		stockCartFrame.getCmbUnit().setSelectedItem(sc.getUnit());
	}
	
	
	public void resetViewFields() {
		stockCartFrame.getTxtStockCode().setText("");
		stockCartFrame.getTxtStockName().setText("");
		stockCartFrame.getCmbStockType().setSelectedIndex(0);
		stockCartFrame.getCmbUnit().setSelectedIndex(0);
		stockCartFrame.getTxtBarcode().setText("");
		stockCartFrame.getCmbTaxType().setSelectedIndex(0);
		stockCartFrame.getTxtaDescription().setText("");
		stockCartFrame.getTxtCreationDate().setText("");
	}
	
	public void setComboBoxes() {

		List<StockType> stockTypes = stockTypeService.getAll();
		String[] stockTypesIds = new String[stockTypes.size()];
		for(int i = 0; i < stockTypes.size(); i++)
			stockTypesIds[i] = stockTypes.get(i).getId()+"";
		
		stockCartFrame.getCmbStockType().setModel(new DefaultComboBoxModel<String>(stockTypesIds));
		
		List<TaxType> taxTypes = taxTypeService.getAll();
		String[] taxTypesIds = new String[taxTypes.size()];
		for(int i = 0; i < taxTypes.size(); i++)
			taxTypesIds[i] = taxTypes.get(i).getId()+"";
		
		stockCartFrame.getCmbTaxType().setModel(new DefaultComboBoxModel<String>(taxTypesIds));
	}

}
