package com.sb.projectapi.repositories;

import com.sb.projectapi.model.CfaItem;
import org.springframework.data.repository.CrudRepository;

public interface CfaMenuRepository extends CrudRepository<CfaItem, Long> {
}
/*

The CrudRespository interface takes in the model and the type of the ID,
 model is Menu
 ID type is Long.
now able to use all the CrudRepository methods save(), findOne(), findById(),
 findAll(), count(), delete(), deleteById() without providing implementation.

 */