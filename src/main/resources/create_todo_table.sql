CREATE TABLE `todo` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `sequence` int NOT NULL,
  `type` varchar(20) DEFAULT 'TODO',
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8