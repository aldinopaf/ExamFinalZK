package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import component.BaseEntity;
import entity.enumcol.ProductCategoryEnum;
import entity.pk.MstProductPk;

@Entity
@Table(name="mst_product")
@IdClass(value=MstProductPk.class)
public class MstProduct extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_code")
	private String productCode;
	@Column(name="product_name")
	private String productName;
	@Column(name="quantity")
	private Long quantity;
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	@Column(name="category")
	private ProductCategoryEnum category;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public ProductCategoryEnum getCategory() {
		return category;
	}
	public void setCategory(ProductCategoryEnum category) {
		this.category = category;
	}
	
}
