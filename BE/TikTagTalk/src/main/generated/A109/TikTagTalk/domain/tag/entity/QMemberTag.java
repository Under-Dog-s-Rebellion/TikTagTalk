package A109.TikTagTalk.domain.tag.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberTag is a Querydsl query type for MemberTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberTag extends EntityPathBase<MemberTag> {

    private static final long serialVersionUID = 1304714122L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberTag memberTag = new QMemberTag("memberTag");

    public final DatePath<java.time.LocalDate> gotTime = createDate("gotTime", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final A109.TikTagTalk.domain.user.entity.QMember member;

    public final QTag tag;

    public QMemberTag(String variable) {
        this(MemberTag.class, forVariable(variable), INITS);
    }

    public QMemberTag(Path<? extends MemberTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberTag(PathMetadata metadata, PathInits inits) {
        this(MemberTag.class, metadata, inits);
    }

    public QMemberTag(Class<? extends MemberTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new A109.TikTagTalk.domain.user.entity.QMember(forProperty("member"), inits.get("member")) : null;
        this.tag = inits.isInitialized("tag") ? new QTag(forProperty("tag")) : null;
    }

}

