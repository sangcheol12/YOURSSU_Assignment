package com.example.ssuBlog.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0012X\u0093\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/ssuBlog/config/QuerydslConfig;", "", "()V", "entityManager", "Ljavax/persistence/EntityManager;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "ssuBlog"})
@org.springframework.context.annotation.Configuration()
public class QuerydslConfig {
    @javax.persistence.PersistenceContext()
    private final javax.persistence.EntityManager entityManager = null;
    
    public QuerydslConfig() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.context.annotation.Bean()
    public com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory() {
        return null;
    }
}