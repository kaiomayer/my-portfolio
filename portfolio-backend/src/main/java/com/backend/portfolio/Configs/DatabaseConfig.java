package com.backend.portfolio.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource getDataSource() {

        String dbName = System.getenv("POSTGRES_DB");
        String dbUser = System.getenv("POSTGRES_USER");
        String dbPassword = System.getenv("POSTGRES_PASSWORD");

        if (dbName == null || dbUser == null || dbPassword == null) {
            throw new IllegalStateException("Database environment variables are not fully configured!");
        }

        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://portfolio-database:5432/" + dbName)
                .username(dbUser)
                .password(dbPassword)
                .build();
    }
}
