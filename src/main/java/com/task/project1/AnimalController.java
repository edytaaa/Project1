package com.task.project1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class  AnimalController {
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @GetMapping("/")
    public String animals(Model model) {
        List<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);

        return "index";
    }


    @GetMapping("/animalInfo")
    public String animalInfo(@RequestParam Long id, Model model) {
        Animal animal = animalRepository.findById(id);
        model.addAttribute("animal", animal);

        return "animalDetails";
    }


    @GetMapping("/dodaj")
    public String dodaj(Model model) {
        model.addAttribute("newAnimal" , new Animal());

        return "addAnimalForm";
    }


    @PostMapping("/addAnimal")
    public String addAnimal(Animal animal) {
        animalRepository.add(animal);

        return "redirect:/";
    }


    @GetMapping("/wyszukaj")
    public String wyszukaj(){

        return "searchForm";
    }


    @GetMapping("/findAnimals")
    public String findAnimals(@RequestParam String name, Model model) {
        List<Animal> animals = animalRepository.findAll();
        List<Animal> animalsFind = new ArrayList<>();

        for (Animal animal : animals) {
            if(animal.getName().equals(name)){
                animalsFind.add(animal);
            }
        }
        model.addAttribute("animals", animalsFind);

        return "animalsFind";
    }
//     //LUB:
//    @GetMapping("/find")                             //np. localhost:8080/find?name=pies
//    public String findAnimal(@RequestParam String name, Model model) {
//        List<Animal> animals = animalRepository.findAll();
//        List<Animal> animalsFind = new ArrayList<>();
//
//        for (Animal animal : animals) {
//            if(animal.getName().equals(name)){
//                animalsFind.add(animal);
//            }
//        }
//        model.addAttribute("animals", animalsFind);
//        return "animalsFind";
//    }
}
