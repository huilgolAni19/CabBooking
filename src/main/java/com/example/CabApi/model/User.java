package com.example.CabApi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    int userId;
    String mobileNumber;
    String userName;
    String emailId;
    String password;

}
