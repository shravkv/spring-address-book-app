package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.ContactData;
import java.util.List;
import java.util.Optional;

public interface IAddressBookService {

    public ContactData addContact(com.bridgelabz.addressbook.dto.ContactDTO greetingDTO);
    public ContactData updateContact(com.bridgelabz.addressbook.dto.ContactDTO employeeDTO, int id);

    public Optional<ContactData> findContactID(int id);
    public List<ContactData> findContactByName(String name);
    public Integer deleteEmployeeID(int id);

    public List<ContactData> findAllContacts();
}
