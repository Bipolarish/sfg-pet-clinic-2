package guru.springframework.sfgpetclinic2.services;

import java.util.Set;

public interface CrudService <T, ID>{
    Set<T> findAll();
    T findById(ID I);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
