CREATE TABLE author (
  id bigserial not null
    constraint author_pkey
    primary key,
  createdTimestamp timestamp,
  modifiedTimestamp timestamp,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(200) NOT NULL,
  birthday DATE NOT NULL
);

CREATE TABLE book(
  id bigserial not null
    constraint book_pkey
    primary key,
  createdTimestamp timestamp,
  modifiedTimestamp timestamp,
  name VARCHAR(45) NOT NULL,
  content bytea,
  page_count BIGINT NOT NULL,
  isbn VARCHAR(100) NOT NULL UNIQUE,
  genre_id BIGINT NOT NULL ,
  author_id BIGINT NOT NULL ,
  publish_year BIGINT NOT NULL,
  publisher_id BIGINT NOT NULL,
  image bytea,
  avg_rating BIGINT DEFAULT 0,
  total_vote_count BIGINT DEFAULT 0,
  total_rating BIGINT DEFAULT 0,
  view_count BIGINT DEFAULT 0,
  descr VARCHAR(500) DEFAULT NULL
);

CREATE TABLE  genre(
  id bigserial not null
    constraint genre
    primary key,
  createdTimestamp timestamp,
  modifiedTimestamp timestamp,
  name VARCHAR(100) NOT NULL,
);

CREATE TABLE publisher(
  id bigserial not null
    constraint publisher_pkey
    primary key,
  createdTimestamp timestamp,
  modifiedTimestamp timestamp,
  name VARCHAR(100) not NULL
);

CREATE TABLE vote(
  id bigserial not null
    constraint vote_pkey
    primary key,
  createdTimestamp timestamp,
  modifiedTimestamp timestamp,
  value BIGINT DEFAULT 0,
  book_id BIGINT NOT NULL,
  username BIGINT NOT NULL
);

alter table author
  add constraint fkggtnytxjulkkw1w361h4s6p2i
foreign key (id) references book;

alter table book
  add constraint fk_author
foreign key (author_id) references author;

alter table book
  add constraint fk_genre
foreign key (genre_id) references genre;

alter table book
  add constraint fk_publisher
foreign key (publisher_id) references publisher;

alter table vote
  add constraint fk_book_id
foreign key (book_id) references book;