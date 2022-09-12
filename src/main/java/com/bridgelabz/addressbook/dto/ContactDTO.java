package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    @Pattern(regexp = "^[A-Z][a-z]{2,20}$", message = "Not allow ")
    public String name;
    public String address;
    public List<String> phoneNumber;
    public String city;
}
