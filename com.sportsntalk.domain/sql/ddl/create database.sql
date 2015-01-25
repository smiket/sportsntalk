--
-- schema
--

create schema if not exists sportsntalk default character set "utf8mb4" default collate "utf8mb4_unicode_ci";
use `sportsntalk`;

drop table if exists edge_constraint;
drop table if exists edge;
drop table if exists edge_type;

drop table if exists vertex_attribute_constraint;
drop table if exists vertex_attribute;
drop table if exists vertex_attribute_type;

drop table if exists vertex;
drop table if exists vertex_type;
drop table if exists log;

--
-- log
--

create table log
(
  id int unsigned auto_increment not null primary key,
  date_time datetime not null,
  host_name nvarchar(255) not null,
  user_name nvarchar(255) not null,
  category nvarchar(255) not null,
  severity int unsigned not null,
  message nvarchar(4000) not null
);

--
-- vertex
--

create table vertex_type -- user, picture, post, comment ...
(
  id int unsigned not null primary key,
  name nvarchar(255) not null unique
);

create table vertex
(
  id int unsigned auto_increment not null primary key,
  vertex_type_id int unsigned not null,
  created_on datetime not null,
  created_by nvarchar(255) not null,
  modified_on datetime not null,
  modified_by nvarchar(255) not null,
  
  foreign key(vertex_type_id) references vertex_type(id)
);

create table vertex_attribute_type -- first name, last name, image format, comment text ...
(
  id int unsigned not null primary key,
  name nvarchar(255) not null unique
);

create table vertex_attribute
(
  id int unsigned auto_increment not null primary key,
  vertex_id int unsigned not null,
  vertex_attribute_type_id int unsigned not null,
  value nvarchar(255) not null unique,
  created_on datetime not null,
  created_by nvarchar(255) not null,
  modified_on datetime not null,
  modified_by nvarchar(255) not null,
  
  foreign key(vertex_id) references vertex(id),
  foreign key(vertex_attribute_type_id) references vertex_attribute_type(id),
  unique key (vertex_id, vertex_attribute_type_id)
);

create table vertex_attribute_constraint -- constrain attribute types to vertex types ...
(
  id int unsigned auto_increment not null primary key,
  vertex_type_id int unsigned not null,
  vertex_attribute_type_id int unsigned not null,
  
  foreign key(vertex_type_id) references vertex_type(id),
  foreign key(vertex_attribute_type_id) references vertex_attribute_type(id),
  unique key (vertex_type_id, vertex_attribute_type_id)
);

--
-- edge
--

create table edge_type
(
  id int unsigned primary key,
  name nvarchar(255) not null unique
);

create table edge
(
  id int unsigned auto_increment not null primary key,
  start_vertex_id int unsigned not null,
  edge_type_id int unsigned not null,
  end_vertex_id int unsigned not null,
  valid_from datetime not null,
  valid_to datetime not null,
  
  unique key(start_vertex_id, edge_type_id, end_vertex_id),
  foreign key(start_vertex_id) references vertex(id),
  foreign key(edge_type_id) references edge_type(id),
  foreign key(end_vertex_id) references vertex(id)
);

create index idx_edge_start on edge(edge_type_id, start_vertex_id);
create index idx_edge_end on edge(edge_type_id, end_vertex_id);

create table edge_constraint -- constrain edge between vertexes ...
(
  id int unsigned auto_increment not null primary key,
  start_vertex_type_id int unsigned not null,
  edge_type_id int unsigned not null,
  end_vertex_type_id int unsigned not null,
  
  unique key (start_vertex_type_id, edge_type_id, end_vertex_type_id),
  foreign key(start_vertex_type_id) references vertex_type(id),
  foreign key(edge_type_id) references edge_type(id),
  foreign key(end_vertex_type_id) references vertex_type(id)
);
