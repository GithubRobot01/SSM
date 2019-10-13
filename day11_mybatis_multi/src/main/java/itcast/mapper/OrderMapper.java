package itcast.mapper;

import itcast.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> findAll();
}
