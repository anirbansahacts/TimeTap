package com.elams.leaveservice.repository;

import com.elams.leaveservice.entity.NationalHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import java.time.LocalDate;
 
public interface NationalHolidayRepository extends JpaRepository<NationalHoliday, Long> {
	@Query("SELECT CASE WHEN COUNT(h) > 0 THEN TRUE ELSE FALSE END " +
			"FROM NationalHoliday h WHERE h.month = :month AND h.day = :day")
			boolean existsByMonthAndDay(@Param("month") int month,
			                                     @Param("day") int day);
}
