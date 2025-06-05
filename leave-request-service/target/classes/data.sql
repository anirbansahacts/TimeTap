--clear previous data first
DELETE FROM national_holiday;
Alter TABLE national_holiday AUTO_INCREMENT=1;

--insert fresh data
INSERT INTO national_holiday (month, day, description) VALUES (1, 1, 'New Year''s Day');
INSERT INTO national_holiday (month, day, description) VALUES (1, 26, 'Republic Day');
INSERT INTO national_holiday (month, day, description) VALUES (4, 14, 'Ambedkar Jayanti');
INSERT INTO national_holiday (month, day, description) VALUES (5, 1, 'Labour Day');
INSERT INTO national_holiday (month, day, description) VALUES (8, 15, 'Independence Day');
INSERT INTO national_holiday (month, day, description) VALUES (10, 2, 'Gandhi Jayanti');
INSERT INTO national_holiday (month, day, description) VALUES (12, 25, 'Christmas Day');