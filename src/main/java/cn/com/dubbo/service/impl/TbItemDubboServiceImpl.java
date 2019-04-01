package cn.com.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.commons.EasyUiDataGrid;
import cn.com.dubbo.service.TbItemDubboService;
import cn.com.mapper.TbItemMapper;
import cn.com.po.TbItem;
import cn.com.po.TbItemExample;

public class TbItemDubboServiceImpl implements TbItemDubboService{
	
	@Resource
	private TbItemMapper tbItemMapper;
	@Override
	public EasyUiDataGrid show(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItem> list=tbItemMapper.selectByExample(new TbItemExample());
		
		PageInfo<TbItem> pi=new PageInfo<>(list);
		EasyUiDataGrid dataGrid=new EasyUiDataGrid();
		dataGrid.setRows(pi.getList());
		dataGrid.setTotals(pi.getTotal());
		return dataGrid;
	}

}
