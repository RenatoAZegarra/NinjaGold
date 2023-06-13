package com.example.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/ninja")
public class NinjaController {

    private int gold = 0;
    private List<String> activities = new ArrayList<>();

    private void addActivity(String activity) {
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.toString();
        String logEntry = String.format("[%s] %s", formattedTimestamp, activity);
        activities.add(logEntry);
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("gold", gold);
        model.addAttribute("activities", activities);
        return "index.jsp";
    }

    @PostMapping("/farm")
    public String visitFarm(Model model) {
        int earnedGold = getRandomNumber(10, 20);
        gold += earnedGold;
        addActivity(String.format("<span style='color: green;'>Earned %d gold from the farm.</span>", earnedGold));
        return "redirect:/ninja/";
    }

    @PostMapping("/cave")
    public String visitCave(Model model) {
        int earnedGold = getRandomNumber(5, 10);
        gold += earnedGold;
        addActivity(String.format("<span style='color: green;'>Earned %d gold from the cave.</span>", earnedGold));
        return "redirect:/ninja/";
    }

    @PostMapping("/house")
    public String visitHouse(Model model) {
        int earnedGold = getRandomNumber(2, 5);
        gold += earnedGold;
        addActivity(String.format("<span style='color: green;'>Earned %d gold from the house.</span>", earnedGold));
        return "redirect:/ninja/";
    }

    @PostMapping("/quest")
    public String goOnQuest(Model model) {
        int outcome = getRandomNumber(0, 1); // 0 represents losing gold, 1 represents earning gold
        int goldChange = getRandomNumber(0, 50);
        if (outcome == 0) {
            gold -= goldChange;
            addActivity(String.format("<span style='color: red;'>Lost %d gold on a quest.</span>", goldChange));
        } else {
            gold += goldChange;
            addActivity(String.format("<span style='color: green;'>Earned %d gold on a quest.</span>", goldChange));
        }
        return "redirect:/ninja/";
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
