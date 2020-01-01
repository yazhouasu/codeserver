package com.hbgc.springbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(value="hibernateLazyInitializer")//解决内容为空的异常
public class Users extends BaseEntity implements Serializable,Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GeneratedValue自增长，strategy策略，GenerationType形成方式
    private int uid;
    private String username;
    private String password;
    @Column(length = 1)
    private String sex;
    private String province;//省
    private String city;//市
    private String area;//区
    private String adress;//街道住址
    private String mobile;
    private String email;
    private String validateCode;
    private String token;//登录成功之后的token值。用来做身份验证。


}
