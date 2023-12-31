package A109.TikTagTalk.domain.tagRoom.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = -1379523612L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItem item = new QItem("item");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isShit = createBoolean("isShit");

    public final BooleanPath isSkin = createBoolean("isSkin");

    public final StringPath name = createString("name");

    public final BooleanPath room = createBoolean("room");

    public final StringPath s3Url = createString("s3Url");

    public final NumberPath<Integer> sizeX = createNumber("sizeX", Integer.class);

    public final NumberPath<Integer> sizeY = createNumber("sizeY", Integer.class);

    public final A109.TikTagTalk.domain.tag.entity.QTag tag;

    public QItem(String variable) {
        this(Item.class, forVariable(variable), INITS);
    }

    public QItem(Path<? extends Item> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItem(PathMetadata metadata, PathInits inits) {
        this(Item.class, metadata, inits);
    }

    public QItem(Class<? extends Item> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tag = inits.isInitialized("tag") ? new A109.TikTagTalk.domain.tag.entity.QTag(forProperty("tag")) : null;
    }

}

