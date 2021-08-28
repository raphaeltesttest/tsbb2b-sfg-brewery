package guru.springframework.brewery.web.model;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreditCardDto extends BaseItem {

    @Builder
    public CreditCardDto(UUID id, Integer version, OffsetDateTime createdDate,
                         OffsetDateTime lastModifiedDate) {
        super(id, version, createdDate, lastModifiedDate);
    }

    private Integer cardNumber;
    private LocalDate expirationDate;
    private Integer cvv;
    private Boolean primary;
}
