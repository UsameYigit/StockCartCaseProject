package Entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//Entity for the Stock Carts this will be used to modify stock_carts table.
@Entity
@Table(name = "stock_carts")
public class StockCart {
	@Id
	@Column(name="stock_code", length=50, nullable=false, unique = true)
	private String stockCode;
	
	@Column(name="stock_name", length=100, nullable=false)
	private String stockName;
	
	@Column(name="unit", length=10, nullable=false)
	private String unit;
	
	@Column(name="barcode", length=30, nullable=false)
	private String barcode;
	
	@Column(name="description", nullable=true, columnDefinition="TEXT")
	private String description;
	
	@Column(name="creation_date", nullable=false)
	private LocalDateTime creationDate;

	@ManyToOne
	private TaxType taxType;
	
	@ManyToOne
	private StockType stockType;
	
	public StockCart() {
		
	}
	
	//Constructor method for creating Entity with parameters
	public StockCart(String stockCode, String stockName, StockType stockType, String unit, String barcode, TaxType taxType, String description, LocalDateTime creationDate) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockType = stockType;
		this.unit = unit;
		this.barcode = barcode;
		this.taxType = taxType;
		this.description = description;
		this.creationDate = creationDate;
	}
	
	public String getStockCode() {
		return this.stockCode;
	}
	
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public String getStockName() {
		return this.stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public StockType getStockType() {
		return this.stockType;
	}
	
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getBarcode() {
		return this.barcode;
	}
	
	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}
	
	public TaxType getTaxType() {
		return this.taxType;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreationDate() {
		return this.creationDate;
	}
	
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	//Override of toString method which will help us to get info from the StockCart directly as a string.
	@Override
	public String toString() {	
		return this.stockCode + " " + this.stockName + " " + this.stockType + " " + this.unit + " " + this.barcode + " " + this.taxType + " " + this.description + " " + this.creationDate;
	}
}
