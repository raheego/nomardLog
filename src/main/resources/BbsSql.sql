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