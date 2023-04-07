drop table if exists translation_result;

create table translation_result
(
    id         int PRIMARY KEY AUTO_INCREMENT,
    input_text varchar(255),
    result     varchar(255),
    params     varchar(255),
    ip_address varchar(255),
    request_data timestamp
);