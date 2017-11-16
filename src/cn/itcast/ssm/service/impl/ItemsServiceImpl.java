package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsExample;
import cn.itcast.ssm.po.ItemsExample.Criteria;
import cn.itcast.ssm.service.ItemsService;
/**
 * 商品信息管理Service实现类
 * <p>Title: ItemsServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-28下午3:52:02
 * @version 1.0
 */
@Service
public class ItemsServiceImpl implements ItemsService {
	
	//spring容器会自动注入使用@Autowired标注的属性。
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> getItemsList() throws Exception {
		ItemsExample example = new ItemsExample();
		//创建查询条件
		//Criteria criteria = example.createCriteria();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	@Override
	public Items getItemsById(int id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItemsById(Items items) throws Exception {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
		
	}

}
