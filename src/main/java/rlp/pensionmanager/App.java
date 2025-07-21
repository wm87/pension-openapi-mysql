package rlp.pensionmanager;

import rlp.pensionmanager.repository.DutyHourRepository;
import rlp.pensionmanager.repository.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    PensionRepository pensionRepository;

    @Autowired
    DutyHourRepository dutyHourRepository;

    @Override
    public void run(String... args) {

    }
}
