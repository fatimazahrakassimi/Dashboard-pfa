package service;

import java.util.List;

import model.Sprint;



public interface Isprint {
	
	public void addSprint(Sprint s);
	public List<Sprint> ListSprintE();
	public Sprint getSprint(int idSprint);
	public void updateSprint(Sprint s);
	public void  deleteSprint(int id);
	public List<Sprint> ListSprintR();


}
