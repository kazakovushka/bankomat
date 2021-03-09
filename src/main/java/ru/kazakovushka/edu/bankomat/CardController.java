package ru.kazakovushka.edu.bankomat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @GetMapping(value = "/")
    public String getCards(Model model) {
        model.addAttribute("name", cardRepository.findAll());
        return "index";
    }

    @PostMapping(value = "/getCard")
    public String getCardNum(@RequestParam(name = "number") String number, Model model) {
        Card card = cardRepository.findByNumber(number);
        if (card != null) {
            model.addAttribute("card", card);
            log.info("load card" + card);
            return "pin";
        } else {
            log.warn("no card with number {}", number);
            return "mainMenu";
        }
    }

    @GetMapping(value = "/main")
    public String main(Model model) {
        return "mainMenu";
    }

    @PostMapping(value = "/operations")
    public String getOperations(@ModelAttribute Card card, Model model) {
        model.addAttribute("card", card);
        log.info("model card = {}", model.getAttribute("card"));
        return "operations";
    }

    @PostMapping(value = "/operation", params = "action=balance")
    public String getBalance(@ModelAttribute Card card, Model model) {
        model.addAttribute("card", card);
        System.out.println("get balance for card" + card);
        return "balance";
    }


    @PostMapping(value = "/operation", params = "action=takeMoney")
    public String takeMoney(@ModelAttribute Card card, Model model) {
        return "takeMoney";
    }

}
