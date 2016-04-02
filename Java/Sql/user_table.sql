CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
  );
  
  INSERT INTO user VALUES (null, "John", "Smith", "smithj", "password"),
  						  (null, "Mary", "Byrne", "byrnem", "password"),
  						  (null, "Frankie", "Cocozza", "cocozzaf", "password"),
  						  (null, "Test", "User", "1", "1"),
  						  (null, "Patrick", "Jones", "jonesp", "password");


 CREATE TABLE `images` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) NOT NULL,
  `RATING` int NOT NULL,
  `NUM_OF_RATING` int NOT NULL,
  `FILENAME` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
  );
  
  INSERT INTO images VALUES (null, "img1", 1, 1, "img1.jpg"),
  						    (null, "img2", 4, 2, "img2.jpg"),
  						    (null, "img3", 6, 2, "img3.jpg"),
  						    (null, "img4", 8, 2, "img4.jpg"),
  						    (null, "img5", 10, 2, "img5.jpg"); 
  	
  						    
select * from user; 						    
select * from images;

drop table images;
drop table user;