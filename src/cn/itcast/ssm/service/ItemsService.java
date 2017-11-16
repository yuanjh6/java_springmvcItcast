package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.Items;

/**
 * 商品信息管理Service
 * <p>Title: ItemsService</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-28下午3:48:51
 * @version 1.0
 */
public interface ItemsService {

	List<Items> getItemsList() throws Exception;
	Items getItemsById(int id) throws Exception;
	void updateItemsById(Items items) throws Exception;
}
