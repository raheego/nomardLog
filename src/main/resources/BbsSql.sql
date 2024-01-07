CREATE TABLE `category`
(
    `continent_id`  INT(11) NOT NULL AUTO_INCREMENT,
    `continet_name` VARCHAR(50) NOT NULL,
    `contry_name`   VARCHAR(50) NOT NULL,
    PRIMARY KEY (`continent_id`) USING BTREE
)

CREATE TABLE `tag`
(
    `tag_id`  INT(11) NOT NULL AUTO_INCREMENT,
    `content` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`tag_id`) USING BTREE
)
-- 대륙 TABLE SQL
CREATE TABLE `continents` (
                              `continent_Id` INT(11) NOT NULL AUTO_INCREMENT,
                              `continent_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
                              PRIMARY KEY (`continent_Id`) USING BTREE
)
    COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4

-- 국가 TABLE SQL
CREATE TABLE `countries` (
                             `country_id` INT(11) NOT NULL AUTO_INCREMENT,
                             `continent_id` INT(11) NULL DEFAULT NULL,
                             `country_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
                             PRIMARY KEY (`country_id`) USING BTREE,
                             INDEX `continent_Id` (`continent_id`) USING BTREE,
                             CONSTRAINT `continent_Id` FOREIGN KEY (`continent_id`) REFERENCES `continents` (`continent_Id`) ON UPDATE CASCADE ON DELETE CASCADE
)
    COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;

CREATE TABLE `hashtag` (
                           `hashtag_id` INT(11) NOT NULL AUTO_INCREMENT,
                           `bbs_id` INT(11) NULL DEFAULT NULL,
                           `content` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_bin',
                           PRIMARY KEY (`hashtag_id`) USING BTREE,
                           INDEX `bbs_id` (`bbs_id`) USING BTREE,
                           CONSTRAINT `bbs_id` FOREIGN KEY (`bbs_id`) REFERENCES `bbs` (`bbs_id`) ON UPDATE CASCADE ON DELETE CASCADE
)
    COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=12
;
