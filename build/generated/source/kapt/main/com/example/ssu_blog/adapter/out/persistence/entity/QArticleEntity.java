package com.example.ssu_blog.adapter.out.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleEntity extends EntityPathBase<ArticleEntity> {

    private static final long serialVersionUID = -131134131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleEntity articleEntity = new QArticleEntity("articleEntity");

    public final NumberPath<Long> articleId = createNumber("articleId", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QUserEntity userEntityId;

    public QArticleEntity(String variable) {
        this(ArticleEntity.class, forVariable(variable), INITS);
    }

    public QArticleEntity(Path<ArticleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleEntity(PathMetadata metadata, PathInits inits) {
        this(ArticleEntity.class, metadata, inits);
    }

    public QArticleEntity(Class<? extends ArticleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userEntityId = inits.isInitialized("userEntityId") ? new QUserEntity(forProperty("userEntityId")) : null;
    }

}

