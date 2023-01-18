package Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tax_type_carts")
public class TaxType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int id;
	
	@Column(name="code", length=15, nullable=false)
	private String code;
	
	@Column(name="name", length=50, nullable=false)
	private String name;
	
	@Column(name="description", columnDefinition = "TEXT")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "taxtype")
    private Set<StockCart> stockCarts = new HashSet<>();
	
	public TaxType() {
		
	}
	
	public TaxType(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<StockCart> getStockCarts() {
		return stockCarts;
	}

	public void setStockCarts(Set<StockCart> stockCarts) {
		this.stockCarts = stockCarts;
	}
}
