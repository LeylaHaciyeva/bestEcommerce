package az.code.sellingbackend.service;

import az.code.sellingbackend.dto.CheckoutItemDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Value("${BASE_URL}")
    private String baseUrl;
    @Value("${STRIPE_SECRET_KEY}")
    private String apiKey;

    public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {

        Stripe.apiKey = apiKey;
        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();
        for (CheckoutItemDto checkoutItemDto : checkoutItemDtoList) {
            sessionItemList.add(createSessionLineItem(checkoutItemDto));
        }
        SessionCreateParams params=SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(baseUrl+"success")
                .setCancelUrl(baseUrl+ "failure")
                .addAllLineItem(sessionItemList).build();
        return Session.create(params);
    }

    private SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto) {
        return SessionCreateParams.LineItem.builder()
                .setPriceData(createPriceData(checkoutItemDto))
                .setQuantity(Long.valueOf(checkoutItemDto.getQuantity()))
                .build();
    }

    private SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
        return SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("usd")
                .setUnitAmount((long) (checkoutItemDto.getPrice() * 100))
                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(checkoutItemDto.getProductName()).build()).build();
    }
}
