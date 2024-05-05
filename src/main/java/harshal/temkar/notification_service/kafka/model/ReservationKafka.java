package harshal.temkar.notification_service.kafka.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationKafka  {

	private String id;

    private String customerid;
	
    private String hotelid;
	
    private Date checkindate;

    private Date checkoutdate;
}
