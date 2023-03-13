package az.code.sellingbackend.controller;

import az.code.sellingbackend.dto.CheckoutItemDto;
import az.code.sellingbackend.dto.StripeResponse;
import az.code.sellingbackend.service.AuthenticationTokenService;
import az.code.sellingbackend.service.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})

public class OrderController {
    @Autowired
    AuthenticationTokenService authenticationTokenService;
    @Autowired
    OrderService orderService;

    @PostMapping("/create-checkout-sessions")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList
                                                       ) throws StripeException {
        Session session=orderService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse=new StripeResponse(session.getId());
        return new ResponseEntity<>(stripeResponse,HttpStatus.OK);
    }
}
