package org.example.Controller;

import org.example.DTO.Torcat;
import org.example.Entity.Category;
import org.example.Entity.Trottinette;
import org.example.Repository.CategoryRepository;
import org.example.Service.TrottinetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/Trottinette")
public class TrottinetteController {
    @Autowired
    private TrottinetteService trottinetteService;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/addtt")
    public boolean add(@RequestBody Torcat torcat){
        Category category=new Category();

        if(categoryRepository.findByCategory(torcat.namecat())!=null && categoryRepository.findByCategory(torcat.namecat()).getCategory().equals(torcat.namecat())){
            category=categoryRepository.findByCategory(torcat.namecat());
        }else {
            category.setCategory(torcat.namecat());
        }
        categoryRepository.save(category);
        Trottinette trottinette=new Trottinette();
        trottinette.setCategory(category);
        trottinette.setMarque(torcat.marque());
        trottinette.setModele(torcat.model());
        trottinette.setPrice(torcat.price());
        trottinette.setDescription(torcat.description());
        trottinette.setVitesse(torcat.Vitesse());
        trottinette.setTempscharge(torcat.Tempcharge());
        trottinette.setImage(torcat.image());
        return trottinetteService.createTrottinette(trottinette);
    }
   /*@PostMapping("/Addtro")
    public ResponseEntity<Trottinette> createtro(@RequestBody Trottinette trottinette) {
        Trottinette createtro = trottinetteService.createTrottinette(trottinette);
        return ResponseEntity.status(HttpStatus.CREATED).body(createtro);
    }*/
/*
    @PostMapping("/Addtro")
    public ResponseEntity<Trottinette> createtro(@ModelAttribute Trottinette trottinette,
                                                 @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            // Traitez l'image ici, par exemple, en la stockant dans la base de données ou sur le système de fichiers
            byte[] imageData = imageFile.getBytes();
            trottinette.setImage(imageData);

            Trottinette createtro = trottinetteService.createTrottinette(trottinette);
            return ResponseEntity.status(HttpStatus.CREATED).body(createtro);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/

    @GetMapping("/GetTrottinette")
    public ResponseEntity<List<Trottinette>> getAllTrottinette() {
        List<Trottinette> trottinettes = trottinetteService.getAllTrottinette();
        return ResponseEntity.ok(trottinettes);
    }

    @DeleteMapping("/{idTrottinette}")
    public ResponseEntity<Trottinette> deleteTro(@PathVariable Long idTrottinette) {
        trottinetteService.deletetrottinette(idTrottinette);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idTrottinette}")
    public ResponseEntity<Trottinette> updateTro(
            @PathVariable Long idTrottinette,
            @RequestBody Trottinette trottinetteModifiee) {

        Trottinette updatedTro = trottinetteService.updateTrottinette(idTrottinette, trottinetteModifiee);

        if (updatedTro != null) {
            return ResponseEntity.ok(updatedTro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{idTrottinette}")
    public ResponseEntity<Trottinette> getTrottinetteById(@PathVariable Long idTrottinette) {
        Trottinette trottinette = trottinetteService.findTrottinetteById(idTrottinette);

        if (trottinette != null) {
            return ResponseEntity.ok(trottinette);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/CheckAvailability/{idTrottinette}")
    public ResponseEntity<String> checkTrottinetteAvailability(@PathVariable Long idTrottinette) {
        boolean isAvailable = trottinetteService.isTrottinetteAvailable(idTrottinette);

        if (isAvailable) {
            return ResponseEntity.ok("La trottinette est disponible.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La trottinette n'est pas disponible.");
        }

}
/*@GetMapping("/")
    public String admin(){
        return "redirect:/admin";
}*/
    /*@GetMapping("/access")
    public String access(){
        return "/access";
}*/
        /*@GetMapping("/login")
    public String login(){
        return "/login";
}*/
}

