package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.models.Email;
import com.example.freemoneynoscam.repository.EmailRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ValidateEmailService {
    private EmailRepository repository = new EmailRepository();

    public boolean isEmailValid(String email) {
        //TODO implement logic such that we verify an e-mail is valid
        return true;
    }

    public boolean saveEmail(String email) {
        if (!(email == null)) {
            if (email.contains("@")) {
                if (email.charAt(0) != '@') {
                    if (email.charAt(email.length() - 1) != '@') {
                        long count = email.chars().filter(c -> c == '@').count();
                        if (count == 1) {
                            if (!email.contains(" ")) {
                                try {
                                    repository.insertEmail(email);
                                    return true;
                                } catch (SQLException e) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    ;

    public List<Email> getAllEmails() {
        List<Email> allEmails = repository.getAllEmails();
        return allEmails;
    }
}
