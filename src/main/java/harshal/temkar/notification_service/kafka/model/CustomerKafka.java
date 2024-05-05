package harshal.temkar.notification_service.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerKafka {

	private String id;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String contact;
}
