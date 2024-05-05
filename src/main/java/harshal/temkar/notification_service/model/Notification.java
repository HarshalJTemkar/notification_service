package harshal.temkar.notification_service.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "NOTIFICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification implements Serializable {

	@Id
	@GeneratedValue
    @UuidGenerator(style = Style.TIME)
	@Column(name = "ID")
	private String id;
	
	@NotBlank
	@Column(name = "CUSTOMER_ID")
	private String customerid;
	
	@NotBlank
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "DATE")
	private Date date;
}
