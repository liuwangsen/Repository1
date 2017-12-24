package com.cn.pojo;

/**
 * 分页信息辅助类 ：包括创建分页信息实体类和每一页的内部逻辑构成
 * 
 * @author liuwangsen
 *
 */
public class PageUtil
{
	/**
	 *  获得每页显示记录数
	 * @param everyPage
	 * @return
	 */
	public static int getEveryPage(int everyPage)
	{
		if (everyPage == 0)
		{
			everyPage = 8;
		}
		return everyPage;   // 等价于return everyPage == 0 ? 10 : everyPage; 三元运算符
		
	}

	/**
	 *  获得当前页
	 * @param currentPage
	 * @return
	 */
	public static int getCurrentPage(int currentPage)
	{
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 *  获得总页数
	 * @param everyPage
	 * @param totalCount
	 * @return
	 */
	public static int getTotalPage(int everyPage, int totalCount)
	{
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0)
		{
			totalPage = totalCount / everyPage;
		} else
		{
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}

	/**
	 * 获得起始位置
	 * @param everyPage
	 * @param currentPage
	 * @return
	 */
	public static int getBeginIndex(int everyPage, int currentPage)
	{
		return (currentPage - 1) * everyPage;
	}

	/**
	 *  获得是否有上一页
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasPrePage(int currentPage)
	{
		return currentPage == 1 ? false : true;
	}

	/**
	 *  获得是否有下一页
	 * @param totalPage
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasNextPage(int totalPage, int currentPage)
	{
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}

	/**
	 *  创建分页信息对象
	 * @param everyPage  每一页记录数
	 * @param totalCount  总记录数        以上全局
	 * @param currentPage  当前页数
	 * @return
	 */
	public static Page createPage(int everyPage, int totalCount, int currentPage)
	{
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage, hasNextPage);
	}
}
