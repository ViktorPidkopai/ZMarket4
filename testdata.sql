TRUNCATE TABLE `zmarket4`.`product`;
TRUNCATE TABLE `zmarket4`.`category`;

INSERT INTO `zmarket4`.`category` values(1, 'Pets');
INSERT INTO `zmarket4`.`category` values(2, 'Feeds');
INSERT INTO `zmarket4`.`category` values(3, 'Tools');

INSERT INTO `zmarket4`.`product` values(1, 'Dog', 10000, 1);
INSERT INTO `zmarket4`.`product` values(2, 'Cat', 15000, 1);
INSERT INTO `zmarket4`.`product` values(3, 'Bird', 9000, 1);
INSERT INTO `zmarket4`.`product` values(4, 'For cats', 10000, 2);
INSERT INTO `zmarket4`.`product` values(5, 'For dogs', 10000, 2);
INSERT INTO `zmarket4`.`product` values(6, 'For bird', 10000, 2);
INSERT INTO `zmarket4`.`product` values(7, 'Birdcage', 10000, 3);
INSERT INTO `zmarket4`.`product` values(8, 'Фиговинка', 10000, 3);
