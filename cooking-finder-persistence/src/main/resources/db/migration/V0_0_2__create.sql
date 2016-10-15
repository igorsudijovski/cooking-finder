create table t_user
(
  id bigint not null auto_increment,
  username varchar(255) not null,
  password varchar(255) not null,
  email varchar(255) not null,
  firstName varchar(255) not null,
  lastName varchar(255) not null,
  access_token varchar(255) not null,
  access_token_datetime datetime not null,
  primary key (id)
);

create table t_feed
(
  id bigint not null auto_increment,
  name varchar(255) not null,
  description varchar(1500),
  main_image bigint,
  user_id bigint not null,
  primary key (id)
);


create table t_ingredients
(
  id bigint not null auto_increment,
  name varchar(255) not null,
  description varchar(1500),
  image_id bigint,
  primary key (id)
);


create table t_image
(
  id bigint not null auto_increment,
  name varchar(255) not null,
  description varchar(1000),
  file_name varchar(255) not null,
  file_path varchar(1000) not null,
  image_type varchar(255) not null,
  width int not null,
  height int not null,
  primary key (id)
);

create table t_feed_ingredients
(
  id bigint not null auto_increment,
  ingredient_id bigint not null,
  feed_id bigint not null,
  measurement varchar(255) not null,
  primary key (id)
);

create table t_feed_images
(
  feed_id bigint not null,
  image_id bigint not null,
  primary key (feed_id, image_id)
);


create table t_feedback_type
(
  id bigint not null auto_increment,
  name varchar(255) not null,
  primary key (id)
);

create table t_feed_feedback
(
  user_id bigint not null,
  feedback_type_id bigint not null,
  primary key(user_id, feedback_type_id)
);
alter table t_feed_feedback add constraint FK_feed_feedback_user foreign key (user_id) references t_user(id);
alter table t_feed_feedback add constraint FK_feed_feedback_feedback_type foreign key (feedback_type_id) references t_feedback_type(id);


alter table t_user add constraint UK_user_username unique(username);
alter table t_user add constraint UK_user_email unique(email);
alter table t_user add constraint UK_user_access_token unique(access_token);
alter table t_ingredients add constraint UK_ingredients_name unique(name);
alter table t_feedback_type add constraint UK_feedback_type_name unique(name);


alter table t_feed add constraint FK_feed_user_id foreign key (user_id) references t_user(id);
alter table t_feed add constraint FK_feed_image foreign key (main_image) references t_image(id);
alter table t_ingredients add constraint FK_ingredients_image foreign key (image_id) references t_image(id);
alter table t_feed_ingredients add constraint FK_feed_ingredients_ingredient foreign key (ingredient_id) references t_ingredients(id);
alter table t_feed_ingredients add constraint FK_feed_ingredients_feed foreign key (feed_id) references t_feed(id);
alter table t_feed_images add constraint FK_feed_images_feed foreign key (feed_id) references t_feed(id);
alter table t_feed_images add constraint FK_feed_images_image foreign key (image_id) references t_image(id);

