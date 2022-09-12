package com.bridgelabz.addressbook.controller;


import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    IAddessBookService iAddressBookService;

    @PostMapping("/addContact")
    public ResponseEntity<ResponseDTO> createContact( @Valid @RequestBody ContactDTO contactDTO ){
        ResponseDTO responseDTO = new ResponseDTO("Contact Added Successfully", iAddressBookService.addContact ( contactDTO ));
        return new ResponseEntity<>( responseDTO, HttpStatus.CREATED );
    }
    @GetMapping("/findContactByID/{id}")
    public ResponseEntity<ResponseDTO> findContact(@PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("ID found", iAddressBookService.findContactID( id ));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
    }

    @GetMapping("/findContactByName/{name}")
    public ResponseEntity<ResponseDTO> findContactName( @PathVariable String name ){
        ResponseDTO responseDTO = new ResponseDTO("Contact found", iAddressBookService.findContactbyName(name));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
    }

    @DeleteMapping("deleteContact/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Succfully deleted", iAddressBookService.deleteEmployeeID( id ));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    //Update Employee Using its ID

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> UpdateContact(@Valid @RequestBody ContactDTO employeeDTO, @PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("Updated", iAddressBookService.updateContactID( employeeDTO, id ));
        if(iAddressBookService.updateContactID( employeeDTO, id ) != null){
            return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
        }
        responseDTO.setMessage("ID not found");
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAllContacts")
    public List<ContactData> findAllContacts(){
        return iAddressBookService.findAllContacts();
    }
}
