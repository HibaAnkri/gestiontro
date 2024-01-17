package org.example.Service;

import org.example.Entity.Commentaire;
import org.example.Repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {
    @Autowired
    public CommentaireRepository commentaireRepository;

    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Commentaire findCommentaireById(Long idCommentaire) {
        return commentaireRepository.findById(idCommentaire).orElse(null);
    }

    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    public void deleteCommentaire(Long idCommentaire) {
        commentaireRepository.deleteById(idCommentaire);
    }


}
