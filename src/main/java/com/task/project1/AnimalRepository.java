package com.task.project1;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AnimalRepository {
    private Map<Long, Animal> animals; //LUB: TreeMap<Long, Animal> animals

    public AnimalRepository() {
        animals = new HashMap<>(); //LUB: animals = new TreeMap<>();
        animals.put(1L, new Animal(1L, "pies", "Leniwiec", "zdjęcie psa" ));
        animals.put(2L, new Animal(2L, "pies", "Zgrywus", "zdjęcie psa"));
        animals.put(3L, new Animal(3L, "kot", "Marzyciel",  "zdjęcie kota"));
        animals.put(4L, new Animal(4L, "mysz", "Psotnik", "zdjęcie myszy"));
    }


    public List<Animal> findAll() {

        return new ArrayList<>(animals.values());
    }


    public Animal findById(Long id) {

        return animals.get(id);
    }


    public void add(Animal animal) {
        int count = animals.values().size();
        List<Animal> all = findAll();
        Animal lastAnimal = all.get(count - 1);
        Long id = lastAnimal.getId() + 1;
        animal.setId(id);
        animals.put(id, animal);
    }
//     //LUB:        GDY: TreeMap<Long, Animal> animals ORAZ animals = new TreeMap<>();
//    public void add(Animal animal) {
//        Long id = animals.lastKey() + 1;
//        animal.setId(id);
//        animals.put(id, animal);
//    }
}
