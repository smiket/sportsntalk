--
-- vertex types
--

insert into vertex_type values (1, 'user');
insert into vertex_type values (2, 'post');
insert into vertex_type values (3, 'comment');
insert into vertex_type values (4, 'picture');
insert into vertex_type values (5, 'video');
insert into vertex_type values (6, 'link');
insert into vertex_type values (7, 'message');

--
-- vertex attribute types
--

insert into vertex_attribute_type values (1, 'first_name');
insert into vertex_attribute_type values (2, 'middle_name');
insert into vertex_attribute_type values (3, 'last_name');
insert into vertex_attribute_type values (4, 'content');


--
-- vertex attribute constraints
--

insert into vertex_attribute_constraint values (null, 1, 1); -- user first name
insert into vertex_attribute_constraint values (null, 1, 2); -- user middle name
insert into vertex_attribute_constraint values (null, 1, 3); -- user last name
insert into vertex_attribute_constraint values (null, 2, 4); -- post content
insert into vertex_attribute_constraint values (null, 3, 4); -- comment content
insert into vertex_attribute_constraint values (null, 4, 4); -- picture content
insert into vertex_attribute_constraint values (null, 5, 4); -- video content
insert into vertex_attribute_constraint values (null, 6, 4); -- link content
insert into vertex_attribute_constraint values (null, 7, 4); -- message content

--
-- edge types
--

insert into edge_type values (1, 'create');
insert into edge_type values (2, 'like');
insert into edge_type values (3, 'share');
insert into edge_type values (4, 'attach');
insert into edge_type values (5, 'send');
insert into edge_type values (6, 'friend_request');
insert into edge_type values (7, 'friend');
insert into edge_type values (8, 'report');
insert into edge_type values (9, 'mother');
insert into edge_type values (10, 'father');
insert into edge_type values (11, 'brother');
insert into edge_type values (12, 'sister');
insert into edge_type values (13, 'husband');
insert into edge_type values (14, 'wife');

--
-- edge constraints
--

insert into edge_constraint values (null, 1, 1, 2); -- user create post
insert into edge_constraint values (null, 1, 1, 3); -- user create comment
insert into edge_constraint values (null, 1, 1, 4); -- user create picture
insert into edge_constraint values (null, 1, 1, 5); -- user create video
insert into edge_constraint values (null, 1, 1, 6); -- user create link
insert into edge_constraint values (null, 1, 1, 7); -- user create message

insert into edge_constraint values (null, 3, 4, 2); -- comment attach post
insert into edge_constraint values (null, 4, 4, 2); -- picture attach post
insert into edge_constraint values (null, 5, 4, 2); -- video attach post
insert into edge_constraint values (null, 6, 4, 2); -- link attach post

insert into edge_constraint values (null, 1, 2, 2); -- user like post
insert into edge_constraint values (null, 1, 3, 2); -- user share post

insert into edge_constraint values (null, 7, 5, 1); -- message send user

insert into edge_constraint values (null, 1, 6, 1); -- user friend_request user
insert into edge_constraint values (null, 1, 7, 1); -- user friend user
insert into edge_constraint values (null, 1, 8, 1); -- user report user
insert into edge_constraint values (null, 1, 8, 2); -- user report post

insert into edge_constraint values (null, 1, 9, 1);  -- user mother user
insert into edge_constraint values (null, 1, 10, 1); -- user father user
insert into edge_constraint values (null, 1, 11, 1); -- user brother user
insert into edge_constraint values (null, 1, 12, 1); -- user sister user
insert into edge_constraint values (null, 1, 13, 1); -- user husband user
insert into edge_constraint values (null, 1, 14, 1); -- user wife user
