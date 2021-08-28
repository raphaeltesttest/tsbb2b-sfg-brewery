package guru.springframework.brewery.domain;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Brewery extends BaseEntity {

    @Builder
    public Brewery(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String breweryName) {
        super(id, version, createdDate, lastModifiedDate);
        this.breweryName = breweryName;
    }

    private String breweryName;

}
