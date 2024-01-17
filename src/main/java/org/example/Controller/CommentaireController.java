package org.example.Controller;

import org.example.Entity.Commentaire;
import org.example.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping("/AddCommentaire")
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire createdCommentaire = commentaireService.createCommentaire(commentaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCommentaire);
    }

    @GetMapping("/GetCommentaires")
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireService.getAllCommentaires();
        return ResponseEntity.ok(commentaires);
    }

    @DeleteMapping("/{idCommentaire}")
    public ResponseEntity<Commentaire> deleteCommentaire(@PathVariable Long idCommentaire) {
        commentaireService.deleteCommentaire(idCommentaire);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/{idCommentaire}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long idCommentaire) {
        Commentaire commentaire = commentaireService.findCommentaireById(idCommentaire);

        if (commentaire != null) {
            return ResponseEntity.ok(commentaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
