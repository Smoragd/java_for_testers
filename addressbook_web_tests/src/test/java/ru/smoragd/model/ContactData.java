package ru.smoragd.model;

public record ContactData(String id,
                          String firstname,
                          String middlename,
                          String lastname,
                          String nickname,
                          String photo,
                          String title,
                          String company,
                          String address,
                          String homePhone,
                          String mobilePhone,
                          String workPhone,
                          String email,
                          String email2,
                          String email3,
                          String homepage,
                          String bday,
                          String bmonth,
                          String byear,
                          String aday,
                          String amonth,
                          String ayear,
                          String group) {

    public ContactData() {
        this("","", "", "", "", "", "","",
                "", "", "", "", "", "", "",
                "", "","","","","","","");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3, this.homepage,
                this.bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear, this.group);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3, this.homepage,
                this.bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear, this.group);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3, this.homepage,
                this.bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear, this.group);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3, this.homepage,
                this.bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear, this.group);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3, this.homepage,
                this.bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear, this.group);
    }

    public ContactData withEmptyFieldsExceptIdFirstnameLastname() {
        return new ContactData(
                this.id,this.firstname, "", this.lastname, "", "", "", "",
                "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", ""
        );
    }


}
