package ru.kazakovushka.edu.bankomat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
        model.addAttribute("card", card);
        System.out.println("load card" + card);
        return "pin";
    }

    @GetMapping(value = "/main")
    public String main(Model model) {
        return "mainMenu";
    }

    @PostMapping(value = "/operations")
    public String getOperations(@ModelAttribute Card card, Model model) {
        model.addAttribute("card", card);
        System.out.println("operations for card" + card);
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
