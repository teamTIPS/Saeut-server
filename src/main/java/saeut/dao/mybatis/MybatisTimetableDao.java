package saeut.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import saeut.dao.TimetableDao;
import saeut.dao.mybatis.mapper.TimetableMapper;
import saeut.domain.Timetable;

@Repository
public class MybatisTimetableDao implements TimetableDao{

	@Autowired
	private TimetableMapper timetableMapper;
	
	
	@Override
	public List<Timetable> getTimeListById(String id) {
		return timetableMapper.getTimeListById(id);
	}

	@Override
	public void insertTimetable(Timetable timetable) {
		timetableMapper.insertTimetable(timetable);
	}

	@Override
	public void modTimetable(Timetable timetable) {
		timetableMapper.modTimetable(timetable);
	}

	@Override
	public void removeTimetableById(String id) {
		timetableMapper.removeTimetableById(id);
	}

}
