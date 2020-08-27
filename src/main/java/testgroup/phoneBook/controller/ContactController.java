package testgroup.phoneBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.phoneBook.model.Contact;
import testgroup.phoneBook.service.ContactService;

import java.util.List;

@Controller
public class ContactController {
    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allContacts(){
        List<Contact> contacts = contactService.allContacts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contacts");
        modelAndView.addObject("contactsList", contacts);

        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("contact", contactService.getById(id));

        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editContact(@ModelAttribute("contact") Contact contact) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        contactService.edit(contact);

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact") Contact contact) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        contactService.add(contact);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteContact(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Contact contact = contactService.getById(id);
        contactService.delete(contact);

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchContacts(@RequestParam String keyword){
        List<Contact> contacts = contactService.searchContacts(keyword);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contacts");
        modelAndView.addObject("contactsList", contacts);

        return modelAndView;
    }

}
