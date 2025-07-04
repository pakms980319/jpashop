package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item.Book;
import jpabook.jpashop.domain.Item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) { itemRepository.save(item); }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto updateItemDto) {
        Item findItem = itemRepository.findOne(itemId);

        findItem.setPrice(updateItemDto.getPrice());
        findItem.setName(updateItemDto.getName());
        findItem.setStockQuantity(updateItemDto.getStockQuantity());
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne((itemId));
    }
}
