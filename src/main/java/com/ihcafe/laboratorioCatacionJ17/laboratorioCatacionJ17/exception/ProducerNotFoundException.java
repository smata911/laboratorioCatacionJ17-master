package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.exception;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Producer;

public class ProducerNotFoundException extends ResourceNotFoundException {

    /**
     *
     * @param field
     * @param fieldValue
     * @return
     */
    public static ResourceNotFoundException
    buildProducerNotFoundExceptionForField(String field, String fieldValue){
        return resourceNotFoundExceptionOf(Producer.class, field, fieldValue);
    }

    /**
     *
     * @param producerId
     * @return
     */
    public static ResourceNotFoundException
    buildProducerNotFoundExceptionForId(String producerId){
        return resourceNotFoundExceptionOf(Producer.class, "producerId", producerId);
    }

    /**
     *
     * @param searchParams
     * @return ResourceNotFoundException instance
     */
    public static ResourceNotFoundException buildProducerNotFoundException(String... searchParams){
        return resourceNotFoundExceptionOf(Producer.class, searchParams);
    }
}
