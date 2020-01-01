package com.hbgc.springbootdemo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ONLINECODE")
@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OnlineCode extends BaseEntity implements Serializable,Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String username;
    private String description; //描述
    private String className; //类名
    private String sourceCode;  //源代码
    private String compileResult; //编译结果
    private String executeResult; //运行结果


}
