package com.cn.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.pojo.Page;
import com.cn.pojo.PageUtil;
import com.cn.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
public class TestUserServiceImpl
{
	@Autowired
	private IUserService userService;
	
	@Test
	public void testFindRecord()
	{
		List<Map<String, Object>> records = userService.recordsTable();
		
		System.out.println(records.size());
		
		for(Map record: records)
		{
			System.out.println(record.get("winner"));
		}
	}
//	@Test
//	public void testAddRecord()
//	{
//		CompetitionRecord record = new CompetitionRecord();
//		record.setHome_name("黑八");
//		record.setVisit_name("张三3");
//		record.setTotal_score("3:2");
//		record.setWinner("黑八");
//		record.setCompetition_time("2013-12-13");
//		userService.addRecord(record);
//	}
	@Test
	public void testGetRecordCount()
	{
		List<Map<String, Object>>  listCountRecord = userService.getRecordCount();
		Map<String, Object> mapCountRecord = listCountRecord.get(0);
		System.out.println(mapCountRecord.get("countRecord"));
	}
	@Test
	public void testFindByPage()
	{
		List<Map<String, Object>> listCountRecord = userService.getRecordCount();
		Map<String, Object> mapCountRecord = listCountRecord.get(0);
		Long countRecord = (Long)mapCountRecord.get("countRecord");//获得总记录数
		
		Page page = PageUtil.createPage(8, countRecord.intValue(), 2);    //显示第一页记录，每页记录数为8
		
		List<Map<String, Object>>  pageRecords   = userService.findByPage(page);
		
		System.out.println(pageRecords.size());
		
		for(Map pageRecord: pageRecords)
		{
			System.out.println(pageRecord.get("id"));
		}
	}

}
