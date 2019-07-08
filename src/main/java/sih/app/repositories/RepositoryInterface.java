package sih.app.repositories;

import sih.app.domain.HasId;

import java.util.Collection;

public interface RepositoryInterface<T extends HasId> {

    /**
     * adds entity to the collection
     * @param entity
     */
    void add(T entity);

    /**
     * @return a collection with all the entities
     */
    Collection<T> getAll();
}
