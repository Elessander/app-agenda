package br.com.app_agenda;

import java.util.Date;

public class ContactEntity {

    private Long id;

    private String contact;

    private String phone;

    private String email;

    private Date birthdate;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contato: " + id + '\n' +
                "Nome: " + contact + '\n' +
                "Telefone: " + phone + '\n' +
                "Data de Nascimento: " + birthdate;
    }

}

