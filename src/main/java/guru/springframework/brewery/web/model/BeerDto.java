package guru.springframework.brewery.web.model;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BeerDto extends BaseItem {

    @Builder
    public BeerDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate, String beerName,
                   BeerStyleEnum beerStyle, Long upc, Integer quantityOnHand, BigDecimal price) {
        super(id, version, createdDate, lastModifiedDate);
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.quantityOnHand = quantityOnHand;
        this.price = price;
    }

    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private Integer quantityOnHand;

    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal price;

}
