/* customer */
CREATE TABLE customer (
	c_num NUMBER NOT NULL, /* ȸ����ȣ */
	c_id VARCHAR2(100) unique NOT NULL, /* ���̵� */
	c_password VARCHAR2(100) NOT NULL, /* ��й�ȣ */
	c_name VARCHAR2(100) NOT NULL, /* �̸� */
	c_phone VARCHAR2(11) unique NOT NULL, /* ��ȭ��ȣ */
	c_point NUMBER NOT NULL /* ����Ʈ */
);
create sequence sq_custom;
COMMENT ON TABLE customer IS 'customer';

COMMENT ON COLUMN customer.c_num IS 'ȸ����ȣ';

COMMENT ON COLUMN customer.c_id IS '���̵�';

COMMENT ON COLUMN customer.c_password IS '��й�ȣ';

COMMENT ON COLUMN customer.c_name IS '�̸�';

COMMENT ON COLUMN customer.c_phone IS '��ȭ��ȣ';

COMMENT ON COLUMN customer.c_point IS '����Ʈ';

CREATE UNIQUE INDEX PK_customer
	ON customer (
		c_num ASC
	);

ALTER TABLE customer
	ADD
		CONSTRAINT PK_customer
		PRIMARY KEY (
			c_num
		);

/* post */
CREATE TABLE post (
	p_num NUMBER NOT NULL, /* ���ȣ */
	p_title VARCHAR2(100) NOT NULL, /* ���� */
	p_date DATE NOT NULL, /* ��¥ */
	p_max NUMBER NOT NULL, /* ���ο� */
	p_comment VARCHAR2(300), /* ����Ǹ� */
	bigcat VARCHAR2(100) NOT NULL, /* ��з� */
	smallcat VARCHAR2(100) NOT NULL /* �Һз� */
);
create sequence sq_post;

COMMENT ON TABLE post IS 'post';

COMMENT ON COLUMN post.p_num IS '���ȣ';

COMMENT ON COLUMN post.p_title IS '����';

COMMENT ON COLUMN post.p_date IS '��¥';

COMMENT ON COLUMN post.p_max IS '���ο�';

COMMENT ON COLUMN post.p_comment IS '����Ǹ�';

COMMENT ON COLUMN post.bigcat IS '��з�';

COMMENT ON COLUMN post.smallcat IS '�Һз�';

CREATE UNIQUE INDEX PK_post
	ON post (
		p_num ASC
	);

ALTER TABLE post
	ADD
		CONSTRAINT PK_post
		PRIMARY KEY (
			p_num
		);

/* attend */
CREATE TABLE attend (
	p_num NUMBER NOT NULL, /* ���ȣ */
	c_num NUMBER NOT NULL, /* ȸ����ȣ */
	a_deposit NUMBER NOT NULL, /* ��������Ʈ */
	a_check CHAR check (a_check in ('Y','N')) not null /* �������� */
);

COMMENT ON TABLE attend IS 'attend';

COMMENT ON COLUMN attend.p_num IS '���ȣ';

COMMENT ON COLUMN attend.c_num IS 'ȸ����ȣ';

COMMENT ON COLUMN attend.a_deposit IS '��������Ʈ';

COMMENT ON COLUMN attend.a_check IS '��������';

CREATE UNIQUE INDEX PK_attend
	ON attend (
		p_num ASC,
		c_num ASC
	);

ALTER TABLE attend
	ADD
		CONSTRAINT PK_attend
		PRIMARY KEY (
			p_num,
			c_num
		);

/* nonbuy */
CREATE TABLE nonbuy (
	bigcat VARCHAR2(100) NOT NULL, /* ��з� */
	smallcat VARCHAR2(100) NOT NULL, /* �Һз� */
	n_place VARCHAR2(100) NOT NULL, /* ��� */
	n_time VARCHAR2(10) NOT NULL, /* �ð� */
	n_deposit NUMBER NOT NULL /* ������ */
);

COMMENT ON TABLE nonbuy IS 'nonbuy';

COMMENT ON COLUMN nonbuy.bigcat IS '��з�';

COMMENT ON COLUMN nonbuy.smallcat IS '�Һз�';

COMMENT ON COLUMN nonbuy.n_place IS '���';

COMMENT ON COLUMN nonbuy.n_time IS '�ð�';

COMMENT ON COLUMN nonbuy.n_deposit IS '������';

CREATE UNIQUE INDEX PK_nonbuy
	ON nonbuy (
		bigcat ASC,
		smallcat ASC
	);

ALTER TABLE nonbuy
	ADD
		CONSTRAINT PK_nonbuy
		PRIMARY KEY (
			bigcat,
			smallcat
		);

/* ticketbuy */
CREATE TABLE ticketbuy (
	bigcat VARCHAR2(100) NOT NULL, /* ��з� */
	smallcat VARCHAR2(100) NOT NULL, /* �Һз� */
	t_min NUMBER NOT NULL, /* �ּ��ο� */
	t_price NUMBER NOT NULL /* �ݾ� */
);

COMMENT ON TABLE ticketbuy IS 'ticketbuy';

COMMENT ON COLUMN ticketbuy.bigcat IS '��з�';

COMMENT ON COLUMN ticketbuy.smallcat IS '�Һз�';

COMMENT ON COLUMN ticketbuy.t_min IS '�ּ��ο�';

COMMENT ON COLUMN ticketbuy.t_price IS '�ݾ�';

CREATE UNIQUE INDEX PK_ticketbuy
	ON ticketbuy (
		bigcat ASC,
		smallcat ASC
	);

ALTER TABLE ticketbuy
	ADD
		CONSTRAINT PK_ticketbuy
		PRIMARY KEY (
			bigcat,
			smallcat
		);



/* review */
CREATE TABLE review (
	p_num NUMBER NOT NULL, /* ���ȣ */
	c_num NUMBER NOT NULL, /* ȸ����ȣ */
	r_good NUMBER NOT NULL, /* ���ƿ� */
	r_review VARCHAR2(300) /* �ı� */
);

COMMENT ON TABLE review IS 'review';

COMMENT ON COLUMN review.p_num IS '���ȣ';

COMMENT ON COLUMN review.c_num IS 'ȸ����ȣ';

COMMENT ON COLUMN review.r_good IS '���ƿ�';

COMMENT ON COLUMN review.r_review IS '�ı�';

CREATE UNIQUE INDEX PK_review
	ON review (
		p_num ASC,
		c_num ASC
	);

ALTER TABLE review
	ADD
		CONSTRAINT PK_review
		PRIMARY KEY (
			p_num,
			c_num
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_nonbuy_TO_post
		FOREIGN KEY (
			bigcat,
			smallcat
		)
		REFERENCES nonbuy (
			bigcat,
			smallcat
		);

ALTER TABLE post
	ADD
		CONSTRAINT FK_ticketbuy_TO_post
		FOREIGN KEY (
			bigcat,
			smallcat
		)
		REFERENCES ticketbuy (
			bigcat,
			smallcat
		);

ALTER TABLE attend
	ADD
		CONSTRAINT FK_post_TO_attend
		FOREIGN KEY (
			p_num
		)
		REFERENCES post (
			p_num
		);

ALTER TABLE attend
	ADD
		CONSTRAINT FK_customer_TO_attend
		FOREIGN KEY (
			c_num
		)
		REFERENCES customer (
			c_num
		);

ALTER TABLE review
	ADD
		CONSTRAINT FK_attend_TO_review
		FOREIGN KEY (
			p_num,
			c_num
		)
		REFERENCES attend (
			p_num,
			c_num
		);
