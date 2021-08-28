package guru.springframework.brewery.interceptors;

@Slf4j
@Component
public class OrderHeaderInterceptor extends EmptyInterceptor {

    private final ApplicationEventPublisher publisher;

    public OrderHeaderInterceptor(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {

        if (entity instanceof BeerOrder){
            for(Object curObj : currentState){
                if(curObj instanceof OrderStatusEnum){
                    for (Object prevObj : previousState){
                        if (prevObj instanceof OrderStatusEnum) {
                            OrderStatusEnum curStatus = (OrderStatusEnum) curObj;
                            OrderStatusEnum prevStatus = (OrderStatusEnum) prevObj;

                            if(curStatus != prevStatus){
                                log.debug("Order status change detected");

                                publisher.publishEvent(new BeerOrderStatusChangeEvent((BeerOrder) entity, prevStatus));
                            }
                        }
                    }
                }
            }
        }

        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }
}
