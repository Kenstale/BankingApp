package com.example.BankingApp.models.users;

import com.example.BankingApp.embedable.Address;
import com.example.BankingApp.models.Accounts.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@DynamicUpdate
@Table(name = "account_holder")
public class AccountHolder extends User{

   /* @OneToMany(mappedBy = "primaryOwner")
    private List<Account> primaryOwnerList;
    @OneToMany(mappedBy = "secondaryOwner")
    private List<Account> secondaryOwnerList;*/

    @NotNull(message = "A date of birth is required")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private LocalDate birthDate;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="current_street")),
            @AttributeOverride(name="buildingNumber", column=@Column(name="current_number")),
            @AttributeOverride(name="city", column=@Column(name="current_city")),
            @AttributeOverride(name="country", column=@Column(name="current_country")),
            @AttributeOverride(name="zipCode", column=@Column(name="current_zip"))
    })
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="mailing_street")),
            @AttributeOverride(name="buildingNumber", column=@Column(name="mailing_number")),
            @AttributeOverride(name="city", column=@Column(name="mailing_city")),
            @AttributeOverride(name="country", column=@Column(name="mailing_country")),
            @AttributeOverride(name="zipCode", column=@Column(name="mailing_zip"))
    })
    private Address mailingAddress;
    @JsonIgnore
    @OneToMany(mappedBy = "primaryOwner")
    private Set<Account> accountsAsPrimaryOwner;


    @JsonIgnore
    @OneToMany(mappedBy = "secondaryOwner")
    private Set<Account> accountsAsSecondaryOwner;


    // Constructor

    public AccountHolder() {
    }

    public AccountHolder(String name, String username, String password, LocalDate birthDate, Address primaryAddress, Address mailingAddress) {
        super(name, username, password);
        setBirthDate(birthDate);
        setPrimaryAddress(primaryAddress);
        setMailingAddress(mailingAddress);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Account> getAccountsAsPrimaryOwner() {
        return accountsAsPrimaryOwner;
    }

    public void setAccountsAsPrimaryOwner(Set<Account> accountsAsPrimaryOwner) {
        this.accountsAsPrimaryOwner = accountsAsPrimaryOwner;
    }

    public Set<Account> getAccountsAsSecondaryOwner() {
        return accountsAsSecondaryOwner;
    }

    public void setAccountsAsSecondaryOwner(Set<Account> accountsAsSecondaryOwner) {
        this.accountsAsSecondaryOwner = accountsAsSecondaryOwner;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    // Getter

    // Makes mailingAddress optional
    public Optional<Address> getMailingAddress() {
        return Optional.ofNullable(mailingAddress);
    }
}
