/* customer */
CREATE TABLE customer (
	c_num NUMBER NOT NULL, /* 회원번호 */
	c_id VARCHAR2(100) unique NOT NULL, /* 아이디 */
	c_password VARCHAR2(100) NOT NULL, /* 비밀번호 */
	c_name VARCHAR2(100) NOT NULL, /* 이름 */
	c_phone VARCHAR2(11) unique NOT NULL, /* 전화번호 */
	c_point NUMBER NOT NULL /* 포인트 */
);
create sequence sq_custom;
COMMENT ON TABLE customer IS 'customer';

COMMENT ON COLUMN customer.c_num IS '회원번호';

COMMENT ON COLUMN customer.c_id IS '아이디';

COMMENT ON COLUMN customer.c_password IS '비밀번호';

COMMENT ON COLUMN customer.c_name IS '이름';

COMMENT ON COLUMN customer.c_phone IS '전화번호';

COMMENT ON COLUMN customer.c_point IS '포인트';

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
	p_num NUMBER NOT NULL, /* 방번호 */
	p_title VARCHAR2(100) NOT NULL, /* 제목 */
	p_date DATE NOT NULL, /* 날짜 */
	p_max NUMBER NOT NULL, /* 방인원 */
	p_comment VARCHAR2(300), /* 남기실말 */
	bigcat VARCHAR2(100) NOT NULL, /* 대분류 */
	smallcat VARCHAR2(100) NOT NULL /* 소분류 */
);
create sequence sq_post;

COMMENT ON TABLE post IS 'post';

COMMENT ON COLUMN post.p_num IS '방번호';

COMMENT ON COLUMN post.p_title IS '제목';

COMMENT ON COLUMN post.p_date IS '날짜';

COMMENT ON COLUMN post.p_max IS '방인원';

COMMENT ON COLUMN post.p_comment IS '남기실말';

COMMENT ON COLUMN post.bigcat IS '대분류';

COMMENT ON COLUMN post.smallcat IS '소분류';

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
	p_num NUMBER NOT NULL, /* 방번호 */
	c_num NUMBER NOT NULL, /* 회원번호 */
	a_deposit NUMBER NOT NULL, /* 차감포인트 */
	a_check CHAR check (a_check in ('Y','N')) not null /* 참여여부 */
);

COMMENT ON TABLE attend IS 'attend';

COMMENT ON COLUMN attend.p_num IS '방번호';

COMMENT ON COLUMN attend.c_num IS '회원번호';

COMMENT ON COLUMN attend.a_deposit IS '차감포인트';

COMMENT ON COLUMN attend.a_check IS '참여여부';

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
	bigcat VARCHAR2(100) NOT NULL, /* 대분류 */
	smallcat VARCHAR2(100) NOT NULL, /* 소분류 */
	n_place VARCHAR2(100) NOT NULL, /* 장소 */
	n_time VARCHAR2(10) NOT NULL, /* 시간 */
	n_deposit NUMBER NOT NULL /* 보증금 */
);

COMMENT ON TABLE nonbuy IS 'nonbuy';

COMMENT ON COLUMN nonbuy.bigcat IS '대분류';

COMMENT ON COLUMN nonbuy.smallcat IS '소분류';

COMMENT ON COLUMN nonbuy.n_place IS '장소';

COMMENT ON COLUMN nonbuy.n_time IS '시간';

COMMENT ON COLUMN nonbuy.n_deposit IS '보증금';

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
	bigcat VARCHAR2(100) NOT NULL, /* 대분류 */
	smallcat VARCHAR2(100) NOT NULL, /* 소분류 */
	t_min NUMBER NOT NULL, /* 최소인원 */
	t_price NUMBER NOT NULL /* 금액 */
);

COMMENT ON TABLE ticketbuy IS 'ticketbuy';

COMMENT ON COLUMN ticketbuy.bigcat IS '대분류';

COMMENT ON COLUMN ticketbuy.smallcat IS '소분류';

COMMENT ON COLUMN ticketbuy.t_min IS '최소인원';

COMMENT ON COLUMN ticketbuy.t_price IS '금액';

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
	p_num NUMBER NOT NULL, /* 방번호 */
	c_num NUMBER NOT NULL, /* 회원번호 */
	r_good NUMBER NOT NULL, /* 좋아요 */
	r_review VARCHAR2(300) /* 후기 */
);

COMMENT ON TABLE review IS 'review';

COMMENT ON COLUMN review.p_num IS '방번호';

COMMENT ON COLUMN review.c_num IS '회원번호';

COMMENT ON COLUMN review.r_good IS '좋아요';

COMMENT ON COLUMN review.r_review IS '후기';

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
