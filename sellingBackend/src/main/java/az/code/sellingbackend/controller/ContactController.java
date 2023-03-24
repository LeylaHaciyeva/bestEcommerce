package az.code.sellingbackend.controller;

import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.entity.Contact;
import az.code.sellingbackend.entity.Product;

import az.code.sellingbackend.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "contact", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequiredArgsConstructor
@Component
@EnableAutoConfiguration
public class ContactController {
    private final ContactService contactService;



    @GetMapping("/getAllMessages")
    public List<Contact> getAllProducts() {
        List<Contact> messages = contactService.getAllMessage();
        return messages;
    }


    @PostMapping("/post")
    public ResponseEntity<HttpStatus> createProduct(@RequestBody Contact contact) {
        contactService.post(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
