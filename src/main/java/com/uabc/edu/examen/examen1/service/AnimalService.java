
package com.uabc.edu.examen.examen1.service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        import com.uabc.edu.examen.examen1.exception.RecordNotFoundException;
        import com.uabc.edu.examen.examen1.model.AnimalEntity;
        import com.uabc.edu.examen.examen1.repository.AnimalRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;


@Service
public class AnimalService {

    @Autowired
    AnimalRepository repository;

    public List<AnimalEntity> getAnimals()
    {
        List<AnimalEntity> result = (List<AnimalEntity>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<AnimalEntity>();
        }
    }
    public List<AnimalEntity> getAllAnimales()
    {
        List<AnimalEntity> result = (List<AnimalEntity>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<AnimalEntity>();
        }
    }


    public AnimalEntity getAnimalById(Integer id) throws RecordNotFoundException
    {
        Optional<AnimalEntity> animal = repository.findById(id);

        if(animal.isPresent()) {
            return repository.findById(id).get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public AnimalEntity createAnimal(AnimalEntity entity)
    {
        if(entity.getId()  == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<AnimalEntity> animal = repository.findById(entity.getId());

            if(animal.isPresent())
            {
                AnimalEntity newEntity = animal.get();
                newEntity.setId(entity.getId());
                newEntity.setTipoanimal(entity.getTipoanimal());
                newEntity.setColor(entity.getColor());
                newEntity.setRaza(entity.getRaza());
                newEntity.setTipopelo(entity.getTipopelo());
                newEntity.setFechaNac(entity.getFechaNac());
                newEntity.setVacunas(entity.isVacunas());
                newEntity.setEstadoAdopcion(entity.isEstadoAdopcion());
                newEntity.setNombredueño(entity.getNombredueño());
                newEntity.setImg(entity.getImg());

                repository.deleteById(entity.getId());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                      entity = repository.save(entity);
                return entity;

            }
        }
    }

    public void deleteAnimalById(Integer id) throws RecordNotFoundException
    {
        Optional<AnimalEntity> animal = repository.findById(id);

        if(animal.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}