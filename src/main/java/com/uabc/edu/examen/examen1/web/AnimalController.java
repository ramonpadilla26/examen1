package com.uabc.edu.examen.examen1.web;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.uabc.edu.examen.examen1.exception.RecordNotFoundException;
import com.uabc.edu.examen.examen1.model.AnimalEntity;
import com.uabc.edu.examen.examen1.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/")
public class AnimalController {
    @Autowired
    AnimalService service;
    @RequestMapping
    //@RequestMapping("/list-animal")
    public String getAnimals(Model model)
    {
        List<AnimalEntity> list = service.getAnimals();
        list.forEach(animal -> {
            if (!animal.isEstadoAdopcion()) {
                animal.setStr(Base64.getEncoder().encodeToString(animal.getImg()));
            }});


        model.addAttribute("animals", list);
        return "list-animal";

    }
    @RequestMapping(path = "/adopt/{id}")
    public String getAnimalAdop(Model model, @PathVariable("id") Integer id) throws RecordNotFoundException {
        AnimalEntity animal = service.getAnimalById(id);
        animal.setEstadoAdopcion(true);
        service.createAnimal(animal);
        return "redirect:/";
    }
    //////////////////////

    @RequestMapping("/adopta/{id}")
    public String getAllAnimal(Model model)
    {
        List<AnimalEntity> list = service.getAllAnimales();


        list.forEach(animal -> {
            if (!animal.isEstadoAdopcion()) {
                animal.setStr(Base64.getEncoder().encodeToString(animal.getImg()));

            }
        });
        model.addAttribute("animales", list);
        return "adop-animal";
    }
////*
    @RequestMapping("/new")
    public String getAdmin(Model model) {
        model.addAttribute("animal", new AnimalEntity());
        return "add-edit-animal";
    }



        @RequestMapping(path = {"/edit", "/edit/{id}"})
        public String editAnimalById(Model model, @PathVariable("id") Optional<Integer> id)throws RecordNotFoundException
        {
            if (id.isPresent()) {
                AnimalEntity entity = service.getAnimalById(id.get());
                model.addAttribute("animal", entity);
            } else {
                model.addAttribute("animal", new AnimalEntity());
            }
            return "add-edit-animal";

        }

        @RequestMapping(path = "/delete/{id}")
        public String deleteAnimalById(Model model, @PathVariable("id") Integer id)
            throws RecordNotFoundException
        {
            service.deleteAnimalById(id);
            return "redirect:/";
        }

        @RequestMapping(path = "/createAnimal", method = RequestMethod.POST)
        public String createAnimal(@RequestParam(value = "id", required = false) Optional<Integer> id,
            @RequestParam(value = "tipoanimal", required = true) String tipoanimal,
            @RequestParam(value = "color", required = true) String color,
            @RequestParam(value = "raza", required = true) String raza,
            @RequestParam(value = "tipopelo", required = true) String tipopelo,
            @RequestParam(value = "fechanac", required = true) String fechanac,
        @RequestParam(value = "vacunas", required = false, defaultValue = "false") boolean vacunas,
        @RequestParam(value = "estadoadopcion", required = false, defaultValue = "false") boolean estadoadopcion,
        @RequestParam(value = "nombredueño", required = false) String nombredueño,
        @RequestParam(value = "static/img", required = false) MultipartFile img) throws RecordNotFoundException {
        AnimalEntity entity;
        if (id.isPresent()) {
            entity = service.getAnimalById(id.get());
        } else{
            entity = new AnimalEntity();
        }
        entity.setTipoanimal(tipoanimal);
        entity.setColor(color);
        entity.setRaza(raza);
        entity.setTipopelo(tipopelo);
        entity.setFechaNac(fechanac);
        entity.setVacunas(vacunas);
        entity.setEstadoAdopcion(estadoadopcion);
        entity.setNombredueño(nombredueño);
        try {
            entity.setImg(img.getBytes());
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        service.createAnimal(entity);
        return "redirect:/";
    }


    }
