package by.nekhviadovich.store.exception;

public interface EntityErrorType {

    String ENTITY_NOT_FOUND = "Entity not found by id: %s";

    String ENTITY_NOT_UPDATED = "Entity not updated: %s";

    String ENTITY_LIST_NOT_FOUND_OR_EMPTY = "Entity list not found";
}
