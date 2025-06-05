package com.elams.leaveservice.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NationalHoliday {
	
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    private int month;
	    private int day; 
	 
	    private String description;
	 
	    //private String region; // Optional for regional holidays
	
}
