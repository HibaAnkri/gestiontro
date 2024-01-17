package org.example.Service;


import org.example.Entity.Trottinette;
import org.example.Repository.TrottinetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class TrottinetteService {
    @Autowired
    public TrottinetteRepository trottinetteRepository;


    public boolean createTrottinette(Trottinette trottinette) {
           try {
               trottinetteRepository.save(trottinette);
               return true;
           }catch (Exception e){
               return false;
           }
    }


    public Trottinette findTrottinetteById(Long idTrottinette){return  trottinetteRepository.findById(idTrottinette).orElse(null);}


    public List<Trottinette> getAllTrottinette() {
        return trottinetteRepository.findAll();
    }

    public void deletetrottinette(Long idTrottinette) {
        trottinetteRepository.deleteById(idTrottinette);

    }

    public Trottinette updateTrottinette(Long idTrottinette, Trottinette trottinetteModifiee) {
        if (trottinetteRepository.existsById(idTrottinette)) {
            trottinetteModifiee.setId(idTrottinette);
            return trottinetteRepository.save(trottinetteModifiee);
        } else {
            return null;
        }
    }
    public boolean isTrottinetteAvailable(Long idTrottinette) {
        Trottinette trottinette = findTrottinetteById(idTrottinette);
        return trottinette != null && trottinette.isAvailable();
    }

}


