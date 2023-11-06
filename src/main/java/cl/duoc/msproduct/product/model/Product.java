package cl.duoc.msproduct.product.model;

// import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private float price;
	@Column(name = "url_image")
	private String urlImage;	
	private boolean active;
	// @Column(name="create_at")
	// @Temporal(TemporalType.DATE)
	// private Date createAt;

	// @PrePersist //antes de persistir la info en la bd se crea la fecha
	// public void prePersist() {
	// 	createAt = new Date();
	// }
}
