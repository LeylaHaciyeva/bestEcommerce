package az.code.sellingbackend.service;
import az.code.sellingbackend.entity.Contact;
import az.code.sellingbackend.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ContactService {
    @Autowired
    ContactRepo contactRepo;

    public void post(Contact contact) {
            contactRepo.save(contact);
    }

    public List<Contact> getAllMessage() {
        List<Contact> messages=contactRepo.findAll();
        return  messages;
    }



}
