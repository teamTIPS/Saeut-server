package saeut.dao;

import java.util.List;

import saeut.domain.Timetable;

public interface TimetableDao {

	// userId로 Timetable 가져오기
	List<Timetable> getTimeListById(String id);
	
	// Timetable 추가하기
	void insertTimetable(Timetable timetable);
	
	// userId로 Timetable 수정하기
	void modTimetable(Timetable timetable);
	
	// userId로 Timetable 삭제하기
	void removeTimetableById(String id);
}
