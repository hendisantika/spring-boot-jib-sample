package id.my.hendisantika.jibsample.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jib-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 11/03/25
 * Time: 08.10
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class Customer {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String phone;
    private String dob;
}
