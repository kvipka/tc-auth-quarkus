package com.restapicode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@Entity
@Table(
        name = "account"
)
public class Account extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(10) unsigned", length = 32)
    private Integer id;
    @Column(name = "username", columnDefinition = "varchar(32)", length = 32)
    private String username;
    @JsonIgnore
    @Column(name = "salt", columnDefinition = "binary(32)", length = 32)
    private byte[] salt;
    @JsonIgnore
    @Column(name = "verifier", columnDefinition = "binary(32)", length = 32)
    private byte[] verifier;
    @JsonIgnore
    @Column(name = "session_key_auth", columnDefinition = "binary(40)", length = 40)
    private byte[] sessionKeyAuth;
    @JsonIgnore
    @Column(name = "session_key_bnet", columnDefinition = "varbinary(64)", length = 64)
    private byte[] sessionKeyBnet;
    @JsonIgnore
    @Column(name = "totp_secret", columnDefinition = "varchar(32)", length = 32)
    private byte[] totpSecret;
    @Column(name = "email", columnDefinition = "varchar(255)", length = 255)
    private String email;
    @Column(name = "reg_mail", columnDefinition = "varchar(255)", length = 255)
    private String regMail;
    @Column(name = "joindate", columnDefinition = "timestamp")
    private Timestamp joinDate;
    @Column(name = "last_ip", columnDefinition = "varchar(15)", length = 15)
    private String lastIp;
    @Column(name = "last_attempt_ip", columnDefinition = "varchar(15)", length = 15)
    private String lastAttemptIp;
    @Column(name = "failed_logins", columnDefinition = "int(10) unsigned", length = 10)
    private Integer failedLogins;
    @Column(name = "locked", columnDefinition = "tinyint(3) unsigned", length = 3)
    private Integer locked;
    @Column(name = "lock_country", columnDefinition = "varchar(2)", length = 2)
    private String lockCountry;
    @Column(name = "last_login", columnDefinition = "timestamp")
    private Timestamp lastLogin;
    @Column(name = "online", columnDefinition = "tinyint(3) unsigned", length = 3)
    private Integer online;
    @Column(name = "expansion", columnDefinition = "tinyint(3) unsigned", length = 3)
    private Integer expansion;
    @Column(name = "mutetime", columnDefinition = "bigint(20)", length = 20)
    private Long muteTime;
    @Column(name = "mutereason", columnDefinition = "varchar(255)", length = 255)
    private String muteReason;
    @Column(name = "muteby", columnDefinition = "varchar(255)", length = 255)
    private String muteBy;
    @Column(name = "locale", columnDefinition = "tinyint(3) unsigned", length = 3)
    private Integer locale;
    @Column(name = "os", columnDefinition = "varchar(3)", length = 3)
    private String os;
    @Column(name = "recruiter", columnDefinition = "int(10) unsigned", length = 10)
    private Integer recruiter;

    public static Account findByUsername(String userName) {
        return (Account)findAllByUsername(userName).firstResult();
    }

    public static PanacheQuery<Account> findAllByUsername(String userName) {
        return find("username", new Object[]{userName});
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getVerifier() {
        return verifier;
    }

    public void setVerifier(byte[] verifier) {
        this.verifier = verifier;
    }

    public byte[] getSessionKeyAuth() {
        return sessionKeyAuth;
    }

    public void setSessionKeyAuth(byte[] sessionKeyAuth) {
        this.sessionKeyAuth = sessionKeyAuth;
    }

    public byte[] getSessionKeyBnet() {
        return sessionKeyBnet;
    }

    public void setSessionKeyBnet(byte[] sessionKeyBnet) {
        this.sessionKeyBnet = sessionKeyBnet;
    }

    public byte[] getTotpSecret() {
        return totpSecret;
    }

    public void setTotpSecret(byte[] totpSecret) {
        this.totpSecret = totpSecret;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegMail() {
        return regMail;
    }

    public void setRegMail(String regMail) {
        this.regMail = regMail;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getLastAttemptIp() {
        return lastAttemptIp;
    }

    public void setLastAttemptIp(String lastAttemptIp) {
        this.lastAttemptIp = lastAttemptIp;
    }

    public Integer getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getLockCountry() {
        return lockCountry;
    }

    public void setLockCountry(String lockCountry) {
        this.lockCountry = lockCountry;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getExpansion() {
        return expansion;
    }

    public void setExpansion(Integer expansion) {
        this.expansion = expansion;
    }

    public Long getMuteTime() {
        return muteTime;
    }

    public void setMuteTime(Long muteTime) {
        this.muteTime = muteTime;
    }

    public String getMuteReason() {
        return muteReason;
    }

    public void setMuteReason(String muteReason) {
        this.muteReason = muteReason;
    }

    public String getMuteBy() {
        return muteBy;
    }

    public void setMuteBy(String muteBy) {
        this.muteBy = muteBy;
    }

    public Integer getLocale() {
        return locale;
    }

    public void setLocale(Integer locale) {
        this.locale = locale;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Integer recruiter) {
        this.recruiter = recruiter;
    }
}
