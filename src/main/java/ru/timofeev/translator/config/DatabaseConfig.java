package ru.timofeev.translator.config;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatabaseConfig {

//    @Value("${spring.datasource.driverClassName}")
//    String driverClassName;
//
//    @Value("${spring.datasource.username}")
//    String username;
//
//    @Value("${spring.datasource.password}")
//    String password;
//
//    @Value("${spring.datasource.url}")
//    String url;

    @Bean
    public DataSource dataSource() {

    // TODO: fix problems with custom data source

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setPassword(password);
//        dataSource.setUsername(username);
//        dataSource.setUrl(url);

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")//script to create person table
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
