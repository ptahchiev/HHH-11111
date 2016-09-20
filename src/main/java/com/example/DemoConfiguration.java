package com.example;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EmbeddableType;
import java.util.Set;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Configuration
public class DemoConfiguration {

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    @PostConstruct
    public void createProduct() {
        Set<EmbeddableType<?>> embeddableTypes = entityManager.getMetamodel().getEmbeddables();

        for (EmbeddableType type : embeddableTypes) {
            if (ILocalizable.class.equals(type.getJavaType())) {
                throw new IllegalStateException("The metamodel must not contain the ILocalizable interface!");
            }
        }

    }

}
