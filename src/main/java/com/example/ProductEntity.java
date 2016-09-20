package com.example;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Entity(name = "product")
public class ProductEntity {

    @Id
    private Long pk;

    @ElementCollection(targetClass = LocalizedLobValue.class)
    @CollectionTable(name = ("product_name_lv"), joinColumns = { @JoinColumn(name = ("product_pk")) }, indexes = {
                    @Index(name = ("idx_product_name_lv"), columnList = ("product_pk")) }, foreignKey = @ForeignKey(name = ("fk_product_name_lv")))
    @MapKeyColumn(name = "locale")
    private Map<String, ILocalizable> description = new HashMap<>();

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public Map<String, ILocalizable> getDescription() {
        return description;
    }

    public void setDescription(Map<String, ILocalizable> description) {
        this.description = description;
    }
}
