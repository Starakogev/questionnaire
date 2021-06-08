package com.starakogev.questionnaire.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DataBaseConfiguration {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username("postgres")
                .url("jdbc:postgresql://localhost:5432/questionnaire")
                .password("1234")
                .build();
    }

    @Value("${data-base.migration.drop-pooling-schema:false}")
    private boolean dropPoolingSchemaBeforeMigrate;

    @Bean
    public Flyway flywayInitializer(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .sqlMigrationPrefix("")
                .dataSource(dataSource)
                .placeholderPrefix("$${")
                .load();
        if (dropPoolingSchemaBeforeMigrate) {
            flyway.clean();
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("drop schema if exists questionnaire_schema cascade");
            } catch (SQLException e) {
                throw new RuntimeException("не удалось очистить базу", e);
            }
        }
        flyway.migrate();
        return flyway;
    }
}
