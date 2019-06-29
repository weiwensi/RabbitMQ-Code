package com.gysoft.entrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/27 8:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {

    private   String  userName;
    private  String password;



}
