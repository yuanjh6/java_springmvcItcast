package cn.itcast.ssm.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.ssm.exception.CustomerException;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.QueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.validator.ValidatorGroup1;
import cn.itcast.ssm.validator.ValidatorGroup2;

/**
 * 商品信息管理controller
 * <p>Title: ItemsController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-28下午4:02:21
 * @version 1.0
 */
@Controller
//在类上添加一个@RequestMapping，就会对请求增加一级目录。可以有效的对url进行归类。
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;

	//.action可以带也可以不带。
	@RequestMapping("/list")
	public String itemsList(Model model) throws Exception {
		
		//int a = 1/0;
		/*if (true) {
			//自定义异常
			throw new CustomerException("这是我们自定义的异常，测试着玩呢！！！");
		}*/
		//查询商品列表
		List<Items> itemsList = itemsService.getItemsList();
		//把查询结果传递给jsp
		model.addAttribute("itemsList", itemsList);
		
		return "itemsList";
	}
	//@RequestMapping的method属性就是限定请求的方法
	@RequestMapping(value="/editItems/{id}", method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(ModelMap model, @PathVariable("id") Integer id) throws Exception {
		//int id = 1;
//		String id = request.getParameter("id");
		Items items = itemsService.getItemsById(id);
		model.addAttribute("items1", items);
		//返回逻辑视图名
		return "editItems";
	}
	/**
	 * 商品修改提交处理
	 * <p>Title: updateItems</p>
	 * <p>Description: </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateItems")
	//需要在Items前添加@Validated注解，然后紧跟Items后添加一个BindingResult参数
	//在方法形参中添加一个MultipartFile参数接收图片文件
	public String updateItems(Model model, MultipartFile pictureFile,
			@Validated(ValidatorGroup2.class) @ModelAttribute("items1")Items items, 
			BindingResult result) throws Exception {
		//取校验结果
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				//取错误消息
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("errors", allErrors);
//			model.addAttribute("name", "张三");
//			model.addAttribute("age", "20");
			return "editItems";
		}
		
		//取图片信息，给图片重新命名
		//取图片的原始名称
		String originalFilename = pictureFile.getOriginalFilename();
		//新文件名
		String newFileName = UUID.randomUUID() 
				+ originalFilename.substring(originalFilename.lastIndexOf("."));
		//把图片转存到D:\temp\image
		pictureFile.transferTo(new File("D:\\temp\\image\\" + newFileName ));
		//把新图片名称保存到数据库
		items.setPic(newFileName);
		
		/*//创建商品对象
		Items items = new Items();
		items.setId(id);
		items.setName(name);
		items.setPrice(price);
		items.setDetail(detail);
		items.setCreatetime(createtime);*/
		//调用service更新数据库
		itemsService.updateItemsById(items);
		//如果想跳转到其他url就直接使用redirect+“：”+要跳转的url就可以了
		//return "redirect:list.action";
		//修改成功后又显示商品编辑页面
		return "forward:editItems.action";
	}
	/**
	 * 绑定pojo包装类型
	 * <p>Title: queryItems</p>
	 * <p>Description: </p>
	 * @param queryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryItems")
	public void queryItems(QueryVo queryVo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//业务逻辑不实现
		//如果queryVo对象中有值说明绑定成功
		System.out.println(queryVo.getItems().getId());
//		request.setAttribute("message", "request挺好用");
//		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"name\":\"zhangsan\"}");
		response.sendRedirect("list.action");
	}
	/**
	 * 绑定数组类型
	 * <p>Title: deleteItmes</p>
	 * <p>Description: </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteItmes")
	public String deleteItmes(Integer[] ids) throws Exception {
		System.out.println(ids);
		return "success";
	}
	/**
	 * json数据交互
	 * <p>Title: jsonDataTrans</p>
	 * <p>Description: </p>
	 * @param items
	 * @throws Exception
	 */
	@RequestMapping("/json")
	@ResponseBody
	public Items jsonDataTrans(@RequestBody Items items) throws Exception {
		System.out.println(items.getName());
		items.setName("这是响应的商品名称");
		return items;
	}
	
}
