package com.cn.pojo;

/**
 * 比赛记录实体类：序号，主场方，客场方，总比分，获胜者，比赛时间
 * @author liuwangsen
 *
 */
public class CompetitionRecord
{
	private int id;
	private String home_name;
	private String visit_name;
	private String total_score;
	private String winner;
	private String competition_time;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getHome_name()
	{
		return home_name;
	}
	public void setHome_name(String home_name)
	{
		this.home_name = home_name;
	}
	public String getVisit_name()
	{
		return visit_name;
	}
	public void setVisit_name(String visit_name)
	{
		this.visit_name = visit_name;
	}
	public String getTotal_score()
	{
		return total_score;
	}
	public void setTotal_score(String total_score)
	{
		this.total_score = total_score;
	}
	public String getWinner()
	{
		return winner;
	}
	public void setWinner(String winner)
	{
		this.winner = winner;
	}
	public String getCompetition_time()
	{
		return competition_time;
	}
	public void setCompetition_time(String competition_time)
	{
		this.competition_time = competition_time;
	}

}
