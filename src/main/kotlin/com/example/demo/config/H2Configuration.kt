//package com.example.demo.config
//
//import io.r2dbc.spi.ConnectionFactory
//import org.springframework.beans.factory.annotation.Qualifier
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.io.ClassPathResource
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
//import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
//import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
//import org.springframework.transaction.annotation.EnableTransactionManagement
//
//@Suppress("SpringJavaInjectionPointsAutowiringInspection")
//@Configuration
//@EnableR2dbcRepositories
//@EnableTransactionManagement
//class H2Configuration {
//    @Bean
//    fun initializer(@Qualifier("connectionFactory") connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
//        val initializer = ConnectionFactoryInitializer()
//        initializer.setConnectionFactory(connectionFactory)
//        val populator = org.springframework.r2dbc.connection.init.CompositeDatabasePopulator()
//        populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("/db/schema.sql")))
//        populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("/db/data.sql")))
//        initializer.setDatabasePopulator(populator)
//        return initializer
//    }
//}