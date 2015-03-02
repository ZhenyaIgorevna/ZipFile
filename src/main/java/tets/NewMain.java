package tets;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Yauheniya_Neliub on 2/19/2015.
 */
public class NewMain {

        public static void main(String[] args) {

            int i = 0;

                String password = "123456";
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(password);

                System.out.println(hashedPassword);
        }
}
