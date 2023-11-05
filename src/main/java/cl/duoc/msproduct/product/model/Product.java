package cl.duoc.msproduct.product.model;

import java.time.LocalDate;
import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private float price;
	@Column(name = "url_image")
	private String urlImage;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	private LocalDate date;
	
}
