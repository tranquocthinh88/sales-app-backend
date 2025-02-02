package com.code.salesappbackend.repositories;

import com.code.salesappbackend.models.OrderVoucher;
import com.code.salesappbackend.models.id_classes.OrderVoucherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderVoucherRepository extends BaseRepository<OrderVoucher, OrderVoucherId> {
}