-- DROP TABLE EMPRESA;
CREATE TABLE IF NOT EXISTS EMPRESA (
	ID_EMPRESA BIGINT NOT NULL,
	NOME_EMPRESA VARCHAR(255) NULL
);

ALTER TABLE EMPRESA ADD PRIMARY KEY (ID_EMPRESA);

CREATE UNIQUE INDEX ON EMPRESA (NOME_EMPRESA);

CREATE SEQUENCE EMPRESA_SEQ	START 1;

INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(1, 'Bardella');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(2, 'UPS');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(3, 'Lockheed');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(4, 'Johnson');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(5, 'Fedex Corp');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(6, 'Caterpillar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(7, 'Bristolmyers');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(8, 'Boeing');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(9, 'Santos - Brasil');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(10, 'Randon Part');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(11, 'Lupatech');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(12, 'Inepar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(13, 'Ger Paranapanema');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(14, 'Fras-Le');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(15, 'Schulz');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(16, 'Taurus Armas');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(17, 'GOL');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(18, 'Eternit');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(19, 'Valid');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(20, 'Triunfo Part');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(21, 'PBG');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(22, 'Marcopolo');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(23, 'Cosan Log');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(24, 'Aço Altona');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(25, 'Eneva');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(26, 'Weg');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(27, 'RUMO LOG');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(28, 'Vale');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(29, 'Usiminas');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(30, 'Santos Brasil Participações');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(31, 'Invepar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(32, 'Contax');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(33, 'Celulose Irani');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(34, 'CCR');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(35, 'Azul');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(36, 'Cedro');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(37, 'Netflix');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(38, 'Nike');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(39, 'MC Donald s');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(40, 'Home Depot');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(41, 'Ford Motors');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(42, 'Comcast');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(43, 'Amazon');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(44, 'Rodobens');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(45, 'Saraiva Livr');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(46, 'Rossi Resid');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(47, 'Mundial');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(48, 'Metal Leve');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(49, 'Karsten');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(50, 'Iochpe-Maxion');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(51, 'Grendene');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(52, 'Locamerica');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(53, 'C&A');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(54, 'Le Lis Blanc');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(55, 'Grazziotin');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(56, 'Estrela');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(57, 'Direcional');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(58, 'Coteminas');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(59, 'Anima');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(60, 'Even');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(61, 'Marisa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(62, 'Movida');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(63, 'JHSF');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(64, 'Helbor');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(65, 'PDG Realty');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(66, 'Arezzo');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(67, 'Ez Tec');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(68, 'Cia Hering');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(69, 'Alpargatas');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(70, 'Smiles');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(71, 'Localiza');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(72, 'MRV Engenharia');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(73, 'Magazine Luiza');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(74, 'Lojas Renner');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(75, 'Cogna');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(76, 'Whirlpool');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(77, 'Whirpool');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(78, 'Via Varejo');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(79, 'Tecnisa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(80, 'Starbucks');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(81, 'Ser Educacional');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(82, 'Saraiva livr');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(83, 'Lojas Americanas');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(84, 'Hoteis Othon');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(85, 'Gafisa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(86, 'YDUQS');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(87, 'Cyrela Realty');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(88, 'CVC');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(89, 'Walmart');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(91, 'Procter Gamble');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(92, 'Pepsico Inc');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(93, 'Colgate');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(94, 'Coca-Cola');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(95, 'Avon');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(96, 'São Martinho');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(97, 'MDiasBranco');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(98, 'CAMIL');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(99, 'Brasilagro');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(100, 'Biosev');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(101, 'Minerva');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(102, 'Vivara');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(103, 'Carrefour');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(104, 'Pão de Açúcar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(105, 'Natura');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(106, 'Marfrig');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(107, 'JBS');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(108, 'Proctor Gamble');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(109, 'BRF');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(110, 'BRB Banco');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(111, 'Battistella');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(112, 'Banpara');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(113, 'Wells Fargo');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(114, 'Visa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(115, 'Morgan Stanley');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(116, 'Mastercard');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(117, 'JPMorgan');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(118, 'Honeywell');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(119, 'GE');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(120, 'Goldman Sachs');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(121, 'Citigroup');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(122, 'Bank America');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(123, '3M');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(124, 'Sao Carlos');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(125, 'LPS Brasil');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(126, 'BMG');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(127, 'Gradiente');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(128, 'General Shopping');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(129, 'Porto Seguro');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(130, 'CSU CardSyst');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(131, 'Brasil Brokers');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(132, 'BR Properties');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(133, 'Banrisul');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(134, 'Banco Inter');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(135, 'Santander BR');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(136, 'Multiplan');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(137, 'Itaú Unibanco');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(138, 'Aliansce Sonae');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(139, 'Log');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(140, 'Itaúsa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(141, 'IRB Brasil RE');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(142, 'Iguatemi');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(143, 'Bradesco');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(144, 'brMalls');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(145, 'Alper');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(146, 'BB Seguridade');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(147, 'Banco Pan');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(148, 'Banco do Brasil');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(149, 'American Express');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(150, 'Celul Irani');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(151, 'Freeport');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(152, 'Paranapanema');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(153, 'Ferbasa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(154, 'Eucatex');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(155, 'Suzano Papel');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(156, 'Klabin S/A');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(158, 'Unipar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(159, 'Suzano Holding');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(160, 'MMX Mineração');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(161, 'Gerdau');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(162, 'CSN');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(164, 'Braskem');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(165, 'Bradespar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(166, 'Arcelor');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(167, 'Cemepe');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(168, 'Betapart');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(169, 'Walt Disney');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(170, 'Atompar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(171, 'Philipmorris');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(172, 'CCX');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(173, 'Schlumberger ');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(174, 'Halliburton');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(175, 'Cophillips');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(176, 'Chevron');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(177, 'PETRORIO');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(178, 'OSX Brasil');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(179, 'Dommo');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(180, 'Pet Manguinhos');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(181, 'Ultrapar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(182, 'Petrobras');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(183, 'Petrobras Distribuidora');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(184, 'Exxon Mobil');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(185, 'Enauta Part');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(186, 'Biomm');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(187, 'Baumer');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(188, 'Pfizer');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(189, 'Merck');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(190, 'Biotoscana');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(191, 'Dimed');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(192, 'Alliar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(193, 'OdontoPrev');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(194, 'RD');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(195, 'Qualicorp');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(196, 'Ourofino S/A');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(198, 'Hypera Pharma');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(199, 'Fleury');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(201, 'Abbott Laboratories');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(202, 'Totvs');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(203, 'Xerox');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(204, 'Qualcomm');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(205, 'Oracle');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(206, 'Microsoft');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(207, 'IBM');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(208, 'Intel');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(209, 'HP Company');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(210, 'eBay');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(211, 'Cisco');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(212, 'Att Inc');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(213, 'Apple');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(214, 'Linx');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(215, 'Positivo Inf');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(216, 'Ebay');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(217, 'Verizon');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(218, 'OI');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(219, 'Tim Participações');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(220, 'Telefônica Brasil S.A');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(221, 'Telebras');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(223, 'Celpe');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(224, 'CEEE-D');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(225, 'Ceee-gt');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(226, 'Casan');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(227, 'CEG');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(228, 'CEB');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(229, 'Renova');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(230, 'Coelce');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(231, 'Celesc');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(232, 'Alupar Investimento');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(233, 'Sanepar');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(234, 'CPFL Renovav');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(235, 'Copel');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(236, 'CPFL Energia');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(237, 'Comgás');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(238, 'AES Tietê');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(239, 'Neoenergia');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(240, 'ISA CTEEP');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(241, 'Engie Brasil');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(242, 'Taesa');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(243, 'Sabesp');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(244, 'Renaova');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(246, 'CESP');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(247, 'Cemig');
INSERT INTO EMPRESA(ID_EMPRESA, NOME_EMPRESA) VALUES(248, 'Afluente T');