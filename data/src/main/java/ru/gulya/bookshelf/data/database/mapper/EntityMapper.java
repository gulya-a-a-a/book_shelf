package ru.gulya.bookshelf.data.database.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class EntityMapper<ItemType, EntityType> {

    private static int INITIAL_LIST_CAPACITY = 50;

    public ItemType transform(EntityType entity) {
        ItemType item = null;
        if (entity != null) {
            item = createItem(entity);
        }
        return item;
    }

    public List<ItemType> transform(Collection<EntityType> entities) {
        final List<ItemType> itemsList = new ArrayList<>(INITIAL_LIST_CAPACITY);
        for (EntityType entity : entities) {
            final ItemType item = transform(entity);
            if (item != null) {
                itemsList.add(item);
            }
        }
        return itemsList;
    }

    public EntityType transformTo(ItemType item) {
        EntityType entity = null;
        if (item != null) {
            entity = createEntity(item);
        }
        return entity;
    }

    abstract ItemType createItem(EntityType entity);

    abstract EntityType createEntity(ItemType item);
}
