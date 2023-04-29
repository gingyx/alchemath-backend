package com.project;

import com.project.repository.Global;
import com.project.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationRunner {

    GlobalRepository globalRepository;

    public Initializer(GlobalRepository globalRepository) {
        this.globalRepository = globalRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        globalRepository.deleteAll();
        var global = new Global(1, """
            [{"ADD_SUB":1050,"BRACK_SIGN":1100,"MUL_DIV":1200,"BRACK_MULT":1300,"FRAC":1350},{"ADD_SUB":1050,"BRACK_SIGN":1100,"MUL_DIV":1200,"BRACK_MULT":1300,"FRAC":1350,"DISCRIMI":1400},{"ADD_SUB":1050,"BRACK_SIGN":1100,"MUL_DIV":1200,"BRACK_MULT":1300,"FRAC":1350,"HORNER":1400}]                   
                """);
        globalRepository.save(global);
    }

}
