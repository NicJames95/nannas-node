package com.Nannas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="product_id")
	private int productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	
	@Column(name="description")
	private String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Image_id")
	private Image image;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
