package com.fintech.accountsapi.repository.postgresql.entities;

import com.fintech.accountsapi.domain.entities.account.Account;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "Account")
@Table(name = "account")
public class AccountEntity {

        @Id
        @Column(name = "id", nullable = false, unique = true, length = 36)
        private String id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "email", nullable = false)
        private String email;

        public AccountEntity() {
        }

        public AccountEntity(final String id, final String name, final String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public static AccountEntity fromDomain(final Account account) {
            return new AccountEntity(account.getId().getValue(), account.getName(), account.getEmail());
        }

        public Account toDomain() {
            return new Account(this.id, this.name, this.email);
        }
}
