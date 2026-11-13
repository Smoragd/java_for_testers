package model;

public record ContactData(String firstname,
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
                          String bday) {

    public ContactData() {
        this("", "", "", "", "", "","",
                "", "", "", "", "", "", "", "", "");
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.nickname, this.photo, this.title, this.company,
                this.address, this.homePhone, this.mobilePhone, this.workPhone, this.email, this.email2, this.email3, this.homepage,
                this.bday);
    }

    public ContactData noDatesNoGroup(String firstname,
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
                                             String homepage) {
        return new ContactData(firstname, middlename, lastname, nickname, photo, title, company,
                address, homePhone, mobilePhone, workPhone, email, email2, email3, homepage, this.bday);
    }

}
