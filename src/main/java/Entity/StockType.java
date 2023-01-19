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
@Table(name = "stock_type_carts")
public class StockType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int id;
	
	@Column(name="code", length=15, nullable=false)
	private String code;
	
	@Column(name="name", length=50, nullable=false)
	private String name;
	
	@Column(name="rating")
	private double rating;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stockType")
    private Set<StockCart> stockCarts = new HashSet<>();

	public StockType() {
		
	}
	
	public StockType(String code, String name, double rating) {
		this.code = code;
		this.name = name;
		this.rating = rating;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Set<StockCart> getStockCarts() {
		return stockCarts;
	}

	public void setStockCarts(Set<StockCart> stockCarts) {
		this.stockCarts = stockCarts;
	}
	
	@Override
	public String toString() {
		return this.id+"";
	}
}
