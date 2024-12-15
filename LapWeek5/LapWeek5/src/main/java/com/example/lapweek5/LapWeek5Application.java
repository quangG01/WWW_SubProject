package com.example.lapweek5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.lapweek5.entity.Address;
import com.example.lapweek5.entity.Candidate;
import com.example.lapweek5.repositories.AddressRepository;
import com.example.lapweek5.repositories.CandidateRepository;
import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class LapWeek5Application {

    public static void main(String[] args) {
        SpringApplication.run(LapWeek5Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            // Kiểm tra xem có bất kỳ candidate nào đã có trong cơ sở dữ liệu chưa
            if (candidateRepository.count() == 0) {
                Random rnd = new Random();
                for (int i = 1; i < 1000; i++) {
                    // Khởi tạo Address sử dụng constructor
                    Address add = new Address(
                            rnd.nextInt(1, 1000) + "",  // street
                            "Quang Trung",               // city
                            CountryCode.VN.getNumeric(), // country
                            rnd.nextInt(70000, 80000) + "",  // number
                            "HCM"                        // zipcode
                    );
                    addressRepository.save(add);

                    // Khởi tạo Candidate sử dụng constructor
                    Candidate can = new Candidate(
                            "Name #" + i, // fullName
                            java.sql.Date.valueOf(LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29))), // dob
                            "email_" + i + "@gmail.com", // email
                            rnd.nextLong(1111111111L, 9999999999L) + "", // phone
                            add // address
                    );

                    candidateRepository.save(can);

                    System.out.println("Added: " + can);
                }
            } else {
                System.out.println("Candidates already exist in the database. Skipping data initialization.");
            }
        };
    }
}
