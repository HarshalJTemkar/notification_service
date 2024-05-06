package harshal.temkar.notification_service.kafka.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

	private String id;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String contact;
}
