package com.lt.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lt.bean.GradeCard;
import com.lt.dao.GradeCardDAOImpl;

public class GradeCardImplService implements GradeCardInterface
{

	List<GradeCard> gradeCard = new ArrayList<GradeCard>();
	GradeCardDAOImpl gradeCardDao = new GradeCardDAOImpl();
	
	@Override
	public List<GradeCard> viewGradeCard(int StudentId) throws SQLException {
		return gradeCardDao.viewGradeCard(StudentId);
		// TODO Auto-generated method stub
		
	}

	

	
}