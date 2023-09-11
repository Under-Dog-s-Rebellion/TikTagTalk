package A109.TikTagTalk.domain.tag.entity;

import A109.TikTagTalk.domain.tagRoom.entity.Item;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    private Item item;
}