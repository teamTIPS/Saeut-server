package saeut.service.facade;

import java.util.List;

import saeut.domain.Timetable;

public interface TimetableFacade {

/////////////////////////////////////////////////////////////////////////
/*  돌봄 요청자 또는 제공자의 개인 시간표 n개를 설정 */
/////////////////////////////////////////////////////////////////////////
	// userId로 Timetable 가져오기
	List<Timetable> getTimeListById(String id);
	
	// Timetable 추가하기
	void insertTimetable(Timetable timetable);
	
	// userId로 Timetable 수정하기
	void modTimetable(Timetable timetable);
	
	// userId로 Timetable 삭제하기
	void removeTimetableById(String id);
		
}
